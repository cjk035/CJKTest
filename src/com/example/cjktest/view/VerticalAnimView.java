package com.example.cjktest.view;

import com.example.cjktest.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class VerticalAnimView extends RelativeLayout{
	
	private LinearLayout topView;
	private LinearLayout botView;
	private Context context;
	private Animation topOut;
	private Animation botIn;
	private android.widget.RelativeLayout.LayoutParams params_1;
	private android.widget.LinearLayout.LayoutParams params_2;

	@SuppressLint("NewApi")
	public VerticalAnimView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();
		// TODO Auto-generated constructor stub
	}

	public VerticalAnimView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
		// TODO Auto-generated constructor stub
	}

	public VerticalAnimView(Context context) {
		super(context);
		this.context = context;
		init();
		// TODO Auto-generated constructor stub
	}
	
	private void init(){
		params_1 = new android.widget.RelativeLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
		params_1.addRule(RelativeLayout.CENTER_IN_PARENT);
		
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.top_title, null);
		addView(view, params_1);
		
		topView = (LinearLayout) view.findViewById(R.id.topView);
		botView = (LinearLayout) view.findViewById(R.id.botView);
		
		params_2 = new android.widget.LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.FILL_PARENT, android.widget.LinearLayout.LayoutParams.FILL_PARENT);
		params_2.gravity = Gravity.CENTER;
		
		topOut = AnimationUtils.loadAnimation(context, R.anim.push_top_out);
		botIn = AnimationUtils.loadAnimation(context, R.anim.push_bottom_in);
	}
	
	public void addTopOutView(View view){
		topView.clearAnimation();
		topView.removeAllViews();
		topView.setAnimation(topOut);
		topView.addView(view, params_2);
		topOut.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				topView.setVisibility(View.VISIBLE);
			}
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				topView.setVisibility(View.GONE);
			}
		});
		topOut.start();
	}
	
	public void addBotInView(View view){
		botView.clearAnimation();
		botView.removeAllViews();
		botView.setAnimation(botIn);
		botView.addView(view, params_2);
		botIn.start();
	}
}
