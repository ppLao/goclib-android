package org.goclib.android.core;

import java.util.Timer;
import java.util.TimerTask;

import org.goclib.android.R;
import org.goclib.android.events.BaseEvent;
import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.IActivity;
import org.goclib.android.inf.RunnerTask;
import org.goclib.android.ui.SimpleProcessDialog;
import org.goclib.android.utils.ApplicationUtils;
import org.goclib.android.utils.LogUtil;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import android.view.View;

public class ActivityHelper extends ContextHelper implements RunnerTask {
	private BaseListenerInf mListener = null;
	private boolean mDialogCancelable = false;
	private BACK_STATUS mBackKeyStatus = BACK_STATUS.DEFAULT;
	private BaseListenerInf mDefaultListener = null;
	private boolean mAutoRestoreDefaultBackKeyListener = true;

	private BaseListenerInf mOnSplashListener=null;
	
	private Timer timer = new Timer();
	private TimerTask task = new MyTimerTask();
	public static long DEFAULT_DELAY=3000;
	public static long DEFAULT_PERIOD=1000;
	
	public enum BACK_STATUS {
		NONE(9990), DEFAULT(9991), NORMAL(9992), ALERT(9993), AGAIN(9994), WEBVIEW(9995),RESULT(9996);
		private int id = -1;
		public String value = null;

		private BACK_STATUS(int id) {
			this.id = id;
		}

		BACK_STATUS(String value) {
			this.value = value;
		}

		public int getId() {
			return id;
		}
	};

	protected Dialog mLoading;

	public ActivityHelper(Context context) {
		// restore(context);
		super(context);
		mDefaultListener = new BackKeyListener(context);
		restoreListener();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		if (isAutoRestoreDefaultBackKeyListener())
			setListener(mDefaultListener);
	}

