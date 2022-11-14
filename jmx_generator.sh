#!/bin/bash
# $1 是模板文件，将其中的 __THREAD__ 替换为真实的线程数
# $2 是输出目录

for type in "auto" "manual"; do
  for thread in 50 100 200 300 400; do
    echo "Running test with $thread threads"
    if [ ! -d "$2/$type" ]; then
      mkdir "$2/$type"
    fi
    sed "s/__THREAD__/$thread/" "$1" >"$2/$type/read_""$thread""_$type.jmx"
  done
done
