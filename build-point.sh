#!/bin/bash

VER=0.0.2

echo $VER && \

cd fresh-point && docker build -t lastiverse/fresh-point:$VER . && \
cd ../ && \
docker push lastiverse/fresh-point:$VER
