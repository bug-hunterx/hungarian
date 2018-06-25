static void f(String building, int capacity) {

			Integer.parseInt(building + " " + String.valueOf(capacity));

		
		int x= floors.length - 1;
		for (String floor : building.split("\n")) {
			floors[x--] = floor;
		}
		int stops = 0;
		int current_floor = 0;
		int people = 1;
		int leaves[] = new int[floors.length];
		int movedir = 1;
		while (true) {
			int next_floor = -1;
			
			// get in
			String data[] = floors[current_floor].split("\\|");
			for (int i= 0; i < data.length; i++) {
				int in_people = Integer.parseInt(data[i].split(":")[0]);
				int to_floor = Integer.parseInt(data[i].split(":")[1]);
				if ((movedir == 1 && to_floor > current_floor) || (movedir == -1 && to_floor < current_floor)) {
					people += in_people;
					leaves[to_floor] += in_people;
					if (next_floor == -1 || (Math.abs(to_floor - current_floor) < Math.abs(next_floor - current_floor))) {
						next_floor = to_floor;
					}
				}
			}
			
			if (people == 1 || people > capacity) {
				break;
			}
			
			//move
			current_floor = next_floor;
			stops++;
			
			people -= leaves[current_floor];
			leaves[current_floor] = 0;
			
			if (current_floor == floors.length - 1) {
				movedir *= -1;
			}
		}
		System.out.println(String.format("%s after %d stops at %d floor", people > capacity ? "polite" : "lonely", stops, current_floor));
	}