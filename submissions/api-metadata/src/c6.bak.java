static void f(int i) {
		int t;
		if(i<2000) t=(int)(((i+99)/100)*100-i);
		else {
			if(i>=5000) {
				t=(int)((int)(((i*1.1)+250)/500)*500-i);
			}
			else {
				t=(int)(((i+499)/500)*500-i);
			}
		}
		
		String r;
		if(t==0||t>1500) {
			r="PAID BY CARD";
		}
		else if (t!=t/100*100) {
			r="KEEP THE CHANGE YOU FILTY ANIMAL";
		}
		else {
			r="HERE IS "+(t+i);
		}
		
		System.out.println(r);
	}