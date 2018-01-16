#!/bin/sh
echo "Start command datamodel unit test"
edge_command_model_home=$(pwd)

#start 
cd $edge_command_model_home
cd ./command-json-format
mvn test
#check unit test fail
if [ $? -ne 0 ]; then
        echo "Unittest is failed."; exit 1
fi

echo "End of command datamodel unit test"
