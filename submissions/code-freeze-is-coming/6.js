function f(cost){
        var final = 0;
    var tip = 0;
    var response = '';
    if(cost < 2000){
        final = Math.ceil(cost/100)*100;
    }else if(cost < 5000){
        final = Math.ceil(cost/500)*500;
    }else{
        final = Math.round(Math.floor(cost*1.1)/500)*500;
    }
    tip = final-cost;
    if(tip > 0 && tip <= 1500){
        if((tip % 100) !== 0){
        response = 'KEEP THE CHANGE YOU FILTY ANIMAL'
      } else {
        response = 'HERE IS ' + final; 
      }
    } else {
        response = 'PAID BY CARD'
    }
    console.log(response);
}