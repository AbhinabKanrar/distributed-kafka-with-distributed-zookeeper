#!/bin/bash

nohup ./kafka_2.12-2.0.1/bin/kafka-server-start.sh kafka_2.12-2.0.1/config/server.properties &> kafka-log.log&


