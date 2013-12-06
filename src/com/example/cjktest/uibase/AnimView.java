package com.example.cjktest.uibase;

import com.example.cjktest.log.CJKLog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

/**
 * childActivity动画
 * 
 * @author sheng
 * 
 */
public class AnimView extends FrameLayout {

	private Context context;
	private int animOutId;
	private int animInId;
	private Animation animIn, animOut;
	private Handler handler = new Handler();
	

	public AnimView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public AnimView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	public AnimView(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 设置移出动画资源id
	 * @param animOutId
	 */
	public void setAnimOutId(int animOutId) {
		this.animOutId = animOutId;
	}
	
	/**
	 * 设置进入动画资源id
	 * @param animInId
	 */
	public void setAnimInId(int animInId) {
		this.animInId = animInId;
	}
	
	@Override
	public void addView(View child, android.view.ViewGroup.LayoutParams params) {
		
		if(animOutId > 0 && getChildCount() > 0){
			animOut(getChildAt(0));
			removeViewAt(0);
		}
		
		animInt(child);
		child.setVisibility(View.VISIBLE);
		if(child.getParent() == null){
			super.addView(child, params);
		}else{
			CJKLog.logE("", "没有执行添加操作");
		}
	}
	
	
	/**
	 * 移出动画
	 * @param view
	 */
	private void animOut(final View view){
		animOut = AnimationUtils.loadAnimation(context, animOutId);
		animOut.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				view.setVisibility(View.GONE);
				CJKLog.logE("", "--getChildCount()="+getChildCount());
			}
		});
		view.setAnimation(animOut);
		animOut.startNow();
	}
	
	/**
	 * 进入动画
	 * @param view
	 */
	private void animInt(final View view){
		animIn = AnimationUtils.loadAnimation(context, animInId);
		animIn.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				CJKLog.logE("", "++getChildCount()="+getChildCount());
			}
		});
		view.setAnimation(animIn);
		animIn.startNow();
	}
}
