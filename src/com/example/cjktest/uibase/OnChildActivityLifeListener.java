package com.example.cjktest.uibase;

import java.io.Serializable;

/**
 * 监听子Activity的生命周期
 * @author Administrator
 *
 */
public interface OnChildActivityLifeListener extends Serializable{
	
	public void onChildActivityCreate(ChildActivity activity);
	
	public void onChildActivityStart(ChildActivity activity);
	
	public void onChildActivityRestart(ChildActivity activity);
	
	public void onChildActivityResume(ChildActivity activity);
	
	public void onChildActivityPause(ChildActivity activity);
	
	public void onChildActivityStop(ChildActivity activity);
	
	public void onChildActivityDestroy(ChildActivity activity);
}
