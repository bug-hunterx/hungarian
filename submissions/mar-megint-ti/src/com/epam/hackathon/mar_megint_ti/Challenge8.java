package com.epam.hackathon.mar_megint_ti;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Challenge8 {

	public static void main(String[] args) {
		System.out.print("1: "); f("Results, Relentlessly", 3, 4);
		System.out.print("2: "); f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5);
		System.out.print("3: "); f("abcdefg", 3, 4);
		System.out.print("4: "); f("abcdefghi", 3, 4);
		System.out.print("5: "); f("abcdefghijkl", 3, 4);
		System.out.print("6: "); f("abcdefghijklm", 3, 4);
	}

	//---
	static void f(String input, int n, int width) {
		int len = input.length();
		int lines = (int) Math.ceil(len / (n * width * 1.0));

		for (int i = 0; i < lines * n * width - len; i++) {
			input += " ";
		}
		String[] cols = new String[n];
		for (int i = 0; i < n; i++) {
			cols[i] = input.substring(0, lines * width);
			input = input.substring(lines * width);
		}
		
		for (int j = 0; j < lines; j++) {
			for (int i = 0; i < n; i++) {
				if (i > 0) {
					print('|');
				}
				String col = cols[i];
				print(col.substring(0, width));
				cols[i] = col.substring(width);
			}
			print('\n');
		}
	}
	
	static void print(Object o) {
		System.out.print(o);
	}
	//---
}

