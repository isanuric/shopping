#!/bin/bash

# Stop and remove all Docker containers
#docker stop $(docker ps -aq)
#docker rm $(docker ps -aq)
if [ -f "/my-postgres" ]; then
    docker rm $(docker ps -aq)
fi


# Start a new PostgreSQL container
docker run --name my-postgres -e POSTGRES_USER=username -e POSTGRES_PASSWORD=password -p 5432:5432 -d postgres:latest

sleep 3

# Connect to the PostgreSQL container
docker exec -it my-postgres psql -U username
