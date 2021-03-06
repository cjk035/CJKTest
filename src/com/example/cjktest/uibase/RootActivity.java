package com.example.cjktest.uibase;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.cjktest.R;
import com.example.cjktest.log.CJKLog;
import com.example.cjktest.model.ActivityManagerModel;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.FrameLayout.LayoutParams;

public class RootActivity extends BaseSlidingMenuActivity implements Serializable{
	
    private static final String STATES_KEY = "android:states";
    static final String PARENT_NON_CONFIG_INSTANCE_KEY = "android:parent_non_config_instance";

    /**
     * This field should be made private, so it is hidden from the SDK.
     * {@hide}
     */
    protected LocalActivityManager mLocalActivityManager;
    private AnimView containerView;
    private LinearLayout leftContainerView;
    
    private ArrayList<OnChildActivityLifeListener> childChangeListeners;
    
    public RootActivity() {
        this(true);
    }
    
    public RootActivity(boolean singleActivityMode) {
        mLocalActivityManager = new LocalActivityManager(this, singleActivityMode);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle states = savedInstanceState != null
                ? (Bundle) savedInstanceState.getBundle(STATES_KEY) : null;
        mLocalActivityManager.dispatchCreate(states);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocalActivityManager.dispatchResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Bundle state = mLocalActivityManager.saveInstanceState();
        if (state != null) {
            outState.putBundle(STATES_KEY, state);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mLocalActivityManager.dispatchPause(isFinishing());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLocalActivityManager.dispatchStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalActivityManager.dispatchDestroy(isFinishing());
    }

    public ChildActivity getCurrentActivity() {
        return (ChildActivity)mLocalActivityManager.getCurrentActivity();
    }
    
    public ChildActivity getChildActivity(String id){
    	return (ChildActivity)mLocalActivityManager.getActivity(id);
    }

    public final LocalActivityManager getLocalActivityManager() {
        return mLocalActivityManager;
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	CJKLog.print("requestCode="+requestCode);
    	CJKLog.print("resultCode="+resultCode);
    	if(getCurrentActivity() != null){
    		getCurrentActivity().onActivityResult(requestCode, resultCode, data);
    	}else{
    		super.onActivityResult(requestCode, resultCode, data);
    	}
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	
    	CJKLog.print("onKeyDown--1---"+getClass().getSimpleName());
    	if(ActivityManagerModel.liveActivityList.size() > 1){
    		
    		CJKLog.print("onKeyDown--2---"+getClass().getSimpleName());
    		getCurrentActivity().onKeyDown(keyCode, event);
    		
    		int size = ActivityManagerModel.liveActivityList.size();
    		ChildActivity activity = ActivityManagerModel.liveActivityList.get(size - 1);
    		
    		mLocalActivityManager.destroyActivity(activity.getClass().getSimpleName(), true);
    		
    		size = ActivityManagerModel.liveActivityList.size();
    		activity = ActivityManagerModel.liveActivityList.get(size - 1);
    		
    		startCActivity(activity.getClass(), new Intent(this, activity.getClass()), activity.getOnChildActivityLifeListener());
    		
    		return false;
    	}else{
    		
    		CJKLog.print("onKeyDown--3---"+getClass().getSimpleName());
    		
    		return super.onKeyDown(keyCode, event);
    	}
    }
    
    /**
     * 销毁子Activity
     * @param activity
     */
    public void childFinish(ChildActivity activity){
    	
    	mLocalActivityManager.destroyActivity(activity.getClass().getSimpleName(), true);
    	int size = ActivityManagerModel.liveActivityList.size();
    	if(size > 0){
    		ChildActivity childActivity = ActivityManagerModel.liveActivityList.get(size - 1);
    		startCActivity(childActivity.getClass(), new Intent(this, childActivity.getClass()), childActivity.getOnChildActivityLifeListener());
    	}  
    }
    
    /**
     * 在RootActivity中启动一个子activity,并返回已启动的BaseActivity实例
     * @param cls      要启动的子Activity
     * @param listener 监听子Activity的生命周期的监听器 ,可以null
     * @return         子Activity
     */
    protected ChildActivity startCActivity(Class<?> cls, Intent intent, OnChildActivityLifeListener listener){
    	if(!ActivityManagerModel.liveActivityList.contains(getChildActivity(cls.getSimpleName()))){
    		intent.putExtra("OnChildActivityChangeListener", listener);
        	intent.putExtra("RootActivity", this);
    	}
    	
    	LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
    	View view = mLocalActivityManager.startActivity(cls.getSimpleName(), intent).getDecorView();
    	view.setTag(cls.getSimpleName());
    	getContainerView().addView(view, params);
    	ChildActivity childActivity = getCurrentActivity();
    	return childActivity;
    }
    
     
    /**
     * 获取containerView
     * @return
     */
    protected AnimView getContainerView(){
    	if(containerView == null){
    		containerView = getMiddleContainerView();
    		containerView.setAnimInId(R.anim.push_left_in);
    		containerView.setAnimOutId(R.anim.push_left_out);
    	}
    	return containerView;
    }

	@Override
	protected void setLeftMenuActivity(Class<?> cls) {
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		LinearLayout view = (LinearLayout) getSlidingMenu().findViewById(R.id.left_menu);
		view.addView(mLocalActivityManager.startActivity(cls.getSimpleName(), new Intent(this, cls)).getDecorView(), params);
	}
}
