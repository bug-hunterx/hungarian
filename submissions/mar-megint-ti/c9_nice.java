	static void f(String s) {
		String[]t=s.split("\\s+");
		int l=3,c=0,i=0;
		boolean b=false;
		for(int j=0;j<t.length;j++){
			if(t[j].matches("^(p|.oo).*")&&i<1){
				if(b)
					b=false;
				else 
					l--; 
				if(l<1){System.out.print("GAME OVER");return;}
			}
			if(t[j].matches("\\d+"))c+=Integer.parseInt(t[j]);
			if(c>99){c-=100;l++;}
			if(t[j].matches("^(P|B).*")){System.out.print("WIN");return;}
			if(t[j].matches("1Up"))l++;
			if(t[j].matches("^M.*"))b=true;
			i--;
			if(t[j].matches("Star"))i=2;
		}
		System.out.print("???");
	}