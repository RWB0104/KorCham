package main.java.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import main.java.common.Common;

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
	 * @return instance: LogManager 인스턴스
	 */
	public static LogManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 로그 시작 시간 반환 함수
	 * 
	 * @return startTime: 로그 시작 시간
	 */
	private String getStartTime()
	{
		return startTime;
	}
	
	/**
	 * 로그 시작 시간 지정 함수
	 * 
	 * @return: startTime 객체 지정
	 */
	private void setStartTime()
	{
		startTime = Common.Now();
	}
	
	/**
	 * 로그 경로 반환 함수
	 * 
	 * @return logPath: 로그 경로
	 */
	public String getLogPath()
	{
		return logPath;
	}
	
	/**
	 * 로그 경로 지정 함수
	 * 
	 * @param logPath: 로그 경로
	 * 
	 * @return: LogManager Class의 logPath에 객체 지정
	 */
	public void setLogPath(String logPath)
	{
		this.logPath = logPath;
	}
	
	/**
	 * 로그파일 경로 반환 함수
	 * 
	 * @return logFile: 로그파일 경로
	 */
	public String getLogFile()
	{
		return logFile;
	}
	
	/**
	 * 로그파일 경로 지정 함수
	 * 
	 * @param logFile: 로그파일 경로
	 * 
	 * @return: LogManager Class의 logFile에 객체 지정
	 */
	public void setLogFile(String logFile)
	{
		this.logFile = logFile;
	}
	
	/**
	 * 로그 기록 함수
	 * 
	 * @param text: 로그 내용
	 * 
	 * @return: 로그파일에 로그 내용 기록 (로그파일 없을 경우 새로 생성)
	 */
	private void LogWrite(String text)
	{
		// 파일 쓰기 동작
		try
		{
			BufferedWriter buffer = new BufferedWriter(new FileWriter(getLogFile(), true));
			buffer.write("[" + Common.Now() + "] " + text);
			buffer.flush();
			buffer.close();
		}
		
		// 예외 처리
		catch (Exception e)
		{
			Common.Sys("로그파일 기록 실패 (" + getLogFile() + ")");
			Common.Sys("로그 기능이 종료됩니다.");
			
			Common.logActive = false;
		}
	}
	
	/**
	 * 로그 기록 준비
	 * 
	 * @return: Common.logActive에 로그 작동여부 기록
	 */
	public void Start()
	{
		setStartTime();
		
		// 로그 경로 지정
		setLogPath(Common.jarPath + File.separator + "logs");
		
		// 로그파일 경로 지정
		setLogFile(getLogPath() + File.separator + getStartTime() + ".log");
		
		File path = new File(getLogPath());
		
		// 로그 저장 폴더가 없을 경우
		if (!path.exists())
		{
			Common.Sys("로그 폴더 누락 감지\n");
			
			// 폴더 생성
			if (path.mkdir())
			{
				Common.Sys("로그 폴더 생성 완료\n");
				
				Common.logActive = true;
			}
			
			// 폴더 생성 실패
			else
			{
				Common.Sys("로그 폴더 생성 불가");
				Common.Sys("관리자 권한으로 프로그램을 실행하거나 직접 생성하세요.");
				Common.Sys("로그 폴더가 없으므로 로그 파일이 생성되지 않습니다.\n");
				
				Common.logActive = false;
				
				return;
			}
		}
		
		// 로그 저장 폴더가 있을 경우
		else
		{
			Common.Sys("로그 폴더 감지\n");
			
			Common.logActive = true;
		}
	}
}