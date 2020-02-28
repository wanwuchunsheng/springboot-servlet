#!/bin/bash
DEPLOYMENT=$1
MODULE=$2
TAG=$3
echo "update image to:${IMAGE}"
kubectl set image deployments/${DEPLOYMENT} ${MODULE}=registry.cn-hangzhou.aliyuncs.com/smartwf/springboot-servlet:${TAG}
