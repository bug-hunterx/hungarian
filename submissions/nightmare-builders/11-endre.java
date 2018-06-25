	public static void f(String map) {
		List<Laser> lasers = new ArrayList<>();
		for (int i = 0; i < size(map).x; i++) {
			for (int j = 0; j < size(map).y; j++) {
				Coordinate from = new Coordinate(i, j);
				if (get(map, i, j) == '>') {
					lasers.add(new Laser(from, new Coordinate(1, 0)));
				} else if (get(map, i, j) == '<') {
					lasers.add(new Laser(from, new Coordinate(-1, 0)));
				} else if (get(map, i, j) == 'v') {
					lasers.add(new Laser(from, new Coordinate(0, 1)));
				} else if (get(map, i, j) == '^') {
					lasers.add(new Laser(from, new Coordinate(0, -1)));
				}
			}
		}
		for (int iter = 0; iter < 1000; iter++) {
			for (Laser laser : lasers) {
				laser.go(map);
			}
			for (Laser laser1 : lasers) {
				for (Laser laser2 : lasers) {
					if (laser1!= laser2) {
						for (Coordinate c : laser1.history) {
							if (laser2.history.contains(c)) {
								char item = get(map, c.x, c.y);
								if (item == '/') {
									Coordinate coord = new Coordinate(c.x, c.y);
									int index1 = laser1.history.indexOf(coord);
									Coordinate prev1 = laser1.history.get(index1 + 1); 
									int index2 = laser2.history.indexOf(coord);
									Coordinate prev2 = laser2.history.get(index2 + 1);
									Coordinate dir1 = coord.minus(prev1);
									Coordinate dir2 = coord.minus(prev2);
									if (dir1.equals(dir2) || getNewDir(dir1, '/').equals(dir2.negate())) {
										System.out.println(":/"); return;
									}
								} else if (item == '\\'){
									Coordinate coord = new Coordinate(c.x, c.y);
									int index1 = laser1.history.indexOf(coord);
									Coordinate prev1 = laser1.history.get(index1 + 1); 
									int index2 = laser2.history.indexOf(coord);
									Coordinate prev2 = laser2.history.get(index2 + 1);
									Coordinate dir1 = coord.minus(prev1);
									Coordinate dir2 = coord.minus(prev2);
									if (dir1.equals(dir2) || getNewDir(dir1, '\\').equals(dir2.negate())) {
										System.out.println(":/"); return;
									}
								} else if (item != '@' && !(item >= '0' && item <= '9')){
									System.out.println(":/"); return;
								}
							}
						}
					}
				}
			}
			boolean finished = true;
			for (int i = 0; i < size(map).x; i++) {
				for (int j = 0; j < size(map).y; j++) {
					if (get(map, i, j) == '@') {
						boolean hit = false;
						for (Laser laser : lasers) {
							if (laser.history.contains(new Coordinate(i, j))) {
								hit = true;
							}
						}
						if (!hit) {
							finished = false;
						}
					}
				}
			}
			if (finished) {
				System.out.println(":D"); return;
			}
		}
		System.out.println(":("); return;
	}

	static char get(String map, int x, int y) {
		String[] lines = map.split("\n");
		if (y < 0 || x < 0 || y>=size(map).y||x>=size(map).x) {
			return ' ';
		}
		return lines[y].charAt(x);
	}

	static Coordinate size(String map) {
		int sizeX = map.split("\n")[0].length();
		int sizeY = map.split("\n").length;
		return new Coordinate(sizeX, sizeY);
	}
	
	static Coordinate getNewDir(Coordinate dir, char sign) {
		if (sign == '/') {
			if (dir.x == 1 && dir.y == 0) {
				return new Coordinate(0, -1);
			} else if (dir.x == -1 && dir.y == 0) {
				return new Coordinate(0, 1);
			} else if (dir.x == 0 && dir.y == 1) {
				return new Coordinate(-1, 0);
			} else if (dir.x == 0 && dir.y == -1) {
				return new Coordinate(1, 0);
			}
		} else if (sign == '\\') {
			if (dir.x == 1 && dir.y == 0) {
				return new Coordinate(0, 1);
			} else if (dir.x == -1 && dir.y == 0) {
				return new Coordinate(0, -1);
			} else if (dir.x == 0 && dir.y == 1) {
				return new Coordinate(1, 0);
			} else if (dir.x == 0 && dir.y == -1) {
				return new Coordinate(-1, 0);
			}
		}
			throw new RuntimeException();
	}

	static class Laser {
		
		@Override
		public String toString() {
			return "Laser [history=" + history + ", dir=" + dir + "]";
		}

		private List<Coordinate> history = new ArrayList<>();
		Coordinate dir;

		public Laser(Coordinate from, Coordinate dir) {
			history.add(from);
			this.dir = dir;
		}

		void go(String map) {
			if (get(map, history.get(0).x, history.get(0).y) != '@') {
				Coordinate next = new Coordinate(history.get(0).x + dir.x, history.get(0).y + dir.y);
				char nextObject = get(map, next.x, next.y);
				if (nextObject == ' ') {
					history.add(0, next);
				} else if (nextObject == '/') {
					history.add(0, next);
					dir = getNewDir(dir, '/');
				} else if (nextObject == '\\') {
					history.add(0, next);
					dir = getNewDir(dir, '\\');
				} else if ('0' <= nextObject && nextObject <= '9') {
					history.add(0, findOther(map, next, nextObject));
				} else if (nextObject == '@') {
					history.add(0, next);
				}
			}
		}

		private Coordinate findOther(String map, Coordinate not, char nextObject) {
			for (int i = 0; i < size(map).x; i++) {
				for (int j = 0; j < size(map).y; j++) {
					if (get(map, i, j) == nextObject && (i != not.x || j != not.y)) {
						return new Coordinate(i, j);
					}
				}
			}
			throw new RuntimeException("Not found: " + map);
		}
	}

	static class Coordinate {
		int x;
		int y;
		
		

		@Override
		public String toString() {
			return "Coordinate [x=" + x + ", y=" + y + "]";
		}

		public Coordinate minus(Coordinate coord) {
			return new Coordinate(x - coord.x, y - coord.y);
		}
		
		public Coordinate negate() {
			return new Coordinate(-x , - y );
		}


		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Coordinate other = (Coordinate) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
		

	}
