static void f(String s, int n, int w) {
		List<String> t =new ArrayList<String>();
		int i=0,j=0,k,l=s.length();
		while (i<l) {
		    t.add(s.substring(i,Math.min(i+w,l)));
		    i+=w;
		}
		k=(t.size()+n-1)/n*n;
		String o="";
		for(i=0;i<k/n;i++) {
			for(j=i;j<k;j+=k/n) {
				s=(t.size()<=(j))?"":t.get(j);
				if(s.length()<w)s+=new String(new char[w-s.length()]).replace('\0', ' ');
				o+=s+"|";//(s+(j>=k-n?"":"|"));
			}
			o=o.substring(0,o.length()-1)+"\n";
		}
		System.out.println(o);
	}