package main.java.common;

import java.io.File;
import java.util.Calendar;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * 기본 설정 정보 클래스
 * 
 * @author RWB
 * 
 * @since 2020.03.17 Tue 19:42
 */
public class Config
{
	private final String logPath = Common.jarPath + File.separator + "logs";
	private final String soundFile = Common.jarPath + File.separator + "sound" + File.separator + "alert.wav";
	
	private final Boolean logActive = true;
	private final Boolean soundActive = true;
	
	private final JsonArray urlList = new JsonArray();
	
	/**
	 * Config 생성자 함수
	 * 
	 * @return {Active}: urlList에 기본값 지정
	 */
	public Config()
	{
		String start = Common.DateCalculator(Calendar.DATE, 0);
		String end = Common.DateCalculator(Calendar.DATE, 15);
		
		JsonObject object = new JsonObject();
		object.addProperty("url", "URL1");
		object.addProperty("start", start);
		object.addProperty("end", end);
		
		urlList.add(object);
		
		object = new JsonObject();
		object.addProperty("url", "URL2");
		object.addProperty("start", start);
		object.addProperty("end", end);
		
		urlList.add(object);
		
		object = new JsonObject();
		object.addProperty("url", "URL3");
		object.addProperty("start", start);
		object.addProperty("end", end);
		
		urlList.add(object);
	}
	
	/**
	 * 로그 폴더 경로 반환 함수
	 * 
	 * @return {} logPath: 로그 폴더 경로
	 */
	public String getLogPath()
	{
		return logPath;
	}
	
	/**
	 * 사운드 파일 경로 반환 함수
	 * 
	 * @return {} soundFile: 사운드 파일 경로
	 */
	public String getSoundFile()
	{
		return soundFile;
	}
	
	/**
	 * 로그 프로세스 실행 여부 반환 함수
	 * 
	 * @return {} logActive: 로그 프로세스 실행 여부 (true / false)
	 */
	public boolean isLogActive()
	{
		return logActive;
	}
	
	/**
	 * 사운드 프로세스 실행 여부 반환 함수
	 * 
	 * @return {} soundActive: 사운드 프로세스 실행 여부 (true / false)
	 */
	public boolean isSoundActive()
	{
		return soundActive;
	}
	
	/**
	 * URL 주소 리스트 반환 함수
	 * 
	 * @return {} urlList: URL 주소 리스트
	 */
	public JsonArray getUrlList()
	{
		return urlList;
	}
}