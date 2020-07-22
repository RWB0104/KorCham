@echo off
cls

set te="java -version 2>&1"

FOR /F %%i IN (' %te% ') DO SET X=%%i

IF %X%==Java (
	cls
	java -jar KorCham.jar
) ELSE (
	echo JAVA가 설치되지 않았거나 환경변수가 지정되지 않았습니다.
	echo 1.8 이상의 JAVA를 설치하고 환경변수를 등록해주세요.
	pause
)