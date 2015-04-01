package org.goclib.android.utils;

import android.util.Log;

public final class LogUtil {
	public static final String TAG_ERROR="error";
	public static final String TAG_INFO="info";
	public static final String TAG_VERBOSE ="verbose";
	
	public static void traceAll(String tag,Object msg){
		traceAll(tag,msg,null);
	}
	
	public static void traceAll(String tag,Object msg,Object trigger){
		StringBuffer sb =new StringBuffer();
		if(trigger !=null)
			sb.append(trigger.getClass().toString()).append("-").append(tag);
		
		if(tag == TAG_ERROR)
			Log.e(sb.toString(), String.valueOf(msg));
		else if(tag == TAG_INFO)
			Log.i(sb.toString(), String.valueOf(msg));
		else if(tag == TAG_VERBOSE)
			Log.v(sb.toString(),String.valueOf(msg));
	}
	
	public static void debug(Object msg){
		debug(msg,null);
	}
	public static void debug(Object msg,Object trigger){
		traceAll(TAG_VERBOSE,msg,trigger);
	}
	
	public static void trace(Object msg){
		trace(msg,null);
	}
	public static void trace(Object msg,Object trigger){
		traceAll(TAG_INFO,msg,trigger);
	}
	public static void error(Object msg){
		error(msg,null);
	}
	public static void error(Object msg,Object trigger){
		traceAll(TAG_ERROR,msg,trigger);
	}
}
