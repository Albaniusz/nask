#!/bin/bash
echo "Start client"

sleep 1

printf "\n\nEndpoint /characters?page=1\n\n"

curl -v "http://localhost:8080/characters" | jq

sleep 3

printf "\n\nEndpoint /characters/1\n\n"

curl -v "http://localhost:8080/characters/1" | jq

sleep 1

printf "\n\nClient done!\n"
