static void f(String t){
	int[][] winmap = new int[][]{{1,2,3},{4,5,6},
		{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},
		{3,5,7}};
	char[] map = new char[10];
	Arrays.fill(map, '-');
	char[] a = t.toCharArray();
	for (int x = 0; x < a.length; x++){
		int pos = Integer.parseInt(a[x]+"");
		if (x%2==0){
			map[pos]='O';
		}else{
			map[pos]='X';
		}
		for (int xx=0;xx<winmap.length;xx++){
			char w1=map[winmap[xx][0]];
			char w2=map[winmap[xx][1]];
			char w3=map[winmap[xx][2]];
			if (w1==w2 && w2==w3 && w1 !='-'){
				System.out.println(w1);
				return;
			}
		}
	}
	System.out.println("?");
}