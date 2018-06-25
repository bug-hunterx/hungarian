		static void f(int n,string scene) {
			int counter = 0;
			char[] test = scene.ToCharArray();
			string[] lines = scene.Split(new string[] {"\n", "\r\n"}, StringSplitOptions.RemoveEmptyEntries);
			char[,] oLines = new char[lines[0].Length, lines.Length];
			for(int i = 0; i < lines[0].Length ; i++) {
				for(int j = 0; j <lines.Length; j++) {
					oLines [i,j] = lines [j][i];
				}
			}

			for (int i = 0; i < oLines.GetLength (0); i++) {
				string row = new string (GetRow (oLines, i).ToArray ());
				bool haveTorch = row.Contains ("$");
				if ((row [row.Length - 1] == 'X') && haveTorch) {
					int flamePos = row.IndexOf ("$");
					int basePos = row.IndexOf ("X");
					string s = row.Substring (flamePos + 1, basePos - flamePos);
					string b = row.Substring (0, flamePos+1);

					if (haveTorch && valid (s,b)) {
						counter += 1;
					}
				}
			}

			if (counter < n) {
				for (int i = 0; i < oLines.GetLength (0); i++) {
					string row = new string (GetRow (oLines, i).ToArray ());
					bool haveTorch = row.Contains (".");
					if ((row [row.Length - 1] == 'X') && haveTorch) {
						int flamePos = row.IndexOf (".");
						int basePos = row.IndexOf ("X");
						string s = row.Substring (flamePos + 1, basePos - flamePos);
						string b = row.Substring (0, flamePos+1);

						if (haveTorch && valid (s,b) && counter < n) {
							test [(((flamePos * (lines [0].Length + 1)) + i))] = '$';
							counter += 1;
						}
					}
				}
			}

			if (counter == 0 && n >= 0) {
				Console.Write (":(");
			} else if (counter != n) {
				Console.Write (n - counter);
			} else {
				Console.Write (test);
			}
		}

		public static bool valid(string s, string b) {
			int balance = 0;
			char previous = ' ';
			for (int k = 0; k < s.Length; k++) {
				if (s [k] != '/' && s [k] != '\\' && s [k] != '|') {
						return false;
					}
				if (s [k] == '/') {
					balance++;
					if (previous == '/') {
						break;
					}
					previous = '/';
				} else if (s [k] == '\\') {
					balance--;
					if (previous == '\\') {
						break;
					}
					previous = '\\';
				}
			}
			return (balance == 0 && !b.Contains("/") && !b.Contains(".") && !b.Contains("$") && !b.Contains("|") && !b.Contains("X") && !b.Contains("\\"));
		}

		public static IEnumerable<T> GetRow<T>(T[,] array, int index)
		{
			for (int i = 0; i < array.GetLength(1); i++)
			{
				yield return array[index, i];
			}
		}