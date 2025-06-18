#!/usr/bin/env bash
set -e

usage(){ echo "Usage: $0 -t <tag>"; exit 1; }

while getopts "t:" opt; do
  case $opt in
    t) TAG=$OPTARG ;;
    *) usage ;;
  esac
done
[ -z "$TAG" ] && usage

echo "→ Building image my-spring-app:${TAG}"
docker build -t my-spring-app:"${TAG}" .
