@echo off
set LOCALCLASSPATH=%CLASSPATH%;.;lib\GG.jar;lib\htmlparser.jar;lib\jh.jar;lib\jsearch.jar;lib\GooseGetHelp.jar;
java -Xms32m -Xmx64m -cp "%LOCALCLASSPATH%" -noverify org.mp3house.gg.bin.GGRun