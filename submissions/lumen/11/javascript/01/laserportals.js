function f(input) {
    var board,
        numberOfTargets = 0,
        gates = [],
        turrets = [],
        xmax,
        ymax,
        actualTurret,
        blastHappened;

    board = input.split('\n').map(function (row, y) {
        return row.split('').map(function (elem, x) {
            var elemObj = {
                    obj: elem,
                    isSpace: elem === '@' || elem === ' ',

                    beenHere: false
                },
                gateNumber = parseInt(elem);

            if (elemObj.isSpace) {
                elemObj.beenHere = false;
            }

            if (!isNaN(gateNumber)) {
                if (!gates[gateNumber]) {
                    gates[gateNumber] = [];
                }

                gates[gateNumber].push({'x': x, 'y': y});
                elemObj.obj = gateNumber;
                elemObj.isGate = true;
            }

            switch (elem) {
                case '@':
                    elemObj.isTarget = true;
                    numberOfTargets++;
                    break;
                case '#':
                    elemObj.isCube = true;
                    break;
                case '<':
                case '>':
                case '^':
                case 'v':
                    turrets.push({ 'x': x, 'y': y });
                    elemObj.isTurret = true;
                    break;
                case '/':
                case '\\':
                    elemObj.isMirror = true;
                    break;
            }

            return elemObj;
        });
    });

    xmax = board[0].length - 1;
    ymax = board.length - 1;

    for (var i = 0; i < turrets.length && !blastHappened && numberOfTargets > 0; i++ ) {
        actualTurret = turrets[i];
        followThroughBeam(actualTurret.x, actualTurret.y, board[actualTurret.y][actualTurret.x].obj, false, actualTurret.x, actualTurret.y);
    }



    function followThroughBeam(currentX, currentY, direction, wasGateBefore, startX, startY) {
        var nextPosition,
            currentElem = board[currentY][currentX];

        if (currentElem.isTarget) {
            numberOfTargets--;
        }

        if (currentElem.isSpace) {
            if (currentElem.beenHere) {
                blastHappened = true;
                return;
            }
            currentElem.beenHere = true;
        }

        nextPosition = getNextPosition(currentX, currentY, direction, wasGateBefore, startX, startY);

        if (nextPosition) {
            followThroughBeam(nextPosition.x, nextPosition.y, nextPosition.direction, nextPosition.wasGateBefore, startX, startY);
        }
    }

    function getNextPosition(currentX, currentY, direction, wasGateBefore, startX, startY) {
        var nextX = currentX,
            nextY = currentY,
            newDirection = direction,
            currentElem = board[currentY][currentX],
            isGate = currentElem.isGate;

        if (currentElem.isCube || (currentElem.isTurret && currentX !== startX && currentY != startY)) {
            return false;
        } else if (currentElem.isMirror) {
            switch (direction) {
                case 'v':
                    if (currentElem.obj === '/') {
                        nextX--;
                        newDirection = '<';
                    } else {
                        nextX++;
                        newDirection = '>'
                    }
                    break;
                case '^':
                    if (currentElem.obj === '/') {
                        nextX++;
                        newDirection = '>';
                    } else {
                        nextX--;
                        newDirection = '<'
                    }
                    break;
                case '>':
                    if (currentElem.obj === '/') {
                        nextY--;
                        newDirection = '^';
                    } else {
                        nextY++;
                        newDirection = 'v'
                    }
                    break;
                case '<':
                    if (currentElem.obj === '/') {
                        nextY++;
                        newDirection = 'v';
                    } else {
                        nextY--;
                        newDirection = '^'
                    }
                    break;
            }
        } else if (currentElem.isGate) {
            if (wasGateBefore) {
                switch (direction) {
                    case 'v': nextY++;
                        break;
                    case '^': nextY--;
                        break;
                    case '>': nextX++;
                        break;
                    case '<': nextX--;
                        break;
                }
            } else {
                // look up other gate
                if (currentX === gates[currentElem.obj][0].x && currentY === gates[currentElem.obj][0].y) {
                    nextX = gates[currentElem.obj][1].x;
                    nextY = gates[currentElem.obj][1].y;
                } else {
                    nextX = gates[currentElem.obj][0].x;
                    nextY = gates[currentElem.obj][0].y;
                }
                // TODO: wasGatebefore handling
            }
        } else {
            switch (direction) {
                case 'v': nextY++;
                    break;
                case '^': nextY--;
                    break;
                case '>': nextX++;
                    break;
                case '<': nextX--;
                    break;
            }
        }

        if (nextX < 0 || nextX > xmax || nextY < 0 || nextY > ymax) {
            return false;
        } else {
            return {
                x: nextX,
                y: nextY,
                wasGateBefore: isGate,
                direction: newDirection
            };
        }

    }

    console.log(blastHappened ? ':/' : (numberOfTargets === 0 ? ':D' : ':('));
    return blastHappened ? ':/' : (numberOfTargets === 0 ? ':D' : ':(');
}
