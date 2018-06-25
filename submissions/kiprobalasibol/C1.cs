static void f(string x, char c)
{
    int r = 0, s = 0;
    var l = File.ReadAllLines(x);

    for (int i = 0; i < l.Count(); i++)
    {
        if (l[i].LastIndexOf(c) > -1)
        {
            r = l.Count() - i - 1;
            s = l.Count() - l[i].LastIndexOf(c) - 1;
        }
    }

    Console.Write("{0},{1}", r, s);
}
        