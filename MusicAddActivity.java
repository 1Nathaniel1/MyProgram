package com.example.nathaniel.musicsqlite.Muisc;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nathaniel.musicsqlite.R;
import com.example.nathaniel.musicsqlite.User.LoginActivity;
import com.example.nathaniel.musicsqlite.User.RegisterActivity;

import java.util.ArrayList;

public class MusicAddActivity extends AppCompatActivity {
    private MyDatabaseHelper MOH;
    EditText singer, song;
    Button songAdd,songQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_music_add);
        MOH=new MyDatabaseHelper(this);
        findview();
        songAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Singer = singer.getText().toString().trim();
                String Song = song.getText().toString().trim();
                MusicInfo musicInfo = new MusicInfo();
                musicInfo.setSongs(Song);
                musicInfo.setSinger(Singer);
                SQLiteDatabase sdb = MOH.getReadableDatabase();
                ContentValues values=new ContentValues();
                values.put("Song",musicInfo.getSongs());
                values.put("Singer",musicInfo.getSinger());
                long id=sdb.insert("music",null,values);
                Toast.makeText(MusicAddActivity.this, "添加成功", Toast.LENGTH_LONG).show();
            }
        });
        songQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MusicAddActivity.this, MusicShowActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findview() {
        singer=(EditText) findViewById(R.id.et_singer);
        song=(EditText)findViewById(R.id.et_song);
        songAdd=(Button)findViewById(R.id.bt_save);
        songQuery=(Button)findViewById(R.id.bt_query);
    }
}