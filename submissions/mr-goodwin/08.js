function f(n,e,o){var r=e*o,g=n.length%r,t=n.length?g?r-g:0:r;n+=new Array(t+1).join(" ");for(var a=new RegExp(".{1,"+o+"}","g"),h=n.match(a,"g"),l=[],i=h.length/e;h.length;)l.push(h.splice(0,i));for(var c=[],f=0;i>f;f++){var p=l.map(function(n){return n[f]});c.push(p.join("|"))}console.log(c.join("\n"))}