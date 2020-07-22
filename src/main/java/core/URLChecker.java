package main.java.core;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import main.java.bean.URLBean;
import main.java.common.Common;
import main.java.exception.InvalidMenuException;

/**
 * 시험장 URL 저장 기능 클래스
 * 
 * @author RWB
 *
 * @since 2020.07.22 Wed 10:23
 */
public class URLChecker
{
	private Scanner scanner = null;
	
	/**
	 * URLChecker 생성자 함수
	 * 
	 * @param {Scanner} scanner: Scanner 객체
	 * 
	 * @return {Active}: URLChecker 초기화
	 */
	public URLChecker(Scanner scanner)
	{
		this.scanner = scanner;
	}
	
	/**
	 * URL 저장 동작 함수
	 * 
	 * @return {Active}: 지정된 경로에 URL 목록 저장
	 */
	public void check()
	{
		URLBean bean = new URLBean();
		
		bean = selectExam(bean);
		
		// 시험 선택값이 null일 경우
		if (bean.getExam() == null)
		{
			return;
		}
		
		bean = selectLevel(bean);
		
		// 등급 선택값이 null일 경우
		if (bean.getLevel() == null)
		{
			bean = selectExam(bean);
		}
		
		bean = selectPlace(bean);
		
		// 시험장 선택값이 null일 경우
		if (bean.getPlace() == null)
		{
			bean = selectLevel(bean);
		}
		
		saveURL(bean);
	}
	
	private URLBean selectExam(URLBean bean)
	{
		String result = null;
		
		while (true)
		{
			// 시험 정보 선택 시도
			try
			{
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("시험 정보 가져오는 중...");
				
				String url = "http://license.korcham.net/ex/dailyExamPlaceConf.do";
				
				Document document = Jsoup.connect(url).timeout(5000).get();
				
				Elements elements = document.select("#selectJmcd > option");
				
				String[] data = new String[elements.size()];
				
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("========================================================================");
				System.out.println("                             시험을 선택해주세요.");
				System.out.println("========================================================================");
				System.out.println();
				System.out.println("  원하시는 시험에 해당하는 숫자를 입력하세요.");
				System.out.println();
				
				for (int i = 0; i < elements.size(); i++)
				{
					System.out.println("  [" + (i + 1) + "] " + elements.get(i).text());
					
					data[i] = elements.get(i).attr("value");
				}
				
				System.out.println();
				System.out.println("  [0] 뒤로 가기");
				System.out.println();
				System.out.println("========================================================================");
				System.out.println();
				System.out.print("시험 선택 >> ");
				
				String input = scanner.nextLine();
				
				int active = Integer.parseInt(input);
				
				// 선택한 시험이 제시한 범위가 아닐 경우
				if (active < 0 || active > elements.size() + 1)
				{
					throw new InvalidMenuException();
				}
				
				// 선택한 시험이 제시한 범위일 경우
				else
				{
					active--;
					
					// 뒤로가기가 아닐 경우
					if (active > -1)
					{
						result = data[active];
					}
					
					bean.setExam(result);
					
					break;
				}
			}
			
			// 유효하지 않은 데이터 형식 오류
			catch (NumberFormatException e)
			{
				System.out.println();
				System.err.println("[ERROR] 숫자를 입력해주세요.");
			}
			
			// 유효하지 않은 메뉴 선택
			catch (InvalidMenuException e)
			{
				System.out.println();
				System.err.println("[ERROR] 지정된 시험을 선택해주세요.");
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
				System.err.println("[ERROR] 메뉴 선택 실패.");
			}
		}
		
		return bean;
	}
	
	private URLBean selectLevel(URLBean bean)
	{
		String result = null;
		
		while (true)
		{
			// 등급 정보 선택 시도
			try
			{
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("시험 등급 정보 가져오는 중...");
				
				URL url = new URL("http://license.korcham.net/ex/ajaxGetExamElevelList2.do");
				
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(5000);
				connection.setRequestMethod("POST");
				connection.setDoOutput(true);
				
				DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
				wr.writeBytes("jmcdKey=" + bean.getExam());
				wr.flush();
				wr.close();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "EUC-KR"));
				
				String temp;
				
				StringBuffer response = new StringBuffer();
				
				while ((temp = reader.readLine()) != null)
				{
					response.append(temp);
				}
				
				reader.close();
				
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				
				JsonObject object = gson.fromJson(response.toString(), JsonObject.class);
				
				JsonArray array = object.get("result").getAsJsonArray();
				
				String[] data = new String[array.size()];
				
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("========================================================================");
				System.out.println("                             등급을 선택해주세요.");
				System.out.println("========================================================================");
				System.out.println();
				System.out.println("  원하시는 등급에 해당하는 숫자를 입력하세요.");
				System.out.println();
				
				for (int i = 0; i < array.size(); i++)
				{
					String type = array.get(i).getAsJsonObject().get("typeName").getAsString();
					String level = array.get(i).getAsJsonObject().get("elevelName").getAsString();
					
					System.out.println("  [" + (i + 1) + "] " + type + " " + level);
					
					data[i] = array.get(i).getAsJsonObject().get("elevel").getAsString();
				}
				
				System.out.println();
				System.out.println("  [0] 뒤로 가기");
				System.out.println();
				System.out.println("========================================================================");
				System.out.println();
				System.out.print("등급 선택 >> ");
				
				String input = scanner.nextLine();
				
				int active = Integer.parseInt(input);
				
				// 선택한 등급이 제시한 범위가 아닐 경우
				if (active < 0 || active > array.size() + 1)
				{
					throw new InvalidMenuException();
				}
				
				// 선택한 등급이 제시한 범위일 경우
				else
				{
					active--;
					
					// 뒤로가기가 아닐 경우
					if (active > -1)
					{
						result = data[active];
					}
					
					bean.setLevel(result);
					System.err.println(result);
					
					break;
				}
			}
			
