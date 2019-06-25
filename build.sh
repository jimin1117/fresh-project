#!/bin/bash

mvn install && \
cd fresh-customer && docker build -t lastiverse/fresh-customer:0.0.1 . && \
cd ../fresh-point && docker build -t lastiverse/fresh-point:0.0.1 . && \
cd ../fresh-rent && docker build -t lastiverse/fresh-rent:0.0.1 . && \
cd ../fresh-video && docker build -t lastiverse/fresh-video:0.0.1 . && 
cd ../ && \
docker push lastiverse/fresh-customer:0.0.1 && \
docker push lastiverse/fresh-point:0.0.1 && \
docker push lastiverse/fresh-rent:0.0.1 && \
docker push lastiverse/fresh-video:0.0.1
