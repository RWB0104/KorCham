package main.java.common;

public enum TargetURL
{
	URL1("http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1103"),
	URL2("http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1104"),
	URL3("http://license.korcham.net/ex/dailyExamPlaceConf.do?selectJmcd=202099AKK1&selectDkcd=1&selectAreaCd=01&selectPcode=1105");
	
	private final String value;
	
	/**
	 * enum의 value 지정 함수
	 * 
	 * @param value: enum 객체
	 * 
	 * @return: value를 전달받은 객체로 지정
	 */
	TargetURL(String value)
	{
		this.value = value;
	}
	
	/**
	 * enum의 값 반환 함수
	 * 
	 * @return value: enum이 가진 값 반환
	 */
	public String getValue()
	{
		return value;
	}
}