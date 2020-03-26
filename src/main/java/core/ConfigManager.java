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

public class ConfigManager
{
	private static ConfigManager instance = new ConfigManager();

	private Config config = new Config();

	// 설정파일 경로
	private String configPath = Common.jarPath + File.separator + "KorChamConf.json";

	public static ConfigManager getInstance()
	{
		return instance;
	}

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

		// 설정파일 읽기 동작
		try
		{
			Gson gson = new Gson();

			String jsonStr = new String(Files.readAllBytes(Paths.get(configPath)));

			config = gson.fromJson(jsonStr, Config.class);

			Common.logPath = config.getLogPath();
			Common.soundFile = config.getSoundFile();

			Common.logActive = config.isLogActive();
			Common.soundActive = config.isSoundActive();

			Common.urlList = config.getUrlList();
		}

		// 예외 처리
		catch (Exception e)
		{
			Common.Sysln("설정파일을 읽는 중 오류가 발생했습니다. 설정파일에 올바른 값을 입력하세요.");
			Exit.Close(false);
		}
	}

	/**
	 * 설정파일 생성 함수
	 * 
	 * @return: 기본 설정값이 지정된 설정파일 생성
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