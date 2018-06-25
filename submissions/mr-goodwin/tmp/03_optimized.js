
function f(a) {

    function decoding(encString,dictionary){
        var str = encString;
        var out2 = [];
        var count = 0;
        var dict = dictionary;

        for(i=0; i<encString.length;i++){
            out2[i] = dict[encString[i]];
        }

        return out2;

    }

    //var dict = "Ghostbusters\nIf|there's|something|strange\nIn|you|neighborhood\nWho|gonna|call\nGhostbusters\nIf|weird\nAnd|it|don't|look|good\nWho|call\nGhostbusters\n\nI|ain't|afraid|of|no|ghost\nI|ghost\n\nIf|you're|seeing|things\nRunning|through|your|head\nWho|can|call\nGhostbusters\nAn|invisible|man\nSleeping|in|bed\nWho|ghost\n\nWho|all|alone\nPick|up|the|phone\nAnd|here|likes|girls\nI|ghost\nYeah|yeah|yeah\n\nWho|ya|call\nGhostbusters\n\nIf|you've|had|a|dose|a\nFreaky|ghost|baby\nYou|better|call\nGhostbusters\n\nLemme|tell|something\nBustin'|makes|me|feel|good\n\nI|ghost\n\nDon't|get|caught|alone|no\n\nGhostbusters\n\nWhen|comes|door\nUnless|just|want|some|more\nI|think|call\nGhostbusters\n\nWho|can't|hear|you\nWho|call\nGhostbusters\n\nLouder\nGhostbusters\n\nWho|call\nGhostbusters".split('|');
    var dict = ["Ghostbusters\nIf","there's","something","strange\nIn","you","neighborhood\nWho","gonna","call\nGhostbusters\nIf","weird\nAnd","it","don't","look","good\nWho","call\nGhostbusters\n\nI","ain't","afraid","of","no","ghost\nI","ghost\n\nIf","you're","seeing","things\nRunning","through","your","head\nWho","can","call\nGhostbusters\nAn","invisible","man\nSleeping","in","bed\nWho","ghost\n\nWho","all","alone\nPick","up","the","phone\nAnd","here","likes","girls\nI","ghost\nYeah","yeah","yeah\n\nWho","ya","call\nGhostbusters\n\nIf","you've","had","a","dose","a\nFreaky","ghost","baby\nYou","better","call\nGhostbusters\n\nLemme","tell","something\nBustin'","makes","me","feel","good\n\nI","ghost\n\nDon't","get","caught","alone","no\n\nGhostbusters\n\nWhen","comes","door\nUnless","just","want","some","more\nI","think","call\nGhostbusters\n\nWho","can't","hear","you\nWho","call\nGhostbusters\n\nLouder\nGhostbusters\n\nWho","call\nGhostbusters\n"];
    var enc = [0,1,2,3,4,5,4,6,7,1,2,8,9,10,11,12,4,6,13,14,15,16,17,18,14,15,16,17,19,20,21,22,23,24,25,26,4,27,28,29,30,24,31,4,6,13,14,15,16,17,18,14,15,16,17,32,4,6,7,20,33,34,35,36,37,13,14,15,16,17,18,38,9,39,36,40,14,15,16,17,41,42,42,43,44,6,45,46,47,48,49,16,50,51,52,53,54,55,44,56,57,58,59,60,14,15,16,17,18,14,15,16,17,61,62,63,64,17,65,9,66,23,24,67,4,68,69,70,71,72,4,53,73,44,6,73,44,6,13,72,4,53,73,44,6,13,74,75,76,44,6,77,44,6,73,26,44,73,44,6,78];
    var output = decoding(enc,dict);
    var result = output.join(" ");
    console.log(result);
}
