function f(a,b,c){var d=c*b-a.length%(c*b),e=a+new Array(c*b>d?d:0).join(" ");d!=c*b&&(e+=" ");var f=[],g=Math.round(e.length/b/c);g=1>g?1:g,e=e.replace(new RegExp("(.{"+c+"})","g"),"$1|");for(var a=0;g>a;a++)f[a]=[];for(var h=e.split("|"),i=0,j=0,a=0;a<h.length-1;a++)f[i][j]=h[a],g>i+1?i+=1:(j+=1,i=0);for(var a=0;g>a;a++)f[a]=f[a].join("|");console.log(f.join("\n"))}