package com.example.nathaniel.musicsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nathaniel.musicsqlite.User.LoginActivity;
import com.example.nathaniel.musicsqlite.User.RegisterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLogin,btnPwd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主界面
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取控件
        init();
    }

    private void init() {
        btnLogin=(Button)findViewById(R.id.ButtonIn);
        btnPwd=(Button)findViewById(R.id.ButtonAdd);
        btnLogin.setOnClickListener(this);
        btnPwd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonIn:
                //跳转到显示窗口
                Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent1);
            case R.id.ButtonAdd:
                Intent intent2=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent2);
        }
    }
}

