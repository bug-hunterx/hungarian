def f(s, n, width)
		rows = (s.length.to_f / (n * width)).ceil
		for row in 0..rows-1
		
    		for i in 0..n-1
    		    for j in 0..width-1
					index = rows * i * width + row * width + j					
					p(index < s.length() ? s[index] : " ")
                    
				end
				if (i < n-1) 
					p( "|")
                end
		    end
			puts
		end
		
end

def p(str)
  print str
  $stdout.flush
end