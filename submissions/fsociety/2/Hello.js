function f(s) {
    t='';
    k = "`1234567890-=~!@#$%^&*()_+ qwertyuiop[]\\QWERTYUIOP{}| asdfghjkl;'  ASDFGHJKL:\"   zxcvbnm,./   ZXCVBNM<>?    ";
    rs = [0, 0, 0, 0];
    us=['','','',''];
    for(i=0;i<s.length;i++) {
        r = Math.floor(k.indexOf(s[i]) / 27);
        sf = r%2;
        rs[r]++;
        if(us[r].indexOf(s[i])<0) us[r]+=s[i];
    }
    for(i=0;i<4;i++) {
        us[i]=us[i].split('').sort((a,b)=>k.indexOf(a) - k.indexOf(b)).join('')
    }
    m=9999;
    for(i=0;i<4;i++) {
        if (rs[i] < m && rs[i] > 0) m=rs[i];
    }
    ms=[];
    for(i=0;i<4;i++){
        if (rs[i]==m) ms.push(i);
    }
    if(ms.length>1) {
        m=9999;
        for(i=0;i<4;i++) {
            if (us[i].length < m && us[i].length > 0) m=us[i].length;
        }
        mus=[];
        for(i=0;i<4;i++){
            if (us[i].length==m) mus.push(i);
        }
        if(mus.length>1){
            m=mus[0];
            for(i=0;i<mus.length;i++) {
                if (mus[i] < m && mus[i] > 0) m=mus[i];
            }
            t+=us[m];
        }else{
            t+=us[mus[0]];
        }
    }else{
        t=us[ms[0]];
    }
    console.log(s, '=>', t);
}

f('FJAFJKLDSKF7JKFDJ')
console.log('------------------------------------------------------------')
f('ASDFDSASDFDSAzxcPOIUY')
console.log('------------------------------------------------------------')
f('qwERfgHJ123456789')
console.log('------------------------------------------------------------')
f('FGhjKL:"\';lkqwerzxcc')
console.log('------------------------------------------------------------')
f('ASDFASDFqwer432!')
console.log('------------------------------------------------------------')
f('EUIyouiepIEjhadSDJ(*Y9y9')
console.log('------------------------------------------------------------')
f('1233AERSdfqw')
console.log('------------------------------------------------------------')
f('ASDF11!*&+1')
console.log('------------------------------------------------------------')
f('}*3%&2098@$2k234#@$M`')
console.log('------------------------------------------------------------')
f('wqfdSREA3321')
console.log('------------------------------------------------------------')
f(':X:D:):DDDDDDDxDDDD:(;);];]')
