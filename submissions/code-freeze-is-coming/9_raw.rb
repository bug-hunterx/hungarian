def f(s)
    l=3
    r=0
    m=0
    c=0
    s.split(' ').each do |i|
        r=r-1 if r>0
        case i
        when "Mushroom"
         m=1 if m!=1 
        when "Star"
         r=3
        when "1Up"
         l=l+1
        when "goomba","koopa","piranha"
         if r==0
            if m==1
                m=0
            else
                l=l-1
            end
         end
         if l==0
            puts "GAME OVER"
            return
         end
        when "Bowser","Princess"
         puts "WIN"
         return
        else
         c=c+i.to_i
        end
        if (c>=100)
            l=l+1
            c=c-100
        end
    end
    puts "???"
end