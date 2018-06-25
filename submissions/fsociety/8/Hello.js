function f(s,n,w){
    a=s.match(new RegExp('.{1,'+w+'}','g'));
    r=Math.ceil(a.length/n);
    for(i=0;i<n*r;i++){
        a[i]=a[i]?a[i]:Array(w+1).join(' ');
        l=a[i].length;
        a[i]=l==w?a[i]:a[i]+Array(w-l+1).join(' ');
    }
    t='';
    for(i=0;i<r;i++){
        for(j=0;j<n-1;j++){
            t+=a[j*r+i]+'|';
        }
        t+=a[(n-1)*r+i]+'\n';
    }
    console.log(t)
}

f("This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5);
f("Results, Relentlessly", 3, 4);

