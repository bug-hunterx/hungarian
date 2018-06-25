static void f(int n, string s)
{
    var t = tr(s);
    int light = 0;
    var p = @"^X((/\|*\\)*|(\\\|*/)*|\|*)*";
    var torch = t.Count(f =>
        {
            var m = Regex.Match(f, p + @"(\$|\.)");
            if (m.Success && m.Groups[4].Value == "$") light++;
            return m.Success;
        });

    if (torch == 0)
        Console.WriteLine(":(");
    else if (torch < n)
        Console.WriteLine(n - torch);
    else if(light > n)
        Console.WriteLine(n - light);
    else
    {
        t = t.Select(f =>
            {
                var m = f;
                if (n-light > 0)
                {
                    m = Regex.Replace(f, "(?<=" + p + @")(\.)", "$");
                    if (m != f) light++;
                }
                return m;
            }).ToArray();
        Console.WriteLine(string.Join("\n", tr(string.Join("\n", t))).Reverse().ToArray());
    }

}

static string[] tr(string s)
{
    var m = s.Split('\n').Max(x => x.Length) + 1;
    var st = new string[m];
    for (int i = s.Length - 1; i >= 0; i--)
        st[i % m] += s[i];
    return st.Take(m-1).ToArray();
}