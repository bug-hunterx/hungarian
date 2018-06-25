function f(string) {
    var freq = {}, result = "";
    for (var i = 0; i < string.length; i++) {
        var character = string.charAt(i);
        if (freq[character]) {
            freq[character]++;
        } else {
            freq[character] = 1;
        }
    }

    var l = Object.keys(freq).sort(function(a,b){
        if(freq[a] > freq[b]){
            return 1;
        }
        if(freq[a] < freq[b]){
            return -1;
        }
        if(a > b){
            return 1;
        }
        if(a < b){
            return -1;
        }
        return 0;
    });

    l.forEach(function(currentValue){
        for (var i = 0; i<freq[currentValue]; i++){result+=currentValue;}
    });
    console.log(result);
}