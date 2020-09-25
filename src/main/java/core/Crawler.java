package main.java.core;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import main.java.common.Common;
import main.java.log.LogManager;

/**
 * 자리 유무 분석 클래스
 * 
 * @author RWB
 *
 * @since 2020.03.05 Thu 09:41
 */
public class Crawler
{
	private LogManager log = LogManager.getInstance();
	private SoundManager sound = SoundManager.getInstance();
	
	private static Crawler instance = new Crawler();
	
	private String encode = null;
	
	/**
	 * Crawler 인스턴스 반환 함수
	 * 
	 * @return {Crawler} instance: Crawler 인스턴스
	 */
	public static Crawler getInstance()
	{
		return instance;
	}
	
	/**
	 * Elements인 table 객체의 j열 헤더 텍스트 값 반환 함수
	 * 
	 * @param {Elements} elms: HTML의 table Elements
	 * @param {int} i: 열 번호
	 * 
	 * @return {String} result: j열 헤더 텍스트 값
	 */
	private String getHeader(Elements elms, int i)
	{
		String result = elms.select("tr").get(0).select("th").get(i).text();
		return result;
	}
	
	/**
	 * Elements인 table 객체의 i행 j열 바디 텍스트 값 반환 함수
	 * 
	 * @param {Elements} elms: HTML의 table Elements
	 * @param {int} i: 행 번호
	 * @param {int} j: 열 번호
	 * 
	 * @return {String} elms.select("tr").get(i).select("td").get(j).text(): i행 j열 바디 텍스트 값
	 */
	private String getBody(Elements elms, int i, int j)
	{
		String result = elms.select("tr").get(i).select("td").get(j).text();
		return result;
	}
	
	/**
	 * 암호화 코드 반환 함수
	 * 
	 * @param {String} url: URL
	 * 
	 * @return {String} encode: 암호화 코드
	 */
	private String getEncode()
	{
		String encode = null;
		
		// 암호화 코드 확인 시도
		try
		{
			String url = "http://license.korcham.net/ex/dailyExamPlaceConf.do";
			
			Document document = Jsoup.connect(url).timeout(5000).get();
			
			Elements script = document.getElementsByTag("script");
			
			Pattern pattern = Pattern.compile("var strTemp = \"(.+?)\";");
			Matcher matcher = pattern.matcher(script.html());
			
			// 정규식과 일치할 경우
			if (matcher.find())
			{
				encode = matcher.group(1);
			}
		}
		
		// 응답시간 초과 오류
		catch (SocketTimeoutException e)
		{
			System.out.println();
			System.err.println("[ERROR] 서버가 응답하지 않습니다.");
		}
		
		// 입출력 오류
		catch (IOException e)
		{
			System.out.println();
			System.err.println("[ERROR] 데이터 입출력 과정에서 오류가 발생했습니다.");
		}
		
		// 오류
		catch (Exception e)
		{
			System.out.println();
			System.err.println("[ERROR] 암호화 코드 확인 실패");
		}
		
		return encode;
	}
	
	/**
	 * 크롤링 함수
	 * 
	 * @param {int} num: 인덱스
	 * 
	 * @return {Active}: 신청 가능 여부가 마감 혹은 빈 칸이 아닐 경우, 해당 시험장의 시간과 날짜 출력
	 */
	public void Crawling(int num)
	{
		int index = num + 1;
		
		boolean buzz = false;
		
		// 크롤링 동작
		try
		{
			String url = Common.urlList.get(num).getAsJsonObject().get("url").getAsString();
			String date = Common.urlList.get(num).getAsJsonObject().get("date").getAsString();
			
			double connectStart = System.currentTimeMillis();
			
			// 암호화 코드가 유효하지 않을 경우
			if (encode == null)
			{
				encode = getEncode();
			}
			
			StringBuilder builder = new StringBuilder();
			builder.append(url);
			builder.append("&encodeTemp=");
			builder.append(encode);
			
			url = builder.toString();
			
			Document doc = Jsoup.connect(url).timeout(5000).get();
			
			Elements table = doc.select("#placeInfoTable > tbody > tr");
			Elements header = doc.select("#placeInfoTable > tbody > tr > th");
			
			double connectEnd = System.currentTimeMillis();
			double connectTime = connectEnd - connectStart;
			
			String connectStr = null;
			
			// 연결 시간이 1000ms 이상일 경우
			if (connectTime >= 1000)
			{
				connectStr = "연결시간 " + String.format("%.3f", connectTime / 1000) + "s";
			}
			
			// 연결 시간이 1000ms 미만일 경우
			else
			{
				connectStr = "연결시간 " + connectTime + "ms";
			}
			
			// 행, 열의 갯수
			int col = header.size();
			int row = table.size();
			
			double processStart = System.nanoTime();
			
			// 행의 수만큼 반복
			for (int i = 1; i < row; i++)
			{
				// 열의 수만큼 반복
				for (int j = 2; j < col; j++)
				{
					// 값의 내용이 마감 혹은 빈 칸이 아닐 경우
					if (!getBody(table, i, j).equals("마감") && !getBody(table, i, j).equals(""))
					{
						// 신청 가능 인원 수 출력
						Common.Sysln(index + "번 째 " + getBody(table, i, 0) + " " + getBody(table, i, 1) + " " + getHeader(table, j) + "(" + getBody(table, i, j) + ")");
						log.LogWrite(index + "번 째 " + getBody(table, i, 0) + " " + getBody(table, i, 1) + " " + getHeader(table, j) + "(" + getBody(table, i, j) + ")");
						
						buzz = true;
					}
				}
				
				// 날짜가 지정된 날짜와 동일할 경우
				if (getBody(table, i, 0).replace(" ", "").equals(date.replace(" ", "")))
				{
					break;
				}
			}
			
			double processEnd = System.nanoTime();
			double processTime = processEnd - processStart;
			
			String processStr = null;
			
			// 연결시간이 1000ns 이상일 경우
			if (processTime >= 1000)
			{
				processStr = "처리시간 " + String.format("%.3f", processTime / 1000000) + "ms";
			}
			
			// 연결 시간이 1000ns 미만일 경우
			else
			{
				processStr = "처리시간 " + processTime + "ns";
			}
			
			Common.Sysln("URL" + (num + 1) + ": " + connectStr + " / " + processStr);
			log.LogWrite("URL" + (num + 1) + ": " + connectStr + " / " + processStr);
			
			// 신청 가능 인원 수가 하나라도 발생했을 경우
			if (buzz)
			{
				sound.Play();
			}
			
			// 종료
			return;
		}
		
		// 예외 처리
		catch (Exception e)
		{
			Common.Sysln("오류로 인한 크롤링 실패 (URL" + index + ")");
			log.LogWrite("오류로 인한 크롤링 실패 (URL" + index + ")");
		}
	}
}