package com.epam.hackathon.mar_megint_ti;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Challenge2 {

	public static void main(String[] args) {
		System.out.print(" 1: "); f("FJAFJKLDSKF7JKFDJ");
		System.out.print(" 2: "); f("ASDFDSASDFDSAzxcPOIUY");
		System.out.print(" 3: "); f("qwERfgHJ123456789");
		System.out.print(" 4: "); f("FGhjKL:\"';lkqwerzxcc");
		System.out.print(" 5: "); f("ASDFASDFqwer432!");
		System.out.print(" 6: "); f("EUIyouiepIEjhadSDJ(*Y9y9");
		System.out.print(" 7: "); f("1233AERSdfqw");
		System.out.print(" 8: "); f("ASDF11!*&+1");
		System.out.print(" 9: "); f("}*3%&2098@$2k234#@$M");
		System.out.print("10: "); f("wqfdSREA3321");
		System.out.print("11: "); f(":X:D:):DDDDDDDxDDDD:(;);];]");
		System.out.print("12: "); f("");
	}

	//---
	@SuppressWarnings("rawtypes")
	static void f(String s) {
		String[] R = { "`1234567890-=~!@#$%^&*()_+", "qwertyuiop[]\\QWERTYUIOP{}|", "asdfghjkl;'ASDFGHJKL:\"",
				"zxcvbnm,./ZXCVBNM<>?" };
		Set[] w = new Set[4];
		int[] n = new int[4];
		for (int i = 0; i < 4; i++) {
			Set r = new TreeSet();
			n[i] = p(r, R[i], s);
			w[i] = r;
		}
		int j = 99, t = 4, u = 99;
		for (int i = 0; i < 4; i++) {
			int z = n[i];
			if (z != 0 && z <= j) {
				int q = w[i].size();
				if (z == j) {
					if (q < u) {
						j = z;
						t = i;
						u = q;
					}
				} else {
					j = z;
					t = i;
					u = q;
				}
			}
		}
		String r = R[t];
		for (Object o : w[t]) {
			System.out.print(r.charAt((int) o));
		}
	}

	static int p(Set s, String r, String t) {
		int c = 0;
		for (int i = 0; i < t.length(); i++) {
			int x = r.indexOf(t.charAt(i));
			if (x != -1) {
				c++;
				s.add(x);
			}
		}
		return c;
	}
	//---
}

