#!/bin/bash

nohup ./confluent-5.0.1/bin/kafka-rest-start confluent-5.0.1/etc/kafka-rest/kafka-rest.properties &> kafka-rest-proxy.log&


