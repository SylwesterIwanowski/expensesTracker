#!/usr/bin/env bash

mvn clean install
java -jar ./target/budget-tracker-0.1.0.jar > backend.log &
echo $! > backend.pid
