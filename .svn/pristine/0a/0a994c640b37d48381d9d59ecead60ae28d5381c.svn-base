package org.goclib.android.control;

import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.BaseSourceInf;

public class BaseController {
	private BaseSourceInf mSource;
	private BaseListenerInf mListener=null;
	
	public BaseController(){
		this(null);
		
	}
	
	protected void prepearSourceEvent(){
		
	}
	
	protected void clearSourceEvent(){
		
	}
	
	public BaseController(BaseSourceInf source){
		setSource(source);
		
	}

	public BaseSourceInf getSource() {
		return mSource;
	}

	public void setSource(BaseSourceInf mSource) {
		clearSourceEvent();
		this.mSource = mSource;
		prepearSourceEvent();
	}

	public BaseListenerInf getListener() {
		return mListener;
	}
	
	public void removeListener(){
		if(getSource()!=null)
			getSource().removeListener(mListener);
	}

	public void addListener(BaseListenerInf mListener) {
		this.mListener = mListener;
		if(getSource()!=null)
			getSource().addListener(mListener);
	}
}
