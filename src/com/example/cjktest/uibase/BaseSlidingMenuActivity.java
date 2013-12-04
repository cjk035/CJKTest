package com.example.cjktest.uibase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.cjktest.R;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.SlidingMenu.OnCloseListener;
import com.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.slidingmenu.lib.SlidingMenu.OnOpenListener;
import com.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.slidingmenu.lib.app.SlidingFragmentActivity;



public abstract class BaseSlidingMenuActivity extends SlidingFragmentActivity implements OnOpenListener,
OnOpenedListener, OnCloseListener, OnClosedListener{
	private SlidingMenu sm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initSlidingMenu();
	}
	
	 // [start]初始化函数
    private void initSlidingMenu() {
        setBehindContentView(R.layout.behind_slidingmenu);
        
        sm = getSlidingMenu();
        
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.slidingmenu_shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm.setBehindScrollScale(0.0f);
    }
    
    /**
     * 设置左边的菜单页面
     */
    protected abstract void setLeftMenuActivity(Class<?> cls);
    
    /**
     * 设置中间的containerView
     * @return
     */
    protected LinearLayout getMiddleContainerView(){
    	return null;
    };
    
	@Override
	/**
	 * SlidingMenu关闭后
	 */
	public void onClosed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * SlidingMenu关闭前
	 */
	public void onClose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * SlidingMenu打开后
	 */
	public void onOpened() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * SlidingMenu打开前
	 */
	public void onOpen() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
	}
}
