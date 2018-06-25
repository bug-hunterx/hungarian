function f(storyboard) {
    var lives = 2;
    var coins = 0;
    var superM = false;
    var invulnerability = 0;
    var endMessage = '';
    
    var log = function(m) {
        console.log(m)
    };
    
    var processElement = function(element) {
        var result = true;
        if (element) {
            if(element === 'Princess' || element === 'Bowser'){
                endMessage = "WIN";
                result = false
            } else if(invulnerability <= 0 && (element === 'goomba' || element === 'koopa' || element === 'piranha')){
                // console.log(superM)
                if(!superM){
                    lives--
                } else {
                    superM = false
                }
                if (lives < 0) {
                    endMessage = "GAME OVER";
                    result = false
                }
            } else if(element === 'Mushroom'){
                superM = true
            } else if(element === 'Star'){
                invulnerability=3
            } else if(element === '1Up'){
                lives++
            } else if (parseInt(element)){
                coins+=parseInt(element);
                if(coins >= 100){
                    lives+=(coins/100).toFixed();
                    coins-=coins%100
                }
            }
        } else {
            result = false
        }
        invulnerability--;
        return result;
    };
    
    var elements = storyboard.split(' ');
    var valid = elements.filter(e=>e);
    var alive = true;
    var i = 0;
    while (alive) {
        alive = processElement(valid[i++])
    }
    log(endMessage ? endMessage : "???")
}