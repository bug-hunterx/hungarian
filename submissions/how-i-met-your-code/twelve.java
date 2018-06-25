static void f(String f, int w, int h) {
		String[] r = f.split("\\n");
		int t[] = new int[8], x = 0, y = 0, i, j;
		boolean m = true, inf = false;
		String preDir = ">";
		String dirH, dirW, dir;
		int difH, difW;
		int count = 0;
		while (m & !inf & count < 1000000) {			
			for (j = 0; j < t.length; j++)
				t[j] = 0;
			dirH = "";
			dirW = "";
			dir = "";
			difW = 0;
			difH = 0;
			for (i = x; i < x + h; i++) {
				for (j = y; j < y + w; j++) {
					if (r[i].charAt(j) == 'h')
						t[0]++;
					else if (r[i].charAt(j) == 'H')
						t[1]++;
					else if (r[i].charAt(j) == 'w')
						t[2]++;
					else if (r[i].charAt(j) == 'W')
						t[3]++;
					else if (r[i].charAt(j) == '>')
						t[4]++;
					else if (r[i].charAt(j) == '<')
						t[5]++;
					else if (r[i].charAt(j) == '^')
						t[6]++;
					else if (r[i].charAt(j) == 'v')
						t[7]++;
				}
			}

			if (t[1] >= t[0]) {
				if (t[4] > t[5]) {
					dirH = "<";
					difH = t[4] - t[5];
				} else if (t[4] < t[5]) {
					dirH = ">";
					difH = t[5] - t[4];
				}
			}
			if (t[3] >= t[2]) {
				if (t[6] > t[7]) {
					dirW = "^";
					difW = t[6] - t[7];
				} else if (t[6] < t[7]) {
					dirW = "v";
					difW = t[7] - t[6];
				}
			}

			if (dirW.isEmpty() & !dirH.isEmpty())
				dir = dirH;
			else if (!dirW.isEmpty() & dirH.isEmpty())
				dir = dirW;
			else if (!dirW.isEmpty() & !dirH.isEmpty()) {
				if (difH > difW)
					dir = dirH;
				else if (difH < difW)
					dir = dirW;
				else if (difH == difW & difH != 0)
					dir = preDir;
			}

			preDir = dir;
			if (dir.equals(">") & y < r[0].length() - 1 - w)
				y++;
			else if (dir.equals("<") & y > 1)
				y--;
			else if (dir.equals("^") & x > 1)
				x--;
			else if (dir.equals("v") & x < r.length - 1 - h)
				x++;

			if (dir.isEmpty())
				m = false;
			if(x==0 & y==0) inf = true;
			count++;
		}
		if(!m) System.out.println("9");
		else System.out.println("8");
	}