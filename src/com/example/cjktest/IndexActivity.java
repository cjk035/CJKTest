package com.example.cjktest;

import android.os.Bundle;

public class IndexActivity extends BaseChildActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.index);
		setTopTiltle("Index");
	}
	
	@Override
	protected int setNavIndex() {
		// TODO Auto-generated method stub
		return 0;
	}
}
