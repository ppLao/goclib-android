package org.goclib.android.utils;

import org.goclib.android.entity.GoclMeasureEntity;
import org.goclib.android.events.BaseEvent;
import org.goclib.android.inf.BaseListenerInf;

import android.view.View;
import android.view.ViewTreeObserver;

public final class MeasureUtil {

	public static MeasureObject getSize(View v){
		int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		v.measure(w, h); 
		int height =v.getMeasuredHeight(); 
		int width =v.getMeasuredWidth(); 
		return new MeasureObject(width, height);
	}
	public static int getWidth(View v){
		int w = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		v.measure(w, 0); 
		return v.getMeasuredWidth();
	}
	public static int getHeight(View v){
		int h = View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED); 
		v.measure(0,h); 
		return v.getMeasuredHeight();
	}
	public static class MeasureObject{
		private float floatWidth=0f;
		private float floatHeight=0f;
		private int intWidth=0;
		private int intHeight=0;
		private boolean isInt=false;
		public MeasureObject(int w,int h){
			intWidth=w;
			intHeight=h;
			isInt=true;
		}
		public MeasureObject(float w,float h){
			floatWidth=w;
			floatHeight=h;
		}
		
		public int getWidth(){
			return intWidth;
		}
		public int getHeight(){
			return intHeight;
		}
	}
	
	public static void getMeasureSizeByViewTreeObserver(View target,BaseListenerInf listener){
		if(target==null|| listener == null){
			return;
		}
		final BaseListenerInf _l=listener;
		final View _t=target;
		ViewTreeObserver vto = target.getViewTreeObserver();
		vto.addOnPreDrawListener(new ViewOnPreDrawListener(_l,_t)); 
	}
	
	public static class ViewOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener{
		private boolean _flag=false;
		private BaseListenerInf _l;
		private View _t;
		public ViewOnPreDrawListener(BaseListenerInf l,View t){
			_flag = false;
			_l=l;
			_t=t;
		}

		@Override
		public boolean onPreDraw() {
			// TODO Auto-generated method stub
			int height = _t.getMeasuredHeight(); 
	        int width = _t.getMeasuredWidth(); 
	        GoclMeasureEntity _entity=new GoclMeasureEntity();
	        _entity
	        	.setHeight(height)
	        	.setWidth(width)
	        	.setId(_t.getId());
	        if(!_flag){
	        	_l.onCall(new BaseEvent(BaseEvent.ON_MEASURE_UI,_entity));
	        	_flag=true;
	        }
	        return true; 
		}
	}
}
