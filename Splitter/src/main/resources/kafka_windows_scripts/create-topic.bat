@echo off
setlocal enabledelayedexpansion

rem Prompt the user for input
set /p "input1=Enter the topic name: "
set /p "input2=Enter the partition numbers: "
set /p "input3=Enter the replication factor: "

cmd /k D:\kafka_2.12-3.5.1\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --topic !input1! --create --partitions !input2! --replication-factor !input3!

set /p "inputx=press enter to continue..."

pause