	static long[] lift = new long[1000000]; // count(0-999)_to(0-999)
	static long[] people = new long[1000000]; // key: from*1000+x : count(0-999)_to(0-999)
	static int count = 0;
	static int stops = -1;
	static boolean first = true;
	
	static void f(String building, int capacity) {
		String[] floorsA = building.split("\n");
			String[] floors = new String[floorsA.length + 1];
			if (floorsA.length > 4) {				
				int ii = 0;
				for (int i = 0; i < floorsA.length; i ++) {
					if (i == floorsA.length - 4) {
						floors[ii] = "";
						ii++;
					}
					floors[ii] = floorsA[i];
					ii++;
				}
			}
			else {
				floors = floorsA; 
			}
		for (int i = floors.length - 1; i >= 0; i--) {
			int floor = floors.length - i - 1;
			String[] actualFloor = floors[i].split("\\|");
			if (floors[i].isEmpty() ) continue;
			for (int j = 0; j < actualFloor.length; j++) {
				String current = actualFloor[j];
				people[floor * 1000 + j] = Integer.valueOf(current.split(":")[0]) * 1000 + Integer.valueOf(current.split(":")[1]);	
			}
		}
		
		boolean up = true;
		boolean nextUp = up;
		int liftAt = 0;
		while(true) {
			if (liftAt == 0) {
				nextUp = true;
			}
			
			if (exit(liftAt, lift)) {
				stops++;
				enter(up, capacity, liftAt);
				if (up && liftAt >= maxHeight(lift)) {
					nextUp = false;
					enter(nextUp, capacity, liftAt);
				}
				if (!first && count == 0) {
					System.out.println("lonely after " + stops + " stops at " + liftAt + " floor");
					System.exit(0);
				}
			}
			up = nextUp;
			if (up) {
				liftAt++;
			} else {
				liftAt--;
			}
			first = false;
		}
		
	}
	
	private static long maxHeight(long[] lift2) {
		long max = 1;
		for (int i = 0; i < 1000000; i++) {
			if (max < lift2[i] % 1000) {
				max = (int) (lift2[i] % 1000);
			}
		}
		return max;
	}

	static void enter(boolean up, int capacity, int where) {
		for (int i = where * 1000; i < where * 1000 + 1000; i++) {
			if (people[i] % 1000 > where ^ !up) {
				addToLift(people[i], capacity, where);
				people[i] = 0;
			}
		}
	}
	
	private static void addToLift(long people, int capacity, int where) {
		for (int i = 0;true;i++) {
			if (lift[i] == 0) {
				lift[i] = people;
				count+= people / 1000;
				if (count > capacity - 1) {
					System.out.println("polite after " + stops + " stops at " + where + " floor");
					System.exit(0);
				}
				return;
			}
		}
	}

	static boolean exit(int where, long[] lift) {
		int wantExit = 0;
		for (int i = 0; i <lift.length; i++) {
			if (lift[i]%1000 == where) {
				wantExit += lift[i]/1000;
				lift[i] = 0;
			}
		}
		count-=wantExit;
		return first || wantExit > 0;
	}