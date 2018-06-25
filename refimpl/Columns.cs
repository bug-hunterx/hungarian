using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;

namespace Challenges
{
    public class Columns
    {
        string[][] Transpose(string[][] a)
        {
            return a[0]
                        .Select((_, i) => a.Select(r => r[i]).ToArray())
                        .ToArray();
        }

        public string Execute(string input, int n, int width)
        {
            var lineWidth = (input.Length + width - 1) / width;
            input = input.PadRight(lineWidth * width);

            var a = Enumerable
                            .Range(0, lineWidth)
                            .Select(i => input.Substring(i * width, width))
                            .Concat(Enumerable.Repeat("".PadLeft(width), n - 1))
                            .ToArray();

            var rows = a.Length / n;
            var b = Enumerable.Range(0, n)
                            .Select(i => a.Skip(i * rows).Take(rows).ToArray())
                            .ToArray();

            b = Transpose(b);

            return String.Join("\n", b.Select(l => String.Join("|", l)));
        }

        public static IEnumerable<object[]> Generate(int count)
        {
            const string temp = "Looking for an expert team to deliver domain - led, proactive solutions ? We’ll help you design, develop, deploy, and manage next generation software products that will drive your business forward.";
            int[] widths = { 1, 2, 3, 7, 9, 11, 13 };
            int[] cols = { 1, 2, 3, 4, 7 };

            foreach (var w in widths)
                foreach (var co in cols)
                {
                    yield return new object[] {
                        temp,
                        w,
                        co,
                        new Columns().Execute(temp, w, co)
                        };
                }

            foreach (var c in new[] { 1, 2, 3, 5, 7 })
            {
                foreach (var w in new[] { 1, 2, 4, 7, 13 })
                {
                    const string input = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    if ((input.Length + w) < c * w) continue;

                    var r = new Columns().Execute(input, c, w);

                    yield return new object[] { input, c, w, r };
                }
            }
        }
    }
}
