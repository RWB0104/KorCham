package main.java.view;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class Test
{
	public static void main(String[] args)
	{
		try
		{
			URL url = new URL("http://license.korcham.net/ex/ajaxGetExamElevelList2.do");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes("jmcdKey=202099AKK1");
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
			
			System.out.println(gson.toJson(object));
			System.out.println(object.get("result").getAsJsonArray().size());
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}