function f(s) {
    s=(s.replace(/\s\s+/g, ' ')).split(" ");
    mario = {life:3, coins:0, mode:0, invulnerability:0};
    end=0;
    c=console;
    for(n of s){
        if(n == "Bowser" || n == "Princess"){
            c.log("WIN");end++;break;
        }
        if(n == "1Up")mario.life++;
        if(n == "Mushroom")mario.mode=1;
        if(mario.invulnerability)mario.invulnerability--;
        if(n == "Star")mario.invulnerability=3;
        if("goombakoopapiranha".indexOf(n)>-1 && !mario.invulnerability) {
            if(mario.mode) mario.mode--;
            else mario.life--;
            if(!mario.life){
                c.log("GAME OVER");end++;break;
            }
        }
        if("0123456789".indexOf(n[0])>-1 && n != "1Up") mario.coins+=parseInt(n);
        if(mario.coins>100)mario.life+=(mario.coins-(mario.coins%100))/100;;
        mario.coins%=100;
    }
    if(!end)c.log("???");
}

/*
 function test() {
 f("piranha Princess piranha");
 f("1Up koopa goomba piranha Bowser");
 f("Star Mushroom  piranha goomba piranha goomba Princess");
 f(" piranha piranha piranha piranha");
 f("piranha piranha Star goomba goomba Princess");
 f("10 40 koopa goomba 20 30 piranha piranha");
 f("4400 40 21 koopa koopa koopa               koopa koopa goomba 20 30 piranha piranha");
 }
 test();
 */
/*
 @hackathonbot: show challenge 9
 @hackathonbot: test /solutionsJS/ch09_min.js 9
 @hackathonbot: test /solutionsJS/ch09.js 9
 */
