#!/bin/bash

VER=0.0.2

echo $VER && \

cd fresh-rent && docker build -t lastiverse/fresh-rent:$VER . && \
cd ../ && \
docker push lastiverse/fresh-rent:$VER
