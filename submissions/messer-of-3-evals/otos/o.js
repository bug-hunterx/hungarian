function f(s){
    z = s.split('').reduce(function(a, b){
        return a.concat(b)
        .replace("\/\ ","__")
        .replace("\ \\","__")
        .replace("\/\ \\","__\\")
        .replace(/\/\|\|\|\|/,"////__")
        .replace(/\/\|\ \/\|/,"/__ /__")
        .replace(/\/\/\|\|/,"///|")
        .replace(/\/\/\/\|\\\\\_\_/,"///\\\\\\")
        .replace(/\/\|\|\\/,"//\\\\");
    });

    console.log(z);
}
