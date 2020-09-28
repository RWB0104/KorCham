package main.java.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.JsonArray;

/**
 * 공통 모듈 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.05 Thu 20:53
 */
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
	 * @return {String} result: 현재 시간의 포맷 (1900-01-01 00:00:01)
	 */
	public static String Now()
	{
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String result = timeFormat.format(time);
		
		return result;
	}
	
	/**
	 * 현재 시간 지정포맷 반환 함수
	 * 
	 * @param {String} format: 시간 포맷
	 * 
	 * @return {String} result: 현재 시간의 포맷
	 */
	public static String Now(String format)
	{
		Timestamp time = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat(format);
		
		String result = timeFormat.format(time);
		
		return result;
	}
	
	/**
	 * 시간 계산기
	 * 
	 * @param {int} mode: 계산 대상 (ex. Calendar.DATE)
	 * @param {int} day: 더할 날짜
	 * 
	 * @return {Active}: timeFormat.format(time): 더한 시간의 포맷 (1900. 01. 01)
	 */
	public static String DateCalculator(int mode, int day)
	{
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd");
		
		calendar.setTimeInMillis(time.getTime());
		calendar.add(mode, day);
		
		time = new Timestamp(calendar.getTime().getTime());
		
		return timeFormat.format(time);
	}
	
	/**
	 * 현재 시간을 포함한 내용 콘솔 출력
	 * 
	 * @param {Object} obj: 표시할 내용
	 * 
	 * @return {Active}: ([1900-01-01 00:00:01] 내용) 형태로 콘솔 출력
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
	 * @param {Object} obj: 표시할 내용
	 * 
	 * @return {Active}: ([1900-01-01 00:00:01] 내용) 형태로 콘솔 출력
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
	
	/**
	 * 문자열을 yyyy.MM.dd 형태의 날짜 객체로 변환하는 함수
	 * 
	 * @param {String} str: 날짜 문자열
	 * 
	 * @return {Date} date: 날짜 객체
	 */
	public static Date ConvertDate(String str)
	{
		Date date;
		
		// 문자열 날짜 변환 시도
		try
		{
			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy.MM.dd");
			
			date = timeFormat.parse(str);
		}
		
		// 오류
		catch (Exception e)
		{
			date = null;
			
			Sysln("잘못된 날짜 포맷입니다.");
		}
		
		return date;
	}
}