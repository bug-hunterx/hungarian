

var fs = require('fs');


function f() {

    var words = "Ghostbusters/If/there's/something/strange/In/you/neighborhood/Who/gonna/call/weird/And/it/don't/look/good/I/ain't/afraid/of/no/ghost/you're/seeing/things/Running/through/your/head/can/An/invisible/man/Sleeping/in/bed/all/alone/Pick/up/the/phone/here/likes/girls/Yeah/yeah/ya/you've/had/a/dose/Freaky/baby/You/better/Lemme/tell/Bustin'/makes/me/feel/Don't/get/caught/When/comes/door/Unless/just/want/some/more/think/can't/hear/Louder".split('/');

    //var key = "00++01020304++050607++08060910++00++01020311++1213141516++08060910++00++||171819202122++171819202122++||01232425++26272829++08300610++00++313233++34352836++08060910++00++||171819202122++171819202122++||08060910++00++01233738++39404142++1210++00++||171819202122++174313444145++171819202122++46474747++||08480910++00++||01495051522051++532254++555610++00++||57584803++5960616216++||171819202122++171819202122++||636465382121++||00++||661367272868++690670717273++1774065610++00++||08480910++00++||08480910++00++||1774065610++00++||08480910++00++||17757606++08480910++00++||77++00++||08480910++00++||08304810++00++||08480910++00++";

    var output = '';
    /*for (var i = 0; i < key.length-2; i+=2) {

        var actual = Number(key[i] + key[i+1]);
        if (isNaN(actual)) {
            if (key[i] + key[i+1] == '++') {
                output+='\n';
            } else if (key[i] + key[i+1] == '||'){
                output+='\n';
            }
        } else {


            if (key[i+2] + key[i+3] == '++') {
                output+=words[Number(key[i] + key[i+1])];
            } else {
                output+=words[Number(key[i] + key[i+1])] + ' ';
            }
        }


    }*/



    console.log(output);

    //fs.writeFile("output.txt", output);
}

f();


var words = "Ghostbusters/If/there's/something/strange/In/you/neighborhood/Who/gonna/call/weird/And/it/don't/look/good/I/ain't/afraid/of/no/ghost/you're/seeing/things/Running/through/your/head/can/An/invisible/man/Sleeping/in/bed/all/alone/Pick/up/the/phone/here/likes/girls/Yeah/yeah/ya/you've/had/a/dose/Freaky/baby/You/better/Lemme/tell/Bustin'/makes/me/feel/Don't/get/caught/When/comes/door/Unless/just/want/some/more/think/can't/hear/Louder".split('/');
filename = 'text.txt';
var code = '';
fs.readFile(filename, 'utf8', function (err, data) {
    if (err) throw err;
    var sep = '!';
    var min = 65;
    var max = 90;
    var act = 65;
    var double = false;

    data.split('\r\n\r\n').forEach(function (item, index) {

        item.split('\r\n').forEach(function (sub) {
            sub.split(' ').forEach(function (word) {
                //code += words.indexOf(word) < 10 ? '0' + words.indexOf(word) : words.indexOf(word);
                console.log(words.length);



                if (act <= max && !double) {
                    code += String.fromCharCode(act);
                    act++;

                    if (act == max) {
                        double = true;
                        act = min;
                    }

                } else {
                    code += String.fromCharCode(act) +'' + String.fromCharCode(act);
                    act++;
                }

            })
            //console.log('***************');
            code+= sep;
            //code+='++';
        })


        code+= sep;
        //code+= '--';
        //console.log('-------------------');
    })
    //console.log(code);
    //console.log(code.length);


    fs.writeFile('code.txt', code);
});
