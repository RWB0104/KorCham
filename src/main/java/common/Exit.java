package main.java.common;

import main.java.log.LogManager;

public class Exit
{
	private static LogManager log = LogManager.getInstance();

	/**
	 * 프로그램 종료 함수
	 * 
	 * @param mode: 로그 사용 여부
	 * 
	 * @return: 프로그램 종료
	 */
	public static void Close(boolean mode)
	{
		Common.Sysln("프로그램을 종료합니다");

		if (mode)
		{
			log.LogWrite("프로그램 종료");
		}

		// 프로그램 종료
		System.exit(0);
	}
}