package main.java.common;

import java.io.File;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Config
{
	private final String logPath = Common.jarPath + File.pathSeparator + "logs";
	private final String soundFile = Common.jarPath + File.pathSeparator + "sound" + File.pathSeparator + "alert.wav";
	
	private final boolean logActive = true;
	private final boolean soundActive = true;
	
	private final JsonArray urlList = new JsonArray();
	
	/**
	 * Config Class 생성 시 초기 동작 함수
	 * 
	 * @return: urlList에 기본값 지정
	 */
	public Config()
	{
		JsonObject object = new JsonObject();
		
		object.addProperty("url", "http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1103");
		object.addProperty("date", "2020. 04. 10");
		
		urlList.add(object);
		
		object = new JsonObject();
		object.addProperty("url", "http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1104");
		object.addProperty("date", "2020. 04. 11");
		
		urlList.add(object);
		
		object = new JsonObject();
		object.addProperty("url", "http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1105");
		object.addProperty("date", "2020. 04. 12");
		
		urlList.add(object);
	}
	
	/**
	 * 로그 폴더 경로 반환 함수
	 * 
	 * @return logPath: 로그 폴더 경로
	 */
	public String getLogPath()
	{
		return logPath;
	}
	
	/**
	 * 사운드 파일 경로 반환 함수
	 * 
	 * @return soundFile: 사운드 파일 경로
	 */
	public String getSoundFile()
	{
		return soundFile;
	}
	
	/**
	 * 로그 프로세스 실행 여부 반환 함수
	 * 
	 * @return logActive: 로그 프로세스 실행 여부 (true / false)
	 */
	public boolean isLogActive()
	{
		return logActive;
	}
	
	/**
	 * 사운드 프로세스 실행 여부 반환 함수
	 * 
	 * @return soundActive: 사운드 프로세스 실행 여부 (true / false)
	 */
	public boolean isSoundActive()
	{
		return soundActive;
	}
	
	/**
	 * URL 주소 리스트 반환 함수
	 * 
	 * @return urlList: URL 주소 리스트
	 */
	public JsonArray getUrlList()
	{
		return urlList;
	}
}