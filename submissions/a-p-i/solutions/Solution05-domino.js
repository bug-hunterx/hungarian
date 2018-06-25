function f (s)  {
	
    s1 = "";

	patterns = [
	    {a:"\|\|\\", b:"|\\", c:3},
	    {a:"/\|\|", b:"//|", c:3},
		{a:"/ ", b:"__", c:2},
	    {a:"/\| ", b:"// ", c:3},
	    {a:" \|\\", b:" \\", c:3},
	    {a:" \\", b:"__", c:2},
	    {a:"/\|\|\\", b:"//\\", c:4},
		{a:"/$", b:"__", c:1},
	    {a:"/\|$", b:"//", c:2},
	    {a:"^\|\\", b:"\\", c:2},
	    {a:"^\\", b:"__", c:1},
	    {a:"/ \\", b:"__\\", c:3}
    ];
	
    while (s != s1) {
        s1 = s;
        
        patterns.forEach(function (pattern) {

        	s1 = s1.replace(pattern.a,pattern.b);
        
        });
        
        
        temp = s;
        s = s1;
        s1 = temp;
    }
    console.log(s1);
	
}