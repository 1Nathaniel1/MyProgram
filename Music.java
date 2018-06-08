package com.example.nathaniel.musicsqlite.Muisc;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.nathaniel.musicsqlite.R;


public class Music extends AppCompatActivity {
    private Button player;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //主界面
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.musicplayer);
        player=(Button)findViewById(R.id.play);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Music.this,MusicAddActivity.class);
                startActivity(intent);
            }
        });
    }
}
