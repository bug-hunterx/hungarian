def f(s)
	t=s.split(\s+)
	&l=3
	&c=0
	&i=0
	&b=false
	$j=0
	while $j < t.length  do
		if t[j].match('^(p|.oo).*') && i<1 then
			if b === true then
				b=false
			else
				l--
				if l<1 
				puts "GAME OVER"
				ret
			end
		end
		if t[j].match('\\d+') then c+=t[j].to_i end
		if c>99 then c-=100 l++ end
		if t[j].match('^(P|B).*') then puts 'WIN' ret end
		if t[j].match("1Up")) then l++ end
		if t[j].match("^M.*")) then b=true end
		i--;
		if t[j].match("Star")) then i=2; end
	end
	puts "???"
end