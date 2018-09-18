package com.example.administrator.mybroadcast.MusicPath;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by Administrator on 2017/12/15.
 */

public class MusicPath implements Parcelable{
	private String musicName;
	private String musicPath;

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(musicName);
		dest.writeString(musicPath);
	}

	/**
	 * 必须用 public static final 修饰符
	 * 对象必须用 CREATOR
	 */
	public static final Creator<MusicPath> CREATOR = new Creator<MusicPath>() {

		@Override
		public MusicPath createFromParcel(Parcel source) {
			String name = source.readString();
			String path = source.readString();

			MusicPath music = new MusicPath();
			music.setMusicName(name);
			music.setMusicPath(path);

			return music;
		}

		@Override
		public MusicPath[] newArray(int size) {
			return new MusicPath[size];
		}

	};
}
