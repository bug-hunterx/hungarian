function f(a){
	if(a[0]=='\\')a=" "+a;
	if(a[a.length-1]=='/')a+=" ";
	var s=a.split("");
	var c=[];
	for(var i=0;i<s.length;i++){
		if(s[i]=='/'){
			if(s[i+1]=='|'){c.push((i+1)+',/')}
			if(s[i+1]==' '){
						c.push((i+1)+',_');c.push((i)+',_');
			}
		}if(s[s.length-i]=='\\'){
			if(s[i-1]=='|'){c.push((i+1)+',\\')}
			if(s[i-1]==' '){
						c.push((i+1)+',_');c.push((i)+',_')
			}
		}
	}
	a="";
	s.forEach(function(d){a+=d;})
	if(c.length!==0){
		for(var i=0;i<c.length;i++){
			var k=c[i].split(',');
			s[k[0]]=k[1];
		}
	} else {
		f(a);
	}
	
	console.log(a);
}






f('//|||||\\\\')