	public void restoreListener() {
		setListener(mDefaultListener);
	}

	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return ApplicationUtils.getDisplayWidth(getContext());
	}

	public int getScreenHeight() {
		// TODO Auto-generated method stub
		return ApplicationUtils.getDisplayHeight(getContext());
	}
	
	public void displayProgressDialog(Boolean value,int theme) {
		// TODO Auto-generated method stub
		if (value)
			mLoading = SimpleProcessDialog.show(getContext(),theme);
		else if (mLoading != null)
			mLoading.dismiss();

	}
	public void displayProgressDialog(Boolean value) {
		// TODO Auto-generated method stub
		if (value)
			mLoading = SimpleProcessDialog.show(getContext(),R.style.Transparent_Dialog);
		else if (mLoading != null)
			mLoading.dismiss();

	}

	public AlertDialog.Builder displayAlertDialog(String msg) {
		// TODO Auto-generated method stub
		return displayAlertDialog(msg, null);
	}

	public AlertDialog.Builder displayAlertDialog(String msg,
			OnClickListener onClick) {
		// TODO Auto-generated method stub
		AlertDialog.Builder myDialog = new AlertDialog.Builder(getContext())
				.setMessage(msg).setNeutralButton(
						getContext().getString(R.string.goclib_confrim),
						onClick);
		myDialog.setCancelable(getDialogCancelable());
		myDialog.create().show();
		return myDialog;
	}

	public Builder displayAlertDialog(View v) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder myDialog = new AlertDialog.Builder(new ContextThemeWrapper(getContext(), R.style.Transparent_Dialog));
		myDialog.setView(v);

		return myDialog;
	}

	public Builder displayAlertDialog(View v, int paddingTop, int paddingLeft,
			int paddingBottom, int paddingRight) {
		// TODO Auto-generated method stub
		AlertDialog.Builder myDialog = new AlertDialog.Builder(getContext());
		myDialog.setView(v);
		return myDialog;
	}

	public boolean getDialogCancelable() {
		return mDialogCancelable;
	}

	public void setDialogCancelable(boolean mDialogCancelable) {
		this.mDialogCancelable = mDialogCancelable;
	}

	public BACK_STATUS getBackKeyStatus() {
		return mBackKeyStatus;
	}

	public boolean onBackKeyClick() {
		boolean _result = getBackKeyStatus() == BACK_STATUS.AGAIN
				|| getBackKeyStatus() == BACK_STATUS.ALERT
				|| getBackKeyStatus() == BACK_STATUS.NORMAL
				|| getBackKeyStatus() == BACK_STATUS.NONE;
		// LogUtil.trace(getBackKeyStatus()+","+_result,this);
		if (getListener() != null)
			getListener().onCall(new BaseEvent(BaseEvent.ON_RETURN, getBackKeyStatus()));
		// final BaseApplication _app=(BaseApplication)
		// (ApplicationUtils.defaultContext==null?BaseApplication.getInstance():ApplicationUtils.defaultContext);
		// if(getBackKeyStatus() == BACK_STATUS.AGAIN){
		// //_app.exitDelay(BaseApplication.getInstance());
		// if(getListener()!=null)
		// getListener().onCall(new
		// BaseEvent(BaseEvent.ON_RETURN,getBackKeyStatus()));
		// _result=true;
		// }
		// else if(getBackKeyStatus() == BACK_STATUS.ALERT){
		// displayAlertDialog(BACK_STATUS.ALERT.value, new OnClickListener() {
		//
		// public void onClick(DialogInterface dialog, int which) {
		// // TODO Auto-generated method stub
		// _app.exit(_app);
		// }
		// });
		// _result=true;
		// }else if(getBackKeyStatus() == BACK_STATUS.NORMAL){
		// try{
		// ((Activity)getContext()).onBackPressed();
		// }catch(Exception err){err.printStackTrace();};
		// _result=true;
		// }
		return _result;
	}

	public void setBackKeyStatus(BACK_STATUS mBackKeyStatus) {
		this.mBackKeyStatus = mBackKeyStatus;
	}

	public Activity getActivity() {
		return getContext() instanceof Activity ? (Activity) getContext(): null;
	}
	
	public IActivity getIActivity() {
		return getContext() instanceof IActivity ? (IActivity) getContext() :null;
	}

	public View findViewById(int resId) {
		return getActivity() == null ? null : getActivity().findViewById(resId);
	}

	public BaseListenerInf getListener() {
		return mListener;
	}

	public void setListener(BaseListenerInf mListener) {
		this.mListener = mListener;
	}

	public void setOnBackKeyListener(BackKeyListener listener) {
		setListener(listener);
	}

	public boolean isAutoRestoreDefaultBackKeyListener() {
		return mAutoRestoreDefaultBackKeyListener;
	}

	public void setAutoRestoreDefaultBackKeyListener(
			boolean mAutoRestoreDefaultBackKeyListener) {
		this.mAutoRestoreDefaultBackKeyListener = mAutoRestoreDefaultBackKeyListener;
	}

	public class BackKeyListener implements BaseListenerInf {
		private Context mContext = null;

		public BackKeyListener(Context context) {
			// TODO Auto-generated constructor stub
			setContext(context);
		}

		@Override
		public void onCall(BaseEvent event) {
			// TODO Auto-generated method stub
			if (BaseEvent.ON_RETURN.equals(event.getType())) {
				BACK_STATUS status = (BACK_STATUS) event.getData();
				if (status == BACK_STATUS.ALERT)
					onBackStatusAlert(status);
				else if (status == BACK_STATUS.AGAIN)
					onBackStatusAgain(status);
				else if (status == BACK_STATUS.NORMAL)
					onBackStatusNormal(status);
				else if(status == BACK_STATUS.NONE)
					onBackStatusNone(status);
				else if(status == BACK_STATUS.RESULT)
					onBackStatusResult(status);
			}
		}

		public void onBackStatusNone(BACK_STATUS status) {
			// TODO Auto-generated method stub
			
		}
		public void onBackStatusResult(BACK_STATUS status) {
			// TODO Auto-generated method stub
			Activity _act = getContext() instanceof Activity ? (Activity) getContext(): null;
			if (_act != null){
				if(getIActivity()!=null){
					Intent _intent=getIActivity().getResultIntentForBackStatusMode(null);
					_act.setResult(getIActivity().getResultCodeForBackStatusMode(),_intent);
				}else{
					_act.setResult(Activity.RESULT_CANCELED);
				}
				_act.finish();
			}
		}

		public void onBackStatusAlert(BACK_STATUS status) {
			displayAlertDialog(status.value, new OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					BaseApplication _ba = ApplicationUtils.getBaseApplication(getContext());
					if (_ba != null)
						_ba.exit(getContext());
				}
			});
		}

		public void onBackStatusAgain(BACK_STATUS status) {
			BaseApplication _ba = ApplicationUtils.getBaseApplication(getContext());
			if (_ba != null)
				_ba.exitDelay(getContext());

		}

		public void onBackStatusNormal(BACK_STATUS status) {
			Activity _act = getContext() instanceof Activity ? (Activity) getContext(): null;
			if (_act != null)
				_act.onBackPressed();
		}

		public Context getContext() {
			return mContext;
		}

		public void setContext(Context mContext) {
			this.mContext = mContext;
		}
	}

	@Override
	public void splashStart() {
		// TODO Auto-generated method stub
		splashStart(DEFAULT_DELAY, DEFAULT_PERIOD);
	}
	
	@Override
	public void splashStart(long delay) {
		// TODO Auto-generated method stub
		splashStart(delay, DEFAULT_PERIOD);
	}
	
	@Override
	public void splashStart(long delay,long period){
		// TODO Auto-generated method stub
		if(timer!=null){
			timer.cancel();
			timer.purge();
			timer = null;
		}
		if (task != null) {
			task.cancel();
			task = null;
		}
		task = new MyTimerTask();
		timer=new Timer();
		timer.schedule(task,delay,period);
		
	}
	
	public class MyTimerTask extends TimerTask {
		public void run() {
			timer.cancel();
			timer.purge();
			timer = null;
			splashComplete();
			//getHandler().obtainMessage(ON_COMPLETE);
			//onCall(new BaseEvent(BaseEvent.ON_APP_START, null));
		}
		
	}

	@Override
	public void splashComplete() {
		// TODO Auto-generated method stub
		LogUtil.trace("splash complete"+getListener(),this);
		if (getOnSplashListener()!= null)
			getOnSplashListener().onCall(new BaseEvent(BaseEvent.ON_SPLASH_COMPLETE, null));
	}

	public BaseListenerInf getOnSplashListener() {
		return mOnSplashListener;
	}

	public void setOnSplashListener(BaseListenerInf mOnSplashListener) {
		this.mOnSplashListener = mOnSplashListener;
	}
}
