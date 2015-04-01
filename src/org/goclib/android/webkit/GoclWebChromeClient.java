package org.goclib.android.webkit;

import org.goclib.android.utils.ApplicationUtils;
import org.goclib.android.utils.LogUtil;
import org.goclib.android.utils.cons.AppConst;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;

public class GoclWebChromeClient extends WebChromeClient {
	private Context mContext=null;
	private ValueCallback<Uri> mValueCallback;
	public GoclWebChromeClient(Context context) {
		// TODO Auto-generated constructor stub
		this.setContext(context);
	}
	
	// For Android 3.0+
    public void openFileChooser(ValueCallback<Uri> uploadMsg) {  
        //mUploadMessage = uploadMsg;
	    	LogUtil.trace(uploadMsg,this);
	    	mValueCallback=uploadMsg;
	        Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
	        i.addCategory(Intent.CATEGORY_OPENABLE);  
	        i.setType("image/*");  
	        getActivity().startActivityForResult(Intent.createChooser(i,"File Chooser"), AppConst.CODE_GET_CONTENT_RESULT);  

       }

    // For Android 3.0+
       public void openFileChooser( ValueCallback<Uri> uploadMsg, String acceptType ) {
	      // mUploadMessage = uploadMsg;
	   	   LogUtil.trace(uploadMsg,this);
	   	   mValueCallback=uploadMsg;
	       Intent i = new Intent(Intent.ACTION_GET_CONTENT);
	       i.addCategory(Intent.CATEGORY_OPENABLE);
	       i.setType("*/*");
	       getActivity().startActivityForResult(Intent.createChooser(i, "File Browser"),AppConst.CODE_GET_CONTENT_RESULT);
       }

    //For Android 4.1
       public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture){
    	   LogUtil.trace(uploadMsg,this);
    	   mValueCallback=uploadMsg;
           Intent i = new Intent(Intent.ACTION_GET_CONTENT);  
           i.addCategory(Intent.CATEGORY_OPENABLE);
           //i.addCategory(Intent.category_);
           i.setType("image/*");  
           getActivity().startActivityForResult( Intent.createChooser( i, "File Chooser" ), AppConst.CODE_GET_CONTENT_RESULT);
           //ApplicationUtils.ta
       }
       

	public Context getContext() {
		return mContext;
	}

	public void setContext(Context mContext) {
		this.mContext = mContext;
	}
	
	public Activity getActivity(){
		return getContext() == null ? null : (Activity)getContext();
	}

	public ValueCallback<Uri> getValueCallback() {
		return mValueCallback;
	}

//	public void setValueCallback(ValueCallback<Uri> mValueCallback) {
//		this.mValueCallback = mValueCallback;
//	}
}
