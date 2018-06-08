package com.example.nathaniel.musicsqlite.User;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nathaniel.musicsqlite.Muisc.Music;
import com.example.nathaniel.musicsqlite.R;
/**
 * Created by Nathaniel on 2018/6/1.
 */

public class LoginActivity extends Activity {
    EditText username;
    EditText password;
    Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.EditTextName);
        password=(EditText) findViewById(R.id.EditTextPwd);
        login=(Button) findViewById(R.id.ButtonIn);
        register=(Button) findViewById(R.id.ButtonAdd);
        login.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString();
                String pass=password.getText().toString();
                Log.i("TAG",name+"_"+pass);
                UserService uService=new UserService(LoginActivity.this);
                boolean flag=uService.login(name, pass);
                if(flag){
                    Log.i("TAG","登录成功");
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this, Music.class);
                    startActivity(intent);
                }else{
                    Log.i("TAG","登录失败");
                    Toast.makeText(LoginActivity.this, "登录失败,账号或密码不正确，请重新输入", Toast.LENGTH_LONG).show();
                }
            }
        });
        register.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
