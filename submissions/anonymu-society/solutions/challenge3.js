function de(b){var a,e={},d=b.split(""),c=f=d[0],g=[c],h=o=256;for(b=1;b<d.length;b++)a=d[b].charCodeAt(0),a=h>a?d[b]:e[a]?e[a]:f+c,g.push(a),c=a.charAt(0),e[o]=f+c,o++,f=a;return g.join("")}
function f() {
var compressed="Ghostbuăers@If thĈe's someďingĕtraĜeċn you neighborāod@WāĦĨ gonna call@ĀĂĄĆtĈĊČĎĐrĒĔĖĘĚĜ wĬrĵAnd it dĽ'ŢlookĻũĵķoĹĩļľŀłńņāăąćĉċ aěŦſfĠişočnŰĮňžƀnƂaƄƀƇƉƋŹt@ċčħu'őĕeĬŗŖgĊRuľěĝďrĨĮűr ĐaŮĸłĥƝŁŃŅŇźŊŌ@ŝŠnvisible mġ@SǋepƫǄƱ beƶŰƺųĿƻŷƾŉżĊƎƁŢƒƅƕĪƗƍIſǧƃǪ ƈǬĻƘƚůűŬŴǠƽƘŻŋŽŎƝƟǌƼſŨī@PicūupŏǌpāȋŝşŶǿňȁǁǦƐǨƓƆǴƖǷǮƳđŠŧikeĔďǌgirlōǰȠǲƔȤǶƌă@YeahĦɁɃyɅɄɂǹĸyŀǞŵƼŸȜǀŽƛű'vǌhƵſţĂǌǵa@FőakyȦăǘabyȿĺǙtȂǾɒƿǤƚLemĘĎeńĦŀŔęhƫ@BŊƁǍɦȮǍǌfƢlŬĴƚǯƏƑȢǫƊɩƙʕǱǩȺǵʚȽƙ@DťŢgęƻuĮǨȊǌʚƊƚǢȝɕķeĥšŁėʌƭƯɆĨƲŤı@UnǋsĔƺjŊŘġŢʂǍıģǯŖūƺɱɳȚɵǣȂǥǺɍǼǟ˛ʴɔ˟ɌɎĽˣɑ˥ɷž˖ǻ˙Ĉɴ˭˞ɋǜ˩ǽˤȀ˦ʔƻȸƴƲƝĶ˨ˢɐǡ˼ˮLĨdĈ˜ʵ˧˸̆˴̉˶̄ŰƸʀ̔ɓˮˠ˹˫̜̈˶";
var decompressed=de(compressed);
decompressed=decompressed.split("@").join("\n");
console.log(decompressed);
}