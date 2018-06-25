
def f(q,s)
    s=s.split("\n").map{|x|x.split('')}.transpose
    w=[]
    f=[]
    s.each_with_index{|q, y|
        t = q.reverse
        sz = t.size - 2
        next unless t[0]=='X'
        hz=true
        zz=false
        z=0
        t.drop(1).each_with_index{|i, x|
            if hz && zz && z==0 then
                w << [sz-x,y] if i=='.'
                f << [sz-x,y] if i=='$'
            end
            zz=true if '/|\\'.index i
            hz=false unless '/|\\'.index i
            z+=1 if i=='/'
            z-=1 if i=='\\'
        }
    }
    
    l = f.count
    d = q - l
    
    if f.count + w.count == 0 then
        puts ':('
    elsif d < 0 then
        puts d
    elsif d == 0 then
        puts 0
    elsif d <= w.count then
        while d > 0 do
            c=w.shift
            s[c[1]][c[0]]='$'
            d-=1
        end
        
        puts s.transpose.map{|x|x.join('')}.join("\n")
    else
        puts d - w.count
    end
end