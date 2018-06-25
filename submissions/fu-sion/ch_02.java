public static void f(String l) {
	if (l.length() > 1) { 
	String[] rows = { "`1234567890-=~!@#$%^&*()_+", "qwertyuiop[]QWERTYUIOP{}", "asdfghjkl;\'\\ASDFGHJKL:\"", "zxcvbnm,./ZXCVBNM<>?" };
	String[] resultRows = { "", "", "", "" };
	l = d(d(l, rows, resultRows, false),rows, resultRows, true); 
	}
	System.out.println(l);
}

public static String d(String l, String[] rows, String[] resultRows, boolean unique) {
	int minIndex = 0;
	boolean flag = false;
	for (int i = 0; i < 4; i++) {
		String tmp = "";
		for (int k = 0; k < rows[i].length(); k++) {
			if (l.lastIndexOf(rows[i].charAt(k)) > -1) {
				if (!unique) {
					for (int z = 0; z < c(l,
							rows[i].charAt(k)); z++) {
						tmp += l.charAt(l.indexOf(rows[i].charAt(k)));
					}
				} else {
					tmp += l.charAt(l.indexOf(rows[i].charAt(k)));
				}
			}
		}
		resultRows[i] = tmp;
		if ((tmp.length() < resultRows[minIndex].length() || resultRows[minIndex]
				.isEmpty()) && !tmp.isEmpty())
			minIndex = i;
	}

	for (String item : resultRows) {
		if (item.length() == resultRows[minIndex].length()
				&& item != resultRows[minIndex]) {
			for (int z = 0; z < l.length(); z++) {
				if (c(resultRows[minIndex], l.charAt(z)) > 1
						|| c(item, l.charAt(z)) > 1) {
					flag = true;
				}
			}
			if (flag) {
				return d(l, rows, resultRows, true);

			}
		}
	}
	return resultRows[minIndex];

}
public static int c(String s,char x){int a=0,i=0;while((i=s.indexOf(x, i))!=-1){a++;i++;};return a;}