function f(n, field) {
	var rows = field.split('\n').reverse();
	var c = 0;
	var fire = [];
	for( var x = 0; x < rows[0].length; x++ ) {
		var count = {'\\':0,'/':0,'|':0}
		if( rows[0][x] != 'X'){
			continue;
		}
		for( var y = 1; y < rows.length; y++){
			if(count.hasOwnProperty(rows[y][x])){
				count[rows[y][x]]++;
			} else {
				if( rows[y][x] == 'X' ) break;
				if((count['/']==count['\\']&&count['/']) || (count['/']==count['\\']&&!count['/']&&count['|'])){
					if(rows[y][x]=='.'){
						fire.push([y,x]);
					}else if(rows[y][x]=='$'){
						c++;
					}
					break;
				}
			}
		}
		
	}
	
	var fl = fire.length;
	if( fl+c == 0) console.log(':(');
	else if( n > fl + c ) console.log(n-c-fl);
	else if( n < c ) console.log(n-c);
	else {
		fire.forEach((f)=>{
			if( c == n ) return;
			var e = rows[f[0]].split('');
			e[f[1]]='$';
			rows[f[0]] = e.join('');
			c++;
		});
		console.log(rows.reverse().join('\n'));
	}
}

/*var field = `    .  
  . \\  
$ | | $
| X / |
X   X X`;

/*field = `*    *  .   
   ~ .  \\   
  .  |  |  $
  |  X  /  |
  X     X  X`;
  
/*field = `          .
    #     \\
  . /   . \\
  | \\ $ | /
. / / ! X /
| X X X   X`;*/
  
/*var field = `    #  
  $ \\  
$ | | $
| | / !
  X X X`;

f( 3, field );*/