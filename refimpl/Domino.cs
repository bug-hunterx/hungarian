using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;

namespace Challenges
{
    public class Domino
    {
        public string Execute(string input)
        {
            if (input?.Length == 0) return input;

            var parts = new[]
            {
@"/|\ => /|\",
@"|\ => \\",
@"/| => //",
@" \ => __",
@"/  => __"
}.Select(a => a.Split(new[] { " => " }, StringSplitOptions.RemoveEmptyEntries)).SelectMany(a => a).ToArray();

            string current, last;

            for (current = " " + input + " ", last = ""; current != last;)
            {
                last = current;
                current = "";

                for (int i; (i = current.Length) < last.Length;)
                {
                    // check for a matching construct in the last state
                    var index = Array.FindIndex(parts, item => last.Substring(i).StartsWith(item));
                    // if there is, transform it to its next state
                    // otherwise just copy the domino
                    current += index % 2 == 0
                    ? parts[index + 1]
                    : last.Substring(i, 1);
                }
            }

            return current;
        }
    }
}
