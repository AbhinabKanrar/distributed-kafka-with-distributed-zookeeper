#!/bin/bash

wget http://mirrors.wuchna.com/apachemirror/zookeeper/stable/zookeeper-3.4.12.tar.gz

tar xzf zookeeper-3.4.12.tar.gz

cd zookeeper-3.4.12

mkdir data

cd data

touch myid

read -p 'Please provide UNIQUE instance id =>' id

echo $id >> myid

cd ../conf/

mv zoo*.cfg zoo.cfg

read -p 'Please change the zookeeper-3.4.12/conf/zoo.cfg file accordingly(refer https://github.com/AbhinabKanrar/distributed-kafka-with-distributed-zookeeper/blob/master/guideline.txt) and when done, press ENTER'

