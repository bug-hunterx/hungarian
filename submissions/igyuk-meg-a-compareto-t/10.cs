static void f(int n, string scene)
        {
            var rows = scene.Split('\n').Reverse();
            var result = (String[])rows.ToArray().Clone();

            var toLit = new List<Tuple<int, int>>();

            var litted = 0;
            for (int x = 0; x < rows.First().Length; x++)
            {
                if (rows.First()[x] != 'X') continue;

                var d = new Dictionary<char, int>()
                {
                    { '/', 0 },
                    { '|', 0 },
                    { '\\', 0 }
                };
                var y = 0;
                foreach (var row in rows)
                {
                    if (d.ContainsKey(row[x]))
                    {
                        d[row[x]]++;
                    }
                    else
                    {
                        if ((d['/'] == d['\\'] && d['/'] != 0) || (d['/'] == 0 && d['\\'] == 0 && d['|'] > 0 ) )
                        {
                            if (row[x] == '.')
                            {
                                toLit.Add(Tuple.Create(y, x));
                            } else if( row[x] == '$' )
                            {
                                litted++;
                            }
                            break;
                        } else
                        {
                        }
                    }
                    y++;
                }
            }

            if (litted + toLit.Count == 0)
            {
                Console.WriteLine(":(");
            }
            else if (n > toLit.Count + litted)
            {
                Console.WriteLine(n - litted - toLit.Count);
            } else if ( n < litted)
            {
                Console.WriteLine(n - litted );
            }
            else {

                foreach (var lit in toLit)
                {
                    if( n == litted )
                    {
                        break;
                    }
                    var s = new StringBuilder(result[lit.Item1]);
                    s[lit.Item2] = '$';
                    result[lit.Item1] = s.ToString();
                    litted++;
                }

                Console.WriteLine(String.Join("\n", result.Reverse()));
            }
        }