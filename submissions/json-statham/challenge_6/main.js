function f(cost) {
    function round(y) {
        return Math.ceil(cost/y)*y;
    }
    
    function log (message) {
        console.log(message);
    }
    
    function printResult(totalAmount) {
        var tip = totalAmount - cost;
        if (tip == 0 || tip > 1500){
            log("PAID BY CARD");
        } else if (tip % 100 != 0) {
            log("KEEP THE CHANGE YOU FILTY ANIMAL");
        } else{
            log("HERE IS "+totalAmount);
        }
    }
    
    function calculateTip(){
        x = parseInt(cost * 1.1);
        y = 500;
        return (x % y) >= (y/2) ? parseInt(x / y) * y + y : parseInt(x / y) * y;
        
    }
    if (cost<2000) 
        printResult(round(100));
     else if (cost < 5000) 
        printResult(round(500));
     else {
        printResult(calculateTip());
        
    }

}