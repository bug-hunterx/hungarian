function f(s,w,h){
	s=s.split('\n');
	origin=[0,0];
	direction='r';
	hh=[];
    do{
	area='';
	nextH=nextW=y=x=c=b=u=r=d=l=0;
	hh.push(origin.join(''));
	toconsole='';
	for(q=0;q<h;q++){
		if(origin[1]+q<s.length && origin[1]+q>=0){
			if(origin[0]>0){
				area+=s[origin[1]+q].substr(origin[0],Math.min(s[0].length-origin[0],w));
			}else{
				area+=s[origin[1]+q].substr(0,w+origin[0]);
			}
		}
	}
	for(q=0;q<s.length;q++){
		if(q<origin[1] || q>origin[1]+h-1){
			toconsole+=s[q]+'\n';
		}else{
			if(origin[0]>0){
				toconsole+=s[q].substr(0,origin[0])+'%c'+s[q].substr(origin[0],Math.min(s[0].length-origin[0],w))+'%c'+s[q].substr(origin[0]+Math.min(s[0].length-origin[0],w))+'\n';
			}else{
				toconsole+='%c'+s[q].substr(0,w+origin[0])+'%c'+s[q].substr(w+origin[0])+'\n';
			}
		}
	}
	for(i=0;i<area.length;i++){
		if(area[i]=='^') u++;
		if(area[i]=='>') r++;
		if(area[i]=='v') d++;
		if(area[i]=='<') l++;
		if(area[i]=='h') y++;
		if(area[i]=='H') x++;
		if(area[i]=='w') c++;
		if(area[i]=='W') b++;
	}
	if(x>=y){
	  nextH=r-l;
	}
	if(b>=c){
	  nextW=d-u;
	}
	if(Math.abs(nextH)==Math.abs(nextW) && nextH!=0){
		if(direction=='r'||direction=='l'){
		  nextH=nextH/Math.abs(nextH);nextW=0;
		  direction=nextH>0?'r':'l';
		}
		if(direction=='d'||direction=='u'){
		  nextW=nextW/Math.abs(nextW);nextH=0;
		  direction=nextW>0?'d':'unshift';
		}
	}
	if(Math.abs(nextH)>Math.abs(nextW)){
		origin[0]+=nextH>0?1:nextH<0?-1:0;
		direction=nextH>0?'r':'l';
	}else if(Math.abs(nextH)<Math.abs(nextW)){
		origin[1]+=nextW>0?1:nextW<0?-1:0;
		direction=nextW>0?'d':'u';
	}
	if(nextH== 0 && nextW==0){
		direction='o';
	}
	}while(hh.indexOf(origin.join(''))<0 && direction!='o');
	if(direction=='o'){
		console.log(9);
	}else if(hh.indexOf(origin.join(''))>=0){
		console.log(8);
	}
}