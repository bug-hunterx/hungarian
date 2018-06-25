static void f(string s)
{
    var t = " " + s + " ";
    s = t;
    do
    {
        t = s;
        s = s.Replace(@"/|\", "s");
        s = s.Replace("/ ", "__");
        s = s.Replace("/|", "//");
        s = s.Replace(@" \", "__");
        s = s.Replace(@"|\", @"\\");
    } while (t != s);
    s = s.Replace("s", @"/|\");

    Console.WriteLine(s.Trim());
}