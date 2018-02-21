###############################################################################
# Copyright 2017 Samsung Electronics All Rights Reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
###############################################################################

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
