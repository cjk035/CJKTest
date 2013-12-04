package com.example.cjktest.log;

import android.util.Log;

public class CJKLog {
	
	private static boolean mLogState = true;
	/**
	 * 设置log输出状态
	 * @param logState  true为输出log，false为不输出log
	 */
	public static void setLogState(boolean logState){
		mLogState = logState;
	}
	
	public static void print(String str){
		if(mLogState){
			System.out.println(str);
		}
	}
	
	/**
	 * Send an ERROR log message.
	 * @param tag
	 * @param msg
	 */
	public static void logE(String tag, String msg){
		if(mLogState){
			Log.e(tag, msg);
		}
	}
	
	/**
	 * Send an INFO log message.
	 * @param tag
	 * @param msg
	 */
	public static void logI(String tag, String msg){
		if(mLogState){
			Log.i(tag, msg);
		}
	}
	
	/**
	 * Send a DEBUG log message.
	 * @param tag
	 * @param msg
	 */
	public static void log(String tag, String msg){
		if(mLogState){
			Log.d(tag, msg);
		}
	}

}
