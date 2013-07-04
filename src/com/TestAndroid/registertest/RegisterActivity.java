package com.TestAndroid.registertest;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class RegisterActivity extends Activity {

	private static final String places[]={"�й�","�й����","�й�����","�й�̨��"};
	private boolean isNotified=false;
	private int sexFlag=0;
	private boolean isChecked=false;
	private int plcFlag=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		setTitle("ע��");
		
		//��ȡ�ؼ�
		final EditText username=(EditText)findViewById(R.id.username);
		final EditText pwd=(EditText)findViewById(R.id.pwd);
		final EditText pwdrp=(EditText)findViewById(R.id.pwdrp);
		RadioGroup sex=(RadioGroup)findViewById(R.id.sex);
		Spinner from=(Spinner)findViewById(R.id.from);
		final EditText mail=(EditText)findViewById(R.id.mail);
		ToggleButton notify=(ToggleButton)findViewById(R.id.notify);
		CheckBox check=(CheckBox)findViewById(R.id.check);
		Button register=(Button)findViewById(R.id.register);
		Button cancel=(Button)findViewById(R.id.cancel);
		
		//��Spinner����������
		ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,places);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		from.setAdapter(adapter);
		
		//�¼�����
		notify.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO �Զ����ɵķ������
				isNotified=isChecked;
			}
		});
		check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean flag) {
				// TODO �Զ����ɵķ������
				isChecked=flag;
			}
		});
		sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO �Զ����ɵķ������
				sexFlag=arg1;
			}
		});
		from.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO �Զ����ɵķ������
				plcFlag=arg2;
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO �Զ����ɵķ������
				
			}
					
		});
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO �Զ����ɵķ������
				String strUser=username.getText().toString();
				String strPwd=pwd.getText().toString();
				String strPwdrp=pwdrp.getText().toString();
				String strMail=mail.getText().toString();
				if(strUser.equals("")){
					//�����Ի���
					new AlertDialog.Builder(RegisterActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����").setMessage("�������û���").setPositiveButton("ȷ��", null).show();
					return;
				}
				if(!strPwd.equals(strPwdrp)){
					new AlertDialog.Builder(RegisterActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����").setMessage("�����������벻��ͬ").setPositiveButton("ȷ��", null).show();
					return;
				}
				if(!isChecked){
					new AlertDialog.Builder(RegisterActivity.this).setIcon(android.R.drawable.ic_dialog_alert)
					.setTitle("����").setMessage("�빴ѡͬ������").setPositiveButton("ȷ��", null).show();
					return;
				}
				
				//�������ݵ������activity
				Bundle bundle=new Bundle();
				bundle.putString("username", strUser);
				bundle.putString("mail", strMail);
				bundle.putString("from", places[plcFlag]);
				bundle.putBoolean("notify", isNotified);
				bundle.putBoolean("check", isChecked);
				bundle.putInt("sex", sexFlag);
				Intent intent=new Intent(RegisterActivity.this,ResultActivity.class);
				intent.putExtra("info",bundle);
				
				//����activity
				RegisterActivity.this.startActivity(intent);
				
				RegisterActivity.this.finish();
			}
		});
		cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				RegisterActivity.this.finish();
			}
		});
	}

}
