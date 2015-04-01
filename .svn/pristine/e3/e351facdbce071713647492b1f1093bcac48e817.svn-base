package org.goclib.android.utils;

import android.content.Context;


public class ResourceUtil {

	public static final String DRAWABLE="drawable";
	public static final String ID="id";
	public static final String STRING="string";
	public static final String LAYOUT="layout";
	public static final String STYLE="style";
	public static final String COLOR="color";
	public static final String ANIM="anim";
	
	public static int getBy(Context context,String name,String defType){
		return context.getResources().getIdentifier(name, defType, context.getPackageName());
	}
	
	public static int getDrawableID(Context context,String name){
		return getBy(context,name,DRAWABLE);
	}
	public static int getID(Context context,String name){
		return getBy(context,name,ID);
	}
	public static int getStringID(Context context,String name){
		return getBy(context,name,STRING);
	}
	public static int getLayoutID(Context context,String name){
		return getBy(context,name,LAYOUT);
	}
	public static int getStyleID(Context context,String name){
		return getBy(context,name,STYLE);
	}
	public static int getAnimID(Context context,String name){
		return getBy(context,name,ANIM);
	}
	public static int getColorID(Context context,String name){
		return getBy(context,name,COLOR);
	}
}
