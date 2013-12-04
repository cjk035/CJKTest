package com.example.cjktest;

import com.example.cjktest.uibase.RootActivity;

public class BaseRootActivity extends RootActivity {
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
		return (BaseChildActivity)getCurrentActivity();
	}
}
