#!/usr/bin/env bash

ng serve > frontend.log &
echo $! > frontend.pid
