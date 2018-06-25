def f(i, n, w) 
e = n
m = []
def o(t)
y = " "
for x in 1..t-1
y += " "
end
return y;
end
def drawOneline(h, a, b, c)
line = ""
for x in 0..c-1
line += (a[h]);
h += b
if x < c-1
line += "|"
end
end
return line
end
for x in 0..(i.length/w)
m.push(i[x*w..x*w+w-1])
end
m = m.reject { |c| c.nil? }
if m[-1] == ""
m.delete(m[-1])
end
y = m[-1].length
for x in y..w-1
m[-1] = m[-1] + " "
end
q = m.length / e
l = (m.length) % e
if(l != 0)
q += 1
end
for x in m.length..e*q
m.push(o(w))
end
r = ""
for x in 0..q-1
r += drawOneline(x, m, q, e)
if x != q-1
r+="\n"
end
end
print r
end