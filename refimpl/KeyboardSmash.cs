using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Challenges
{
    public class KeyboardSmash
    {
        public string Execute(string input)
        {
            var rows = "1234567890-=`~!@#$%^&*()_+ qwertyuiop[]\\QWERTYUIOP{}| asdfghjkl;'ASDFGHJKL:\" zxcvbnm,./ZXCVBNM?><".Split(' ');
            var counts = input.ToLookup(c => c);
            var freq = rows
                            .Select((r, i) => new
                            {
                                I = i,
                                F = r.Select(c => counts[c].Count()).Sum(),
                                C = r.Where(c => counts[c].Any()).ToArray()
                            })
                            .Where(r => r.F > 0)
                            .OrderBy(r => r.F)
                            .ThenBy(r => r.C.Length)
                            .ThenBy(r => r.I)
                            .ToArray();

            return freq.Any() ? new string(freq[0].C) : "";
        }
    }
}
