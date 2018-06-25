package com.epam.hackathon.mar_megint_ti;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Challenge6 {

	public static void main(String[] args) {
		System.out.print("1: "); f(100); System.out.print('\n');
		System.out.print("2: "); f(15000); System.out.print('\n');
		System.out.print("3: "); f(1199); System.out.print('\n');
		System.out.print("4: "); f(1999); System.out.print('\n');
		System.out.print("5: "); f(6185); System.out.print('\n');
		System.out.print("6: "); f(6288); System.out.print('\n');
		System.out.print("7: "); f(2800); System.out.print('\n');
		System.out.print("8: "); f(2500); System.out.print('\n');
	}

	//---
	static void f(int cost) {
		int total;
		if (cost < 2000) {
			total = roundUp(cost, 100);
		} else if (cost < 5000) {
			total = roundUp(cost, 500);
		} else {
			total = round((int)(cost * 1.1), 500);
		}
		
		String s;
		int tip = total - cost;
		if (tip == 0 || tip > 1500) {
			s = "PAID BY CARD";
		} else if (tip % 100 != 0) {
			s = "KEEP THE CHANGE YOU FILTY ANIMAL";
		} else {
			s = "HERE IS " + String.valueOf(total);
		}
		System.out.print(s);
	}

	private static int roundUp(int cost, int granularity) {
		int rem = cost % granularity;
		return rem == 0 ? cost : cost - rem + granularity;
	}
	
	private static int round(int cost, int granularity) {
		int rem = cost % granularity;
		return rem == 0 ? cost : rem < granularity / 2 ? cost - rem : cost - rem + granularity;
	}
	//---
}

