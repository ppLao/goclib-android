package org.goclib.android.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.goclib.android.core.BaseApplication;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

public final class ConvertUtil {
	public static ContentValues MapWriteToContentValues(Map<String,Object>from,ContentValues to){
		if(from == null || from.isEmpty()){
			LogUtil.error("[from] object was null or empty ,contentvalues should be return null");
			return null;
		}
		if(to == null)
			to = new ContentValues();
		for(Entry<String,Object> e:from.entrySet()){
			to.put(e.getKey(), String.valueOf(e.getValue()));
		}
		return to;
	}
	
		public static InputStream Byte2InputStream(byte[] b) {
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			return bais;
		}

		public static byte[] InputStream2Bytes(InputStream is) {
			String str = "";
			byte[] readByte = new byte[1024];
			int readCount = -1;
			try {
				while ((readCount = is.read(readByte, 0, 1024)) != -1) {
					str += new String(readByte).trim();
				}
				return str.getBytes();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public static InputStream Bitmap2InputStream(Bitmap bm) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
			InputStream is = new ByteArrayInputStream(baos.toByteArray());
			return is;
		}

		public static InputStream Bitmap2InputStream(Bitmap bm, int quality) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bm.compress(Bitmap.CompressFormat.PNG, quality, baos);
			InputStream is = new ByteArrayInputStream(baos.toByteArray());
			return is;
		}

		public static Bitmap InputStream2Bitmap(InputStream is) {
			return BitmapFactory.decodeStream(is);
		}

		public static InputStream Drawable2InputStream(Drawable d) {
			Bitmap bitmap = drawable2Bitmap(d);
			return Bitmap2InputStream(bitmap);
		}

		public static Drawable InputStream2Drawable(InputStream is) {
			Bitmap bitmap = InputStream2Bitmap(is);
			return bitmap2Drawable(bitmap);
		}

		public static byte[] Drawable2Bytes(Drawable d) {
			Bitmap bitmap = drawable2Bitmap(d);
			return Bitmap2Bytes(bitmap);
		}

		public static Drawable Bytes2Drawable(byte[] b) {
			Bitmap bitmap =Bytes2Bitmap(b);
			return bitmap2Drawable(bitmap);
		}

		public static byte[] Bitmap2Bytes(Bitmap bm) {
			return Bitmap2Bytes(bm,Bitmap.CompressFormat.PNG,100);
		}
		
		public static byte[] Bitmap2Bytes(Bitmap bm,Bitmap.CompressFormat format) {
			return Bitmap2Bytes(bm,format,100);
		}
		
