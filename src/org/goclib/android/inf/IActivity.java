package org.goclib.android.inf;

import java.util.List;

import org.goclib.android.core.ActivityHelper;
import org.goclib.android.entity.GoclBaseEntity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;

public interface IActivity {
	public void setHandler(Handler value);
	public void setHelper(ActivityHelper mHelper);
	public Handler getHandler();
	public void displayProgressDialog(Boolean value);
	public AlertDialog.Builder displayAlertDialog(String msg);
	public AlertDialog.Builder displayAlertDialog(String msg,OnClickListener onClick);
	public AlertDialog.Builder displayAlertDialog(View v);
	public AlertDialog.Builder displayAlertDialog(View v ,int paddingTop,int paddingLeft,int paddingBottom,int paddingRight);
	
	public int getScreenWidth();
	public int getScreenHeight();
	public void finish();
	public void toHome();
	
	public Parcelable getData();
	public Parcelable[] getDataList();
	
	public boolean init();
	public ActivityHelper getHelper();
	
	public boolean onReturn(ActivityHelper.BACK_STATUS backStatus);
	public Intent getResultIntentForBackStatusMode(GoclBaseEntity data);
	public int getResultCodeForBackStatusMode();
	
	Intent requestIntent(Class<? extends Activity>cls);
	Intent requestIntent(Class<? extends Activity> cls, GoclBaseEntity data);
	Intent requestIntent(Class<? extends Activity> cls, GoclBaseEntity[] data);
	Intent requestIntent(Class<? extends Activity> cls, List<GoclBaseEntity> data);
}
