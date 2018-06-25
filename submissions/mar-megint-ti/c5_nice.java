	static void f(String s) {
		String t=s;
		do {
			s=t;
			t=t.replace("/||\\","//\\\\");
			t=t.replace("/ ","__");
			t=t.replaceAll("/$","__");
			t=t.replaceAll("/\\|([^\\\\])","//$1");
			t=t.replaceAll("/\\|$","//");
			t=t.replace(" \\","__");
			t=t.replaceAll("^\\\\","__");
			t=t.replaceAll("([^/])\\|\\\\","$1\\\\\\\\");
			t=t.replaceAll("^\\|\\\\","\\\\\\\\");
		} while(s!=t);
		
		System.out.println(t);
	}
