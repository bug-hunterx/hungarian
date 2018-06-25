procedure f(x:integer);
VAR
	t:LongInt;
	p:LongInt;
BEGIN
	if x < 2000 then
			t:= 100 - (x mod 100);
			if t = 100 then t:=0
	else if (2000 <= x) and (x < 5000) then
		begin
			t:= 500 - (x mod 500);
			if t = 500 then t:=0;
		end;	
	p := x+t;	
	if x >= 5000 then 
		begin
			p:= 500 * ROUND(trunc(x*1.1) / 500);
			t:= p-x;
		end;
	
	if((t = 0) or (t > 1500))  then
		write('PAID BY CARD')
	else if(t mod 100) <> 0 then
		write('KEEP THE CHANGE YOU FILTY ANIMAL')
	else
		begin  
			write('HERE IS ');
			write(p);
		end;
END;