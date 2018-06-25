function f(input) {
    var board = [],
        winner,
        c = console;
    input.split('').forEach(function (boardCell, stepNumber) {
        if (!winner) {
            boardCell = parseInt(boardCell, 10);

            board[boardCell] = (stepNumber % 2 === 0) ? 'O' : 'X';

            if (stepNumber + 1 >= 5) {
                if (winner = checkForWinner(board[boardCell])) {
                    c.log(winner);
                }
            }
        }
    });

    winner || c.log('?');

    function checkForWinner(player) {
        if ((board[1] === board[2]) && (board[1] === board[3]) && board[1] === player) return player;
        if ((board[4] === board[5]) && (board[4] === board[6]) && board[4] === player ) return player;
        if ((board[7] === board[8]) && board[7] === board[9] && board[7] === player ) return player;
        if (board[1] === board[4] && board[1] === board[7] && board[1] === player ) return player;
        if (board[2] === board[5] && board[2] === board[8] && board[2] === player ) return player;
        if (board[3] === board[6] && board[3] === board[9] && board[3] === player ) return player;
        if (board[1] === board[5] && board[1] === board[9] && board[1] === player ) return player;
        if (board[3] === board[5] && board[3] === board[7] && board[3] === player ) return player;
        return false;
    }
}
