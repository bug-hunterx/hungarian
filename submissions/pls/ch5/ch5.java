static void f(String s){
		s=" "+s+" ";
		char[] ch = s.toCharArray();
		for (int i = 0; i <s.length()-1; ++i)
		{
			if(ch[i]=='/'){
				if(ch[i+1]==' '){ ch[i]='_';ch[i+1]='_';}
				if(ch[i+1]=='|' && ch[i+2]!='\\'){
					if(ch[i+2]==' '){
						ch[i+1]='_';
						ch[i+2]='_';
					} else {
						ch[i+1]='/';
					}
				}
			} else
			if(ch[i]==' '){
				if ( ch[i+1]=='\\'){
					ch[i]='_';
					ch[i+1]='_';
				}
				if (ch[i+1]=='|'&& isPerOrStand(ch,i+2)){
					ch[i]='_';
					ch[i+1]='_';
				}
			}
		}


		System.out.print(String.valueOf(ch).trim());
	}
	static boolean isPerOrStand(char[] ch ,int ind){
		if (ch[ind]=='|' || ch[ind]=='\\')  {
			if (ch[ind]!='\\') {return true;}
			else {
				if (isPerOrStand(ch,ind+1)){
					ch[ind]='\\';
					return  true;
				} else {
					return  false;
				}
			}
		} else
			return false;

	}