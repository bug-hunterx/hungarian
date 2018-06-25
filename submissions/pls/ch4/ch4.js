function f(s){var q=[]
var w=[448,56,7,292,146,73,273,84]
var o=s.toString().split("")
var d='?'
var i=j=0
for(;i<o.length;++i){var l=parseInt(o[i])-1
q[l]=i%2==0?'O':'X'
var u=0
for(j=0;j<9;++j)if(q[j]==(i%2==0?'O':'X'))u|=1<<(9-j-1)
for(var k=0;k<8;++k)if((w[k]&u)==w[k])d=q[l]}console.log(d)}
