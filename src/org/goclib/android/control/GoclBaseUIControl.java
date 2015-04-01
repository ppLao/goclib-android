package org.goclib.android.control;

import org.goclib.android.inf.GoclDestroyInf;
import org.goclib.android.inf.GoclInitInf;
import org.goclib.android.inf.GoclSourceInf;
import org.goclib.android.inf.GoclUInf;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

public abstract class GoclBaseUIControl implements GoclUInf,GoclInitInf,GoclDestroyInf,GoclSourceInf {

	private Context mContext=null;
	private Object mOwner=null;
	private Object mSource=null;
	private boolean mInited=false;
	private boolean mDestroy=false;
	private Object mData=null;
	

	public GoclBaseUIControl(){
		this(null,null,false);
		//initialize();
	}
	
	
	public GoclBaseUIControl(Context context){
		this(context,null,true);
		//initialize();
	}
	
	public GoclBaseUIControl(Object owner){
		this(null,owner,true);
	}
	
	public GoclBaseUIControl(Context context,Object owner){
		this(context,owner,true);
	}
	
	public GoclBaseUIControl(Context context,Object owner,boolean autoInitialize){
		setContext(context);
		setOwner(owner);
		if(autoInitialize)
			initialize();
	}
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		if(!isInited())
			restore(null);
	}

	@Override
	public void restore(Object arg) {
		// TODO Auto-generated method stub
		if(!isDestroy())
			destroy();
		mInited = true;
		mDestroy = false;
		prepare(null);
	}
	
	
	@Override
	public void setContext(Context context) {
		// TODO Auto-generated method stub
		mContext = context;
	}

	@Override
	public Context getContext() {
		// TODO Auto-generated method stub
		return mContext;
	}
	
	@Override
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return getContext() instanceof Activity ? (Activity)getContext():null;
	}
	
	@Override
	public  void setData(Object object ,boolean immediately) {
		// TODO Auto-generated method stub
		mData = object;
		if(immediately)
			invalidate();
	}

	@Override
	public void setData(Object object) {
		// TODO Auto-generated method stub
		setData(mData,true);
	}
	
	@Override
	public <T> T getData() {
		// TODO Auto-generated method stub
		return (T) mData;
	}

	@Override
	public void setOwner(Object owner) {
		// TODO Auto-generated method stub
		mOwner = owner;
	}

	@Override
	public <T> T getOwner() {
		// TODO Auto-generated method stub
		return (T) mOwner;
	}

	@Override
	public boolean isDestroy() {
		// TODO Auto-generated method stub
		return mDestroy;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		if(isDestroy())
			return;
		mDestroy=true;
		mInited=false;
		if(getOwner()!=null && getOwner() instanceof GoclDestroyInf)
			((GoclDestroyInf)getOwner()).destroy();
		setOwner(null);
		
	}

	

	@Override
	public boolean isInited() {
		// TODO Auto-generated method stub
		return mInited;
	}

	@Override
	public Object getSource() {
		// TODO Auto-generated method stub
		return  mSource;
	}

	@Override
	public void setSource(Object value) {
		// TODO Auto-generated method stub
		mSource = value;
	}

	
}
