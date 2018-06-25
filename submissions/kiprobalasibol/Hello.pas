procedure f(i:integer; s:string; l:real; filex:string; c:char; count:integer);
var 
	x:integer;
begin

	for x:= 1 to count do 
	begin
		writeln(IntToStr(i), s, FloatToStr(l), filex, c);
	end
end;
