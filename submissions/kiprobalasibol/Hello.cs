(i, s, l, file, c, count) => {
	Console.Write(String.Join("\n", Enumerable.Repeat(String.Concat(i, s, l, file, c), count)).ToLower());
}
