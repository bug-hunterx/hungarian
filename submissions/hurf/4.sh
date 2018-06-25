v="... ... ..."
a=($1)
for((i=0;i<${#a};i++));do
z=$((${a:i:1}-1+(${a:i:1}-1)/3))
[[ `expr $i % 2` = 0 ]] && d='O' || d='X'
v=${v:0:z}$d${v:z+1:${#v}}
regex="(\\${d})(\1|..(\1|.\1.|..\1..)..)\1"
if [[ "$v" =~ $regex ]]
then
echo $d
exit
fi
done
echo ?