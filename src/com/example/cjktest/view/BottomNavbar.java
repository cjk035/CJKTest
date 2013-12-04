package com.example.cjktest.view;


import com.example.cjktest.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/**
 * 底部导航栏
 * @author sheng
 *
 */
public class BottomNavbar extends BaseNavBar{
	private LinearLayout layout;
	private int index;
	
	/** 正常背景*/
	private int[] normal = {R.drawable.bottom_bulletin_normal, R.drawable.bottom_contact_normal, 
			R.drawable.bottom_newproject_normal, R.drawable.bottom_preview_normal, 
			R.drawable.bottom_q_and_a_normal};
	
	/** 选中的背景*/
	private int[] selected = {R.drawable.bottom_bulletin_selected, R.drawable.bottom_contact_selected, 
			R.drawable.bottom_newproject_selected, R.drawable.bottom_preview_selected, 
			R.drawable.bottom_q_and_a_selected};
	
	@SuppressLint("NewApi")
	public BottomNavbar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public BottomNavbar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BottomNavbar(Context context) {
		super(context);
	}
	
	/**
	 * 选中的状态
	 * @param selected  选中的索引
	 */
	public void setSeleted(int selectedIndex){
		if(index != selectedIndex){
			layout.getChildAt(index).setBackgroundResource(normal[index]);
		}
		layout.getChildAt(selectedIndex).setBackgroundResource(selected[selectedIndex]);
		index = selectedIndex;
	}
	
	/**
	 * 获取当前导航选中的索引
	 * @return
	 */
	public int getSeleted(){
		return index;
	}

	@Override
	protected int setNavLayout() {
		// TODO Auto-generated method stub
		return R.layout.bottomnavbar;
	}

	@Override
	protected void init(View view) {
		layout = (LinearLayout) view.findViewById(R.id.layout);
		layout.getChildAt(0).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(index != 0){
					setSeleted(0);
					if(listener != null){
						listener.onClickNavBar(index);
					}
				}
			}
		});
		
		layout.getChildAt(1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(index != 1){
					setSeleted(1);
					if(listener != null){
						listener.onClickNavBar(index);
					}
				}
			}
		});
		
		layout.getChildAt(2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(index != 2){
					setSeleted(2);
					if(listener != null){
						listener.onClickNavBar(index);
					}
				}
			}
		});
		
		layout.getChildAt(3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(index != 3){
					setSeleted(3);
					if(listener != null){
						listener.onClickNavBar(index);
					}
				}
			}
		});
		
		layout.getChildAt(4).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(index != 4){
					setSeleted(4);
					if(listener != null){
						listener.onClickNavBar(index);
					}
				}
			}
		});
	}

	@Override
	protected int getNavCount() {
		// TODO Auto-generated method stub
		if(layout != null){
			return layout.getChildCount();
		}
		return 0;
	}
}
