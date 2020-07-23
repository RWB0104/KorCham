package main.java.core;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine.Info;

import main.java.common.Common;
import main.java.log.LogManager;

/**
 * 사운드 기능 클래스
 * 
 * @author RWB
 * 
 * @since 2020.03.05 Thu 10:48
 */
public class SoundManager
{
	private LogManager log = LogManager.getInstance();
	private static Scanner scanner = new Scanner(System.in);
	
	private static SoundManager instance = new SoundManager();
	
	/**
	 * SoundManager 인스턴스 반환 함수
	 * 
	 * @return {SoundManager} instance: SoundManager 인스턴스
	 */
	public static SoundManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 알림 소리 재생 함수
	 * 
	 * @return {Active}: 지정된 WAV 재생
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
					Common.Sysln("사운드 파일이 존재하지 않습니다. (" + Common.soundFile + ")");
					Common.Sys("지정한 사운드 파일 경로에 기본 사운드를 다운로드 받겠습니까? (Y / N) >> ");
					
					String result = scanner.nextLine();
					
					System.out.println();
					
					// 사운드 파일 다운로드 승인
					if (result.toUpperCase().equals("Y"))
					{
						soundDownload();
					}
					
					// 아닐 경우
					else
					{
						Common.soundActive = false;
						
						log.LogWrite("사운드 파일 없음. (" + Common.soundFile + ")");
						log.LogWrite("사운드 기능 종료 (soundActive: " + Common.soundActive + ")");
					}
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
	
	/**
	 * 사운드파일 다운로드 함수
	 * 
	 * @return {Active}: 설정파일에 지정된 사운드파일 경로에 사운드파일 다운로드
	 */
	private void soundDownload()
	{
		OutputStream outStream = null;
		URLConnection connection = null;
		InputStream inStream = null;
		
		File folder = new File(Common.jarPath + File.separator + "sound");
		
		// 폴더 없을 경우 생성
		if (!folder.exists())
		{
			folder.mkdir();
		}
		
		// 사운드 파일 다운로드
		try
		{
			URL url = new URL("https://github.com/RWB0104/KorCham/raw/master/sound/alert.wav");
			byte[] buf;
			
			int byteRead;
			
			outStream = new BufferedOutputStream(new FileOutputStream(Common.soundFile));
			
			connection = url.openConnection();
			inStream = connection.getInputStream();
			buf = new byte[10240];
			
			while ((byteRead = inStream.read(buf)) != -1)
			{
				outStream.write(buf, 0, byteRead);
			}
			
			Common.Sysln("기본 사운드 파일 다운로드 완료");
			
			inStream.close();
			outStream.close();
			
			Play();
		}
		
		// 예외 처리
		catch (Exception e)
		{
			e.printStackTrace();
			
			Common.Sysln("사운드 파일 다운로드 실패. 사운드 기능을 종료합니다.");
			Common.soundActive = false;
		}
		
		System.out.println();
	}
}