@echo off
start "ZooKeeper" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\zookeeper-server-start.bat D:\kafka_2.12-3.5.1\config\zookeeper.properties"
ping 127.0.0.1 -n 25 -w 10000 > nul
start "Kafka server 0" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\kafka-server-start.bat D:\kafka_2.12-3.5.1\config\server.properties"
ping 127.0.0.1 -n 10 -w 10000 > nul
start "Kafka server 1" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\kafka-server-start.bat D:\kafka_2.12-3.5.1\config\server-1.properties"
ping 127.0.0.1 -n 10 -w 10000 > nul
start "Kafka server 2" cmd /k "D:\kafka_2.12-3.5.1\bin\windows\kafka-server-start.bat D:\kafka_2.12-3.5.1\config\server-2.properties"