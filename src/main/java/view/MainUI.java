package main.java.view;

import java.util.Scanner;

import main.java.common.Common;
import main.java.common.Exit;
import main.java.core.ConfigManager;
import main.java.core.Crawler;
import main.java.core.SoundManager;
import main.java.core.URLChecker;
import main.java.exception.InvalidMenuException;
import main.java.log.LogManager;

/**
 * KorCham 메인 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.05 Thu 19:05
 */
public class MainUI
{
	private static Scanner scanner = new Scanner(System.in);
	
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
		System.out.println("                              Ver 3.2                                   ");
		System.out.println("                                                                        ");
		System.out.println("                          Developed by RWB                              ");
		System.out.println("                             2020-03-05                                 ");
		System.out.println("                                                                        ");
		System.out.println("========================================================================");
		
		configManager.getConfig();
		log.Start();
		
		while (true)
		{
			int active = Menu();
			
			switch (active)
			{
				case 1:
					Start();
					break;
				
				case 2:
					configManager.checkConfig();
					break;
				
				case 3:
					URLChecker checker = new URLChecker(scanner);
					checker.check();
					break;
				
				default:
					
					break;
			}
		}
	}
	
	/**
	 * 메뉴 UI 출력 및 메뉴 인덱스 반환 함수
	 * 
	 * @return {int} active: 메뉴 인덱스
	 */
	private static int Menu()
	{
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("========================================================================");
		System.out.println("                           메뉴를 선택해주세요.");
		System.out.println("========================================================================");
		System.out.println();
		System.out.println("                        메뉴의 번호를 입력해주세요.");
		System.out.println();
		System.out.println("                        [1] 매크로 실행");
		System.out.println("                        [2] 설정 확인");
		System.out.println("                        [3] 시험장 URL 리스트 출력");
		System.out.println();
		System.out.println("========================================================================");
		System.out.println();
		System.out.print("메뉴 선택 >> ");
		
		int active = 0;
		
		// 메뉴 선택 시도
		try
		{
			String input = scanner.nextLine();
			
			active = Integer.parseInt(input);
			
			// 입력받은 메뉴가 1 미만 3 초과일 경우
			if (active < 1 || active > 3)
			{
				throw new InvalidMenuException();
			}
		}
		
		// 유효하지 않은 숫자 데이터 형식 오류
		catch (NumberFormatException e)
		{
			System.out.println();
			System.err.println("[ERROR] 숫자를 입력해주세요.");
		}
		
		// 유효하지 않은 메뉴 선택
		catch (InvalidMenuException e)
		{
			System.out.println();
			System.err.println("[ERROR] 지정된 메뉴를 선택해주세요.");
		}
		
		// 오류
		catch (Exception e)
		{
			System.out.println();
			System.err.println("[ERROR] 메뉴 선택 실패.");
			e.printStackTrace();
		}
		
		return active;
	}
	
	/**
	 * 자리 확인 동작 함수
	 * 
	 * @return {Active}: 지정된 URL 분석 및 자리 유무 출력
	 */
	private static void Start()
	{
		int count = 0;
		
		Common.Sysln("사운드 테스트\n");
		sound.Play();
		
		// URL 리스트가 없을 경우
		if (Common.urlList.size() == 0)
		{
			Common.Sysln("하나 이상의 URL 데이터가 있어야 합니다.");
			log.LogWrite("URL 리스트 없음");
			
			Exit.Close(false, 5);
		}
		
		// 크롤링 반복
		while (true)
		{
			count++;
			
			double start = System.currentTimeMillis();
			
			// URL 리스트만큼 반복
			for (int i = 0; i < Common.urlList.size(); i++)
			{
				c.Crawling(i);
			}
			
			double end = System.currentTimeMillis();
			double workTime = end - start;
			
			// 동작 시간이 1초 이상일 경우
			if (workTime >= 1000)
			{
				Common.Sysln(count + "번 째 루틴 완료 (" + String.format("%.3f", workTime / 1000) + "s)\n");
				log.LogWrite(count + "번 째 루틴 완료 (" + String.format("%.3f", workTime / 1000) + "s)\n");
			}
			
			// 동작 시간이 1초 미만일 경우
			else
			{
				Common.Sysln(count + "번 째 루틴 완료 (" + (end - start) + "ms)\n");
				log.LogWrite(count + "번 째 루틴 완료 (" + (end - start) + "ms)\n");
			}
		}
	}
}