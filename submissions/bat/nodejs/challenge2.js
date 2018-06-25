function f(s) {
    var kRows = [
        /[^`1234567890\-=~!@#\$%\^&\*\(\)_+]/g,
        /[^qwertyuiop\[\]QWERTYUIOP\{\}\|\\]/g,
        /[^asdfghjkl;'ASDFGHJKL:"]/g,
        /[^zxcvbnm,\./ZXCVBNM<>?]/g
    ],
    sRows = [
        '`1234567890-=~!@#$%^&*()_+',
        'qwertyuiop[]QWERTYUIOP{}|\\',
        "asdfghjkl;'" + 'ASDFGHJKL:"',
        'zxcvbnm,./ZXCVBNM<>?'
    ],
    lines = [s, s, s, s];    
Array.prototype.gU = function(){
   var u = {}, a = [];
   for(var i = 0, l = this.length; i < l; ++i){
      if(u.hasOwnProperty(this[i])) {
         continue;
      }
      a.push(this[i]);
      u[this[i]] = 1;
   }
   return a;
}

var m = 0,
    minL = '',
    ind = 0;

lines.forEach(function(line, i){  
    l = line.replace(kRows[i], '');   
    if (l.length > 0 && (l.length <= m || m == 0)) {
        if (l.length == m) {
            var lU = l.split('').gU().length,
                mU =  minL.split('').gU().length;
            if (lU <= mU) {
                if (lU == mU) {                    
                    if (ind > i) {
                        m = l.length;
                        minL = l;
                        ind = i;
                    }
                } else {
                    m = l.length;
                    minL = l;
                    ind = i;
                }
            }
        } else {
            m = l.length;
            minL = l;
            ind = i;
        }
    }
});

var sorted = minL.split('').sort(function(a, b) {
    return sRows[ind].indexOf(a) - sRows[ind].indexOf(b);
}).gU().join('');
console.log(sorted)
}
