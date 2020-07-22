package main.java.bean;

/**
 * URL 추출용 Bean 클래스
 * 
 * @author RWB
 *
 * @since 2020.07.22 Wed 23:42
 */
public class URLBean
{
	// 시험
	private String exam;
	
	// 등급
	private String level;
	
	// 시험장
	private String place;
	
	/**
	 * 시험 반환 함수
	 * 
	 * @return {String} exam: 시험
	 */
	public String getExam()
	{
		return exam;
	}
	
	/**
	 * 시험 할당 함수
	 * 
	 * @param {String} exam: 시험
	 * 
	 * @return {Active}: 해당 클래스의 exam에 값 할당
	 */
	public void setExam(String exam)
	{
		this.exam = exam;
	}
	
	/**
	 * 등급 반환 함수
	 * 
	 * @return {String} level: 등급
	 */
	public String getLevel()
	{
		return level;
	}
	
	/**
	 * 등급 할당 함수
	 * 
	 * @param {String} level: 등급
	 * 
	 * @return {Active}: 해당 클래스의 level에 값 할당
	 */
	public void setLevel(String level)
	{
		this.level = level;
	}
	
	/**
	 * 시험장 반환 함수
	 * 
	 * @return {String} place: 시험장
	 */
	public String getPlace()
	{
		return place;
	}
	
	/**
	 * 시험장 할당 함수
	 * 
	 * @param {String} place: 시험장
	 * 
	 * @return {Active}: 해당 클래스의 place에 값 할당
	 */
	public void setPlace(String place)
	{
		this.place = place;
	}
	
	/**
	 * URL 파라미터 반환 함수
	 * 
	 * @return {String} param: URL 파라미터
	 */
	public String getParam()
	{
		StringBuffer buffer = new StringBuffer("jmcdKey=");
		buffer.append(getExam());
		buffer.append("&elevel=");
		buffer.append(getLevel());
		buffer.append("&areaCode=");
		buffer.append(getPlace());
		
		String param = buffer.toString();
		
		return param;
	}
}