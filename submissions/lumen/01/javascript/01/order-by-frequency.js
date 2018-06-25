function f(input) {
    var charMap = {},
        frequencyArray = [],
        result = "";

    function sortInt(a, b) { return a-b; }

    input.split("").forEach(function(char) {
        var asciiCode = char.charCodeAt(0);
        charMap[asciiCode] ?  charMap[asciiCode]++ : (charMap[asciiCode] = 1);
    });

    Object.keys(charMap).sort(sortInt).forEach(function (asciiCode) {
        var frequency = charMap[asciiCode];

        if (frequencyArray[frequency]) {
            frequencyArray[frequency].push(asciiCode);
        } else {
            frequencyArray[frequency] = [ asciiCode ];
        }
    });

    frequencyArray.forEach(function (element, index) {
        element.forEach(function (asciiCode) {
            for (var i = 0; i < index; i++) {
                result += String.fromCharCode(asciiCode);
            }
        })
    });

    console.log(result);

    return result;
}
