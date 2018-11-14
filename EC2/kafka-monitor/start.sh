#!/bin/bash

nohup ./confluent-5.0.1/bin/control-center-start confluent-5.0.1/etc/confluent-control-center/control-center.properties  &> kafka-monitor.log&


