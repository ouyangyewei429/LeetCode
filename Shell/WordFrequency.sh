#!/bin/bash
source /etc/profile;

#
# 思路：
# 
# 1. 先将所有空格替换为换行符
# 2. 按换行符进行分隔，统计每个单词的频数
# 3. 按频数进行降序排列
#
sed 's/ /\n/g' words.txt | 
    awk '
    BEGIN {
        RS="\n"
    } 
    {
        ++w[$0]
    }
    END {
        for(a in w) if(a!="") print a" "w[a]
    }' | sort -k 2 -nr
