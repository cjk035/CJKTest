package com.example.cjktest.uibase;


import com.example.cjktest.R;
import com.example.cjktest.log.CJKLog;
import com.example.cjktest.model.ActivityManagerModel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

/**
 * 中间页面的基类
 * 
 * @author sheng
 * 
 */
public class ChildActivity extends FragmentActivity {
	/** 生命周期监听器*/
	private OnChildActivityLifeListener mLifeListener;
	
	private RootActivity mRootActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		if(getIntent() != null){
			mLifeListener = (OnChildActivityLifeListener)getIntent().getSerializableExtra("OnChildActivityChangeListener");
			mRootActivity = (RootActivity) getIntent().getSerializableExtra("RootActivity");
		}
		ActivityManagerModel.addLiveActivity(this);
		CJKLog.print("onCreate--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityCreate(this);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		ActivityManagerModel.addVisibleActivity(this);
		CJKLog.print("onStart--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityStart(this);
		}
	}

	@Override
	protected void onStop() {
		super.onStop();
		ActivityManagerModel.removeVisibleActivity(this);
		CJKLog.print("onStop--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityStop(this);
		}
	}

	@Override   
	protected void onRestart() {
		super.onRestart();
		CJKLog.print("onRestart--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityRestart(this);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		ActivityManagerModel.addForegroundActivity(this);
		CJKLog.print("onResume--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityResume(this);
		}
		System.out.println("mListener="+mLifeListener);
	}

	@Override
	protected void onPause() {
		super.onPause();
		ActivityManagerModel.removeForegroundActivity(this);
		CJKLog.print("onPause--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityPause(this);
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityManagerModel.removeLiveActivity(this);
		CJKLog.print("onDestroy--"+getClass().getSimpleName());
		if(mLifeListener != null){
			mLifeListener.onChildActivityDestroy(this);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		CJKLog.print("onActivityResult--"+getClass().getSimpleName());
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		CJKLog.print("onKeyDown--"+getClass().getSimpleName());
		return false;
	}
	
	/**
	 * 启动兄弟Activity（与当前Activity同在RootActivity中的Activity）
	 */
	protected void startBActivity(Class<?> cls, Intent intent, OnChildActivityLifeListener listener){
		if(mRootActivity != null){
			mRootActivity.startCActivity(cls, intent, listener);
		}
	}
	
	/**
	 * 返回子Activity的生命周期监听器
	 * @return
	 */
	public OnChildActivityLifeListener getOnChildActivityLifeListener(){
		return mLifeListener;
	}
	
	/**
	 * 返回RootActivity
	 * @return
	 */
	public RootActivity getRooActivity(){
		return mRootActivity;
	}
	
	@Override
	public void finish() {
		if(mRootActivity == null){
//			mRootActivity.childFinish(this);
			mRootActivity.finishFromChild(this);
		}
	}
}
