static void f(string s, int c, int w)
{
    var l = s.Length;
    var q = (l-1) / c / w + 1;
    for (int r = 0; r<q; r++)
    {
        string res = "";
        for (int j = 0; j < c; j++)
        {
            int p = q * w * j + r*w;
            for (int k = 0; k < w; k++)
            {
                res += p < l ? s[p] : ' ';
                p++;
            }
            res += j == c-1 ? "" : "|";
        }
        Console.Write(res + "\n");
    }
}