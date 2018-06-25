function f(input) {
    //keyboard
    k = ['`1234567890-=~!@#$%^&*()_+', 'qwertyuiop[]\\QWERTYUIOP{}|', 'asdfghjkl;\'ASDFGHJKL:"', 'zxcvbnm,./|ZXCVBNM<>?'];
    //chars
    c = k.map(x => []);
    input.split('').map(i => (c[k.findIndex(r => r.includes(i))]).push(i));

    // sorter
    p = i => (a, b) => a[i].length - b[i].length;

    console.log(c.map((r, i) =>
        [r, Array.from(new Set(r.sort((a, b) => k[i].indexOf(a) - k[i].indexOf(b)))).join('')]
    ).sort(p(1)).sort(p(0)).map(r => r[1]).filter(s => s)[0]);
}