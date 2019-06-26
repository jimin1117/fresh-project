#!/bin/bash

VER=0.0.2

echo $VER && \

cd fresh-customer && docker build -t lastiverse/fresh-customer:$VER . && \
cd ../ && \
docker push lastiverse/fresh-customer:$VER
