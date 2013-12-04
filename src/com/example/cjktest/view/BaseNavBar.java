package com.example.cjktest.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
/**
 * 导航栏抽象类
 * @author sheng
 *
 */
public abstract class BaseNavBar extends LinearLayout{
	protected OnClickNavBarListener listener;
	@SuppressLint("NewApi")
	public BaseNavBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public BaseNavBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public BaseNavBar(Context context) {
		super(context);
		init(context);
	}
	
	private void init(Context context){
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(setNavLayout(), null);
		addView(view);
		init(view);
	}
	
	/** 设置导航的页面数量*/
	protected abstract int getNavCount();
	
	/** 设置导航的布局文件*/
	protected abstract int setNavLayout();
	
	/** 初始化导航栏在此实现,包括导航栏中按钮的点击事件的设置*/
	protected abstract void init(View view);
	
	/**
	 * 选中的状态
	 * @param selected  选中的索引
	 */
	public abstract void setSeleted(int selectedIndex);
		
	
	/**
	 * 设置底部导航栏的点击事件,此方法在Activity中调用
	 * @param l
	 */
	public void setOnClickNavBarListener(OnClickNavBarListener l){
		listener = l;
	}
	
	/** 底部兰的点击事件*/
	public interface OnClickNavBarListener{
		/**
		 * 导航栏的点击事件在此实现
		 * @param index  被点击的view的索引
		 */
		public void onClickNavBar(int index);
	}
}
