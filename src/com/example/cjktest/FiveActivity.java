package com.example.cjktest;

import android.os.Bundle;

import com.example.cjktest.uibase.ChildActivity;

public class FiveActivity extends BaseChildActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.five);
		setTopTiltle("Five");
	}
	
	@Override
	protected int setNavIndex() {
		// TODO Auto-generated method stub
		return 4;
	}
}
