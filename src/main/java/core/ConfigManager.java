package main.java.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import main.java.common.Common;
import main.java.common.Config;
import main.java.common.Exit;
import main.java.log.LogManager;

/**
 * 설정 기능 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.13 Fri 19:22
 */
public class ConfigManager
{
	private static ConfigManager instance = new ConfigManager();
	
	private static LogManager logManager = LogManager.getInstance();
	private static SoundManager soundManager = SoundManager.getInstance();
	
	private Config config = new Config();
	
	// 설정파일 경로
	private String configPath = Common.jarPath + File.separator + "KorChamConf.json";
	
	/**
	 * ConfigManager 인스턴스 반환 함수
	 * 
	 * @return {ConfigManager} instance: ConfigManager 인스턴스
	 */
	public static ConfigManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 설정파일의 설정값 가져오는 함수
	 * 
	 * @return {Active}: 설정파일의 설정값 Common에 지정
	 */
	public void getConfig()
	{
		File file = new File(configPath);
		
		// 설정파일이 없을 경우
		if (!file.exists())
		{
			mkConfig();
		}
		
		// 설정파일 읽기 동작
		try
		{
			Gson gson = new Gson();
			
			String jsonStr = new String(Files.readAllBytes(Paths.get(configPath)), "UTF-8");
			
			config = gson.fromJson(jsonStr, Config.class);
			
			Common.logPath = config.getLogPath();
			Common.soundFile = config.getSoundFile();
			
			Common.logActive = config.isLogActive();
			Common.soundActive = config.isSoundActive();
			
			Common.urlList = config.getUrlList();
		}
		// TODO: 시간차 종료과정 추가하기
		// JSON 구문 오류
		catch (JsonSyntaxException e)
		{
			Common.Sysln("설정파일을 구문오류가 감지되었습니다. 설정파일이 올바른 형식을 갖고 있는지 확인해주세요.");
		}
		
		// JSON 파싱 오류
		catch (JsonParseException e)
		{
			Common.Sysln("설정파일의 값을 읽을 수 없습니다. 설정파일이 올바른 값을 갖고 있는지 확인해주세요.");
		}
		
		// 예외 처리
		catch (Exception e)
		{
			Common.Sysln("설정파일을 읽는 중 오류가 발생했습니다. 설정파일이 올바른지 확인해주세요.");
			Exit.Close(false);
		}
	}
	
	/**
	 * 설정 확인 함수
	 * 
	 * @return {Active}: 설정 파일 값 출력
	 */
	public void checkConfig()
	{
		System.out.println();
		
		getConfig();
		
		Common.Sysln("Log Path: " + logManager.getLogPath());
		Common.Sysln("Sound File: " + Common.soundFile + "\n");
		
		Common.Sysln("Log Active: " + Common.logActive);
		Common.Sysln("Sound Active: " + Common.soundActive + "\n");
		
		for (int i = 0; i < Common.urlList.size(); i++)
		{
			String url = Common.urlList.get(i).getAsJsonObject().get("url").getAsString();
			String date = Common.urlList.get(i).getAsJsonObject().get("date").getAsString();
			
			Common.Sysln("URL: " + url);
			Common.Sysln("Date: " + date);
		}
		
		System.out.println();
		
		Common.Sysln("사운드 테스트");
		
		soundManager.Play();
		
		System.out.println();
	}
	
	/**
	 * 설정파일 생성 함수
	 * 
	 * @return {Active}: 기본 설정값이 지정된 설정파일 생성
	 */
	private void mkConfig()
	{
		// 설정파일 생성 동작
		try
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
			
			String configStr = gson.toJson(config, config.getClass()).replace("  ", "\t");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(configPath, false));
			writer.write(configStr);
			writer.flush();
			writer.close();
		}
		
		// 예외 처리
		catch (Exception e)
		{
			Common.Sysln("설정파일을 생성할 수 없습니다. 프로그램을 종료합니다.");
			Exit.Close(false);
		}
	}
}