			// 유효하지 않은 데이터 형식 오류
			catch (NumberFormatException e)
			{
				System.out.println();
				System.err.println("[ERROR] 숫자를 입력해주세요.");
			}
			
			// 유효하지 않은 메뉴 선택
			catch (InvalidMenuException e)
			{
				System.out.println();
				System.err.println("[ERROR] 지정된 등급을 선택해주세요.");
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
				System.err.println("[ERROR] 메뉴 선택 실패.");
			}
		}
		
		return bean;
	}
	
	private URLBean selectPlace(URLBean bean)
	{
		String result = null;
		
		while (true)
		{
			// 시험장 정보 선택 시도
			try
			{
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("시험장 정보 가져오는 중...");
				
				String url = "http://license.korcham.net/ex/dailyExamPlaceConf.do";
				
				Document document = Jsoup.connect(url).timeout(5000).get();
				
				Elements elements = document.select("#selectAreaCd > option");
				
				String[] data = new String[elements.size()];
				
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println("========================================================================");
				System.out.println("                            시험장을 선택해주세요.");
				System.out.println("========================================================================");
				System.out.println();
				System.out.println("  원하시는 시험장에 해당하는 숫자를 입력하세요.");
				System.out.println();
				
				for (int i = 0; i < elements.size(); i++)
				{
					System.out.println("  [" + (i + 1) + "] " + elements.get(i).text());
					
					data[i] = elements.get(i).attr("value");
				}
				
				System.out.println();
				System.out.println("  [0] 뒤로 가기");
				System.out.println();
				System.out.println("========================================================================");
				System.out.println();
				System.out.print("시험장 선택 >> ");
				
				String input = scanner.nextLine();
				
				int active = Integer.parseInt(input);
				
				// 선택한 시험이 제시한 범위가 아닐 경우
				if (active < 0 || active > elements.size() + 1)
				{
					throw new InvalidMenuException();
				}
				
				// 선택한 시험이 제시한 범위일 경우
				else
				{
					active--;
					
					// 뒤로가기가 아닐 경우
					if (active > -1)
					{
						result = data[active];
					}
					
					bean.setPlace(result);
					
					break;
				}
			}
			
			// 유효하지 않은 데이터 형식 오류
			catch (NumberFormatException e)
			{
				System.out.println();
				System.err.println("[ERROR] 숫자를 입력해주세요.");
			}
			
			// 유효하지 않은 메뉴 선택
			catch (InvalidMenuException e)
			{
				System.out.println();
				System.err.println("[ERROR] 지정된 시험을 선택해주세요.");
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
				System.err.println("[ERROR] 메뉴 선택 실패.");
			}
		}
		
		return bean;
	}
	
	private void saveURL(URLBean bean)
	{
		try
		{
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("URL 리스트 저장하는 중...");
			
			URL url = new URL("http://license.korcham.net/ex/ajaxDailyExamSangwiList.do");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5000);
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(bean.getParam());
			wr.flush();
			wr.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "EUC-KR"));
			
			String temp;
			
			StringBuffer response = new StringBuffer();
			
			while ((temp = reader.readLine()) != null)
			{
				response.append(temp);
			}
			
			reader.close();
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			
			JsonObject object = gson.fromJson(response.toString(), JsonObject.class);
			
			JsonArray array = object.get("snagwiList").getAsJsonArray();
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("========================================================================");
			System.out.println("                              URL 저장 목록");
			System.out.println("========================================================================");
			System.out.println();
			System.out.println("  총 " + array.size() + "개 URL 확인됨.");
			System.out.println();
			
			File file = new File(Common.jarPath + File.separator + "url");
			
			if (!file.exists())
			{
				file.mkdir();
			}
			
			FileWriter writer = new FileWriter(file.getPath() + File.separator + "url.txt");
			
			for (int i = 0; i < array.size(); i++)
			{
				// URL 저장 시도
				try
				{
					String name = array.get(i).getAsJsonObject().get("placeName").getAsString();
					String realURL = "http://license.korcham.net/ex/ajaxDailyExamSangwiList.do?" + bean.getParam();
					String address = array.get(i).getAsJsonObject().get("address").getAsString();
					String tel = array.get(i).getAsJsonObject().get("phone").getAsString();
					
					writer.append(name + "\n");
					writer.append(realURL + "\n");
					writer.append(address + "\n");
					writer.append(tel + "\n");
					writer.append("https://m.map.naver.com/search2/search.nhn?query=" + address + "#/map\n\n");
					writer.flush();
					
					System.out.println("  [" + (i + 1) + "] 기록 완료 \t\t " + name + "");
				}
				
				// 오류
				catch (Exception e)
				{
					writer.append("기록 실패\n");
					writer.flush();
					
					System.err.println("  [" + (i + 1) + "] 기록 실패 " + e.getMessage());
				}
			}
			
			System.out.println("저장 경로 : " + file.getPath() + File.separator + "url.txt");
			
			writer.close();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}