using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace hack2016
{
    class Program
    {
        static void Main(string[] args)
        {
            f("352476"); // X
            f("4268379"); // 0
            f("631854792"); // ?
            f("523764918"); // 0
            //_oo
            //xxx
            //o__
        }

        static void f(string s)
        {
            Action<string> a = x => Console.WriteLine(x);
            var r = new int[8];
            int p=1;
            foreach(var x in s)
            {
                var t = x - '1';
                var e =t+1;
                r[t/3]+=p;
                r[t%3+3]+=p;
                if (e % 4 == 1) r[6] += p;
                if (e % 2 == 1 && e > 1 && e < 9) r[7] += p;
                p*=-1;
            }
            if ( r.Max() == 3) a("O");
            else if (r.Min() == -3) a("X");
            else a("?");
        }

    }
}
