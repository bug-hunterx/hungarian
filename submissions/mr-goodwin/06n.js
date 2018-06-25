//var cost = [0, 100, 15000, 1199, 1999, 6185, 6288, 2800, 2500, 150, 2000, 5000, 2001, 5001, 5111, 5222, 5250, 6250, 16511, 16600];

function f(cost) {

    var tip = 0;

    if (cost < 2000) {
        var rounding = cost % 100;
        tip = rounding ? 100-rounding : 0;
    } else if (cost < 5000) {
        var rounding = cost % 500;
        tip = rounding ? 500-rounding : 0;
    } else {
        tip = Math.trunc(0.1 * cost)

        var rounding = ((cost+tip) % 500);
        //console.log('tip: ', tip)
        //console.log('rounding: ', rounding)
        tip = rounding < 250 ? tip-rounding : tip+(500-rounding);
    }

    //console.log('tip: ', tip)

    if (tip === 0 || tip > 1500){
        console.log("PAID BY CARD")
    } else if (tip % 100 > 0){
        console.log("KEEP THE CHANGE YOU FILTY ANIMAL")
    } else console.log("HERE IS " + (cost+tip));

    //return (cost+tip)
}

//for (t = 0; t < cost.length; t++) {
//    console.log(cost[t], " => ", f(cost[t]));
//    console.log('********************');
//}
