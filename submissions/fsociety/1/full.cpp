static void f(std::string s)
{
	int t[256]{0};
	for(char c : s) t[c]++;

	for(char a : s)
	{
		char u = 127;
		int m = 1024;
		for(char c : s)
		{
			if(t[c] > 0)
			{
				if(t[c] < m)
				{
					m = t[c];
					u = c;
				}
				else if(t[c] == m && c < u)
				{
					u = c;
				}
			}
		}
		while(t[u]-- > 0) std::cout<<u;
	}
}