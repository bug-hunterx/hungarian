package com.epam.hackathon.mar_megint_ti;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.*;
import java.text.*;

public class Challenge7 {

	public static void main(String[] args) {
		System.out.print("1: "); f("1:0|1:1\n3:2|5:0\n1:1|2:2", 6);
		System.out.print("2: "); f("2:1|3:2\n1:0|1:1\n3:2|5:0\n1:1|2:2", 10);
		System.out.print("3: "); f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5", 9);
		System.out.print("4: "); f("1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2", 10);
		System.out.print("x0: "); f("4:2|1:5|2:0\n1:1|2:0\n2:0\n1:0\n1:5|3:6|1:0\n1:1|1:3|2:5", 11);
	}

	//---
	static void f(String building, int capacity) {
		List<String> floors = Arrays.asList(building.split("\n"));
		Collections.reverse(floors);

		List<List<String[]>> floorsExpanded = new ArrayList<>();
		for (String floor : floors) {
			List<String[]> floorExpanded = new ArrayList<>();
			floorsExpanded.add(floorExpanded);
			String floorCorrected = floor.trim();
			if (!floorCorrected.isEmpty()) {
				String[] people = floorCorrected.split("\\|");
				for (String persons : people) {
					String[] per = persons.split(":");
					per[1] = getFloor(per[1]);
					floorExpanded.add(per);
				}
			}
		}
		
		capacity--;
		List<int[]> elevator = new ArrayList<>();
		int floorIdx = 0;
		boolean directionUp = true;
		int elevatorCount = 0;
		int stops = 0;
		while (true) {
			elevatorCount = getOut(elevator, floorIdx, elevatorCount);
			directionUp = updateDirection(floorsExpanded, floorIdx, directionUp, elevatorCount);
			elevatorCount = getIn(elevator, floorsExpanded, floorIdx, directionUp, elevatorCount);
			if (elevatorCount == 0) {
				msg(floorIdx, stops, "lonely ");
				return;
			}
			if (elevatorCount > capacity) {
				msg(floorIdx, stops, "polite ");
				return;
			}
			floorIdx = updateFloor(elevator, directionUp, floorsExpanded.size());
			stops++;
		}
	}

	static void msg(int floorIdx, int stops, String a) {
		System.out.println(a + "after " + stops + " stops at " + (floorIdx >= 4 ? floorIdx + 1 : floorIdx) + " floor");
	}
	
	static int updateFloor(List<int[]> elevator, boolean directionUp, int floorNum) {
		int floorIdx = directionUp ? floorNum : -1;
		for (int[] person : elevator) {
			floorIdx = directionUp ? Math.min(floorIdx, person[1]) : Math.max(floorIdx, person[1]);
		}
		return floorIdx;
	}

	static boolean updateDirection(List<List<String[]>> floorsExpanded, int floorIdx, boolean directionUp,
			int elevatorCount) {
		if (floorIdx == 0) {
			return true;
		} else if (floorIdx == floorsExpanded.size() - 1) {
			return false;
		} else if (elevatorCount == 0) {
			for (String[] people : floorsExpanded.get(floorIdx)) {
				int targetFloorIdx = Integer.parseInt(people[1]);
				if (directionUp && targetFloorIdx > floorIdx || !directionUp && targetFloorIdx < floorIdx) {
					return directionUp;
				}
			}
			return !directionUp;
		}
		return directionUp;
	}

	static int getIn(List<int[]> elevator, List<List<String[]>> floorsExpanded, int floorIdx, boolean directionUp,
			int elevatorCount) {
		Iterator<String[]> it = floorsExpanded.get(floorIdx).iterator();
		while (it.hasNext()) {
			String[] people = it.next();
			int personNum = Integer.parseInt(people[0]);
			int targetFloorIdx = Integer.parseInt(people[1]);
			if (directionUp && targetFloorIdx > floorIdx || !directionUp && targetFloorIdx < floorIdx) {
				elevatorCount += personNum;
				elevator.add(new int[]{personNum,targetFloorIdx});
				it.remove();
			}
		}
		return elevatorCount;
	}

	static int getOut(List<int[]> elevator, int floorIdx, int elevatorCount) {
		Iterator<int[]> it = elevator.iterator();
		while (it.hasNext()) {
			int[] person = it.next();
			if (person[1] == floorIdx) {
				it.remove();
				elevatorCount -= person[0];
			}
		}
		return elevatorCount;
	}
	
	static String getFloor(String floor) {
		int a = Integer.parseInt(floor);
		return String.valueOf(a > 4 ? a - 1 : a); 
	}
	//---
}

