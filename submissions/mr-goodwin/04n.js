function f(g) {
    n = [['1', '2', '3'],['4', '5', '6'],['7', '8', '9'],['1', '4', '7'],['2', '5', '8'],['3', '6', '9'],['1', '5', '9'],['3', '5', '7']]
    w = '?'

    i = 0
    c = 5
    while (i < g.length && w == '?') {
        w = someOneWon(g.substr(0, c))
        i++
        c++
    }

    console.log(w)

    function someOneWon(gp) {
        w = '?'
        e = ''
        o = ''

        for (j = 0; j<gp.length; j++) {
            j % 2 ? e+=gp[j] : o+=gp[j]
        }

        for (j = 0; j < n.length; j++) {
            t = n[j];
            if (o.indexOf(t[0]) != -1 && o.indexOf(t[1]) != -1 && o.indexOf(t[2]) != -1) {
                return 'O'
            }
            if (e.indexOf(t[0]) != -1 && e.indexOf(t[1]) != -1 && e.indexOf(t[2]) != -1) {
                return 'X'
            }
        }
        return w;
    }
}

console.log('O', f('523764918'));
console.log('O', f('5237649'));
console.log('X', f('352476'));
console.log('O', f('4268379'));
console.log('?', f('631854792'));
