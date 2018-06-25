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