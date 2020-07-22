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
			URL url = new URL("http://license.korcham.net/ex/ajaxDailyExamSangwiList.do");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36 Edg/83.0.478.64");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setDoOutput(true);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes("areaCode=01&jmcdKey=202099AKK1&elevel=1");
			wr.flush();
			wr.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "EUC-KR"));

			String temp;

			StringBuffer response = new StringBuffer();

			while ((temp = reader.readLine()) != null)
			{
				response.append(temp);
			}

			System.out.println(response);

			reader.close();

			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			JsonObject object = gson.fromJson(response.toString(), JsonObject.class);

			System.out.println(gson.toJson(object));
		}

		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}