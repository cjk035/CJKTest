package com.example.cjktest;

import android.content.Intent;
import android.view.KeyEvent;

import com.example.cjktest.model.ActivityManagerModel;
import com.example.cjktest.uibase.ChildActivity;
import com.example.cjktest.uibase.RootActivity;

public abstract class BaseRootActivity extends RootActivity {
	/**
	 * 设置导航状态
	 */
	public void setNavState(){
		int index = getCurrentActivity().setNavIndex();
		
	}
	
	/**
	 * 获取当前的activity
	 */
	public BaseChildActivity getCurrentActivity(){
		return (BaseChildActivity)super.getCurrentActivity();
	}
	
	/**
	 * 设置标题
	 * @param title
	 */
	public abstract void setTopTitle(String title);
	
	
	
	

}
