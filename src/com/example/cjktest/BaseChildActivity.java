package com.example.cjktest;

import com.example.cjktest.log.CJKLog;
import com.example.cjktest.uibase.ChildActivity;
import com.example.cjktest.view.BaseNavBar;

public class BaseChildActivity extends ChildActivity{
	
	private BaseNavBar mBaseNavBar;
	/**
	 * 设置底部栏索引
	 * @return
	 */
	protected int setNavIndex(){
		return -1;
	}
	
	/**
	 * 设置导航栏
	 * @param baseNavBar
	 */
	protected void setNavBar(BaseNavBar baseNavBar){
		mBaseNavBar = baseNavBar;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		CJKLog.print("setNavIndex()="+setNavIndex());
		if(mBaseNavBar != null && setNavIndex() > -1){
			mBaseNavBar.setSeleted(setNavIndex());
			CJKLog.print("---setNavIndex()="+setNavIndex());
		}
	}
}
