	static char[][]c;
	static boolean H=true,W=true;
	static void f(String scene, int w, int h){
		int i,j,k,r,l,u,d,a=0,b=0,a1,b1,hoff,woff,s,t;
		char v='>';
		String[]p=scene.split("\n");
		c=new char[p.length][0];
		for(i=0;i<p.length;i++){
			c[i]=(p[i]+"\n").toCharArray();
		}
		for(k=0;k<1000;k++){
			a1=a;b1=b;
			if(a+w<0||b+h<0||a>c.length||b>c[0].length){System.out.println(9);return;}
			hoff=woff=u=d=r=l=0;;
			for(i=b;i<b+h;i++){
				for(j=a;j<a+w;j++){
					if(c(i,j)=='H') hoff++;
					if(c(i,j)=='h') hoff--;
					if(c(i,j)=='W') woff++;
					if(c(i,j)=='w') woff--;
					if(c(i,j)=='^') u++;
					if(c(i,j)=='<') l++;
					if(c(i,j)=='v') d++;
					if(c(i,j)=='>') r++;
				}
			}
			if(hoff!=0)H=hoff>0;
			if(woff!=0)W=woff>0;
			if(!H){l=0;r=0;}
			if(!W){d=0;u=0;}
			if(l==r&&d==u){System.out.println(9);return;}
			s=r-l;t=d-u;
			int z=Math.abs(s),o=Math.abs(t);
			if(z>o){
				if(s<0){
					a--;
					v='<';
				}else{
					a++;
					v='>';
				}
			}else if(o>z){
				if(t<0){
					b--;
					v='^';
				}else{
					b++;
					v='v';
				}
			}else if(v=='<'||v=='>'){
				if(s<0){
					a--;
					v='<';
				}else{
					a++;
					v='>';
				}
			}else{
				if(t<0){
					b--;
					v='^';
				}else{
					b++;
					v='v';
				}
			}
			if(a1==a&&b1==b){System.out.println(9);return;}
		}
		System.out.println(8);
	}

	static char c(int i,int j){
		try{
			return c[i][j];
		}catch(Exception e){
			return(' ');
		}
	}