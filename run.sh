#!/usr/bin/env bash

./bin/zookeeper-server-start.sh config/zookeeper-1.properties &

./bin/zookeeper-server-start.sh config/zookeeper-2.properties &

./bin/zookeeper-server-start.sh config/zookeeper-3.properties &

./bin/kafka-server-start.sh config/server-1.properties &

./bin/kafka-server-start.sh config/server-2.properties &

./bin/kafka-server-start.sh config/server-3.properties &


#./bin/kafka-topics.sh --create --zookeeper localhost:2181,localhost:2182,localhost:2183 --replication-factor 3 --partitions 1 --topic mabsisa

