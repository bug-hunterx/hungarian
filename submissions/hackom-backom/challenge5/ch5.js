function f(d){
	output='';
  
  a=[];
  for(var i=0;i<d.length;i++){
  	if(d[i-1]&&d[i-1]=='/'&&d[i]==' '){
    	a.push(i);
    } else if(d[i+1]&&d[i+1]=='\\'&&d[i]==' '){
    	a.push(i);
    }
  }
  a.reverse();
  
	for(var i=0;i<d.length;i++){
  	x=d[i];
    
    if(x!=' '&&x!='_'){
    	//in the above two cases, we do nothing with d[i]
    	if(i==0 && x=='\\'){
      	//trivial left side
        x='_';
      } else if(i==d.length-1 && x=='/') {
      	//trivial right side
        x='_';
      } else {
        
        //if /\ then _\
        if(d[i+1] && x=='/' && (d[i+1]=='\\'||d[i+1]==' ')){
        	//trivial underscore
          x='_';
        } else
        
        //if the follownig char is '_' or '|' this char does not move
        /*if(d[i+1] && d[i]=='/' && ){
        	//trivial underscore
          d[i]='_';
        } else*/
        
        //if the previous char is '_' or '|', this char does not move
        if(d[i-1] && x=='\\' && d[i-1]==' ' && -1==a.indexOf(i-1)){
        	//trivial underscore
          x='_';
        } else
        
        if(x=='|') {
        
        	if(d[i-1] && d[i-1]=='/' && d[i+1] && d[i+1]=='\\'){
            //trivial stable /|\
            //no manipulation
            
          } else if(d[i-1] && d[i+1] && ((d[i-1]=='/'&& d[i+1]!='|') || (d[i+1]=='\\' && d[i-1]!='|'))){
          	//before-after indexes exist, but one is not tilding toward this item
            //ergo, it cant be the above stable status
            //trivial underscore
            x='_';
          } else {
          	//???
          }
          
        } else {
        	//??
        }
        
      }
    } else {
    	//spaces and underscores
      //no manipulation
    }
    
    if(-1==a.indexOf(i)){
    	output+=x;
    } else {
    	output+='_';
    }
  }
 	
  console.log(output);
}