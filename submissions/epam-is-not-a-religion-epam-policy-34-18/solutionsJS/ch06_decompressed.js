function f(cost) {
    var amount = 0,
        tip
        c = console;
    if(cost<2000) amount = roundUp(cost, 100);
    else if(cost<5000) amount = roundUp(cost, 500);
    else amount=Math.round(Math.trunc(cost*1.1)/500)*500;
    
    tip = amount-cost;
    if( tip > 1500 || tip == 0) c.log("PAID BY CARD");
    else if (tip % 100 < 100 && tip % 100>0) c.log("KEEP THE CHANGE YOU FILTY ANIMAL");
    else c.log("HERE IS "+amount);
}

function roundUp(v, a){
   return Math.ceil(v/a)*a;
}

function test() {
    f(100);
    f(15000);
    f(1199);
    f(1999);
    f(6185);
    f(6288);
    f(2800);
    f(2500);
}

//if( tip > 1500 || tip == 0) console.log("I PAID BY CARD KTHXBAI"+'\n');
/*
@hackathonbot: show challenge 6
@hackathonbot: test /solutionsJS/ch06.js 6
*/