#!/bin/bash

mvn install && \
./bulid-customer.sh && \
./bulid-point.sh && \
./bulid-rent.sh && \
./bulid-video.sh

# mvn install && \
# cd fresh-customer && docker build -t lastiverse/fresh-customer:$VER . && \
# cd ../fresh-point && docker build -t lastiverse/fresh-point:$VER . && \
# cd ../fresh-rent && docker build -t lastiverse/fresh-rent:$VER . && \
# cd ../fresh-video && docker build -t lastiverse/fresh-video:$VER . && 
# cd ../ && \
# docker push lastiverse/fresh-customer:$VER && \
# docker push lastiverse/fresh-point:$VER && \
# docker push lastiverse/fresh-rent:$VER && \
# docker push lastiverse/fresh-video:$VER
