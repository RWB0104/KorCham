package main.java.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import main.java.common.Common;

/**
 * 로그 기능 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.05 Thu 10:21
 */
public class LogManager
{
	// LogManager 객체
	private static LogManager instance = new LogManager();
	
	// 로그 시작 시간
	private String startTime = null;
	
	private String logPath = null;
	private String logFile = null;
	
	/**
	 * LogManager 인스턴스 반환 함수
	 * 
	 * @return {LogManager} instance: LogManager 인스턴스
	 */
	public static LogManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 로그 시작 시간 반환 함수
	 * 
	 * @return {String} startTime: 로그 시작 시간
	 */
	private String getStartTime()
	{
		return startTime;
	}
	
	/**
	 * 로그 시작 시간 지정 함수
	 * 
	 * @return {Active}: startTime 객체 지정
	 */
	private void setStartTime()
	{
		startTime = Common.Now();
	}
	
	/**
	 * 로그 경로 반환 함수
	 * 
	 * @return {String} logPath: 로그 경로
	 */
	public String getLogPath()
	{
		return logPath;
	}
	
	/**
	 * 로그 경로 지정 함수
	 * 
	 * @param {String} logPath: 로그 경로
	 * 
	 * @return {Active}: LogManager Class의 logPath에 객체 지정
	 */
	public void setLogPath(String logPath)
	{
		this.logPath = logPath;
	}
	
	/**
	 * 로그파일 경로 반환 함수
	 * 
	 * @return {String} logFile: 로그파일 경로
	 */
	public String getLogFile()
	{
		return logFile;
	}
	
	/**
	 * 로그파일 경로 지정 함수
	 * 
	 * @param {String} logFile: 로그파일 경로
	 * 
	 * @return {Active}: LogManager Class의 logFile에 객체 지정
	 */
	public void setLogFile(String logFile)
	{
		this.logFile = logFile;
	}
	
	/**
	 * 로그 기록 함수
	 * 
	 * @param {String} text: 로그 내용
	 * 
	 * @return {Active}: 로그파일에 로그 내용 기록 (로그파일 없을 경우 새로 생성)
	 */
	public void LogWrite(String text)
	{
		if (Common.logActive)
		{
			// 파일 쓰기 동작
			try
			{
				BufferedWriter buffer = new BufferedWriter(new FileWriter(getLogFile(), true));
				buffer.write("[" + Common.Now() + "] " + text + "\n");
				buffer.flush();
				buffer.close();
			}
			
			// 예외 처리
			catch (Exception e)
			{
				Common.Sysln("로그파일 기록 실패 (" + getLogFile() + ")");
				Common.Sysln("로그 기능이 종료됩니다.");
				
				Common.logActive = false;
			}
		}
	}
	
	/**
	 * 로그 기록 준비
	 * 
	 * @return {Active}: Common.logActive에 로그 작동여부 기록
	 */
	public void Start()
	{
		setStartTime();
		
		// 로그 경로 지정
		setLogPath(Common.logPath);
		
		// 로그파일 경로 지정
		setLogFile(getLogPath() + File.separator + getStartTime().replace(":", "-") + ".log");
		
		File path = new File(getLogPath());
		
		// 로그 저장 폴더가 없을 경우
		if (!path.exists())
		{
			Common.Sysln("로그 폴더 누락 감지\n");
			
			// 폴더 생성
			if (path.mkdir())
			{
				Common.Sysln("로그 폴더 생성 완료\n");
				
				Common.logActive = true;
			}
			
			// 폴더 생성 실패
			else
			{
				Common.Sysln("로그 폴더 생성 불가");
				Common.Sysln("관리자 권한으로 프로그램을 실행하거나 직접 생성하세요.");
				Common.Sysln("로그 폴더가 없으므로 로그 파일이 생성되지 않습니다.\n");
				
				Common.logActive = false;
				
				return;
			}
		}
		
		// 로그 저장 폴더가 있을 경우
		else
		{
			Common.Sysln("로그 폴더 감지\n");
			
			Common.logActive = true;
		}
		
		LogWrite("KorCham Start\n");
		
		LogWrite("Log Path: " + getLogPath());
		LogWrite("Sound File: " + Common.soundFile + "\n");
		
		LogWrite("Log Active: " + Common.logActive);
		LogWrite("Sound Active: " + Common.soundActive + "\n");
		
		for (int i = 0; i < Common.urlList.size(); i++)
		{
			String url = Common.urlList.get(i).getAsJsonObject().get("url").getAsString();
			String date = Common.urlList.get(i).getAsJsonObject().get("date").getAsString();
			
			LogWrite("URL: " + url);
			LogWrite("Date: " + date);
		}
		
		System.out.println();
	}
}