package main.java.core;

import java.io.BufferedWriter;
import java.io.File;

import main.java.common.Common;

public class ConfigManager
{
	// 설정파일 경로
	private String configPath = Common.jarPath + File.pathSeparator + "KorChamConf.json";

	public void getConfig()
	{
		File config = new File(configPath);

		if (!config.exists())
		{
			// TODO: Config 만들 것
		}

	}

	private void mkConfig()
	{
		BufferedWriter b
	}
}