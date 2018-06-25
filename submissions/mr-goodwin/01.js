function f(a) {
    var arr = a.split('')
        .map(function (c) {
            return c.charCodeAt(0)
        })
        .sort()
        .map(function (c) {
            return String.fromCharCode(c)
        });

    var objs = {}

    for (var i = 0; i < a.length; i++) {
        objs[a[i]] ? objs[a[i]] += a[i] : objs[a[i]] = a[i];
    }

    sortable = [];
    for (var k in objs)
        sortable.push(objs[k])
    sortable.sort(function (a, b) {
        return a.length - b.length == 0 ? a.charCodeAt(0) - b.charCodeAt(0) : a.length - b.length
    })

    console.log(sortable.join(''))
}
