#!/bin/bash

VER=0.0.2

echo $VER && \

cd fresh-video && docker build -t lastiverse/fresh-video:$VER . && \
cd ../ && \
docker push lastiverse/fresh-video:$VER
