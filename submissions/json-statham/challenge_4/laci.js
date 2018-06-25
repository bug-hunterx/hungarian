function f(game){
    
    function getMoves(filtMethod) {
        return game.split('').filter(filtMethod).sort().map(e=>parseInt(e));
    }
    
    function isWinner(moves) {
        return winners.some(e=>e.filter(a=>moves.indexOf(a) >= 0).length == 3)
    }
    
    var winners = [[1,2,3],
    [4,5,6],
    [7,8,9],
    [1,4,7],
    [2,5,8],
    [3,6,9],
    [1,5,9],
    [3,5,7]];
    
    var oMoves = getMoves((elem, index) => !(index % 2));
    var xMoves = getMoves((elem, index) => index % 2);
    if (isWinner(oMoves))console.log('O');
    else if (isWinner(xMoves))console.log('X');
    else {console.log('?');}
}