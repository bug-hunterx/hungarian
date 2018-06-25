function f(n){n=n.split("")
a=[]
F=999
for(i in n){b=0;for(j in n)if(n[j]==n[i])b++
a.push(n[i].charCodeAt(0)+b*F)}
a.sort(function(a,b){return a-b})
s=""
for(i in a)s+=String.fromCharCode(a[i]%F)
console.log(s)}