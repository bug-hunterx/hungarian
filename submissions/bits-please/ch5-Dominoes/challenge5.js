function f(inputDominoes) {
	return inputDominoes; 
}


var test = function(testList) {
	var allOk = true;
	for (var i = 0; i < testList.length; i++) 
        {
            var input = testList[i][0];
            var expected = testList[i][1];
        
            var actual = f(input);
        
            if (actual !== expected) {
        	allOk = false;
                console.log("FAIL: input[" + input + "] expected[" + expected + "] actual[" + actual + "]");
            }
        }
        if (allOk) {
            console.log("ALL OK");
        }
};


var testCases = [
    ["/\|\\", "/\|\\"],
    ["__\\", "__\\"],
    ["/__", "/__"],
    ["__\\\\", "__\\\\"],
    ["//__", "//__"],
    ["//\|\\\\", "//\|\\\\"],
    ["//__\|__\\\\", "//__\|__\\\\"],
    ["/ \\", "__\\"],
    ["///\|\\\\\\`", "///\|\\\\\\`"],
    ["\| \\\\", "\|__\\"],
    ["// \|", "/__\|"],
    ["\|/ \\\|/ \\\|/ \\\|/ \\\|", "\|__\\\|__\\\|__\\\|__\\\|"],
    ["/\|\|\|\|", "////__"],
    ["/\| /\|", "/__/__"],
    ["/\|\|\\", "//\\\\"]
];

test(testCases);