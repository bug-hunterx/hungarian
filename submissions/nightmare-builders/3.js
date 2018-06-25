function f(){
var s = "Ghostbuăers\nIf thĈe's someďingĕtraĜeċn you neighborāod\nWāĦĨ gonna call\nĀĂĄĆtĈĊČĎĐrĒĔĖĘĚĜ wĬrĵAnd it dĽ'ŢlookĻũĵķoĹĩļľŀłńņāăąćĉ\nċ aěŦƀfĠişočnŰĮňſƁnƃaƅƁƈƊƌŹtžŎħu'őĕeĬŗŖgĊRuľěĝďrĨĮűr ĐaŮĸłĥƝŁŃŅŇźŊŌ\nŝŠnvisible mġ\nSǋepƫǄƱ beƶŰƺųĿƻŷƾŉżĊƏƂŢƓƆƖĪƘƎIƀǧƄǪ ƉǬĻƙžůűŬŴǠƽƙŻŋŽƜĨƟǌƼƀŨī\nPicūupŏǌpāȋŝşŶǿňȁǁǦƑǨƔƇǴƗǷǮƳđŠŧikeĔďǌgirlōǰȠǲƕȤǶƍă\nYeahĦɁɃyɅɄɂǹĸyŀǞŵƼŸȜǀŽċčƝ'vǌhƵƀţĂǌǵa\nFőakyȦăǘabyȿĺǙtȂǾɒƿǤžLemĘĎeńĦŀŔęhƫ\nBŊƂǍɧȮǍǌfƢlŬĴƛȷƒȢǫƋɪƚǯƐʗǳǵʚȽƚ\nDťŢgęƻuĮǨȊǌʚƋžǢȝɕķeĥšŁėʍƭƯɆĨƲŤı\nUnǋsĔƺjŊŘġŢʃǍıģǯŖūƺɲɴȚɶǣȂǥǺɍǼǟ˛ʴɔ˟ɌɎĽˣɑ˥ɸſ˖ǻ˙Ĉɵ˭˞ɋǜ˩ǽˤȀ˦ʕƸƃƴƲƝĶ˨ˢɐǡ˼ˮLĨdĈ˜ʵ˧˸̆˴̉˶̄ŰƸʁ̔ɓˮˠ˹˫̜̈˶";

	var dict = {};
    var data = (s + "").split("");
    var currChar = data[0];
    var oldPhrase = currChar;
    var out = [currChar];
    var code = 256;
    var phrase;
    for (var i=1; i<data.length; i++) {
        var currCode = data[i].charCodeAt(0);
        if (currCode < 256) {
            phrase = data[i];
        }
        else {
           phrase = dict[currCode] ? dict[currCode] : (oldPhrase + currChar);
        }
        out.push(phrase);
        currChar = phrase.charAt(0);
        dict[code] = oldPhrase + currChar;
        code++;
        oldPhrase = phrase;
    }
    console.log(out.join(""));
}    
	