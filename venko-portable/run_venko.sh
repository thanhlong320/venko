#!/usr/bin/env bash
SERVER=0.0.0.0
PORTFE=4200
nc -z -v -w5 $SERVER $PORTFE
result1=$?

PORTBE=8080
nc -z -v -w5 $SERVER $PORTBE
result2=$?

#Do whatever you want
if [  "$result1" != 0 ]; then
  if [  "$result2" != 0 ]; then
    docker-compose down
    docker-compose pull 
    docker-compose up -d
    echo "Venko is currently running on http://localhost:4200, it may take a bit longer to fully start up."
  else
    echo "Another application is using port $PORTBE. Please close it before running venko portable?"
  fi  
else
  echo "Another application is using port $PORTFE. Please close it before running venko portable?"
fi
