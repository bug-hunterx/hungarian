f = (a) ->
arr = a.split('').map((c) ->
    c.charCodeAt 0
).sort().map((c) ->
    String.fromCharCode c
)
objs = {}
i = 0
while i < a.length
    if objs[a[i]] then (objs[a[i]] += a[i]) else (objs[a[i]] = a[i])
i++
sortable = []
for k of objs
    sortable.push objs[k]
sortable.sort (a, b) ->
if a.length - (b.length) == 0 then a.charCodeAt(0) - b.charCodeAt(0) else a.length - (b.length)
console.log sortable.join('')
return
