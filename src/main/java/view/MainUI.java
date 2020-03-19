package main.java.view;

import main.java.common.Common;
import main.java.common.Exit;
import main.java.core.ConfigManager;
import main.java.core.Crawler;
import main.java.core.SoundManager;
import main.java.log.LogManager;

public class MainUI
{
	private static ConfigManager configManager = ConfigManager.getInstance();
	private static LogManager log = LogManager.getInstance();
	private static Crawler c = Crawler.getInstance();
	private static SoundManager sound = SoundManager.getInstance();
	
	/**
	 * 메인 동작 함수
	 * 
	 * @param args: Arguments
	 * 
	 * @return: KoCham 메인 동작
	 */
	public static void main(String[] args)
	{
		System.out.println("========================================================================");
		System.out.println("888    d8P                    .d8888b.  888                             ");
		System.out.println("888   d8P                    d88P  Y88b 888                             ");
		System.out.println("888  d8P                     888    888 888                             ");
		System.out.println("888d88K      .d88b.  888d888 888        88888b.   8888b.  88888b.d88b.  ");
		System.out.println("8888888b    d88  88b 888P    888        888 '88b     '8b  888  888  88b ");
		System.out.println("888  Y88b   888  888 888     888    888 888  888  d888888 888  888  888 ");
		System.out.println("888   Y88b  Y88..88P 888     Y88b  d88P 888  888 888  888 888  888  888 ");
		System.out.println("888    Y88b   Y88P   888      'Y8888P'  888  888  Y888888 888  888  888 ");
		System.out.println("========================================================================");
		System.out.println("                                                                        ");
		System.out.println("                          Developed by RWB                              ");
		System.out.println("                             2020-03-05                                 ");
		System.out.println("                                                                        ");
		System.out.println("========================================================================");
		
		configManager.getConfig();
		log.Start();
		
		int count = 0;
		
		Common.Sys("사운드 테스트");
		sound.Play();
		
		// 크롤링 반복
		while (true)
		{
			if (Common.urlList.size() == 0)
			{
				Common.Sys("하나 이상의 URL 데이터가 있어야 합니다.");
				log.LogWrite("URL 리스트 없음");
				
				Exit.Close();
			}
			
			count++;
			
			long start = System.currentTimeMillis();
			
			// URL 리스트만큼 반복
			for (int i = 0; i < Common.urlList.size(); i++)
			{
				c.Crawling(i);
			}
			
			long end = System.currentTimeMillis();
			
			Common.Sys(count + "번 째 루틴 완료 (" + (end - start) + "ms)");
			log.LogWrite(count + "번 째 루틴 완료 (" + (end - start) + "ms)");
		}
	}
}