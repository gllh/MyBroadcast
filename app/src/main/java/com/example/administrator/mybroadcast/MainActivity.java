package com.example.administrator.mybroadcast;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.mybroadcast.Music.Music;
import com.example.administrator.mybroadcast.MusicAdapter.MusicAdapter;
import com.example.administrator.mybroadcast.MusicDetail.MusicDetail;
import com.example.administrator.mybroadcast.MusicPlayService.MusicPlayService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
	private Button bt_stop;
	private Button go;
	private Button bt_end;
	private ListView listview;
	private List<Music> music ;
	private MusicAdapter musicAdapter;
	private MusicPlayService musicPlayService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		listview=(ListView)findViewById(R.id.lv);
		musicPlayService=new MusicPlayService();
		music=new ArrayList<>();
		music= MusicDetail.getpm3(this);
		musicAdapter=new MusicAdapter(this,music);
		listview.setAdapter(musicAdapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String murl=music.get(position).getMurl();
				musicPlayService.play(murl);
			}
		});
	}
	private void init(){
		bt_stop=(Button)findViewById(R.id.bt_stop);
		bt_stop.setOnClickListener(this);
		bt_end=(Button)findViewById(R.id.bt_end);
		bt_end.setOnClickListener(this);
	}

	public void onClick(View view){
		switch (view.getId()){
			case R.id.bt_stop:
					musicPlayService.pause();
				break;
			case R.id.bt_end:
				musicPlayService.onDestroy();
				break;
		}
	}
}
