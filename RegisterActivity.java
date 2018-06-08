package com.example.nathaniel.musicsqlite.User;



/**
 * Created by Nathaniel on 2018/6/1.
 */
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

import com.example.nathaniel.musicsqlite.R;

public class RegisterActivity extends Activity {
    EditText username;
    EditText password;
    EditText repeatpassword;
    Button register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.register);
        findViews();
        register.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String repeatPwd=repeatpassword.getText().toString().trim();
                Log.i("TAG",name+"_"+pass+"_");
                UserService uService=new UserService(RegisterActivity.this);
                User user=new User();
                if (repeatPwd.equals(pass)){
                    user.setUsername(name);
                    user.setPassword(pass);
                    uService.register(user);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else{
                    Log.i("TAG","注册失败");
                    Toast.makeText(RegisterActivity.this, "注册失败，两次输入的密码不一致，请重新输入", Toast.LENGTH_LONG).show();
                    password.setText("");
                    repeatpassword.setText("");
                }

            }
        });
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.EditTextRegistName);
        password=(EditText) findViewById(R.id.EditTextRegisterPwd);
        repeatpassword=(EditText)findViewById(R.id.EditTextRepeatRegisterPwd);
        register=(Button) findViewById(R.id.bt_sureRegist);
    }

}