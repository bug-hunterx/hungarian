/**
     *  -empty
     * <>^v-turret
     * @-target
     * |- -beam
     * /\-mirror
     * 0-9 portal
     */
	 
function f(s){
	s=s.split('\n');
	for(var i=0;i<s.length;i++){
		s[i]=s[i].split('');
	}
	s=process(s,0,0);
}

function process(s,x,y){
	if(s[x][y]==='>'||s[x][y]==='-'){
		kiir('!'+s[x+1][y]);
		if(s[x+1][y]===' '){s[x+1][y]='-';kiir(s);}
	}
	if(s[x][y]==='<'||s[x][y]==='-'){
		if(s[x-1][y]===' ')s[x-1][y]='-';
	}
	return s;
}

function kiir(s){
	console.log(s);
	for(var i=0;i<s.length;i++){
		var a="";
		for(var p=0;p<s[i].length;p++){
			a+=s[i][p];
		}
		console.log(a);
	}
}

f(">    > \n> 9#9 @")