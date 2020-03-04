package main.java.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import main.java.common.Common;
import main.java.common.TargetURL;

public class Crawler
{
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
	
	public void Crawling(TargetURL url, String date)
	{
		try
		{
			Document doc = Jsoup.connect(url.getValue()).get();
			Elements table = doc.select("#placeInfoTable > tbody > tr");
			Elements header = doc.select("#placeInfoTable > tbody > tr > th");
			
			int col = header.size();
			int row = table.size();
			
			for (int i = 1; i < row; i++)
			{
				if (getBody(table, i, 0).equals(date))
				{
					break;
				}
				
				for (int j = 2; j < col; j++)
				{
					if (!getBody(table, i, j).equals("마감") && !getBody(table, i, j).equals(""))
					{
						Common.Sys(url.ordinal() + "번 째 " + getBody(table, i, 0) + " " + getBody(table, i, 1) + " " + getHeader(table, j) + "(" + getBody(table, i, j) + ")");
					}
				}
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			Common.Sys("오류로 인한 크롤링 실패 (URL" + TargetURL.URL1.ordinal() + 1 + ")");
		}
	}
}