		public static byte[] Bitmap2Bytes(Bitmap bm,Bitmap.CompressFormat format,int quality) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			bm.compress(format, quality, baos);
			return baos.toByteArray();
		}

		public static Bitmap Bytes2Bitmap(byte[] b) {
			if (b.length != 0) {
				return BitmapFactory.decodeByteArray(b, 0, b.length);
			}
			return null;
		}

		public static Bitmap drawable2Bitmap(Drawable drawable) {
			Bitmap bitmap = Bitmap
					.createBitmap(
							drawable.getIntrinsicWidth(),
							drawable.getIntrinsicHeight(),
							drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
									: Bitmap.Config.RGB_565);
			Canvas canvas = new Canvas(bitmap);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			drawable.draw(canvas);
			return bitmap;
		}

		public static Drawable bitmap2Drawable(Bitmap bitmap) {
			BitmapDrawable bd = new BitmapDrawable(bitmap);
			Drawable d = (Drawable) bd;
			return d;
		}
	
	
	public static <T> T json2Bean(JSONObject jObject, Class<T> cls)
			throws Exception {
		T t = cls.newInstance();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			Class<?> typeClass = field.getType();
			String fieldName = field.getName();
			field.setAccessible(true);
			// ????????????????
			if (jObject.isNull(fieldName)) {
				// field.set(fieldName, null);
			} else if (typeClass == String.class) {
				String value = jObject.optString(fieldName);
				field.set(t, value);
			} else if (typeClass == int.class || typeClass == Integer.class) {
				int value = jObject.optInt(fieldName);
				field.setInt(t, value);
			} else if (typeClass == long.class || typeClass == Long.class) {
				long value = jObject.optLong(fieldName);
				field.setLong(t, value);
			} else if (typeClass == float.class || typeClass == Float.class) {
				Float value = (Float) jObject.opt(fieldName);
				field.setFloat(t, value);
			} else if (typeClass == double.class || typeClass == Double.class) {
				double value = jObject.optDouble(fieldName);
				Log.e("fieldName", fieldName);
				field.setDouble(t, value);
			} else if (typeClass == java.util.Date.class
					|| typeClass == java.sql.Date.class) {
				Object value = jObject.opt(fieldName);
				field.set(t, formatDate(value));
			} else if (typeClass == byte.class || typeClass == Byte.class) {
				byte value = (byte) jObject.optInt(fieldName);
				field.set(t, value);
			} else if (typeClass == List.class) {
			//	field.set(t, null);
			}else {
				Object value = jObject.opt(fieldName);
				field.set(t, value);
			}
		}
		return t;
	}

	
	public static <T> T json2Bean(String json, Class<T> cls) throws Exception {
		return json2Bean(new JSONObject(json), cls);
	}

	public static <T> List<T> json2Beans(String jsons, Class<T> cls)
			throws Exception {
		return jsonArray2Beans(new JSONArray(jsons), cls);
	}


	public static <T> List<T> jsonArray2Beans(JSONArray jArray, Class<T> cls)
			throws Exception {
		int arrayLen = jArray.length();
		List<T> jsonList = new ArrayList<T>(arrayLen);
		for (int i = 0; i < arrayLen; i++) {
			JSONObject jObject = jArray.getJSONObject(i);
			T bean = json2Bean(jObject, cls);
			jsonList.add(bean);
		}
		return jsonList;
	}

	public static <T> List<T> jsonArray2Beans(String json, Class<T> cls)
			throws Exception {
		return jsonArray2Beans(new JSONArray(json), cls);
	}

	public static <T> List<Map<String, Object>> jsonArray2List(String json)
			throws Exception {
		if (json == null) {
			return new ArrayList<Map<String,Object>>();
		}
		return jsonArray2List(new JSONArray(json));
	}

	public static List<Map<String, Object>> jsonArray2List(JSONArray jArray)
			throws Exception {
		int arrayLen = jArray.length();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>(
				arrayLen);
		for (int i = 0; i < arrayLen; i++) {
			JSONObject jObject = jArray.getJSONObject(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map = json2Map(jObject);
			mapList.add(map);
		}
		return mapList;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> json2Map(JSONObject jObject)
			throws Exception {
		if (jObject == null) {
			return new HashMap<String, Object>();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> it = jObject.keys();
		while (it.hasNext()) {
			String field = (String) it.next();
			Object value = jObject.get(field);
			if (jObject.isNull(field)) {
				value = "";
			}
			map.put(field, value);
		}
		return map;
	}

	public static Map<String, Object> json2Map(String json) throws Exception {
//		if(json!=null && json.startsWith("\ufeff")){
//			json = json.substring(1);
//		}
		return json2Map(new JSONObject(json));
	}
	private static Date formatDate(Object obj) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		Date dDate = new Date();
		String sDate = obj.toString();
		int len = sDate.length();
		switch (len) {
		case 10:
			simpleDateFormat.applyPattern("yyyy-MM-dd");
			break;
		case 16:
			simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm");
			break;
		case 19:
			simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
			break;
		case 21:
			simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
			break;
		default:
			return null;
		}

		try {
			dDate = simpleDateFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dDate;
	}
	
	public static JSONObject map2Json(Map<String,Object>map){
		JSONObject j=new JSONObject(map);
		return j;
	}
	public static JSONArray list2Json(List<Map<String,Object>>list){
		JSONArray arr = new JSONArray(list);
		return arr;
	}
	public static float convertTextSize(float size){
		return convertTextSize(size, ApplicationUtils.defaultContext == null?BaseApplication.getInstance():ApplicationUtils.defaultContext,false);
	}
	public static float convertTextSize(float size,Context context){
		return convertTextSize(size, context,false);
	}
	public static float convertTextSize(float size,boolean useApplicationDisplayMetrics){
		return convertTextSize(size, ApplicationUtils.defaultContext == null?BaseApplication.getInstance():ApplicationUtils.defaultContext,useApplicationDisplayMetrics);
	}
	public static float convertTextSize(float size,Context context,boolean useApplicationDisplayMetrics){
		float _scale=useApplicationDisplayMetrics?ApplicationUtils.getDisplayMetrics(context).scaledDensity:context.getResources().getDisplayMetrics().scaledDensity;
		return size/_scale;
	}
	public static float convertDimension(int dimen){
		return convertDimension(dimen, false);
	}
	public static float convertDimension(int dimen,boolean useApplicationDisplayMetrics){
		return convertDimension(dimen, ApplicationUtils.defaultContext == null?BaseApplication.getInstance():ApplicationUtils.defaultContext,useApplicationDisplayMetrics);
	}
	public static float convertDimension(int dimen,Context context){
		return convertTextSize(context.getResources().getDimension(dimen), context,false);
	}
	public static float convertDimension(int dimen,Context context,boolean useApplicationDisplayMetrics){
		return convertTextSize(context.getResources().getDimension(dimen), context,useApplicationDisplayMetrics);
	}
	
	public static String Uri2Path(Uri uri,Activity context){
		  String[] proj = { MediaStore.Images.Media.DATA };
		  Cursor actualimagecursor = context.managedQuery(uri,proj,null,null,null);    
		  int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);     
		  actualimagecursor.moveToFirst(); 
		  return actualimagecursor.getString(actual_image_column_index);
	}
}
