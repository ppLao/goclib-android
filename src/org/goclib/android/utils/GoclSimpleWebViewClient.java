package org.goclib.android.utils;

import org.goclib.android.events.SimpleWebViewClientEvent;
import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.IActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GoclSimpleWebViewClient extends WebViewClient {
	private Context mContext;
	public GoclSimpleWebViewClient(Context context) {
		// TODO Auto-generated constructor stub
		setContext(context);
	}
	
	@Override
	public void onReceivedHttpAuthRequest(WebView view,
			HttpAuthHandler handler, String host, String realm) {
		super.onReceivedHttpAuthRequest(view, handler, host, realm);
	}
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		view.loadUrl(url);
		if(getListenerContext()!=null)
			getListenerContext().onCall(new SimpleWebViewClientEvent(SimpleWebViewClientEvent.ON_LOADING, url));
		return super.shouldOverrideUrlLoading(view, url);
	}

	@Override
	public void onPageStarted(WebView view, String url, Bitmap favicon) {
		if(getListenerContext()!=null)
			getListenerContext().onCall(new SimpleWebViewClientEvent(SimpleWebViewClientEvent.ON_START, url));
		super.onPageStarted(view, url, favicon);
	}

	@Override
	public void onPageFinished(WebView view, String url) {
		if(getListenerContext()!=null)
			getListenerContext().onCall(new SimpleWebViewClientEvent(SimpleWebViewClientEvent.ON_FINISH, url));
		super.onPageFinished(view, url);
	}

	public Context getContext() {
		return mContext;
	}

	public void setContext(Context mContext) {
		this.mContext = mContext;
	}
	
	public IActivity getActivityContext(){
		return (getContext() instanceof IActivity)?(IActivity)getContext():null;
	}
	
	public BaseListenerInf getListenerContext(){
		return (getContext() instanceof BaseListenerInf)?(BaseListenerInf)getContext():null;
	}
}
