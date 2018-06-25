package hack;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class OrderByFreq {

	public static final void main(String[] a) {
		f("Hello, World!");
		f("Results, Relentlessly");
	}

	static void f(String s) {

		byte[] bytes = null;

		try {
			bytes = s.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		Arrays.sort(bytes);

		Map<Byte, Integer> counts = new LinkedHashMap<Byte, Integer>();
		for (byte b : bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				count = 0;
			}
			counts.put(b, ++count);
		}

		Map<Byte, Integer> result = new LinkedHashMap<>();
		Stream<Map.Entry<Byte, Integer>> st = counts.entrySet().stream();
		st.sorted(Comparator.comparing(e -> e.getValue())).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));

		String str = "";
		for (Map.Entry<Byte, Integer> entry : result.entrySet()) {
			for (int i = 0; i < entry.getValue(); i++) {
				str += (char) (entry.getKey().byteValue());
			}
		}
		System.out.println(str);

	}

}
