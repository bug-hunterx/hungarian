static void f( string input )
        {
            var stables = new List<Regex>()
            {
                new Regex(@"^/+_+\|+_+\\+"),
                new Regex(@"^/+\|\\+"),
                new Regex(@"^_+\\+"),
                new Regex(@"^/+_+")
            };
            var rules = new List<List<Char>>()
            {
                new List<Char>() { '_', ' ', '_', '_' },
                new List<Char>() { '_', ' ', '\\', '_' },
                new List<Char>() { '_', ' ', '/', '_' },
                new List<Char>() { '_', ' ', '|', '_' },
                new List<Char>() { '0', '/', ' ', '_' },
                new List<Char>() { '/', '/', ' ', '_' },
                new List<Char>() { '/', '/', '0', '_' },
                new List<Char>() { '|', '/', ' ', '_' },
                new List<Char>() { '/', '|', '/', '/' },
                new List<Char>() { '/', '|', '|', '/' },
                new List<Char>() { '/', '|', '\\', '\\' },
                new List<Char>() { '/', '|', '0', '/' },
                new List<Char>() { '/', '|', ' ', '/' },
                new List<Char>() { '\\', '|', '\\', '\\' },
                new List<Char>() { ' ', '|', '\\', '\\' },
                new List<Char>() { ' ', '\\', '\\', '_' },
                new List<Char>() { ' ', '\\', ' ', '_' },
                new List<Char>() { ' ', '\\', '0', '_' },
                new List<Char>() { ' ', '\\', '|', '_' },
                new List<Char>() { '0', ' ', '_', '_' },
                new List<Char>() { '_', ' ', '0', '_' },
                new List<Char>() { '\\', '/', '0', '_' },
                new List<Char>() { '/', '/', '0', '_' },
                new List<Char>() { '|', '/', '0', '_' },
                new List<Char>() { '0', '\\', '\\', '_' },
                new List<Char>() { '0', '\\', '|', '_' },
                new List<Char>() { '0', '\\', '/', '_' },
                new List<Char>() { '\\', ' ', '_', '_' },
                new List<Char>() { '/', ' ', '_', '_' },
                new List<Char>() { '|', ' ', '_', '_' }
            };

            var output = input.ToCharArray();
            for (var i = 0; i < input.Length; i++)
            {
                foreach (var stable in stables)
                {
                    while (stable.IsMatch(input.Substring(i)))
                    {
                        i += stable.Match(input.Substring(i)).Groups[0].Value.Length - 1;
                    }
                }
                foreach (var rule in rules)
                {
                a:;
                    if (i == 0)
                    {
                        if (output[i] == rule[1] && (output[i + 1] == rule[2] || rule[2] == '0')&& rule[0] == '0')
                        {
                            output[i] = rule[3];
                            i = 0;
                            goto a;
                        }
                    }
                    else if (i == input.Length - 1)
                    {
                        if (output[i] == rule[1]&& (output[i - 1] == rule[0] || rule[0] == '0')  && rule[2] == '0')
                        {
                            output[i] = rule[3];
                            i = 0;
                            goto a;
                        }
                    }
                    else
                    {
                        if (output[i] == rule[1] && output[i - 1] == rule[0] && output[i + 1] == rule[2])
                        {
                            output[i] = rule[3];
                            i = 0;
                            goto a;
                        }
                    }
                }
            }
            string result = new string( output );

            if (output.Last() == '_' && output[output.Length - 2] != '_')
                result = result + "_";
            if (output[0] == '_' && output[1] != '_')
                result = "_" + result;
            Console.WriteLine(result);
        }