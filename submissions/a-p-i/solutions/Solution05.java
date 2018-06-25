	static void f(String s) {
		String pattern1 = "/ ";
		String result1 = "__";
		String pattern2 = " \\\\";
		String result2 = "__";
		String pattern3 = "/\\| ";
		String result3 = "// ";
		String pattern4 = " \\|\\\\";
		String result4 = " \\\\\\\\";
		String pattern5 = "/\\|\\|";
		String result5 = "//\\|";
		String pattern6 = "/\\|$";
		String result6 = "/__";
		String pattern7 = "\\|\\|\\\\";
		String result7 = "\\|\\\\\\\\";
		String pattern8 = "\\|\\\\\\\\";
		String result8 = "\\\\\\\\\\\\";
		
		String previous = null;
		while(s != previous) {
			previous = s;
			s = s.replaceAll(pattern1, result1);
			s = s.replaceAll(pattern3, result3);
			s = s.replaceAll(pattern5, result5);
			s = s.replaceAll(pattern2, result2);
			s = s.replaceAll(pattern4, result4);
			s = s.replaceAll(pattern8, result8);
			s = s.replaceAll(pattern7, result7);
			s = s.replaceAll(pattern6, result6);
		}
		
		
		System.out.println(s);
	}