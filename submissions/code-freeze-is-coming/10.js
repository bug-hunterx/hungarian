function f(e,r){function n(e,r,n){return e.substr(0,r)+n+e.substr(r+n.length)}for(var l=r.split("\n").reverse(),a=[],s="",f=0,t=0;t<l[0].length;t++)if("X"===l[0][t])for(var i=0,c=!0,o=1;o<l.length;o++){switch(l[o][t]){case"|":break;case"/":1>i?i++:c=!1;break;case"\\":i>-1?i--:c=!1;break;case".":0===i?(a.push({line:o,column:t}),f++):c=!1;break;case"$":0===i?(e--,f++):c=!1;break;default:c=!1}if(!c)break}if(f)if(0>e)s=e;else if(e>a.length)s=e-a.length;else for(var u=0;e>u;u++){var b=a[u];l[b.line]=n(l[b.line],b.column,"$")}else s=":(";if(!s){s=l[0];for(var h=1;h<l.length;h++)s=l[h]+"\n"+s}console.log(s)}