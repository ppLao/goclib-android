package org.goclib.android.ui;

import java.lang.reflect.Method;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;

public class LocalWebView extends WebView {

	public LocalWebView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public LocalWebView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public LocalWebView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public LocalWebView(Context context, AttributeSet attrs, int defStyleAttr,
			boolean privateBrowsing) {
		super(context, attrs, defStyleAttr, privateBrowsing);
		// TODO Auto-generated constructor stub
	}

	public void enableCrossDomain() {
		try {
			java.lang.reflect.Field field = WebView.class
					.getDeclaredField("mWebViewCore");
			field.setAccessible(true);
			Object webviewcore = field.get(this);
			Method method = webviewcore.getClass().getDeclaredMethod(
					"nativeRegisterURLSchemeAsLocal", String.class);
			method.setAccessible(true);
			method.invoke(webviewcore, "http");
			method.invoke(webviewcore, "https");
		} catch (Exception e) {
			Log.d("wokao", "enablecrossdomain error");
			e.printStackTrace();
		}
	}

	// for android 4.1+
	public void enableCrossDomainForJellyBean() {
		try {
			java.lang.reflect.Field webviewclassic_field = WebView.class
					.getDeclaredField("mProvider");
			webviewclassic_field.setAccessible(true);
			Object webviewclassic = webviewclassic_field.get(this);
			java.lang.reflect.Field webviewcore_field = webviewclassic
					.getClass().getDeclaredField("mWebViewCore");
			webviewcore_field.setAccessible(true);
			Object mWebViewCore = webviewcore_field.get(webviewclassic);
			java.lang.reflect.Field nativeclass_field = webviewclassic
					.getClass().getDeclaredField("mNativeClass");
			nativeclass_field.setAccessible(true);
			Object mNativeClass = nativeclass_field.get(webviewclassic);

			Method method = mWebViewCore.getClass().getDeclaredMethod(
					"nativeRegisterURLSchemeAsLocal",
					new Class[] { int.class, String.class });
			method.setAccessible(true);
			method.invoke(mWebViewCore, mNativeClass, "http");
			method.invoke(mWebViewCore, mNativeClass, "https");
		} catch (Exception e) {
			Log.d("wokao", "enablecrossdomain error");
			e.printStackTrace();
		}
	}

}
