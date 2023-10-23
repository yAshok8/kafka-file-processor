@echo off

setlocal enabledelayedexpansion

echo "These are the existing topics"

set "outputList="

rem Run the command and capture its output
for /f "delims=" %%i in ('D:\kafka_2.12-3.5.1\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list') do (
    rem Append each line of output to the list
    set "outputList=!outputList! %%i"
)

rem Display the contents of the output list
echo Output List:
ECHO %outputList%

endlocal

set /p "topicname=Enter a topic name you wanna consume: "
set /p "consumercount=How many consumers you want to start: "
set /p "input1=Do you want to use a consumer group? [y/n] "

if "%input1%" == "y"  (
	set /p "input1=Do you want to use new consumer? [y/n] "
	if "%input1%" == "y" (
		set /p "consumername=Consumer Name: "
	) else (
		set /p "consumername=Existing Consumer Name: "
	)
)

setlocal enabledelayedexpansion

rem Define a range of values to iterate over (1 to 5)
if defined consumername (
	for /l %%i in (1, 1, %consumercount%) do (
		ECHO D:\kafka_2.12-3.5.1\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic %topicname% --group %consumername%
		start "consumer %%i" cmd /k D:\kafka_2.12-3.5.1\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic %topicname% --group %consumername%
	)
) else (
	for /l %%i in (1, 1, %consumercount%) do (
		ECHO D:\kafka_2.12-3.5.1\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic %topicname%
		start "consumer %%i" cmd /k D:\kafka_2.12-3.5.1\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic %topicname%
	)
)

endlocal
pause

