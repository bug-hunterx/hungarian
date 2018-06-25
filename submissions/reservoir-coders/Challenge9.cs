        static void f(string S)
        {
            S = S.Replace("1Up", "100");
            int l = 3;
            int v = 0;
            bool b = false;
            var q  = S.Split(' ');
            string s = "???";
            int c = 0;
            foreach (var w in q)
            {
                if (w=="")
                    continue;
                var C = w[0];
                if (C=='P'||C=='B')
                { 
                    s ="WIN";
                    break;
                }
                v--;
                if (C=='g'|| C == 'k' || C == 'p')
                {
                    if (v < 0)
                    {
                        if (!b)
                            l--;
                        b = false;
                    }
                }
                else if (char.IsLower(C))
                    break;
                if (char.IsDigit(C))
                {
                    c += int.Parse(w);
                }
                while (c >= 100)
                {
                    l++;
                    c -= 100;
                }
                if (C == 'M')
                    b = true;
                if (C == 'S')
                    v = 2;

                if (l == 0)
                {
                    s = "GAME OVER";
                    break;
                }
            }
            Console.Write(s);
        }
