sub f {
	@m=split//,$game;
	@O=(),@X=(),@R=("123","456","789","147","258","369","159","357"),$W='?';
	while($i=shift(@m)){($#O<=$#X)?push@O,$i:push@X,$i;}
	$O=join('',@O),$X=join('',@X);
	foreach(@R){
		@rO=$O=~/([$_])/g;
		@rX=$X=~/([$_])/g;
		$gX=@rX,$gO=@rO;
		$pO=index($O,(($O=~/[($_)]/g)[-1]));
		$pX=index($X,(($X=~/[($_)]/g)[-1]));
		if($gO==3&&$gX==3){$W='X';if($pO<=$pX){$W='O';}}
		elsif($gO==3&&$gX<3){$W='O';}
		elsif($gX==3&&$gO<3){$W='X';}
	}
	print$W;
}