	static void f(String i,int c)
	{
		StringTokenizer t=new StringTokenizer(i, "\n");
		List<Map<Integer,Integer>> f=new ArrayList<>(); //floors
		while(t.hasMoreTokens())
		{
			Map<Integer,Integer> w=new HashMap<>();//waiting passengers
			StringTokenizer r=new StringTokenizer(t.nextToken(),"|");
			while(r.hasMoreTokens())
			{
				String[] o = r.nextToken().split(":");
				w.put(Integer.valueOf(o[1]),Integer.valueOf(o[0]));
			}
			f.add(w);
		}
		Collections.reverse(f);
		int n=0; //next floor
		int d=1; //direction
		int s=0; // number of stops
		int k=c;
		Map<Integer,Integer> p=new HashMap<>();
		while(true)
		{
			int h=n>2?n-1:n;//for indexing f
			if(f.size()==n)//turning down
			{
				d=-1;
				n+=2*d;
				continue;
			}
			if(0>n)//turning up
			{
				d=1;
				n+=2*d;
				continue;
			}
			int q=0;
			for(Entry<Integer,Integer> e:p.entrySet()) //look through passengers in lift
			{
				if(e.getKey()==n)
				{
					Integer u = e.getValue();
					if(u==c-k)
					{
						System.out.print("lonely after "+s+" stops at "+n+" floor");
						return;
					}
					k+=u;//capacity increases
					q=1;
				}
			}
			if(q==1)p.remove(n);//passengers GTFO
			q=0;
			for(Entry<Integer,Integer> e:f.get(h).entrySet()) //look through passengers on current level
			{
				int r=e.getKey();
				if(r>n&&d==1||r<n&&d==-1)
				{
					int u=e.getValue();//new capacity
					if(u>k)
					{
						System.out.print("polite after "+s+" stops at "+n+" floor");
						return;
					}
					p.put(r,u);
					k-=u;//capacity decreases
					q=1;
				}
			}
			if(q==1)f.get(h).remove(n);//passengers get in
			int g=0;
			int x=f.size()*2;
			for(Entry<Integer,Integer> e:p.entrySet())// determining next stop
			{
				int r=e.getKey();
				if((r<n&&d==-1||r>n&&d==1)&&r-n<x)
				{
					g=r;
					x=g-n;
				}
			}
			if(g==0)n+=d;else n=g;
			s++;//increment number of stops
		}
	}

