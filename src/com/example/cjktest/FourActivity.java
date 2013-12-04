package com.example.cjktest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.cjktest.uibase.ChildActivity;

public class FourActivity extends BaseChildActivity {
	private TextView btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.four);
		btn = (TextView) findViewById(R.id.text);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent((MainActivity)getRooActivity(), DetailActivity.class);
//				startBActivity(DetailActivity.class, intent, (MainActivity)getRooActivity());
//				((MainActivity)getRooActivity()).startActivityFromChild(FourActivity.this, intent, 500);
			}
		});
	}
	
	@Override
	protected int setNavIndex() {
		// TODO Auto-generated method stub
		return 3;
	}
}
