	static void f(String s, int n, int width) {
		int rows = (int) java.lang.Math.ceil(((double)s.length()) / (n * width));
		
		for (int row = 0; row < rows; row++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < width; j++) {				
					int index = rows * i * width + row * width + j;					
					System.out.print(index < s.length() ? s.charAt(index) : " ");					
				}
				if (i < n-1) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}