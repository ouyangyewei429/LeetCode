# Read from the file file.txt and print its transposed content to stdout.

#! /bin/bash

awk -F' ' '
{
  for (i=1; i<=NF; i++) {
    if (NR == 1)
      arr[i] = $i
    else
      arr[i] = arr[i]" "$i
  }
}
END {
  for (i=1; arr[i]!=""; i++)
    print arr[i]
}' file.txt


:<<BLOCK
col_num=`head -1 file.txt | awk -F' ' '{print NF}'`
for ((col=1; col<=$col_num; col++))
do
  row_content=`cut -d ' ' -f $col file.txt`
  echo $row_content | sed 's/\n/ /g'
done
BLOCK
