package org.goclib.android.events;

import java.util.EventObject;

public class BaseEvent<T> {
	public static final String ON_MEASURE_UI="goclib.onMeasureUI";
	public static final String ON_RETURN="goclib.onReturn";
	public static final String ON_SPLASH_COMPLETE="goclib.onSplashComplete";
	
	private T mData=null;
	private String mType=null;
	public BaseEvent(String type,T data){
		setType(type);
		setData(data);
	}
	public T  getData() {
		return mData;
	}
	public void setData(T data) {
		mData = data;
	}
	public String getType() {
		return mType;
	}
	public void setType(String mType) {
		this.mType = mType;
	}
}
