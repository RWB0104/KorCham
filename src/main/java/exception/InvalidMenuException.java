package main.java.exception;

public class InvalidMenuException extends Exception
{
	private static final long serialVersionUID = 1L;

	public InvalidMenuException()
	{
		super("유효하지 않은 메뉴");
	}
}