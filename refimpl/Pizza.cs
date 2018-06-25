using System;
using System.Linq;
using System.Collections.Generic;
using System;
using System.Linq;
using System.Text.RegularExpressions;

namespace Challenges
{
    public class Pizza
    {
        public string Execute(int cost)
        {
            int value;

            if (cost < 2000)
            {
                value = ((cost + 99) / 100) * 100;
            }
            else if (cost < 5000)
            {
                value = ((cost + 499) / 500) * 500;
            }
            else
            {
                var tmp = (int)(cost * 1.1);
                var rem = tmp % 1000;
                if (rem < 250) tmp -= rem;
                else if (rem > 750) tmp += (1000 - rem);
                else tmp += (500 - rem);

                value = tmp;
            }

            var tip = value - cost;

            return tip == 0 || tip > 1500
                    ? "PAID BY CARD"
                    : tip % 100 > 0
                        ? "KEEP THE CHANGE YOU FILTY ANIMAL"
                        : "HERE IS " + value;
        }
    }
}
