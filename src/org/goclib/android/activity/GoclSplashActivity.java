package org.goclib.android.activity;

import java.util.Timer;
import java.util.TimerTask;

import org.goclib.android.events.BaseEvent;
import org.goclib.android.inf.BaseListenerInf;
import org.goclib.android.inf.RunnerTask;


abstract public class GoclSplashActivity extends GocBaseActivity implements RunnerTask,BaseListenerInf {
	public static final int ON_COMPLETE=-100;
	
	private Timer timer = new Timer();
	private TimerTask task = new MyTimerTask();
	public static long DEFAULT_DELAY=3000;
	public static long DEFAULT_PERIOD=1000;
	
	@Override
	public void splashStart() {
		// TODO Auto-generated method stub
		splashStart(DEFAULT_DELAY, DEFAULT_PERIOD);
	}
	
	@Override
	public void splashStart(long delay) {
		// TODO Auto-generated method stub
		splashStart(delay, DEFAULT_PERIOD);
	}
	
	@Override
	public void splashStart(long delay,long period){
		// TODO Auto-generated method stub
		if(timer!=null){
			timer.cancel();
			timer.purge();
			timer = null;
		}
		if (task != null) {
			task.cancel();
			task = null;
		}
		task = new MyTimerTask();
		timer=new Timer();
		timer.schedule(task,delay,period);
		
	}
	
	public class MyTimerTask extends TimerTask {
		public void run() {
			timer.cancel();
			timer.purge();
			timer = null;
			//getHandler().obtainMessage(ON_COMPLETE);
			onCall(new BaseEvent(BaseEvent.ON_SPLASH_COMPLETE, null));
		}
		
	}

	@Override
	public void onCall(BaseEvent event) {
		// TODO Auto-generated method stub
		if(event.getType().equals(BaseEvent.ON_SPLASH_COMPLETE)){
			splashComplete();
		}
	}

}
