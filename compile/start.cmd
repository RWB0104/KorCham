@echo off
cls

set te="java -version 2>&1"

FOR /F %%i IN (' %te% ') DO SET X=%%i

IF %X%==Java (
	cls
	java -jar KorCham.jar
) ELSE (
	echo JAVA�� ��ġ���� �ʾҰų� ȯ�溯���� �������� �ʾҽ��ϴ�.
	echo 1.8 �̻��� JAVA�� ��ġ�ϰ� ȯ�溯���� ������ּ���.
	pause
)