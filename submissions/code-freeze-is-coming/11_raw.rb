def f(s)
 i=1
 $h= Hash.new
 a=['L','M','N','O','P','Q']
 b=0
 s.split("\n").each do |l|
     for j in 0..l.length-1
       $h[[i,j+1]]=l[j]
     end
     i=i+1
 end
 $h.each do |k,v|
     case v
     when "<"
        sh(k[0],k[1],0,-1,a[b])
        b=b+1
     when ">"
        sh(k[0],k[1],0,1,a[b])
        b=b+1
     when "^"
        sh(k[0],k[1],-1,0,a[b])
        b=b+1
     when "v"
        sh(k[0],k[1],1,0,a[b])
        b=b+1
     end
 end
 if $h.select{|k,v| (v=="@"||v=="X")}.empty?
    puts ":D"
 elsif $h.select{|k,v| (v=="X")}.empty?
    puts ":("
 else
    puts ":/"
 end
end

def sh(i,j,k,l,z)
    ind=[i+k,j+l]
    case $h[ind]
    when " "
     $h[ind]=z
     sh(i+k,j+l,k,l,z)
    when "/"
     sh(i+k,j+l,l*-1,k*-1,z)
    when "\\"
     sh(i+k,j+l,l,k,z)
    when "@"
     $h[ind]="R"
    when "0","1","2","3","4","5","6","7","8","9"
     r=$h.select{|k,v| (v==$h[ind]&&k!=ind)}
     sh(r.keys[0][0],r.keys[0][1],k,l,z)
    when "L","M","N","O","P","Q"
     if z==$h[ind]
      sh(i+k,j+l,k,l,z)
     else
      $h[ind]="X" 
     end   
    end
end