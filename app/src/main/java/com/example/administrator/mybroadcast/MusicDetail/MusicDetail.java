package com.example.administrator.mybroadcast.MusicDetail;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import com.example.administrator.mybroadcast.Music.Music;


import java.util.ArrayList;
import java.util.List;


public class MusicDetail {
	public static List<Music> getpm3(Context context) {
		Cursor cursor = context.getContentResolver().query(
				MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
				MediaStore.Audio.AudioColumns.IS_MUSIC
		);
		List<Music> musicinfos = new ArrayList<Music>();
		for (int i = 0; i < cursor.getCount(); i++) {
			cursor.moveToNext();
			Music music = new Music();
			long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));
			String musicName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
			String singer = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
			String murl=cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
			int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));
			if (isMusic != 0) {
				music.setId(id);
				music.setMusicName(musicName);
				music.setSinger(singer);
				music.setMurl(murl);
				musicinfos.add(music);
			}

		}cursor.close();
		return musicinfos;
	}
}





























//	public static List<HashMap<String,String>> getmusicMap(
//			List<Music> mp3infos){
//		List<HashMap<String,String>> mp3list =new ArrayList<HashMap<String, String>>();
//		for (Iterator iterator=mp3infos.iterator();iterator.hasNext();){
//			Music music=(Music)iterator.next();
//			HashMap<String,String> map=new HashMap<String, String>();
//			map.put("musicName",music.getMusicName());
//			map.put("singer",music.getSinger());
//			map.put("murl",music.getMurl());
//			mp3list.add(map);
//		}
//		return mp3list;
//	}