static void f(int i, string s, double l, string file, char c, int count)
{
	Console.Write(String.Join("\n", Enumerable.Repeat(String.Concat(i, s, l, file, c), count)).ToLower());
}
