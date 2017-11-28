#!/bin/sh
PROJECT_ROOT=$(pwd)
echo $PROJECT_ROOT

#start package device-service
cd $PROJECT_ROOT
mvn clean install -U
echo "done"

cp /usr/bin/qemu-aarch64-static .
