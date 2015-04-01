package org.goclib.android.inf;

import android.app.Activity;
import android.content.Context;

public interface GoclUInf {
	void setContext(Context context);
	Context getContext();
	Activity getActivity();
	
	void invalidate();
	
	void prepare(Object object); 
	
	void setData(Object object , boolean immediately);
	void setData(Object object);
	<T>T getData();
	
	void setOwner(Object owner);
	<T>T getOwner();
}
