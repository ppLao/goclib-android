package org.goclib.android.activity;

import java.util.List;

import org.goclib.android.control.TitleBarContoller;
import org.goclib.android.core.ActivityHelper;
import org.goclib.android.core.ActivityManager;
import org.goclib.android.core.ActivityHelper.BACK_STATUS;
import org.goclib.android.entity.GoclBaseEntity;
import org.goclib.android.events.BaseControllerEvent;
import org.goclib.android.events.BaseEvent;
import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.IActivity;
import org.goclib.android.inf.TitleBarActivityInf;
import org.goclib.android.ui.TitleBar;
import org.goclib.android.utils.cons.AppConst;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;

public abstract class TitleBarFragmentActivity extends GocBaseFragmentActivity
		implements TitleBarActivityInf,BaseListenerInf {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub
		super.prepare();
		setTitleBar(android.R.id.title);
	    getTitleBarContoller().addListener(this);
	}
	
	@Override
	public void onSelectTitleBarLeft(boolean selected) {
		// TODO Auto-generated method stub
		onReturn(getHelper().getBackKeyStatus());
	}

	@Override
	public void onSelectTitleBarTitle(boolean selected) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSelectTitleBarRight(boolean selected) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChangeTitleBarLeft(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChangeTitleBarTitle(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChangeTitleBarRight(Object value) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void onCall(BaseEvent event) {
		// TODO Auto-generated method stub
		String type=event.getType();
		if(type.equals(BaseControllerEvent.ON_CALL_LEFT)){
			onSelectTitleBarLeft(Boolean.valueOf(event.getData().toString()));
		}else if(type.equals(BaseControllerEvent.ON_CALL_TITLE)){
			onSelectTitleBarTitle(Boolean.valueOf(event.getData().toString()));
		}else if(type.equals(BaseControllerEvent.ON_CALL_RIGHT)){
			onSelectTitleBarRight(Boolean.valueOf(event.getData().toString()));
		}else if(type.equals(BaseControllerEvent.ON_LEFT_CHANGE)){
			onChangeTitleBarLeft(event.getData());
		}else if(type.equals(BaseControllerEvent.ON_RIGHT_CHANGE)){
			onChangeTitleBarRight(event.getData());
		}else if(type.equals(BaseControllerEvent.ON_TITLE_CHANGE)){
			onChangeTitleBarTitle(event.getData());
		}
	}
//	
//	public Intent requestIntent(Class<? extends Activity>cls){
//		return requestIntent(cls,new GoclBaseEntity());
//	}
//	
//	@Override
//	public Intent requestIntent(Class<? extends Activity>cls,GoclBaseEntity data){
//		Intent _result=new Intent();
//		_result.setClass(this, cls);
//		data.setContext(getComponentName());
//		_result.putExtra(AppConst.BUNDLE_KEY_DATA, data);
//		return _result;
//	}
//	@Override
//	public Intent requestIntent(Class<? extends Activity> cls,
//			GoclBaseEntity[] data) {
//		// TODO Auto-generated method stub
//		Intent _result=new Intent();
//		_result.setClass(this, cls);
//		for(GoclBaseEntity gb:data){
//			gb.setContent(getComponentName());
//		}
//		_result.putExtra(AppConst.BUNDLE_KEY_DATA_LIST, data);
//		return _result;
//	}
//	@Override
//	public Intent requestIntent(Class<? extends Activity> cls,
//			List<GoclBaseEntity> data) {
//		// TODO Auto-generated method stub
//		return requestIntent(cls,data.toArray(new GoclBaseEntity[data.size()]));
//	}

	@Override
	public void toHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> getContext() {
		// TODO Auto-generated method stub
		if(!(getData() instanceof GoclBaseEntity))
			return null;
		GoclBaseEntity _e=(GoclBaseEntity) getData();
		if(_e == null)
			return null;
		if(_e.getContext() == null || !(_e.getContext() instanceof ComponentName))
			return null;
		ComponentName _cn = (ComponentName) _e.getContext();
		try {
			return Class.forName(_cn.getClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public GoclBaseEntity getData(){
		return getIntent().getParcelableExtra(AppConst.BUNDLE_KEY_DATA);
	}
	
	@Override
	public GoclBaseEntity[] getDataList() {
		// TODO Auto-generated method stub
		GoclBaseEntity[] _result=null;
		Parcelable[] _super=super.getDataList();
		if(_super !=null){
			_result=new GoclBaseEntity[_super.length];
			for(int i=0;i<_super.length;i++){
				_result[i]=(GoclBaseEntity)_super[i];
			}
		}
		return _result;
	}

	
}
