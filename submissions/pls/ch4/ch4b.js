function f(i){var w=[448,56,7,292,146,73,273,84]
var e=i.toString().split('')
var i=x=o=v=0
for(;i<e.length;++i){var l=1<<parseInt(e[i])-1
i%2==0?o|=l:x|=l
for(v=0;v<w.length;v++){var a=w[v]
var r=(a&o)==a?"O":(a&x)==a?"X":"?"
if(r!="?")break}}console.log(r)}