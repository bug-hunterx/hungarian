function f(x,c){
var l=require('fs').readFileSync(x).toString().split("\n");
var s = 0;
for (var i = 0; i < l.length; i++) {
	if(l[i].lastIndexOf(c)>-1){
		x=l.length-i-1;
		s = l.length-l[i].lastIndexOf(c) - 1;
	}
}
process.stdout.write(x+','+s);
}