package org.goclib.android.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;


public final class FileUtil {
	
	
	public static boolean saveJPG(File file,Bitmap bitmap){
		return saveBitmap(file, bitmap, Bitmap.CompressFormat.JPEG, 80, true);
	}
	public static boolean saveJPG(File file,Bitmap bitmap,int quality,boolean replace){
		return saveBitmap(file, bitmap, Bitmap.CompressFormat.JPEG, quality, replace);
	}
	public static boolean saveJPG(File file,Drawable drawable){
		return saveBitmap(file, drawable, Bitmap.CompressFormat.JPEG, 80, true);
	}
	public static boolean saveJPG(File file,Drawable drawable,int quality,boolean replace){
		return saveBitmap(file, drawable, Bitmap.CompressFormat.JPEG, quality, replace);
	}
	
	public static boolean savePNG(File file,Bitmap bitmap){
		return saveBitmap(file, bitmap, Bitmap.CompressFormat.PNG, 80, true);
	}
	
	public static boolean savePNG(File file,Bitmap bitmap,int quality,boolean replace){
		return saveBitmap(file, bitmap, Bitmap.CompressFormat.PNG, quality, replace);
	}
	public static boolean savePNG(File file,Drawable drawable){
		return saveBitmap(file, drawable, Bitmap.CompressFormat.PNG, 80, true);
	}
	public static boolean savePNG(File file,Drawable drawable,int quality,boolean replace){
		return saveBitmap(file, drawable, Bitmap.CompressFormat.PNG, quality, replace);
	}
	
	public static boolean saveBitmap(File file,Drawable drawable,Bitmap.CompressFormat format,int quality,boolean replace){
		return saveBitmap(file, ConvertUtil.drawable2Bitmap(drawable), format, quality, replace);
	}
	
	public static boolean saveBitmap(File file,Bitmap bitmap,Bitmap.CompressFormat format,int quality,boolean replace){
		boolean result=false;
		if(file.exists()){
			if(replace)
				file.delete();
			else
				return result;
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.trace(e.getMessage(),"FileUtil");
			//return result;
		}
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.trace(e.getMessage(),"FileUtil");
			//return result;
		}
		bitmap.compress(format, quality, fos);
		try {
			fos.flush();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.trace(e.getMessage(),"FileUtil");
		}
		result=true;
		return result;
	}
}
