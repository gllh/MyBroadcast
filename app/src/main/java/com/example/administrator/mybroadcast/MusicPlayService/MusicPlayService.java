package com.example.administrator.mybroadcast.MusicPlayService;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class MusicPlayService extends Service {
	private MediaPlayer mediaPlayer;
	private int pausePosition;
	private Button bb;
	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	public void onCreate() {
		super.onCreate();
		System.out.println("播放歌曲");
		Toast.makeText(this,"create",Toast.LENGTH_LONG).show();
	}
	public void pause() {
		if(mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
			pausePosition = mediaPlayer.getCurrentPosition();
		}else {
			mediaPlayer.seekTo(pausePosition);
			mediaPlayer.start();
		}
	}
	public void play(String path) {
		mediaPlayer=new MediaPlayer();
		mediaPlayer.reset();
		try {
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepareAsync();
			mediaPlayer.seekTo(pausePosition);
			mediaPlayer.getCurrentPosition();
			mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mediaPlayer) {
					mediaPlayer.start();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void onDestroy(){
		super.onDestroy();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
}
