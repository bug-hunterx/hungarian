function f(input) {
    // game board
    g = [,,,,,,,,,].fill(0);
    input.split('').map((s, i) => g[s] = i % 2 ? 'X' : 'O');

    // tester function, (boolean result for rule, index1, index2) => field value => returns true if player won
    q = (a, b, c) => t => a && g[b] == t && g[c] == t;
    console.log(g.filter((f, j) =>
        f && [
            i => q(i % 3 == 1, i + 1, i + 2),
            i => q(i < 4, i + 3, i + 6),
            i => q(i == 5, 1, 9),
            i => q(i == 5, 3, 7)].some(p => p(j)(f))
    ).sort()[0] || '?');
}