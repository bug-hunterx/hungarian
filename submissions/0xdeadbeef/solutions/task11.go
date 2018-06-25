func f(s string) {

	type Coordi struct { x,y interface{} }
	type Cell struct { turr, mirr, wall, portal, target interface{} }

	fmt.Println(s);//
	
	var m[1000][1000]Cell;
	var t[]Coordi;

	x := 0;
	y := 0;
	for i := 0; i < len(s); i++ {
		c := string(s[i]);
		switch c {
			case "\n":x=0;y+=1;
			case "^":fallthrough
			case "v":fallthrough
			case "<":fallthrough
			case ">":
				m[x][y].turr=true;
				t=append(t, Coordi{x,y});
			case "\\":fallthrough
			case "/":m[x][y].mirr=true;
			case "#":m[x][y].wall=true;
			case "0","1","2","3","4","5","6","7","8","9":m[x][y].portal=c;
			case "@":m[x][y].target=true;
		}
		x+=1
	}
	for i := 0; i < len(t); i++ {
		
	}
}
