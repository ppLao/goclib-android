package org.goclib.android.core;

import org.goclib.android.utils.ApplicationUtils;

import android.content.Context;
import android.os.Handler;

public class ContextHelper {
	private Context mContext;
	private Handler mHandler;
	private boolean mInited=false;
	
	public ContextHelper(Context context){
		setContext(context);
		setHandler(new Handler());
	}
	
	public void restore(Context context){
		mDestroy=false;
		if(!isInited()){
			setContext(context);
			setHandler(new Handler());
			init();
		}
	}
	
	private boolean mDestroy=false;
	public boolean isDestroy(){
		return mDestroy;
	}
	public void destroy(){
		if(!mDestroy){
			setContext(null);
			setHandler(null);
			mDestroy=true;
			mInited=false;
		}
	}
	protected void init(){
		mInited=true;
	}
	public Handler getHandler() {
		return mHandler;
	}

	public void setHandler(Handler mHandler) {
		this.mHandler = mHandler;
	}
	public Context getContext() {
		return mContext == null ? ApplicationUtils.getDefaultContext():mContext;
	}

	public void setContext(Context mContext) {
		this.mContext = mContext;
	}

	public boolean isInited() {
		return mInited;
	}
}
