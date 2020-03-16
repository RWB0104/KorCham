package main.java.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import main.java.common.Common;
import main.java.common.Config;
import main.java.common.Exit;
import main.java.log.LogManager;

public class ConfigManager
{
	private LogManager log = LogManager.getInstance();
	private Config config = new Config();
	
	// 설정파일 경로
	private String configPath = Common.jarPath + File.pathSeparator + "KorChamConf.json";
	
	/**
	 * 설정파일의 설정값 가져오는 함수
	 * 
	 * @return: 설정파일의 설정값 Common에 지정
	 */
	public void getConfig()
	{
		File file = new File(configPath);
		
		// 설정파일이 없을 경우
		if (!file.exists())
		{
			mkConfig();
		}
		
		try
		{
			Gson gson = new Gson();
			
			String jsonStr = new String(Files.readAllBytes(Paths.get(configPath)));
			
			config = gson.fromJson(jsonStr, Config.class);
			
			Common.logPath = config.getLogPath();
		}
		
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
	
	/**
	 * 설정파일 생성 함수
	 * 
	 * @return: 기본 설정값이 지정된 설정파일 생성
	 */
	private void mkConfig()
	{
		try
		{
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			String configStr = gson.toJson(config, config.getClass());
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(configPath, false));
			writer.write(configStr);
			writer.flush();
			writer.close();
		}
		
		catch (Exception e)
		{
			Common.Sys("설정파일을 생성할 수 없습니다. 프로그램을 종료합니다.");
			log.LogWrite("설정파일 생성 불가");
			
			Exit.Close();
		}
	}
}