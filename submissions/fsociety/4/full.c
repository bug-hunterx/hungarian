void f(char*s)
{
	// p = player, 0(O) or 1(X) (0 starts the game)
	// w = winner, 0 or 1 or 2
	// b = board, 0 = no mark, 1 = player0, 2 = player1

	int b[9] = {0}, p = 1,w = 0;
	while(*s)
	{
		b[*s++-49] = (p^=1) + 1; // sets field to 1 + playerID (0 or 1)

		// macro checks if fields x,y,z are the same player's marks (not 0)
		// but only if the game is not finished yet
		#define C(x,y,z)if(!w&&b[x]&&!((b[x]^b[y])|(b[y]^b[z]))){w=b[x];break;}

		// check all 3 rows, columns and 2 diagonals
		C(0,1,2);C(3,4,5);C(6,7,8);C(0,3,6);C(1,4,7);C(2,5,8);
	}
	
	// prints ? if w (winner) is 0, otherwise O for player0 and X for player1
	printf("%c",w?w&2?88:79:63);
}