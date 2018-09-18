package com.example.administrator.mybroadcast.MusicAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.mybroadcast.Music.Music;
import com.example.administrator.mybroadcast.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/19.
 */

public class MusicAdapter extends BaseAdapter{
	private Context context;
	private List<Music> musics;
	private Music music;

	public MusicAdapter(Context context, List<Music> musics1) {
		this.context = context;
		this.musics = musics1;
	}
	@Override
	public int getCount() {
		return musics.size();
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
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if (convertView==null){
			viewHolder=new ViewHolder();
			convertView= LayoutInflater.from(context).inflate(R.layout.list,null);
			viewHolder.musicName=(TextView)convertView.findViewById(R.id.tv_musicname);
			viewHolder.singer=(TextView)convertView.findViewById(R.id.tv_singer);
			viewHolder.murl=(TextView)convertView.findViewById(R.id.url_gone);
			convertView.setTag(viewHolder);
		}else {
			viewHolder=(ViewHolder) convertView.getTag();
		}
		music=musics.get(position);
		viewHolder.musicName.setText(music.getMusicName());
		viewHolder.singer.setText(music.getSinger());
		return convertView;
	}
	public class ViewHolder{
		public TextView musicName;
		public TextView singer;
		public TextView murl;
	}
}
