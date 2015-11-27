/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/11/9 5:59:33
 * Project: T
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.t;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	ProgressDialog progressDialog;
	Handler myHandler = new Handler() {
		public void handleMessage(Message msg)
		{
			progressDialog.setMessage("  提交成功！");
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		progressDialog = new ProgressDialog(MainActivity.this);
		// 设置进度条风格，风格为圆形，旋转的
		//		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		// 设置ProgressDialog 标题
		//		progressDialog.setTitle("提示");
		// 设置ProgressDialog 提示信息
		progressDialog.setMessage("正在向服务器提交数据...");
		// 设置ProgressDialog 标题图标
		//		progressDialog.setIcon(R.mipmap.ic_launcher);
		// 设置ProgressDialog 的进度条是否不明确
		//		progressDialog.setIndeterminate(false);

		// 设置ProgressDialog 是否可以按退回按键取消
		//		progressDialog.setCancelable(true);
		//设置ProgressDialog 的一个Button
//		progressDialog.setButton("确定", new SureButtonListener());
		// 让ProgressDialog显示
		progressDialog.show();

		new Thread(new Runnable() {
			@Override
			public void run()
			{

				try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
				}
				Message message=new Message();
				message.arg1=1;
				myHandler.sendMessage(message);
				try
				{
					Thread.sleep(300);
				} catch (InterruptedException e)
				{
				}

				//				progressDialog.setMessage("提交成功！");
				progressDialog.dismiss();
			}
		}).start();

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view)
			{
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
