#!/bin/bash

# $1 是 jtl 生成目录
if [ ! -d "$1" ]; then
  echo "creating target directory: $1"
  mkdir "$1"
fi

# 遍历当前目录下的所有 jmx 文件
for file in *.jmx; do
  # 如果是文件
  if [ -f "$file" ]; then
    # 提取文件名
    file_name=${file%.*}
    echo "processing: $file_name"
    jmeter -n -t "$file" -l "$1/$file_name.jtl"
    sleep 2s
  fi
done
