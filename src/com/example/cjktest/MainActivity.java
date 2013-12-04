package com.example.cjktest;

import com.example.cjktest.log.CJKLog;
import com.example.cjktest.uibase.ChildActivity;
import com.example.cjktest.uibase.OnChildActivityLifeListener;
import com.example.cjktest.uibase.RootActivity;
import com.example.cjktest.view.BaseNavBar.OnClickNavBarListener;
import com.example.cjktest.view.BottomNavbar;


import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends RootActivity implements OnClickNavBarListener, OnChildActivityLifeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BottomNavbar bottomNavbar;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		bottomNavbar = (BottomNavbar) findViewById(R.id.bottomNavbar);
		bottomNavbar.setOnClickNavBarListener(this);
		Intent intent = new Intent(this, IndexActivity.class);
		((IndexActivity) startCActivity(IndexActivity.class, intent, this)).setNavBar(bottomNavbar);
		setLeftMenuActivity(LeftMenuActivity.class);
	}
	
	@Override
	protected LinearLayout getMiddleContainerView() {
		// TODO Auto-generated method stub
		return (LinearLayout) findViewById(R.id.middle);
	}

	@Override
	public void onClickNavBar(int index) {
		Intent intent = null;
		switch (index) {
		case 0:
			intent = new Intent(this, IndexActivity.class);
			IndexActivity indexActivity = (IndexActivity) startCActivity(IndexActivity.class, intent, this);
			indexActivity.setNavBar(bottomNavbar);
			break;
		case 1:
			intent = new Intent(this, TwoActivity.class);
			TwoActivity twoActivity = (TwoActivity) startCActivity(TwoActivity.class, intent, this);
			twoActivity.setNavBar(bottomNavbar);
			break;
		case 2:
			intent = new Intent(this, ThreeActivity.class);
			ThreeActivity threeActivity = (ThreeActivity) startCActivity(ThreeActivity.class, intent, this);
			threeActivity.setNavBar(bottomNavbar);
			break;
		case 3:
			intent = new Intent(this, FourActivity.class);
			FourActivity fourActivity = (FourActivity) startCActivity(FourActivity.class, intent, this);
			fourActivity.setNavBar(bottomNavbar);
			break;
		case 4:
			intent = new Intent(this, FiveActivity.class);
			FiveActivity fiveActivity = (FiveActivity) startCActivity(FiveActivity.class, intent, this);
			fiveActivity.setNavBar(bottomNavbar);
			break;
		}
	}

	@Override
	public void onChildActivityCreate(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityCreate="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityStart(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityStart="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityRestart(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityRestart="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityResume(ChildActivity activity) {
		// TODO Auto-generated method stub
//		BaseChildActivity baseRootActivity = (BaseChildActivity)activity;
		CJKLog.print("---onChildActivityResume="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityPause(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityPause="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityStop(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityStop="+activity.getClass().getSimpleName());
	}

	@Override
	public void onChildActivityDestroy(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityDestroy="+activity.getClass().getSimpleName());
	}
}
