static void f(String b, int c) {
		c--;
		List<String> l = new LinkedList<String>(Arrays.asList(b.split("\n")));Collections.reverse(l);
		int f=0,s=0,p=0,d=1,t[],n=l.size();
		if(n>=5) {l.add(4, "");n++;}
		List<List<int[]>> o = l.stream().map(a -> a.equals("")?"0:0":a).collect(Collectors.toList()).stream()
		.map(a -> Arrays.asList(a.split("\\|"))
				.stream()
				.map(x -> {
					String[] v = x.split(":");
					return new int[]{
							Integer.parseInt(v[0]),
							Integer.parseInt(v[1])
							};
					}
					).collect(Collectors.toList())).collect(Collectors.toList());
		t=new int[n];
		try {
			while(true){
				p-=t[f];
				t[f]=0;
				List<int[]> q = o.get(f);
				for(int i[] : q) {
					if((d>0&&i[1]>f)||(d<0&&i[1]<f)) {
						t[i[1]]+=i[0];
						p+=i[0];
						i[0]=0;
						if(p>c) {
							throw new Exception();
						}
					}
				}
				if(p==0) {
					d*=-1;
					for(int i[] : q) {
						if((d>0&&i[1]>f)||(d<0&&i[1]<f)) {
							t[i[1]]+=i[0];
							p+=i[0];
							i[0]=0;
							if(p>c) {
								throw new Exception();
							}
						}
					}
					if(p==0) {
						throw new Exception();
					}
				}
				do{
					f+=d;
					if((n-1)==f) d=-1;
					if(0==f) d=1;
				}while(t[f]==0);
				s++;
			}
		}
		catch (Exception y) {
			System.out.println((p==0?"lonely":"polite")+" after "+s+" stops at "+f+" floor");
		}
	}