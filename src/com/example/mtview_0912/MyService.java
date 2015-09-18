package com.example.mtview_0912;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//子线程本来不可以弹土司，但是下面修改后就可以了，不一定这里先出来，子线程不是马上就会执行的
				Looper.prepare();
				Toast.makeText(getApplicationContext(), "xixi", Toast.LENGTH_SHORT).show();
				Looper.loop();
			}
		}).start();
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stubas
		//service中可以弹土司
		Toast.makeText(getApplicationContext(), "haha", Toast.LENGTH_SHORT).show();
		return START_STICKY;
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
}
