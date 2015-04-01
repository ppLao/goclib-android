package org.goclib.android.core;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.goclib.android.utils.LogUtil;

import android.app.Activity;
import android.content.Context;

public final class ActivityManager {
        
	private Context ctx; 
    
    private static ActivityManager activityManager; 
      
    public static ActivityManager getInstance(Context context){ 
        if(activityManager == null)
        	activityManager = new ActivityManager(context); 
        return activityManager; 
    } 
      
    private ActivityManager(Context context){ 
        ctx = context; 
    } 
      
    
    private final HashMap<String, SoftReference<Activity>> taskMap = new HashMap<String, SoftReference<Activity>>(); 
      
    
    public final void add(Activity atv) {
    	//LogUtil.trace("<add to activity manager>"+atv.toString());
        taskMap.put(atv.toString(), new SoftReference<Activity>(atv)); 
    } 
    
    
    public final void remove(Activity atv) { 
    	LogUtil.trace("<remove activity>"+atv,this);
        taskMap.remove(atv.toString()); 
    }      
   
    public final void exit() { 
    	//LogUtil.trace("<on exit taskmap count>"+taskMap.size());
        for (Iterator<Entry<String, SoftReference<Activity>>> iterator = taskMap.entrySet().iterator(); iterator.hasNext();) { 
                SoftReference<Activity> activityReference =  iterator.next().getValue(); 
                Activity activity = activityReference.get(); 
                LogUtil.trace("<on clear activity>"+activity,this);
                if (activity != null ) 
                	activity.finish(); 
        } 
        taskMap.clear(); 
    }
  
}
