def f(s)
d="`1234567890-=~!@\#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;'ASDFGHJKL:\"````zxcvbnm,./ZXCVBNM<>?"
puts s.split('').group_by{|x|(d.index x)/26}.to_a.map{|x|[x[1].uniq.sort_by{|x|d.index x}.join,x[1].count,x[1].uniq.count,x[0]]}.sort_by{|x|x.drop 1}[0][0]
end