package com.example.cjktest;

import android.widget.TextView;

import com.example.cjktest.log.CJKLog;
import com.example.cjktest.uibase.ChildActivity;
import com.example.cjktest.view.BaseNavBar;

public abstract class BaseChildActivity extends ChildActivity{
	
	private BaseNavBar mBaseNavBar;
	private String title;
	
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
		((BaseRootActivity)getRooActivity()).setTopTitle(title);
	}
	
	protected void setTopTiltle(String title){
		this.title = title;
	}
	
	/**
	 * 返回顶部标题
	 * @return
	 */
	public String getTopTitle(){
		return title;
	}
	
	
}
