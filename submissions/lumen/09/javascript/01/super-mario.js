function f(input) {
    var result,
        storyline = input.split(' '),
        coins = 0,
        lifes = 3,
        invulnerableStepsLeft = 0,
        isInSuperMode = false,
        goal = function () {
            if (lifes > 0) {
                result = 'WIN';
            }
        },
        enemy = function (){
            if (invulnerableStepsLeft > 0) {
                invulnerableStepsLeft--;
            } else {
                if (isInSuperMode) {
                    isInSuperMode = false;
                } else {
                    lifes--;
                    if (lifes < 1) {
                        result = "GAME OVER";
                    }
                }
            }
        },
        actions = {
            '1Up': function () {
                lifes++;
                if (invulnerableStepsLeft > 0) {
                    invulnerableStepsLeft--;
                }
            },
            'Star': function () {
                if (invulnerableStepsLeft > 0) {
                    invulnerableStepsLeft--;
                }
                invulnerableStepsLeft += 2;
            },
            'Mushroom': function() {
                isInSuperMode = true;
                if (invulnerableStepsLeft > 0) {
                    invulnerableStepsLeft--;
                }
            },
            'earnCoins': function(amount) {
                var earnedLifes;
                if (!isNaN(amount)) {
                    coins += amount;
                    if (coins > 100) {
                        earnedLifes = Math.floor(coins / 100);
                        lifes += earnedLifes;
                        coins -= earnedLifes * 100;
                    }
                    if (invulnerableStepsLeft > 0) {
                        invulnerableStepsLeft--;
                    }
                }
            },
            'Bowser': goal,
            'Princess': goal,
            'goomba': enemy,
            'koopa': enemy,
            'piranha': enemy
        };

    storyline.forEach(function (step) {
        if (!result) {
             if (step in actions) {
                 actions[step]();
             } else {
                 actions.earnCoins(parseInt(step, 10));
             }
        }
    });

    console.log(result ? result : '???');
    return result ? result : '???';
}
