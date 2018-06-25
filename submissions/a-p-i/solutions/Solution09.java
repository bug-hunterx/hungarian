static void f(String d) {
		String[] split = d.split("\\s+");
		//System.out.println(split.length);
		Map<String, Integer> v = new HashMap<String, Integer>();
		v.put("piranha", 1);
		v.put("koopa", 1);
		v.put("goomba", 1);
		v.put("Mushroom", 4);
		v.put("Star", 3);
		v.put("1Up", 2);
		v.put("Bowser", 0);
		v.put("Princess", 0);
		
		int life = 3;
		int coins = 0;
		int win = 0;
		int star = 0;
		int count = 0;
		int mush = 0;

		for (String s: split) {
				if (life==0) {
					break;
				}
				if (count == 2) {
					star = 0;
					count = 0;
				} else if (star==1){
					count++;
				}
				//System.out.println(s);
				if (s.matches(".\\d")) {
					coins+= Integer.valueOf(s);
				}
				if (coins >= 100 ) {
					life++;
					coins-=100;
				}
				if (v.containsKey(s)) {
					//System.out.println(s);
					if (v.get(s) == 0) {
						win = 1;
						break;
					}
					
					// ENEMY
					if (v.get(s) == 1 && star == 0) {
						if (mush == 0) {
							life--;
						} else {
							mush = 0;
						}
					}
					
					// 1UP
					if (v.get(s) == 2) {
						life++;
					}
					
					// STAR
					if (v.get(s) == 3) {
						count = 0;
						star = 1;
					}
					
					// MUSH
					if (v.get(s) == 4) {
						mush = 1;
					}
				}
		}
		//System.out.println(life);
		System.out.println(win==1?"WIN":(life==0?"GAME OVER":"???"));
	}