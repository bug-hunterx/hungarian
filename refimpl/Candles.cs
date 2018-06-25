using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Challenges
{
    public class Candles
    {
        static string[] Transpose(string[] a)
        {
            return a[0]
                        .Select((_, i) => a.Select(r => r[i]))
                        .Select(s => String.Join("", s))
                        .ToArray();
        }

        public string Execute(int n, string scene)
        {
            var lines = Transpose(scene.Split('\n'));
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
            if (lit > n) return "" + (n - lit);
            if (n > total) return "" + (n - total);

            for (var i = 0; i < n - lit; i++)
                lines[matches[i]] = lines[matches[i]].Replace('.', '$');

            return String.Join("\n", Transpose(lines));
        }

        public static IEnumerable<object[]> GetCases(int n)
        {
            var rnd = new Random();
            var b = new Builder();

            for (var i = 0; i < n; i++)
            {
                var lines = Enumerable.Range(1, rnd.Next(6, 25)).Select(_ => rnd.Next(100) > 50 ? " " : (b.Sky() + b.Torch())).ToArray();
                var w = lines.Max(l => l.Length);

                var scene = lines.Select(l => l.PadLeft(w)).ToArray();
                var input = String.Join("\n", Candles.Transpose(scene));
                var c = rnd.Next(10);

                yield return new object[] { c, input, new Candles().Execute(c, input) };
            }
        }


        class Builder
        {
            Random r = new Random();

            const string head = "....$$@&*";
            const string sky = "    *$~*";
            string[] body = new[] { "|", @"/||\", "||", "|||", "//", "\\" };
            string[] footer = new[] { "X", "|X", "X ", "X    ", "X  ", "X", "X" };

            public string Torch()
            {
                return head[r.Next(head.Length)] + String.Join("", Enumerable.Range(1, r.Next(1, 4)).Select(_ => body[r.Next(body.Length)])) + footer[r.Next(footer.Length)];
            }

            public string Sky()
            {
                return "".PadLeft(r.Next(5)) + (sky[r.Next(sky.Length)]) + "".PadRight(r.Next(3));
            }
        }
    }
}
