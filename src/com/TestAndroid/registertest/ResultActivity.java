package com.TestAndroid.registertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		setTitle("注册成功");
		
		//接收数据
		Intent intent=this.getIntent();
		Bundle bundle=intent.getBundleExtra("info");
		String strUsername=bundle.getString("username");
		String strMail=bundle.getString("mail");
		String strFrom=bundle.getString("from");
		String strNotify=bundle.getBoolean("notify")?"是":"否";
		String strSex=bundle.getInt("sexFlag")==0 ?"是":"否";
		
		TextView username=(TextView) findViewById(R.id.username);
		username.setText(strUsername);
		TextView mail=(TextView) findViewById(R.id.mail);
		mail.setText(strMail);
		TextView from=(TextView) findViewById(R.id.from);
		from.setText(strFrom);
		TextView notify=(TextView) findViewById(R.id.notify);
		notify.setText(strNotify);
		TextView sex=(TextView) findViewById(R.id.sex);
		sex.setText(strSex);
		
		Button doneBt=(Button)findViewById(R.id.done);
		doneBt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				ResultActivity.this.finish();
			}
		});
	}

}
