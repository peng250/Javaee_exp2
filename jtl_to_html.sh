#! /bin/bash

# $1 是 html 生成目录
if [ ! -d "$1" ]; then
  echo "creating target directory: $1"
  mkdir "$1"
fi

# 遍历当前目录下的所有 jtl 文件
for file in *.jtl; do
  # 如果是文件
  if [ -f "$file" ]; then
    # 提取文件名
    dir=${file%.*}
    echo "processing: $dir"
    # 生成 html，以文件名为目录名
    jmeter -g "$file" -o "$1/$dir"
    # 复制 jtl 文件到 html 目录
    cp "$file" "$1/$dir/"
  fi
done
