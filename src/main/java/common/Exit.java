package main.java.common;

import main.java.log.LogManager;

/**
 * 종료 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.17 Tue 18:45
 */
public class Exit
{
	private static LogManager log = LogManager.getInstance();
	
	/**
	 * 프로그램 종료 함수
	 * 
	 * @param {boolean} mode: 로그 사용 여부
	 * @param {int} time: 대기 시간
	 * 
	 * @return: 프로그램 종료
	 */
	public static void Close(boolean mode, int time)
	{
		// 종료 시도
		try
		{
			String format = "\r%d초 뒤 종료합니다.";
			
			System.out.println();
			System.out.println();
			System.out.println();
			
			for (int i = 1; i <= 5; i++)
			{
				System.out.printf(format, 6 - i);
				
				Thread.sleep(1000);
			}
		}
		
		// 오류
		catch (Exception e)
		{
			System.out.println("오류로 인한 즉시 종료");
			
			System.exit(0);
		}
		
		// 시도 후
		finally
		{
			// 로그 사용 시
			if (mode)
			{
				log.LogWrite("프로그램 종료");
			}
			
			// 프로그램 종료
			System.exit(0);
		}
	}
}