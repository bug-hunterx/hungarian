def f(s,n,w)
p=(s.length.to_f/(n*w)).ceil
for r in 0..p-1
for i in 0..n-1
for j in 0..w-1
k=p*i*w+r*w+j
p(k<s.length()?s[k]:" ")
end
if(i<n-1)
p("|")
end
end
puts
end
end
def p(s)
print s
$stdout.flush
end