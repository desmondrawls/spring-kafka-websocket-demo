# Live-Dashboard-using-Kafka-and-Spring-Websocket
This Demo application reads data from Apache Kafka topic and updating the View using Spring Websocket on real-time.

Setting up Kafka
1. [brew install kafka](https://medium.com/@Ankitthakur/apache-kafka-installation-on-mac-using-homebrew-a367cdefd273)
1. `brew services start kafka`
1. `kafka-console-producer --broker-list localhost:9092 --topic temperature`
1. `kafka-console-consumer --bootstrap-server localhost:9092 --topic temperature --from-beginning`

...or with confluent
1. [zip install](https://docs.confluent.io/current/installation/installing_cp/zip-tar.html)
1. ./bin/zookeeper-server-start ./etc/kafka/zookeeper.properties
1. ./bin/kafka-server-start ./etc/kafka/server.properties
1. ./bin/control-center-start ./etc/confluent-control-center/control-center.properties

[docker quick start](https://docs.confluent.io/current/quickstart/ce-docker-quickstart.html)

If you try `./gradlew bootrun` at this point you will see an error because the temperature topic doesn't exist. 
Visit the control center at `localhost:9092` and create the temperature topic with defaults. 
Now start the server and visit `localhost:5656/home`.
