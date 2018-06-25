
function f() {
    //console.log(
    return    "23strange\nIn@ neighborhood13weird\nAnd#don't look good1\n4\n4\n\n5seeing things\nRunning0head\nWho can@72An invisible man\nSleeping in@r bed1\n4\n4\n15all alone\nPick up the phone\nAnd72\n4\nI here#likes the girls\n4\nYeah yeah yeah yeah\n62\nIf@'ve had a dose of a\nFreaky ghost baby\nYou better72\nLemme tell ya something\nBustin' makes me feel good\n\n4\n4\n\nDon't get caught alone no no\n\n2\nWhen#comes0door\nUnless@ just want some more\n8726262\n87262\nI can't hear@62\nLouder\n262\nWho can ya7262"
        .replace(/1/g, '\nWho you gonna call\nGhostbusters\n')
        .replace(/2/g, 'Ghostbusters\n')
        .replace(/3/g, 'If there\'s something ')
        .replace(/4/g, 'I ain\'t afraid of no ghost')
        .replace(/5/g, 'If you\'re ')
        .replace(/6/g, '\nWho ya gonna call\n')
        .replace(/7/g, ' call\n')
        .replace(/8/g, 'I think you better')
        .replace(/9/g, 'good')
        .replace(/0/g, ' through your ')
        .replace(/@/g, ' you')
        .replace(/#/g, ' it ')

    //);

}

var lyrics = "Ghostbusters\nIf there's something strange\nIn you neighborhood\nWho you gonna call\nGhostbusters\nIf there's something weird\nAnd it don't look good\nWho you gonna call\nGhostbusters\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nIf you're seeing things\nRunning through your head\nWho can you call\nGhostbusters\nAn invisible man\nSleeping in your bed\nWho you gonna call\nGhostbusters\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nWho you gonna call\nGhostbusters\nIf you're all alone\nPick up the phone\nAnd call\nGhostbusters\n\nI ain't afraid of no ghost\nI here it likes the girls\nI ain't afraid of no ghost\nYeah yeah yeah yeah\n\nWho ya gonna call\nGhostbusters\n\nIf you've had a dose of a\nFreaky ghost baby\nYou better call\nGhostbusters\n\nLemme tell ya something\nBustin' makes me feel good\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nDon't get caught alone no no\n\nGhostbusters\n\nWhen it comes through your door\nUnless you just want some more\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI can't hear you\nWho ya gonna call\nGhostbusters\n\nLouder\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho can ya call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n";
console.log(f()==lyrics)