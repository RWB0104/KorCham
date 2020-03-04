package main.java.view;

import main.java.common.TargetURL;
import main.java.core.Crawler;

public class MainUI
{
	public static void main(String[] args)
	{
		// LogManager log = LogManager.getInstance();
		// log.Start();
		
		System.out.println("========================================================================");
		System.out.println("888    d8P                    .d8888b.  888                             ");
		System.out.println("888   d8P                    d88P  Y88b 888                             ");
		System.out.println("888  d8P                     888    888 888                             ");
		System.out.println("888d88K      .d88b.  888d888 888        88888b.   8888b.  88888b.d88b.  ");
		System.out.println("8888888b    d88  88b 888P    888        888 '88b     '8b  888  888  88b ");
		System.out.println("888  Y88b   888  888 888     888    888 888  888  d888888 888  888  888 ");
		System.out.println("888   Y88b  Y88..88P 888     Y88b  d88P 888  888 888  888 888  888  888 ");
		System.out.println("888    Y88b   Y88P   888      'Y8888P'  888  888  Y888888 888  888  888 ");
		System.out.println("========================================================================");
		System.out.println("                                                                        ");
		System.out.println("                          Developed by RWB                              ");
		System.out.println("                             2020-03-00                                 ");
		System.out.println("                                                                        ");
		System.out.println("========================================================================");
		
		Crawler c = new Crawler();
		
		while (true)
		{
			c.Crawling(TargetURL.URL1, "2020. 03. 20");
			c.Crawling(TargetURL.URL2, "2020. 03. 20");
			c.Crawling(TargetURL.URL3, "2020. 03. 20");
		}
	}
}