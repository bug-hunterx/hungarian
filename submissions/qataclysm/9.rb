def f(s)
 a=s.split(" ")
 l=3
 s=false
 i=0
 c=0
 a.each{
  |v|
  if v!='1Up'&&v.to_i>0
   c += v.to_i
   l += c/100
   c=c%100
  else
   case v
   when 'goomba','piranha','koopa'
    if (i<=0)
     if s
      s=false
     else
      l-=1
     end
     if (l<1)
      puts "GAME OVER"
      return
     end
    end
   when 'Bowser','Princess'
    puts "WIN"
    return
   when 'Mushroom'
    s=true
   when '1Up'
    l+=1
   when 'Star'
    i=3
   else
    i+=1
   end
  end
  i-=1
 }
 puts "???"
end