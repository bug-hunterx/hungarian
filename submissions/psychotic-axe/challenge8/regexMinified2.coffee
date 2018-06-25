a=(w=1)->"(.{"+w+"})"
b=(i,c,r)->
 p=i%c*r+i//c+1
 if i%c!=c-1
  "$"+p+"|"
 else
  "$"+p+"\n"
f=(t,c,w)->
 l=t.length
 p=Math.ceil(l/w)
 r=Math.ceil(p/c)
 t=t+new Array(p*w-l+1+c*r*w-p*w).join(" ")
 t=t.replace(new RegExp((a(w)for i in[1..r*c]).join("")),(b(i,c,r)for i in[0..r*c-1]).join(""))
 console.log(t)