package main.java.exception;

/**
 * InvalidMenuException 예외 클래스
 * 
 * @author RWB
 *
 * @since 2020.0721 Tue 19:08
 */
public class InvalidMenuException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * InvalidMenuException 생성자 함수
	 * 
	 * @return {Active}: Exception 초기화
	 */
	public InvalidMenuException()
	{
		super("유효하지 않은 메뉴");
	}
}