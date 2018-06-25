static void f(string s){Console.Write(new string(s.GroupBy(t=>t).OrderBy(g=>g.Count()).ThenBy(g=>g.Key).SelectMany(g=>new string(g.Key,g.Count())).ToArray()));}

