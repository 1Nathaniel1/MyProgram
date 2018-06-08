package com.example.nathaniel.musicsqlite.Muisc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.nathaniel.musicsqlite.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nathaniel on 2018/6/2.
 */

public class MusicShowActivity extends AppCompatActivity {
    MyDatabaseHelper MOH;
    SQLiteDatabase SD;
    List<MusicInfo> musiclist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.listview);
        ListView listView = (ListView) findViewById(R.id.lv);
        musiclist = new ArrayList<MusicInfo>();
        //创建MOH实例
        MOH = new MyDatabaseHelper(this);
        //得到数据库
        SD = MOH.getReadableDatabase();
        //创建musicinfo封装类
        MusicInfo musicInfo = new MusicInfo();
        //查询数据
        Cursor cursor = SD.rawQuery("select * from music", null);
        while (cursor.moveToNext()) {
            String songName = cursor.getString(cursor.getColumnIndex("Song"));
            String singerName = cursor.getString(cursor.getColumnIndex("Singer"));
            musicInfo.setSinger(singerName);
            musicInfo.setSongs(songName);
            musiclist.add(musicInfo);
        }
        //创建MyAdapter实例
        MyAdapter myAdapter = new MyAdapter(this);
        //向ListView中添加Adapter
        listView.setAdapter(myAdapter);
        //设置提示对话框
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2, long arg3) {
                builder.setMessage("真的要删除所有数据吗？")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                //删除数据库
                                ListView listView = (ListView) findViewById(R.id.lv);
                                SD= MOH.getWritableDatabase();
                                SD.delete("music",null,null);
                                Intent intent=new Intent(MusicShowActivity.this,MusicAddActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("否", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // TODO Auto-generated method stub
                            }
                        });
                AlertDialog ad=builder.create();
                ad.show();
            }
        });
        MOH.close();

    }


    public class MyAdapter extends BaseAdapter {
        private Context context;
        private LayoutInflater inflater;

        public MyAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return musiclist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            //从list取出music数据
            MusicInfo musicInfo=musiclist.get(position);
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = inflater.inflate(R.layout.musicinfo, null);
                viewHolder.tv_song = (TextView) convertView.findViewById(R.id.text_gq);
                viewHolder.tv_singer = (TextView) convertView.findViewById(R.id.text_gs);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //向TextView中插入数据
            viewHolder.tv_song.setText(musicInfo.getSongs());
            viewHolder.tv_singer.setText(musicInfo.getSinger());
            return convertView;
        }
        class ViewHolder {
            private TextView tv_song;
            private TextView tv_singer;
        }
     }
}

