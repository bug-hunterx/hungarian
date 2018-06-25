	static char[][]c;
	static int w,h,i,v,k=0,j;
	static int r[][];
	static void f(int n,String s){
		String[]t=s.split("\n");
		String f="";
		c=new char[t.length][0];
		for(i=0;i<t.length;i++)c[i]=(t[i]+"\n").toCharArray();
		w=c[0].length;h=c.length;
		r=new int[3][w*2];
		for(i=0;i<w;i++){
			v=v(i);
			if(v!=0)r[v%2][0]++;
		}
		j = r[0][0];
		int l = j+r[1][0];
		if(l==0)f=":(";
		if(j>n)f=n-j+"";
		k=0;
		if(l<n&&f.equals(""))f=n-l+"";
		for(i=0;i<n-j;i++){
			c[r[2][k]][r[2][k+1]]='$';k+=2;
		}
		if(f.equals(""))for(i=0;i<h;i++)f=f+new String(c[i]);
		System.out.println(f);
	}
	static int v(int x){
		if(c[h-1][x]!='X')return 0;
		int i=0;
		char d = c[h-2][x];
		if(d=='|'){}
		else if(d=='\\')i++;
		else if(d=='/')i--;
		else return 0;
		for (int j=3;j<=h;j++){
			d = c[h-j][x];
			if(d=='|'){}
			else if(d=='\\'){
				i++;
				if(i<-1||i>1) return 0;
			}
			else if(d=='/'){
				i--;
				if(i<-1||i>1) return 0;
			}
			else if(i==0&&d=='$') return 2;
			else if(i==0&&d=='.'){
				r[2][k]=h-j;r[2][k+1]=x;k+=2;
				return 1;
			}
			else return 0;
		}
		return 0;
	}
