using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;

namespace Challenges
{
    public class FreqOrdered
    {
        public string Execute(string input)
        {
            var g = input
                        .GroupBy(c => c, (k, i) => new String(k, i.Count()))
                        .OrderBy(l => l.Length)
                        .ThenBy(l => (int)l[0]);

            return String.Join("", g);
        }
    }
}
