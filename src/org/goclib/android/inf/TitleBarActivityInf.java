package org.goclib.android.inf;


import java.util.List;

import org.goclib.android.control.TitleBarContoller;
import org.goclib.android.entity.GoclBaseEntity;
import org.goclib.android.ui.TitleBar;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Parcelable;

public interface TitleBarActivityInf {
	public TitleBar getTitleBar();
	public TitleBarContoller getTitleBarContoller();
	public void onSelectTitleBarLeft(boolean selected);
	public void onSelectTitleBarTitle(boolean selected);
	public void onSelectTitleBarRight(boolean selected);
	public void onChangeTitleBarLeft(Object value);
	public void onChangeTitleBarTitle(Object value);
	public void onChangeTitleBarRight(Object value);
	public Handler getHandler();
	public Class<?> getContext();
	
//	Intent requestIntent(Class<? extends Activity>cls);
//	Intent requestIntent(Class<? extends Activity> cls, GoclBaseEntity data);
//	Intent requestIntent(Class<? extends Activity> cls, GoclBaseEntity[] data);
//	Intent requestIntent(Class<? extends Activity> cls, List<GoclBaseEntity> data);
}
