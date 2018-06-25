function f(str) {
    rows = [
        '`1234567890-=~!@#$%^&*()_+',
        'qwertyuiop[]\\QWERTYUIOP{}|',
        'asdfghjkl;\'ASDFGHJKL:"',
        'zxcvbnm,./ZXCVBNM<>?',
    ]

    // classify to rows
    r = ['', '', '', '']
    for (i = 0; i < str.length; i++) {
        c = str[i]
        r[whichRow(c)] += c
    }

    // calc the min length row
    minLength = Number.MAX_VALUE
    for (i = 0; i < r.length; i++) {
        l = r[i].length
        if (l && l < minLength) minLength = l
    }

    // keep the shortest rows (not empty)
    sr = []
    for (i = 0; i < r.length; i++) {
        rd = r[i]
        if (rd.length == minLength) sr.push(rd)
    }

    if (sr.length > 1) {
        // uniqueify
        for (i = 0; i < sr.length; i++) {
            sr[i] = uniqueify(sr[i])
        }

        // calc minLength
        minLength = Number.MAX_VALUE
        for (i = 0; i < sr.length; i++) {
            l = sr[i].length
            if (l && l < minLength) minLength = l
        }

        // keep the shortest rows (not empty)
        ssr = []
        for (i = 0; i < sr.length; i++) {
            srd = sr[i]
            if (srd.length == minLength) ssr.push(srd)
        }

    } else {
        ssr = sr
    }

    tr = rows[whichRow(ssr[0][0])]

    res = ssr[0].split('').sort(function(n, m) {
        return tr.indexOf(n) > tr.indexOf(m) ? 1 : -1
    }).join('')

    return res

    function uniqueify(s) {
        sa = ''
        for (j = 0; j < s.length; j++) {
            c = s[j]
            if (sa.indexOf(c) == -1) sa += c
        }
        return sa
    }

    function whichRow(c) {
        for (j = 0; j < rows.length; j++) {
            if (rows[j].indexOf(c) != -1) return j;
        }
    }
}
