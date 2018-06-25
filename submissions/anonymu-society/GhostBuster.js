<p>
GB...<br/><br/>
<script>

function en(c){var x='charCodeAt',b,e={},f=c.split(""),d=[],a=f[0],g=256;for(b=1;b<f.length;b++)c=f[b],null!=e[a+c]?a+=c:(d.push(1<a.length?e[a]:a[x](0)),e[a+c]=g,g++,a=c);d.push(1<a.length?e[a]:a[x](0));for(b=0;b<d.length;b++)d[b]=String.fromCharCode(d[b]);return d.join("")}

function de(b){var a,e={},d=b.split(""),c=f=d[0],g=[c],h=o=256;for(b=1;b<d.length;b++)a=d[b].charCodeAt(0),a=h>a?d[b]:e[a]?e[a]:f+c,g.push(a),c=a.charAt(0),e[o]=f+c,o++,f=a;return g.join("")}

//var lyrics="Ghostbusters\nIf there's something strange\nIn you neighborhood\nWho you gonna call\nGhostbusters\nIf there's something weird\nAnd it don't look good\nWho you gonna call\nGhostbusters\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nIf you're seeing things\nRunning through your head\nWho can you call\nGhostbusters\nAn invisible man\nSleeping in your bed\nWho you gonna call\nGhostbusters\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nWho you gonna call\nGhostbusters\nIf you're all alone\nPick up the phone\nAnd call\nGhostbusters\n\nI ain't afraid of no ghost\nI here it likes the girls\nI ain't afraid of no ghost\nYeah yeah yeah yeah\n\nWho ya gonna call\nGhostbusters\n\nIf you've had a dose of a\nFreaky ghost baby\nYou better call\nGhostbusters\n\nLemme tell ya something\nBustin' makes me feel good\n\nI ain't afraid of no ghost\nI ain't afraid of no ghost\n\nDon't get caught alone no no\n\nGhostbusters\n\nWhen it comes through your door\nUnless you just want some more\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI think you better call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nI can't hear you\nWho ya gonna call\nGhostbusters\n\nLouder\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n\nWho can ya call\nGhostbusters\n\nWho ya gonna call\nGhostbusters\n";
var lyrics="Ghostbusters@If there's something strange@In you neighborhood@Who you gonna call@Ghostbusters@If there's something weird@And it don't look good@Who you gonna call@Ghostbusters@I ain't afraid of no ghost@I ain't afraid of no ghost@@If you're seeing things@Running through your head@Who can you call@Ghostbusters@An invisible man@Sleeping in your bed@Who you gonna call@Ghostbusters@@I ain't afraid of no ghost@I ain't afraid of no ghost@@Who you gonna call@Ghostbusters@If you're all alone@Pick up the phone@And call@Ghostbusters@@I ain't afraid of no ghost@I here it likes the girls@I ain't afraid of no ghost@Yeah yeah yeah yeah@@Who ya gonna call@Ghostbusters@@If you've had a dose of a@Freaky ghost baby@You better call@Ghostbusters@@Lemme tell ya something@Bustin' makes me feel good@@I ain't afraid of no ghost@I ain't afraid of no ghost@@Don't get caught alone no no@@Ghostbusters@@When it comes through your door@Unless you just want some more@I think you better call@Ghostbusters@@Who ya gonna call@Ghostbusters@@Who ya gonna call@Ghostbusters@@I think you better call@Ghostbusters@@Who ya gonna call@Ghostbusters@@I can't hear you@Who ya gonna call@Ghostbusters@@Louder@Ghostbusters@@Who ya gonna call@Ghostbusters@@Who can ya call@Ghostbusters@@Who ya gonna call@Ghostbusters@";
var escLyrics=lyrics;
var compressed=en(escLyrics);

//var compressed="Ghostbuăers If thĈe's someďingĕtraĜeċn you neighborāod WāĦĨ gonna call ĀĂĄĆtĈĊČĎĐrĒĔĖĘĚĜ wĬrĵAnd it dĽ'ŢlookĻũĵķoĹĩļľŀłńņāăąćĉċ aěŦſfĠişočnŰĮňžƀnƂaƄƀƇƉƋŹt ċčħu'őĕeĬŗŖgĊRuľěĝďrĨĮűr ĐaŮĸłĥƝŁŃŅŇźŊŌ ŝŠnvisible mġ SǋepƫǄƱ beƶŰƺųĿƻŷƾŉżĊƎƁŢƒƅƕĪƗƍIſǧƃǪ ƈǬĻƘƚůűŬŴǠƽƘŻŋŽŎƝƟǌƼſŨī PicūupŏǌpāȋŝşŶǿňȁǁǦƐǨƓƆǴƖǷǮƳđŠŧikeĔďǌgirlōǰȠǲƔȤǶƌă YeahĦɁɃyɅɄɂǹĸyŀǞŵƼŸȜǀŽƛű'vǌhƵſţĂǌǵa FőakyȦăǘabyȿĺǙtȂǾɒƿǤƚLemĘĎeńĦŀŔęhƫ BŊƁǍɦȮǍǌfƢlŬĴƚǯƏƑȢǫƊɩƙʕǱǩȺǵʚȽƙ DťŢgęƻuĮǨȊǌʚƊƚǢȝɕķeĥšŁėʌƭƯɆĨƲŤı UnǋsĔƺjŊŘġŢʂǍıģǯŖūƺɱɳȚɵǣȂǥǺɍǼǟ˛ʴɔ˟ɌɎĽˣɑ˥ɷž˖ǻ˙Ĉɴ˭˞ɋǜ˩ǽˤȀ˦ʔƻȸƴƲƝĶ˨ˢɐǡ˼ˮLĨdĈ˜ʵ˧˸̆˴̉˶̄ŰƸʀ̔ɓˮˠ˹˫̜̈˶";

var decompressed=de(compressed);
decompressed=decompressed.split("@").join("\n");

document.writeln('<hr>'+compressed+'<hr><h1>'+compressed.length+' characters versus original '+decompressed.length+' characters.</h1><hr><pre>'+decompressed+'</pre><hr>');

</script>
</p>