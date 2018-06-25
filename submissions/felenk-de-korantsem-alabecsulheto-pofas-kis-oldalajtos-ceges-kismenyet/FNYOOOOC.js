function f( s,  n,  w) {
    var h = (s.length / w) / n + 1,result;
    if(h*w*n>s.length)
        for (var i = 0; i < h*w*n - s.length; i++) s+=" ";
    for (var m = 0; m < h; m++) {
        for (var c = 0; c < n; c++) {
            var v = h * c * w + w * m;

            o = s.substring(v>s.length?s.length:v);
            var y = w > o.length ? o.length : w;
            result+=o.substring(0, y);
            if(c!=n-1)result+="|";
            if (y < w) {
                for (var i = 0; i < w - y; i++) result+=" ";
            }
        }
        result+='\n';
    }
    console.log(result.replace(/undefined/,''));
}