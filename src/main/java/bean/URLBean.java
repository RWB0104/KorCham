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
	
	// 시험명
	private String examName;
	
	// 등급
	private String level;
	
	// 등급명
	private String levelName;
	
	// 시험장
	private String place;
	
	// 시험장명
	private String placeName;
	
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
	 * 시험명 반환 함수
	 * 
	 * @return {String} examName: 시험명
	 */
	public String getExamName()
	{
		return examName;
	}
	
	/**
	 * 시험명 할당 함수
	 * 
	 * @param {String} examName: 시험명
	 * 
	 * @return {Active}: 해당 클래스의 examName에 값 할당
	 */
	public void setExamName(String examName)
	{
		this.examName = examName;
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
	 * 등급명 반환 함수
	 * 
	 * @return {String} levelName: 등급명
	 */
	public String getLevelName()
	{
		return levelName;
	}
	
	/**
	 * 등급명 할당 함수
	 * 
	 * @param {String} levelName: 등급명
	 * 
	 * @return {Active}: 해당 클래스의 levelName에 값 할당
	 */
	public void setLevelName(String levelName)
	{
		this.levelName = levelName;
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
	 * 시험장명 반환 함수
	 * 
	 * @return {String} placeName: 시험장명
	 */
	public String getPlaceName()
	{
		return placeName;
	}
	
	/**
	 * 시험장명 할당 함수
	 * 
	 * @param {String} placeName: 시험장명
	 * 
	 * @return {Active}: 해당 클래스의 placeName에 값 할당
	 */
	public void setPlaceName(String placeName)
	{
		this.placeName = placeName;
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
	
	/**
	 * 시험 전체 이름 반환 함수
	 * 
	 * @return {String} name: 시험 전체 이름
	 */
	public String getName()
	{
		StringBuffer buffer = new StringBuffer(getExamName());
		buffer.append(" ");
		buffer.append(getLevelName());
		buffer.append(" ");
		buffer.append(getPlaceName());
		buffer.append(" ");
		
		String name = buffer.toString();
		
		return name;
	}
}