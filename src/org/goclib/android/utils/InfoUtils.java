package org.goclib.android.utils;

import org.goclib.android.core.BaseApplication;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class InfoUtils {
	public static Context mDefaultContext;
	public static String getVersion(String prefix,Context context) { 
		
		try { 
			PackageManager manager = context.getPackageManager(); 
			PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0); 
			String version = info.versionName; 
			return prefix + version; 
		} catch (Exception e) { 
			e.printStackTrace(); 
			return "unknow version"; 
		} 
	}
	public static String getVersion(){
		return getVersion("", mDefaultContext);
	}
	
	public static Context getDefaultContext(){
		return mDefaultContext == null ? BaseApplication.getInstance():mDefaultContext;
	}
	public static void setDefaultContext(Context value){
		mDefaultContext = value;
	}
	
}
