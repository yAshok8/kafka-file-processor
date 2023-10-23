@echo off
start "Kafka Stop" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\kafka-server-stop.bat"
ping 127.0.0.1 -n 3 -w 10000 > nul
start "Zookeeper Stop" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\zookeeper-server-stop.bat"
