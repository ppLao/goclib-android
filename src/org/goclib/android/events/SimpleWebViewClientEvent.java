package org.goclib.android.events;

public class SimpleWebViewClientEvent extends BaseEvent<String> {
	
	public static final String ON_LOADING="onLoading";
	public static final String ON_START="onStart";
	public static final String ON_FINISH="onFinish";
	
	public SimpleWebViewClientEvent(String type, String data) {
		super(type, data);
		// TODO Auto-generated constructor stub
	}

}
