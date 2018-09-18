package com.example.administrator.mybroadcast.Music;

/**
 * Created by Administrator on 2017/12/15.
 */

public class Music {
	private long id;
	private String musicName;
	private String singer;
	private String murl;

	public Music(){
		super();
	}
	public Music(long id,String musicNmae,String singer,String murl){
		super();
		this.id=id;
		this.musicName=musicNmae;
		this.singer=singer;
		this.murl=murl;
	}

	public long getId() {
		return id;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMusicName() {
		return musicName;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

}
