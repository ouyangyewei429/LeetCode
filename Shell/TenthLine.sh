:<<BLOCK
$ cat file.txt 
Line 1
Line 2
Line 3
Line 4
Line 5
Line 6
Line 7
Line 8
Line 9
Line 10
BLOCK
# Read from the file file.txt and output the tenth line to stdout.

# Solution 1
line_number=`cat file.txt | wc -l`
if [ $line_number -ge 10 ]
then
    awk 'NR==10 { print }' < file.txt
fi

# Solution 2
awk 'NR==10 { print }' < file.txt

# Solution 3
cat file.txt | sed -n 10p

# Solution 4
i=1
cat file.txt | while read line 
do
    if [ $i -eq 10 ]
    then
        echo $line 
        break
    else
        i=$((i+1))
    fi
done

:<<BLOCK
# 其中以下的文件遍历方式不能得到正确的结果
for line in `cat file.txt`
do
    echo $line 
done

#--------------------

$ for line in `cat file.txt`
> do
>     echo $line 
> done
Line
1
Line
2
Line
3
Line
4
Line
5
Line
6
Line
7
Line
8
Line
9
Line
10
BLOCK

# Solution 5
# IFS: Internal Field Separator, 内部字段分隔符
IFS=$'\n'; arr=($(<file.txt)); echo ${arr[9]}
