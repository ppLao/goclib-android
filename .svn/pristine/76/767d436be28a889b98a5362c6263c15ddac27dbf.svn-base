package org.goclib.android.core;

import org.goclib.android.R;
import org.goclib.android.utils.LogUtil;
import org.goclib.android.utils.SaveUtil;
import org.goclib.android.utils.cons.AppConst;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.Toast;

public class BaseApplication extends Application {
	
	
	private static BaseApplication _instance=null;
	public synchronized static BaseApplication getInstance(){
		return _instance;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(_instance==null)
			_instance = this;
		LogUtil.trace("application create");
		
	}
	
	public Class<? extends Activity> getHome(){
		return null;
	}
	public Class<?  extends Activity> getGuide(){
		return getHome();
	}
	
	private long exitDelay=0;
	public static long EXIT_INTERVAL = 2000;
	public void exitDelay(Context context){
		if((System.currentTimeMillis()-exitDelay) > EXIT_INTERVAL){  
			String s=getString(R.string.goclib_click_again)+getString(R.string.goclib_exit);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();                                
            exitDelay = System.currentTimeMillis();   
        } else {
        	//DataUntils.clear(mContext);
        	exit(context);
        }
	}
	
	public void exit(Context context){
		
		ActivityManager.getInstance(context == null?BaseApplication.this:context).exit();
		System.exit(0); 
	}
	public void exitDelay(){
		exitDelay(BaseApplication.getInstance());
	}
	public void exit(){
		exit(BaseApplication.getInstance());
	}
	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		super.onLowMemory();
		System.gc();
	}
	
	public static void retoreFirstRun(){
		SaveUtil.savePreferenceBoolean(getInstance(), AppConst.LOCAL_KEY_FIRST_RUN, true);
	}
	
	public static void setFirstRun(){
		SaveUtil.savePreferenceBoolean(BaseApplication.getInstance(), AppConst.LOCAL_KEY_FIRST_RUN, false);
	}
	
	public static boolean isFirstRun(){
		return SaveUtil.getPreferenceBoolean(getInstance(), AppConst.LOCAL_KEY_FIRST_RUN, true);
	}
}
