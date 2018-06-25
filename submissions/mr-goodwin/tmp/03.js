
function f(a) {

    var lyrics = "Ghostbusters\nIf there's something strange\nIn you neighborhood\nWho you gonna call\nGhostbusters\nIf there's something weird\nAnd it don't look good\nWho you gonna call\nGhostbusters\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nIf you're seeing things\nRunning through your head\nWho can you call\nGhostbusters\nAn invisible man\nSleeping in your bed\nWho you gonna call\nGhostbusters\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nWho you gonna call\nGhostbusters\nIf you're all alone\nPick up the phone\nAnd call\nGhostbusters\n\nI ain't afraid of no ghost\nI here it likes the girls\nI ain't afraid of no ghost\nYeah yeah yeah yeah\n\nWho ya gonna call\nGhostbusters\n\nIf you've had a dose of a\nFreaky ghost baby\nYou better call\nGhostbusters\n\nLemme tell ya something\nBustin' makes me feel good\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nDon't get caught alone no no\n\nGhostbusters\n\nWhen it comes through your door\nUnless you just want some more\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI can't hear you\nWho ya gonna call\nGhostbusters\n\nLouder\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho can ya call\nGhostbusters\n\nWho ya gonna call\nGhostbusters";

    //var mockedLyrics = "1\nIf there's something strange\nIn you neighborhood\nWho you gonna call\n1\nIf there's something weird\nAnd it don't look good\nWho you gonna call\n1\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nIf you're seeing things\nRunning through your head\nWho can you call\n1\nAn invisible man\nSleeping in your bed\nWho you gonna call\n1\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nWho you gonna call\n1\nIf you're all alone\nPick up the phone\nAnd call\n1\n\nI ain't afraid of no ghost\nI here it likes the girls\nI ain't afraid of no ghost\nYeah yeah yeah yeah\n\nWho ya gonna call\n1\n\nIf you've had a dose of a\nFreaky ghost baby\nYou better call\n1\n\nLemme tell ya something\nBustin' makes me feel good\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nDon't get caught alone no no\n\n1\n\nWhen it comes through your door\nUnless you just want some more\nI think you better call\n1\n\nWho ya gonna call\n1\n\nWho ya gonna call\n1\n\nI think you better call\n1\n\nWho ya gonna call\n1\n\nI can't hear you\nWho ya gonna call\n1\n\nLouder\n1\n\nWho ya gonna call\n1\n\nWho can ya call\n1\n\nWho ya gonna call\n1";
    //var dict=['\nGhostbusters\n\n']
    //var result = mockedLyrics.replace(/1/g, dict[0]);
    //console.log(result)

    function createDictionary (lyrics) {

        var str = lyrics;
        var target = "\n";
        var dict = [];
        var tempDict = [];
        tempDict.length = 200;
        var count = 0;

        var pos = 0;

        while (true) {
            var foundPos = str.indexOf(target, pos);
            //console.log("pos" + pos);
            //console.log("foundPos " + foundPos);
            if (foundPos == -1){
                //console.log(str.substring(pos));
                tempDict[count] = str.substring(pos);
                //console.log("tempDict[count] " + tempDict[count]);
                break;
            }
            if(str.substring(pos,foundPos) !== "" && str.substring(pos,foundPos) !== "undefined"){
                tempDict[count] = str.substring(pos,foundPos);
                count++;
            }

            pos = foundPos + 1;
        }
        //console.log(tempDict)
        function uniqueArray (arr){
            var x,
                len=arr.length,
                out=[],
                obj={};

            for (x=0; x<len; x++) {
                obj[arr[x]]=0;
            }
            for (x in obj) {
                if(x !== "undefined"){out.push(x);}
            }
            return out;
        }
        //console.log(tempDict);
        dict = uniqueArray(tempDict);

        //console.log("dict.length " + dict.length)
        //console.log("dict[15] " + dict[15])
        //console.log(dict);
        return dict;
    }
    function encoding(lyrics){
        var str = lyrics;
        var target = " ";
        var inp = [];
        var count = 0;
        var dict = createDictionary(str);
        //console.log("Encoding dict[23] " + dict[23]);


        var pos = 0;
        while (true) {
            var foundPos = str.indexOf(target, pos);
            if (foundPos == -1){
                for(i=0; i<dict.length; i++){
                    if(str.substring(pos) !== "" && str.substring(pos) == dict[i]){
                        inp[count] = i;
                        count++;
                    }
                }
                break;
            }
            for(i=0; i<dict.length; i++){
                if(str.substring(pos,foundPos) !== "" && str.substring(pos,foundPos) == dict[i]){
                    inp[count] = i;
                    count++;
                }
            }
            pos = foundPos + 1;
        }
        //console.log("inp[45] " + inp);
        return inp;
    }
    function decoding(encString,dictionary){
        var str = encString;
        var out2 = [];
        var count = 0;
        var dict = dictionary;
        //console.log("1 " + str);
        //console.log("2 " + dict);


        for(i=0; i<encString.length;i++){
            out2[i] = dict[encString[i]];
        }

        //console.log("out2.length" + out2.length);


        return out2;

    }



    var dict = createDictionary(lyrics);
    var enc = encoding(lyrics);
    var output = decoding(enc,dict);
    var result = output.join(" ");
    console.log(lyrics);
    //return result

    var fs = require('fs');
    fs.writeFile("tmp/dict", JSON.stringify(dict), function(err) {
        if(err) {
            return console.log(err);
        }

        console.log("The file was saved!");
    });

    fs.writeFile("tmp/compressed", JSON.stringify(enc), function(err) {
        if(err) {
            return console.log(err);
        }

        console.log("The file was saved!");
    });

}

f()

//console.log(f() == lyrics2)