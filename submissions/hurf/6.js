function f(cost) {
    if (cost < 2000) {
        tip = Math.ceil(cost / 100) * 100;
    } else if (cost < 5000) {
        tip = Math.ceil(cost / 500) * 500;
    } else {
        tip = Math.round(Math.floor(cost * 1.1) / 500) * 500;
    }
    tip -= cost;
    //console.log(tip);
    if(tip == 0 || tip > 1500) {
        answer = "PAID BY CARD";
    } else if(tip%100 !== 0) {
        answer = "KEEP THE CHANGE YOU FILTY ANIMAL";
    } else {
        answer = "HERE IS " + (cost+tip);
    }
    console.log(answer);
};