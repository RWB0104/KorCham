package main.java.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import main.java.common.Common;
import main.java.common.TargetURL;
import main.java.log.LogManager;

public class Crawler
{
	private LogManager log = LogManager.getInstance();
	private SoundManager sound = SoundManager.getInstance();
	
	/**
	 * Elements인 table 객체의 j열 헤더 텍스트 값 반환 함수
	 * 
	 * @param elms: HTML의 table Elements
	 * @param i: 열 번호
	 * 
	 * @return elms.select("tr").get(1).select("th").get(i).text(): j열 헤더 텍스트 값
	 */
	private String getHeader(Elements elms, int i)
	{
		return elms.select("tr").get(0).select("th").get(i).text();
	}
	
	/**
	 * Elements인 table 객체의 i행 j열 바디 텍스트 값 반환 함수
	 * 
	 * @param elms: HTML의 table Elements
	 * @param i: 행 번호
	 * @param j: 열 번호
	 * 
	 * @return elms.select("tr").get(i).select("td").get(j).text(): i행 j열 바디 텍스트 값
	 */
	private String getBody(Elements elms, int i, int j)
	{
		return elms.select("tr").get(i).select("td").get(j).text();
	}
	
	/**
	 * 크롤링 함수
	 * 
	 * @param url: URI가 지정된 enum 객체
	 * @param date: 날짜 (1900. 01. 01)
	 * 
	 * @return: 신청 가능 여부가 마감 혹은 빈 칸이 아닐 경우, 해당 시험장의 시간과 날짜 출력
	 */
	public void Crawling(TargetURL url, String date)
	{
		int index = url.ordinal() + 1;
		
		// 크롤링 동작
		try
		{
			Document doc = Jsoup.connect(url.getValue()).get();
			Elements table = doc.select("#placeInfoTable > tbody > tr");
			Elements header = doc.select("#placeInfoTable > tbody > tr > th");
			
			// 행, 열의 갯수
			int col = header.size();
			int row = table.size();
			
			// 행의 수만큼 반복
			for (int i = 1; i < row; i++)
			{
				// 날짜가 지정된 날짜와 동일할 경우
				if (getBody(table, i, 0).equals(date))
				{
					// 종료
					return;
				}
				
				// 열의 수만큼 반복
				for (int j = 2; j < col; j++)
				{
					// 값의 내용이 마감 혹은 빈 칸이 아닐 경우
					if (!getBody(table, i, j).equals("마감") && !getBody(table, i, j).equals(""))
					{
						// 신청 가능 인원 수 출력
						Common.Sys(index + "번 째 " + getBody(table, i, 0) + " " + getBody(table, i, 1) + " " + getHeader(table, j) + "(" + getBody(table, i, j) + ")");
						
						sound.Play();
						
						log.LogWrite(index + "번 째 " + getBody(table, i, 0) + " " + getBody(table, i, 1) + " " + getHeader(table, j) + "(" + getBody(table, i, j) + ")");
					}
				}
			}
		}
		
		// 예외 처리
		catch (Exception e)
		{
			Common.Sys("오류로 인한 크롤링 실패 (URL" + index + ")");
			
			log.LogWrite("오류로 인한 크롤링 실패 (URL" + index + ")");
		}
	}
}