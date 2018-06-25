
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Text.RegularExpressions;
using System.IO;

namespace Codegolf
{
    class Program
    {
        static void Main(string[] args)
        {
            var s = "Results, Relentlessly";

            f(s);
        }

        static void f(string s)
        {
            Console.WriteLine(
                new string(
                    s.GroupBy(t => t)
                        .OrderBy(g => g.Count())
                        .ThenBy(g => g.Key)
                        .SelectMany(g => new string(g.Key, g.Count())).ToArray()));
            //.SelectMany(g => new string(g.Key, g.Count())));
        }
    }
}

