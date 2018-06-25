function f(a) {

    //console.log("unique: ", a, '->', unique);

    // 2. split by keyboard row
    var kbdRows = [
        '`1234567890-=~!@#$%^&*()_+',
        'qwertyuiop[]\\QWERTYUIOP{}|',
        'asdfghjkl;\'ASDFGHJKL:"',
        'zxcvbnm,./ZXCVBNM<>?',
        //' ',
    ];

    var splitted = kbdRows.map(getSplittedByKeyboardRow);

    function getSplittedByKeyboardRow(row){
        var filteredRow = a.split('').filter(function(n) {
            return row.indexOf(n) != -1
        });
        return filteredRow.sort(function(n){return row.indexOf(n)});
    }

    // remove empty row elements
    //splitted = splitted.filter(function(n){return .length>0)
    splitted = splitted.map(function (row, index){
            return {row: row, index:index}
    }).filter(function(n){return n.row.length>0})
    //console.log("splitted: ", splitted);

    // 3. sort by length

    var sorted = splitted.sort(function(a, b){return a.row.length - b.row.length});
    //console.log("sorted: ", sorted);

    // 4. solve tie problems
    var orderedShortestRows = splitted
            .filter(function(n){return n.row.length == sorted[0].row.length})
            .sort(function(n){return n.row.index});

    if(orderedShortestRows.length>1){
            orderedShortestRows.forEach(function(n){
            n.row = n.row.filter(function (item, i, ar) {
                return ar.indexOf(item) === i;
            });
        });
        //console.log(orderedShortestRows)
    }

    var finalShortest = orderedShortestRows.reduce(function(lowest, next, index) {
            return next.row.length < lowest.row.length ? next : (next.index < lowest.index ? next : lowest);
        });
    //console.log('reordered Rows: ', orderedShortestRows);
    //finalShortest = finalShortest;

    //console.log(finalShortest)

    var reorderedShortestRow = finalShortest.row.sort(
            function(a, b){
                return kbdRows[finalShortest.index].indexOf(a) - kbdRows[finalShortest.index].indexOf(b)
            })
        .join('')
        .replace(/(\w)\1+/g, function (str, match) {
            return match[0]
        })
        //.replace(/(.)\1/gi, "");

    //console.log(reorderedShortestRow)
    // 5. sort the "winner" inside
    // the sort is implemented in the getSplittedByKeyboardRow

    // 6. remove duplicates
    // 7. print it
    //return reorderedShortestRow.join('');

    console.log(reorderedShortestRow);

    return reorderedShortestRow
}


// TEST DATA
//

var t1 = 'FJAFJKLDSKF7JKFDJ';
var e1 = '7';
var t2 = 'ASDFDSASDFDSAzxcPOIUY';
var e2 = 'zxc';
var t3 = 'qwERfgHJ123456789';
var e3 = 'qwER';
var t4 = 'FGhjKL:"\';lkqwerzxcc';
var e4 = 'zxc';
var t5 = 'ASDFASDFqwer432!';
var e5 = '234!';
var t6 = 'EUIyouiepIEjhadSDJ(*Y9y9';
var e6 = '9*(';
var t7 = '1233AERSdfqw';
var e7 = '123';
var t8 = 'ASDF11!*&+1';
var e8 = 'ASDF';
var t9 = '}*3%&2098@$2k234#@$M';
var e9 = '}';
var t10 = 'wqfdSREA3321';
var e10 = '123';
var t11 = ':X:D:):DDDDDDDxDDDD:(;);];]';
var e11 = ']';

console.log( '------------------------------------------------')
console.log( t1 + '*** -> ', e1, f(t1), e1==f(t1));
console.log( t2 + '*** -> ', e2, f(t2), e2==f(t2));
console.log( t3 + '*** -> ', e3, f(t3), e3==f(t3));
console.log( t4 + '*** -> ', e4, f(t4), e4==f(t4));
console.log( t5 + '*** -> ', e5, f(t5), e5==f(t5));
console.log( t6 + '*** -> ', e6, f(t6), e6==f(t6));
console.log( t7 + '*** -> ', e7, f(t7), e7==f(t7));
console.log( t8 + '*** -> ', e8, f(t8), e8==f(t8));
console.log( t9 + '*** -> ', e9, f(t9), e9==f(t9));
console.log( t10 + '*** -> ', e10, f(t10), e10==f(t10));
console.log( t11 + '*** -> ', e11, f(t11), e11==f(t11));
