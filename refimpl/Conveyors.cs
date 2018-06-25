using System;
using System.Linq;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Challenges
{
    public class Conveyors
    {
        public bool Debug;

        public string Execute(string scene, int width, int height)
        {
            var lines = scene.Split('\n');

            // make a border aroud the area
            var max = lines[0].Length + width * 2;
            var top = new string[height];
            lines = top
                        .Concat(lines)
                        .Concat(top)
                        .Select(l => (l ?? "").PadLeft(max - width).PadRight(max))
                        .ToArray();

            var knownPos = new HashSet<string>();
            var x = width; var y = height;
            var DX = 1;
            var DY = 0;
            var H_OFF = false;
            var V_OFF = false;

            if (Debug) Print(lines, x, y, width, height, DX, DY, H_OFF, V_OFF);

            while (true)
            {
                var area = Enumerable
                                .Range(0, height)
                                .SelectMany(i => lines[y + i].Substring(x, width))
                                .ToLookup(c => c);

                const char DISABLE_H = 'h';
                const char ENABLE_H = 'H';
                const char DISABLE_V = 'w';
                const char ENABLE_V = 'W';
                const string ALL_MOD = "hHwW";

                var counts = ("<>v^" + ALL_MOD).ToDictionary(c => c, c => area[c].Count());

                var switchH = (counts[ENABLE_H] - counts[DISABLE_H]);
                var switchV = (counts[ENABLE_V] - counts[DISABLE_V]);
                if (switchH != 0) H_OFF = switchH < 0;
                if (switchV != 0) V_OFF = switchV < 0;

                var deltaH = H_OFF ? 0 : (counts['>'] - counts['<']);
                var deltaV = V_OFF ? 0 : (counts['v'] - counts['^']);

                if (Debug) Print(lines, x, y, width, height, DX, DY, H_OFF, V_OFF);

                var horizontalCount = Math.Abs(deltaH);
                var verticalCount = Math.Abs(deltaV);

                if (horizontalCount == verticalCount)
                {
                    // all cancelled or no conveyor, stop
                    if (deltaH == 0) return HALT;

                    // otherwise keep moving to the same axis (but not direction!)
                    DX = Math.Abs(DX) * Math.Sign(deltaH);
                    DY = Math.Abs(DY) * Math.Sign(deltaV);
                }
                else if (horizontalCount > verticalCount) // more horizontal conveyors
                {
                    DX = deltaH < 0 ? -1 : 1; DY = 0;
                }
                else // more vertical conveyors
                {
                    DY = deltaV < 0 ? -1 : 1; DX = 0;
                }

                x += DX;
                y += DY;

                if (!knownPos.Add(DX + ";" + DY + ";" + x + ";" + y)) return LOOP;
            }
        }

        public const string LOOP = "8";
        public const string HALT = "9";

        void Print(string[] scene, int x, int y, int w, int h, int dx, int dy, bool hoff, bool voff)
        {
            if (Console.IsInputRedirected || Console.IsOutputRedirected) return;

            Console.CursorLeft = 0;
            Console.CursorTop = 0;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.BackgroundColor = ConsoleColor.Black;

            scene = scene.Select(l =>
            {
                var l2 = l;//.Replace(' ', '.');
                if (hoff) l2 = l2.Replace('<', '(').Replace('>', ')');
                if (voff) l2 = l2.Replace('^', '`').Replace('v', ',');

                return l2;
            }).ToArray();

            foreach (var l in scene)
            {
                Console.WriteLine(l);
            }

            Console.WriteLine();
            Console.WriteLine($"dx: {dx}   ");
            Console.WriteLine($"dy: {dy}   ");

            var cx = Console.CursorLeft;
            var cy = Console.CursorTop;

            Console.ForegroundColor = ConsoleColor.White;
            Console.BackgroundColor = ConsoleColor.DarkCyan;

            for (var i = 0; i < h; i++)
            {

                Console.CursorLeft = x;
                Console.CursorTop = y + i;
                Console.Write(scene[y + i].Substring(x, w));
            }

            Console.ReadKey(true);

            Console.CursorLeft = cx;
            Console.CursorTop = cy;
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.BackgroundColor = ConsoleColor.Black;
        }
    }
}
