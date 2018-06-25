function f(text, cols, width) {

    var blockSize = cols * width;
    var mod = (text.length % blockSize);
    var padding = text.length ? (mod ? blockSize - mod : 0) : blockSize;

    //console.log('original length:', text.length, ' blockSize: ', blockSize, ' padding: ', padding)

    text = text + new Array(padding+1).join(' ');
    //console.log(text)

    // fill the end with spaces - tested, OK
    var re = new RegExp(".{1," + width + "}", "g");
    var splitted = text.match(re, "g");
    //splitted = splitted? splitted : ''
    //console.log('splitted: ', splitted)

    // split to smaller arrays:
    var finalArr = []
    var rows = splitted.length/cols
    //console.log("rows: ", rows, ' cols:', cols)
    while (splitted.length) {
        finalArr.push(splitted.splice(0, rows));
    }

    //console.log(finalArr)

    var res = []

    for (var i = 0; i < rows; i++) {
        //console.log('i:', i)
        var lineArr = finalArr.map(function (row) {
            //console.log(row[i])
            return row[i];
        })
        res.push(lineArr.join('|'));
    }

    console.log(res.join('\n'));
    //return res.join('\n');
}

/*
var test = [
    ['', 3, 4, '    |    |    '],
    ['Results, Relentlessly', 3, 4, 'Resu| Rel|essl\nlts,|entl|y   '],
    ['Results, Relentlesslya', 3, 4, 'Resu| Rel|essl\nlts,|entl|ya  '],
    ['Results, Relentlesslyaa', 3, 4, 'Resu| Rel|essl\nlts,|entl|yaa '],
    ['Results, Relentlesslyaaa', 3, 4, 'Resu| Rel|essl\nlts,|entl|yaaa'],
    ['Results, Relentlesslyaaaa', 3, 4, 'Resu| Rel|essl\nlts,|entl|yaaa\na   |    |    '],
    ['Results, Relentlesslyaaaaa', 3, 4, 'Resu| Rel|essl\nlts,|entl|yaaa\naa  |    |    '],
    ['This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.', 4, 5, 'This |t wit|unnee|...  \nis a |h, a,|ded, |  spa\nlonge| lot,|comma|ces. \nr tex| of, |. And|     \n'],
    //['This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.fsssssssssssss', 4, 8, 'This |t wit|unnee|...  \nis a |h, a,|ded, |  spa\nlonge| lot,|comma|ces. \nr tex| of, |. And|     \n']
];


test.forEach(function (testCase, i) {
    var result = f(testCase[0], testCase[1], testCase[2]);
    var success = (testCase[3] == result);
    if (success){
        console.log(i, '-> ok');
    } else {
        console.log(testCase[0] + ', ' + testCase[1] + ', ' + testCase[2] + ' -> ' + (testCase[3] == result));
        console.log('#' + result + '#')
    }
    //toFile( 'tmp/1', result)
    //toFile( 'tmp/2', testCase[3])
});



function toFile(fileName, str) {
    var fs = require('fs');
    fs.writeFile(fileName, str, function (err) {
        if (err) {
            return console.log(err);
        }

        console.log("The file was saved!");
    });
}

*/
