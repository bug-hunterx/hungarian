function f(n,r,a){function t(n,r,a){var t="",o={};if(n=n.replace(/\s/g,""),!n)return"";for(var e=0;e<u.length;e++)o[u[e]]=(n.match(new RegExp(u[e],"g"))||[]).length;o.H-o.h>0?l=!0:o.H-o.h<0&&(l=!1),o.W-o.w>0?s=!0:o.W-o.w<0&&(s=!1),l||(o["<"]=o[">"]=0),s||(o["\\^"]=o.v=0);var h=o.v-o["\\^"],y=o["<"]-o[">"];return t=Math.abs(h)>Math.abs(y)?h>0?"v":"^":Math.abs(h)<Math.abs(y)?y>0?"<":">":0==Math.abs(h)?"":">"==r||"<"==r?y>0?"<":">":h>0?"v":"^"}function o(n){var r=t(e(n),c,n),a=x[r];return c=r,""===a?(console.log(9),9):f.has(n.x+" "+n.y+" "+a.x+" "+a.y)?(console.log(8),8):(f.add(n.x+" "+n.y+" "+a.x+" "+a.y),void o({x:n.x+a.x,y:n.y+a.y}))}function e(n){for(var t="",o=n.x;o<n.x+a;o++)for(var e=n.y;e<n.y+r;e++)t+=v[o][e];return t}function h(){v=i.split("\n"),2===v.length&&""===v[1]&&v.pop();for(var n=0;a>n;n++)v.unshift(Array(v[0].length+1).join(" ")),v.push(Array(v[0].length+1).join(" "));for(var t=0;t<v.length;t++)v[t]=Array(r+1).join(" ").concat(v[t]),v[t]=v[t].concat(Array(r+1).join(" ")),v[t]=v[t].split("")}function y(){return{x:Number(a),y:Number(r)}}var v=[[]],i=n,u=["\\^","v","<",">","h","H","w","W"],x={v:{x:1,y:0},"^":{x:-1,y:0},">":{x:0,y:1},"<":{x:0,y:-1},"":""},c=">",f=new Set,l=!0,s=!0;h(),o(y())}