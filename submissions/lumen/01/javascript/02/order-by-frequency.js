function f(input) {
    var charMap = {},
        frequencyArray = [],
        result = "";

    input.split("").forEach(function(char) {
        var asciiCode = char.charCodeAt(0);
        charMap[asciiCode] ?  charMap[asciiCode]++ : (charMap[asciiCode] = 1);
    });

    Object.keys(charMap).sort(function(a, b) { return a-b; }).forEach(function (asciiCode) {
        var fa = frequencyArray[b = charMap[asciiCode]], b;
        fa ? fa.push(asciiCode) : (frequencyArray[b] =  [asciiCode]);
    });

    frequencyArray.forEach(function (element, index) {
        element.forEach(function (asciiCode) {
            for (var i = 0; i < index; i++) {
                result += String.fromCharCode(asciiCode);
            }
        })
    });

    console.log(result);
}
