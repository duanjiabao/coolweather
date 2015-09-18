package com.example.mtview_0912;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 隐藏标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置成全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// 设置为上面的MTView
		setContentView(new MTView(this));
		
//		SystemClock.sleep(3000);
//		System.exit(0);//退出虚拟机
//		android.os.Process.killProcess(android.os.Process.myPid());//杀死进程，因为有时虽然Activity退出了的，但是进程还没有退出
		startService(new Intent("com.test.demo.MYSERVICE"));
		
	}
	//软引用
	public Object testSoftReference(String key){  
	    Object obj=null;  
	    Map<String, SoftReference<Object>> map=new HashMap<String, SoftReference<Object>>();  
	    SoftReference<Object> reference=map.get(key);  
	    if(reference!=null){  
	        obj=reference.get();  
	        if(obj!=null){  
	            return obj;  
	        }  
	    }  
	    obj=getObj(key);  
	    reference=new SoftReference<Object>(obj);  
	    map.put(key, reference);  
	    return obj;  
	 }
	private Object getObj(String key) {
		// TODO Auto-generated method stub
		return null;
	}  
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stopService(new Intent("com.test.demo.MYSERVICE"));
	}
}   