l=3;m=0;s=0;c=0
a=$(echo "$@"|grep -o .|tr -d '\n')
for v in $a;do
	if [ $l -le 0 ];then break;fi
	case "$v" in			
        "piranha"|"koopa"|"goomba") if [ $s -gt 0 ];then : ;elif [ $m -eq 1 ];then m=0; else ((l--));fi;;
		"Mushroom")m=1;;
        "Star")s=3;;
        "Princess"|"Bowser" ) echo WIN;exit;;
        "1Up") ((l++));;
		*) ((c+=$v)); while [ $(( c-100 )) -gt 0 ];do((c-=100));((l++));done;;esac
    if [ $s -gt 0 ]; then ((s--));fi	
done
if [ $l -gt 0 ];then echo "???"
else echo GAME OVER;fi
