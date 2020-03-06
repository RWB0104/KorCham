package main.java.core;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine.Info;

import main.java.common.Common;
import main.java.log.LogManager;

public class SoundManager
{
	private String wavFile = Common.jarPath + File.separator + "sound" + File.separator + "alt.wav";
	private LogManager log = LogManager.getInstance();
	
	private static SoundManager instance = new SoundManager();
	
	/**
	 * SoundManager 인스턴스 반환 함수
	 * 
	 * @return instance: SoundManager 인스턴스
	 */
	public static SoundManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 알림 소리 재생 함수
	 * 
	 * @return: 지정된 WAV 재생
	 */
	public void Play()
	{
		try
		{
			if (Common.soundActive)
			{
				File file = new File(wavFile);
				
				AudioInputStream stream = AudioSystem.getAudioInputStream(file);
				AudioFormat format = stream.getFormat();
				
				Info info = new Info(Clip.class, format);
				
				Clip clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
			}
		}
		
		catch (Exception e)
		{
			log.LogWrite("사운드 재생 불가");
			log.LogWrite("사운드 기능 정지");
			
			Common.soundActive = false;
		}
	}
}