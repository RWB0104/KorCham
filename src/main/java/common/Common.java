package main.java.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.google.gson.JsonArray;

public class Common
{
	// 현재 경로
	public static String jarPath = System.getProperty("user.dir");

	// 로그 파일 경로
	public static String logPath = null;

	// 사운드 파일 경로
	public static String soundFile = null;

	// 로그 작동여부
	public static boolean logActive = true;

	// 사운드 작동 여부
	public static boolean soundActive = true;

	// URL 리스트
	public static JsonArray urlList = null;

	/**
	 * 현재 시간 반환 함수
	 * 
	 * @return timeFormat.format(time): 현재 시간의 포맷 (1900-01-01 00:00:01)
	 */
	public static String Now()
	{
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return timeFormat.format(time);
	}

	/**
	 * 현재 시간을 포함한 내용 콘솔 출력
	 * 
	 * @param obj: 표시할 내용
	 * 
	 * @return: ([1900-01-01 00:00:01] 내용) 형태로 콘솔 출력
	 */
	public static void Sys(Object obj)
	{
		// 출력 동작
		try
		{
			System.out.print("[" + Now() + "] " + obj);
		}

		// 예외 처리
		catch (Exception e)
		{
			System.out.println("[" + Now() + "] 표시할 수 없는 객체가 입력되었습니다.");
		}
	}

	/**
	 * 현재 시간을 포함한 내용 콘솔 출력 (줄바꿈)
	 * 
	 * @param obj: 표시할 내용
	 * 
	 * @return: ([1900-01-01 00:00:01] 내용) 형태로 콘솔 출력
	 */
	public static void Sysln(Object obj)
	{
		// 출력 동작
		try
		{
			System.out.println("[" + Now() + "] " + obj);
		}

		// 예외 처리
		catch (Exception e)
		{
			System.out.println("[" + Now() + "] 표시할 수 없는 객체가 입력되었습니다.");
		}
	}
}