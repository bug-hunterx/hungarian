	static char[][] a;
	static int[] t;
	static String[] z;
	static int v;
	static int l;
	static String r;
	static String k="";
	static boolean q=false;
	static String mirrors="";
	
	static void f(String scene) {
		
		r = scene.replace("\n","");
		z = scene.split("\n");
		l = z.length;
		v = z[0].length();
		a = new char[l][];
		for (int i = 0; i < a.length; i++) {
			a[i] = z[i].toCharArray();
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				char c = a[i][j];
				if (c == '<')
					go(-1, 0, j, i);
				if (c == '>')
					go(1, 0, j, i);
				if (c == '^')
					go(0, -1, j, i);
				if (c == 'v')
					go(0, 1, j, i);
			}
		}
		String s="";
		for (int i = 0; i < l; i++) {
			s += String.valueOf(a[i]); 
		}
		System.out.println(q ? ":/" : s.indexOf("@") == -1 ? ":D": ":(");
	}

	static void go(int xd, int yd, int x, int y) {
		int prevx = x;
		int prevy = y;
		x += xd;
		y += yd;
		if (x>=v||x<0||y>=l||y<0)return;
		char g = a[y][x];
		String s = "|";
		if(g!='\\'&&g!='/'){
			s = y+","+x;
		}else{
			if (g=='/'&&prevx<x){
				if(mirrors.indexOf(x+","+y+","+"DOWNLEFT")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"DOWNLEFT";
			}
			else if (g=='/'&&prevx>x){
				if(mirrors.indexOf(x+","+y+","+"TOPRIGHT")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"TOPRIGHT";
			}
			else if (g=='/'&&prevy>y){
				if(mirrors.indexOf(x+","+y+","+"LEFTDOWN")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"LEFTDOWN";
			}
			else if (g=='/'&&prevy<y){
				if(mirrors.indexOf(x+","+y+","+"RIGHTTOP")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"RIGHTTOP";
			}
			if (g=='\\'&&prevx<x){
				if(mirrors.indexOf(x+","+y+","+"TOPLEFT")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"TOPLEFT";
			}
			else if (g=='\\'&&prevx>x){
				if(mirrors.indexOf(x+","+y+","+"DOWNRIGHT")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"DOWNRIGHT";
			}
			else if (g=='\\'&&prevy>y){
				if(mirrors.indexOf(x+","+y+","+"RIGHTDOWN")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"RIGHTDOWN";
			}
			else if (g=='\\'&&prevy<y){
				if(mirrors.indexOf(x+","+y+","+"LEFTTOP")!=-1){
					q=true;
					return;
				}
				mirrors+=x+","+y+","+"LEFTTOP";
			}
		}
		s+="|";
		if (s.length()>3&&k.indexOf(s)!=-1){
			q=true;
			return;
		}
		k+=s;
		if (g == '@'||g=='#'||g=='$') {
			a[y][x] = '$';
			return;
		}
		if (g=='>'||g=='<'||g=='^'||g=='v') {
			return;
		}
		if (g >= '0' && g <= '9') {
			int p = r.indexOf(g);
			if (p == y * v + x) {
				p = r.lastIndexOf(g);
			}
			x = p - p / v * v;
			y = p / v;
		}
		if (g == '/') {
			if (yd==0){
				yd=xd==1?-1:1;
				xd=0;
			}
			else{
				xd=yd==1?-1:1;
				yd=0;
			}
		}
		if (g=='\\') {
			if (yd==0){
				yd=xd==1?1:-1;
				xd=0;
			}
			else{
				xd=yd==1?1:-1;
				yd=0;
			}
		}
		go(xd, yd, x, y);
	}