package com.example.cjktest;

import com.example.cjktest.log.CJKLog;
import com.example.cjktest.model.ActivityManagerModel;
import com.example.cjktest.uibase.ChildActivity;
import com.example.cjktest.uibase.OnChildActivityLifeListener;
import com.example.cjktest.uibase.RootActivity;
import com.example.cjktest.view.BaseNavBar.OnClickNavBarListener;
import com.example.cjktest.view.BottomNavbar;
import com.example.cjktest.view.VerticalAnimView;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends BaseRootActivity implements OnClickNavBarListener, OnChildActivityLifeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BottomNavbar bottomNavbar;
	private TextView titleTv;
	private VerticalAnimView verticalAnimView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		Intent intent = new Intent(this, IndexActivity.class);
		IndexActivity indexActivity = ((IndexActivity) startCActivity(IndexActivity.class, intent, this));
		
		TextView titleView = new TextView(this);
		titleView.setText(indexActivity.getTopTitle());
		
		bottomNavbar = (BottomNavbar) findViewById(R.id.bottomNavbar);
		bottomNavbar.setOnClickNavBarListener(this);
		indexActivity.setNavBar(bottomNavbar);
		
		verticalAnimView = (VerticalAnimView) findViewById(R.id.verticalAnimView);
		verticalAnimView.addBotInView(titleView);
		
		setLeftMenuActivity(LeftMenuActivity.class);
//		titleTv = (TextView) findViewById(R.id.titleTv);
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
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		BaseChildActivity childActiviy = (BaseChildActivity) ActivityManagerModel.getForegroundActivity();
		if(childActiviy.setNavIndex() > 0){
			Intent intent = new Intent(this, IndexActivity.class);
			startCActivity(IndexActivity.class, intent, this);
			return false;
		}else if(childActiviy.setNavIndex() == 0){
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
	public void leftMenu(View v){
		if(getSlidingMenu().isMenuShowing()){
			showContent();
		}else{
			showMenu();
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
		
		BaseChildActivity baseChild = (BaseChildActivity) activity;
		TextView titleView = new TextView(this);
		titleView.setText(baseChild.getTopTitle());
		verticalAnimView.addBotInView(titleView);
	}

	@Override
	public void onChildActivityPause(ChildActivity activity) {
		// TODO Auto-generated method stub
		CJKLog.print("---onChildActivityPause="+activity.getClass().getSimpleName());
		
		BaseChildActivity baseChild = (BaseChildActivity) activity;
		TextView titleView = new TextView(this);
		titleView.setText(baseChild.getTopTitle());
		verticalAnimView.addTopOutView(titleView);
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

	@Override
	public void setTopTitle(String title) {
		// TODO Auto-generated method stub
//		titleTv.setText(title);
	}
}
