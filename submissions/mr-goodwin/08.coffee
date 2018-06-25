
f = (text, cols, width) ->
blockSize = cols * width
mod = text.length % blockSize
padding = if text.length then (if mod then blockSize - mod else 0) else blockSize
text = text + new Array(padding + 1).join(' ')
    re = new RegExp('.{1,' + width + '}', 'g')
splitted = text.match(re, 'g')
    finalArr = []
rows = splitted.length / cols
while splitted.length
    finalArr.push splitted.splice(0, rows)
res = []
i = 0
while i < rows
lineArr = finalArr.map((row) ->
row[i]
)
res.push lineArr.join('|')
i++
console.log res.join('\n')
return
