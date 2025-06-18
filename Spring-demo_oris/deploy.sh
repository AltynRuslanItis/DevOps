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

export TAG
echo "→ Starting stack with tag ${TAG}"
docker-compose up -d
