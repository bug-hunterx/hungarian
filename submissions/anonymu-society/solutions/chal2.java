static void f(String s) {
	String firstRow = "1234567890-=!@#$%&*()_+";
	String secondRow = "qwertyuiop[]QWERTYUIOP{}";
	String thirdRow = "asdfghjkl;ASDFGHJKL:|";
	String forthRow = "zxcvbnm,./ZXCVBNM<>?";

	int[] counter = { 0, 0, 0, 0 };

	Set<Character> set1 = new HashSet<>();
	Set<Character> set2 = new HashSet<>();
	Set<Character> set3 = new HashSet<>();
	Set<Character> set4 = new HashSet<>();

	Set[] array = { set1, set2, set3, set4 };

	for (Character c : s.toCharArray()) {

		if (firstRow.contains(c + "")) {
			set1.add(c);

		}

		if (secondRow.contains(c + "")) {
			set2.add(c);

		}

		if (thirdRow.contains(c + "")) {
			set3.add(c);

		}

		if (forthRow.contains(c + "")) {
			set4.add(c);

		}

	}
	counter[0] = set1.size();
	counter[1] = set2.size();
	counter[2] = set3.size();
	counter[3] = set4.size();

	int min = 0;
	for (int i = 1; i < 4; i++) {
		if (counter[min] == 0)
			min = i;
		else if (counter[i] < counter[min] && counter[i] != 0)
			min = i;
	}

	StringBuilder sb = new StringBuilder();
	for (Character c : (Set<Character>) array[min]) {
		sb.append(c);
	}

	String resultBeforeOrder = sb.toString();
	int result[] = new int[resultBeforeOrder.length()];
	String acutalRow = "";
	for (int i = 0; i < sb.length(); i++) {

		Character c = resultBeforeOrder.charAt(i);
		int indexOfChar = firstRow.indexOf(c);

		if (firstRow.contains(c.toString())) {
			indexOfChar = firstRow.indexOf(c);
			acutalRow = firstRow;
		}

		if (secondRow.contains(c.toString())) {
			indexOfChar = secondRow.indexOf(c);
			acutalRow = secondRow;
		}

		if (thirdRow.contains(c.toString())) {
			indexOfChar = thirdRow.indexOf(c);
			acutalRow = thirdRow;
		}

		if (forthRow.contains(c.toString())) {
			indexOfChar = forthRow.indexOf(c);
			acutalRow = forthRow;
		}

		result[i] = indexOfChar;

	}

	for (int i = result.length - 1; i > 0; i--)
		for (int j = 0; j < i; j++)
			if (result[j] > result[j + 1]) {
				int tmp = result[j];
				result[j] = result[j + 1];
				result[j + 1] = tmp;
			}

	StringBuilder r = new StringBuilder();
	for (int i = 0; i < result.length; i++) {
		r.append(acutalRow.charAt(result[i]));
	}
	System.out.println(r.toString());
}