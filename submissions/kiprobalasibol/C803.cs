public class Candles
{
    string[] Transpose(string[] a)
    {
        return a[0]
                    .Select((_, i) => a.Select(r => r[i]))
                    .Select(s => String.Join("", s))
                    .ToArray();
    }

    public string Execute(int count, string input)
    {
        var lines = Transpose(input.Split('\n'));
        var rx = new Regex(@"(\.|\$)([\|\\/]+)X$");
        var lit = 0;
        var matches = new List<int>();

        for (var i = 0; i < lines.Length; i++)
        {
            var line = lines[i];
            var m = rx.Match(line);
            if (!m.Success) continue;

            if (Regex.Replace(line, @"(/(\|*)\\)|(\\(\|*)/)", "")
                        .IndexOfAny(new[] { '/', '\\' }) > -1) continue;

            if (line.IndexOf('.') > -1)
                matches.Add(i);
            else
                lit++;
        }
        // lit: 2, needed: 4, matches: 4
        //
        var total = lit + matches.Count;
        if (total == 0) return ":(";
        if (lit > count) return "" + (count - lit);
        if (count > total) return "" + (count - total);

        for (var i = 0; i < count - lit; i++)
            lines[matches[i]] = lines[matches[i]].Replace('.', '$');

        return String.Join("\n", Transpose(lines));
    }
}

static void f(int a, string b)
{
    Console.WriteLine(new Candles().Execute(a, b));
}
