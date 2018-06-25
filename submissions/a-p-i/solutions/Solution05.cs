static void f(String s)
        {
            String s1 = "";
            var patterns = new List<Tuple<String, String, int, int>>();
            patterns.Add(new Tuple<string, string, int, int>(@"\|\|\\", @"|\\", 3,1));
            patterns.Add(new Tuple<string, string, int, int>(@"/\|\|", @"//|", 3,2));
            patterns.Add(new Tuple<string, string, int, int>(@"/ ", @"__", 2,45));
            patterns.Add(new Tuple<string, string, int, int>(@"/\| ", @"// ", 3,5));
            patterns.Add(new Tuple<string, string, int, int>(@" \|\\", @" \\", 3,7));
            patterns.Add(new Tuple<string, string, int, int>(@" \\", @"__", 2,8));
            patterns.Add(new Tuple<string, string, int, int>(@"/\|\|\\", @"//\\", 4,9));
            patterns.Add(new Tuple<string, string, int, int>(@"/$", @"__", 1,10));
            patterns.Add(new Tuple<string, string, int, int>(@"/\|$", @"//", 2,11));
            patterns.Add(new Tuple<string, string, int, int>(@"^\|\\", @"\\", 2,12));
            patterns.Add(new Tuple<string, string, int, int>(@"^\\", @"__", 1,13));
            patterns.Add(new Tuple<string, string, int, int>(@"/ \\", @"__\", 3, 14));

            while (!s.Equals(s1))
            {
                s1 = String.Copy(s);
                foreach (var pattern in patterns)
                {
                    foreach (Match match in Regex.Matches(s, pattern.Item1))
                    {
                        s1 = s1.Remove(match.Index, pattern.Item3);
                        s1 = s1.Insert(match.Index, pattern.Item2);
                    }
                }
                String temp = s;
                s = s1;
                s1 = temp;
            }
            Console.WriteLine(s1);
        }