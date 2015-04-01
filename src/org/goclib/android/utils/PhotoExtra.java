package org.goclib.android.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;


public class PhotoExtra{
	public String ASPECT_X="aspectX";
	public String ASPECT_Y="aspectY";
	public String OUTPUT_X="outputX";
	public String OUTPUT_Y="outputY";
	public String CROP="crop";
	public String SCALE="scale";
	public String RETURN_DATA="return-data";
	public String OUTPUT_FORMAT="outputFormat";
	public String NO_FACE_DETECTION="noFaceDetection";
	public Uri dataOutput;
	public Uri data;
	
	public int aspectX=1;
	public int aspectY=1;
	public int outputX=0;
	public int outputY=0;
	public boolean scale=false;
	public boolean return_data=false;
	public boolean noFaceDetection=true;
	public Bitmap.CompressFormat outputFormat=Bitmap.CompressFormat.JPEG;
	private PhotoExtra thiz;
	
	public PhotoExtra(){
		thiz=this;
	}
	public PhotoExtra setAspectX(int v){
		aspectX=v;
		return thiz;
	}
	public PhotoExtra setAspectY(int v){
		aspectY=v;
		return thiz;
	}
	public PhotoExtra setDataOutput(Uri v){
		dataOutput=v;
		return thiz;
	}
	public PhotoExtra setOutputX(int v){
		outputX=v;
		return thiz;
	}
	public PhotoExtra setOutputY(int v){
		outputY=v;
		return thiz;
	}
	public PhotoExtra setScale(boolean v){
		scale=v;
		return thiz;
	}
	public PhotoExtra setReturnData(boolean v){
		return_data=v;
		return thiz;
	}
	public PhotoExtra setNoFaceDetection(boolean v){
		noFaceDetection=v;
		return thiz;
	}
	public PhotoExtra setData(Uri data){
		this.data=data;
		return thiz;
	}
	
	public Intent getCrop(Intent out){
		Intent in = out == null?new Intent():out;
		in.putExtra(CROP, "true");
		in.putExtra(ASPECT_X, aspectX);
		in.putExtra(ASPECT_Y, aspectY);
		if(outputX>=0)
			in.putExtra(OUTPUT_X, outputX);
		if(outputY>=0)
			in.putExtra(OUTPUT_Y, outputY);
		in.putExtra(SCALE, scale);
		in.putExtra(RETURN_DATA, return_data);
		in.putExtra(NO_FACE_DETECTION, noFaceDetection);
		in.putExtra(OUTPUT_FORMAT, outputFormat);
		if(data==null)
			data=dataOutput;
		if(dataOutput!=null)
			in.putExtra(MediaStore.EXTRA_OUTPUT, dataOutput);
		if(data!=null)
			in.setDataAndType(data,"image/*");
		return in;
	}
	
	
}
