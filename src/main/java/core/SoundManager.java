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
		// 사운드 재생 동작
		try
		{
			// soundActive가 true일 경우
			if (Common.soundActive)
			{
				File file = new File(Common.soundFile);
				
				// 사운드 파일이 있을 경우
				if (file.exists())
				{
					AudioInputStream stream = AudioSystem.getAudioInputStream(file);
					AudioFormat format = stream.getFormat();
					
					Info info = new Info(Clip.class, format);
					
					Clip clip = (Clip) AudioSystem.getLine(info);
					clip.open(stream);
					clip.start();
				}
				
				// 사운드 파일이 없을 경우
				else
				{
					Common.soundActive = false;
					
					Common.Sys("사운드 파일이 존재하지 않아 사운드 기능을 종료합니다. (" + Common.soundFile + ")");
					
					log.LogWrite("사운드 파일 없음. (" + Common.soundFile + ")");
					log.LogWrite("사운드 기능 종료 (soundActive: " + Common.soundActive + ")");
				}
			}
		}
		
		// 예외 처리
		catch (Exception e)
		{
			log.LogWrite("사운드 재생 불가");
			log.LogWrite("사운드 기능 정지");
			
			Common.soundActive = false;
		}
	}
}