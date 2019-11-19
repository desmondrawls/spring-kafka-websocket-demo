# Live-Dashboard-using-Kafka-and-Spring-Websocket
This Demo application reads data from Apache Kafka topic and updating the View using Spring Websocket on real-time.

Setting up Kafka
1. [brew install kafka](https://medium.com/@Ankitthakur/apache-kafka-installation-on-mac-using-homebrew-a367cdefd273)
1. `brew services start kafka`
1. `kafka-console-producer --broker-list localhost:9092 --topic temperature`