package org.goclib.android.activity;

import java.io.File;
import java.util.List;

import org.goclib.android.control.TitleBarContoller;
import org.goclib.android.core.ActivityHelper;
import org.goclib.android.core.ActivityManager;
import org.goclib.android.core.ActivityHelper.BACK_STATUS;
import org.goclib.android.entity.GoclBaseEntity;
import org.goclib.android.events.BaseEvent;
import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.IActivity;
import org.goclib.android.ui.TitleBar;
import org.goclib.android.utils.ApplicationUtils;
import org.goclib.android.utils.LogUtil;
import org.goclib.android.utils.cons.AppConst;

import android.R;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.View;

public abstract class GocBaseActivity extends Activity implements IActivity {
	private TitleBar mTitleBar = null;
	private TitleBarContoller mTitleBarContoller = null;
	private ActivityHelper mHelper = null;
	private	Parcelable mData=null;
	private Parcelable[] mDataList=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActivityManager.getInstance(this).add(this);
		//init();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		init();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == ApplicationUtils.RESULT_TAKE_PHOTO_BY_GALLERY_CROP ||
				requestCode == ApplicationUtils.RESULT_TAKE_PHOTO_BY_GALLERY ||
				requestCode == ApplicationUtils.RESULT_TAKE_PHOTO_BY_CAMERA) {
			// 选择头像后返回
			if(resultCode == RESULT_CANCELED){
				onCancelTakePhoto(requestCode,resultCode,data);
			}else if(resultCode == RESULT_OK || resultCode == RESULT_FIRST_USER){
				onTakePhoto(requestCode, resultCode, data);
			}else {
				onTakePhotoCustomResult(requestCode, resultCode, data);
			}
			
		}
	}
	
	protected void onTakePhotoCustomResult(int requestCode, int resultCode, Intent data){
		
	}
	
	protected void onTakePhoto(int requestCode, int resultCode, Intent data){
		
	}
	
	protected void onCancelTakePhoto(int requestCode, int resultCode, Intent data){
		
	}
	// @Override
	public boolean init() {
		// TODO Auto-generated method stub
		if (!isInit()) {
			
			prepare();
		}
		mData = getIntent().getParcelableExtra(AppConst.BUNDLE_KEY_DATA);
		mDataList = getIntent().getParcelableArrayExtra(AppConst.BUNDLE_KEY_DATA_LIST);
		return isInit();
	}

	public boolean isInit() {
		return getHelper() == null ? false : getHelper().isInited();
	}

	protected void prepare() {
		setTitleBarContoller(new TitleBarContoller());
		if (isDestroy() && getHelper()==null)
			setHelper(new ActivityHelper(this));
		getHelper().restore(this);
	}

	@Override
	public void setHandler(Handler value) {
		// TODO Auto-generated method stub
		if (!isDestroy()) {
			getHelper().setHandler(value);
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		displayProgressDialog(false);
		if (!isDestroy()) {
			getHelper().destroy();
			setHelper(null);
		}
		ActivityManager.getInstance(this).remove(this);
	}

	@Override
	public Handler getHandler() {
		// TODO Auto-generated method stub
		return isDestroy() ? null : getHelper().getHandler();
	}

	@Override
	public void displayProgressDialog(Boolean value) {
		// TODO Auto-generated method stub
		if (!isDestroy())
			getHelper().displayProgressDialog(value);
	}

	@Override
	public Builder displayAlertDialog(String msg) {
		// TODO Auto-generated method stub
		return isDestroy() ? null : getHelper()
				.displayAlertDialog(msg);
	}

	@Override
	public Builder displayAlertDialog(String msg, OnClickListener onClick) {
		// TODO Auto-generated method stub
		return (getHelper().isDestroy()) ? null : getHelper()
				.displayAlertDialog(msg, onClick);
	}

	@Override
	public Builder displayAlertDialog(View v) {
		// TODO Auto-generated method stub
		return (isDestroy()) ? null : getHelper()
				.displayAlertDialog(v);
	}

	@Override
	public Builder displayAlertDialog(View v, int paddingTop, int paddingLeft,
			int paddingBottom, int paddingRight) {
		// TODO Auto-generated method stub
		return (isDestroy()) ? null : getHelper()
				.displayAlertDialog(v, paddingTop, paddingLeft, paddingBottom,
						paddingRight);
	}

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return (isDestroy()) ? 0 : getHelper().getScreenWidth();
	}

	@Override
	public int getScreenHeight() {
		// TODO Auto-generated method stub
		return (isDestroy()) ? 0 : getHelper().getScreenHeight();
	}
	
	@Override
	public Intent getResultIntentForBackStatusMode(GoclBaseEntity data) {
		// TODO Auto-generated method stub
		Intent _intent=new Intent();
		return _intent;
	}
	
	@Override
	public int getResultCodeForBackStatusMode() {
		// TODO Auto-generated method stub
		return RESULT_CANCELED;
	}

	// @Override
		public boolean onKeyDown(int keyCode, KeyEvent event) {
			// TODO Auto-generated method stub
			boolean _flag = false;
			if (keyCode == KeyEvent.KEYCODE_BACK
					&& event.getAction() == KeyEvent.ACTION_DOWN) {
				if(onReturn(getHelper().getBackKeyStatus()))
					return true;
			}
			return super.onKeyDown(keyCode, event);
		}

		@Override
		public boolean onReturn(BACK_STATUS backStatus) {
			// TODO Auto-generated method stub
			boolean flag= backStatus != BACK_STATUS.DEFAULT;
			if (flag)
				getHelper().onBackKeyClick();
			else
				onBackPressed();
			
			return flag;
		}
	@Override
	public ActivityHelper getHelper() {
		return mHelper;
	}

	public TitleBar getTitleBar() {
		return mTitleBar;
	}

	public void setTitleBar(TitleBar mTitleBar) {
		this.mTitleBar = mTitleBar;
		if (getTitleBarContoller() != null) {
			getTitleBarContoller().setSource(getTitleBar());
		}
	}

	public void setTitleBar(int resid) {
		setTitleBar((TitleBar) findViewById(resid));
	}

	public TitleBarContoller getTitleBarContoller() {
		return mTitleBarContoller;
	}

	public void setTitleBarContoller(TitleBarContoller mTitleBarContoller) {
		this.mTitleBarContoller = mTitleBarContoller;
		if (getTitleBarContoller() != null) {
			getTitleBarContoller().setSource(getTitleBar());
		}
	}
	@Override
	public void setHelper(ActivityHelper mHelper) {
		this.mHelper = mHelper;
	}
	@Override
	public Parcelable getData() {
		// TODO Auto-generated method stub
		return mData;
	}
	@Override
	public Parcelable[] getDataList() {
		// TODO Auto-generated method stub
		return mDataList == null ? getIntent().getParcelableArrayExtra(AppConst.BUNDLE_KEY_DATA_LIST):mDataList;
	}
	
	public boolean isDestroy(){
		return getHelper() == null||getHelper().isDestroy();
	}
	
	@Override
	public Intent requestIntent(Class<? extends Activity>cls){
		return requestIntent(cls,new GoclBaseEntity());
	}
	
	@Override
	public Intent requestIntent(Class<? extends Activity>cls,GoclBaseEntity data){
		Intent _result=new Intent();
		_result.setClass(this, cls);
		data.setContext(getComponentName());
		_result.putExtra(AppConst.BUNDLE_KEY_DATA, data);
		return _result;
	}
	@Override
	public Intent requestIntent(Class<? extends Activity> cls,
			GoclBaseEntity[] data) {
		// TODO Auto-generated method stub
		Intent _result=new Intent();
		_result.setClass(this, cls);
		for(GoclBaseEntity gb:data){
			gb.setContent(getComponentName());
		}
		_result.putExtra(AppConst.BUNDLE_KEY_DATA_LIST, data);
		return _result;
	}
	@Override
	public Intent requestIntent(Class<? extends Activity> cls,
			List<GoclBaseEntity> data) {
		// TODO Auto-generated method stub
		return requestIntent(cls,data.toArray(new GoclBaseEntity[data.size()]));
	}
}
