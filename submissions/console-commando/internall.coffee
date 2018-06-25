f = (s) ->
  i = undefined
  j = undefined
  r = [
    /[`\d-=~!@#$%^&*()_+]/g
    /[qwertyuiop[\]\\{\}\|]/ig
    /[asdfghjkl:";']/ig
    /[zxcvbnm,.\/<>?]/ig
  ]
  res = m: 9007199254740991
  order = '`1234567890-=~!@#$%^&*()_+qwertyuiop[]\\QWERTYUIOP{}|asdfghjkl;\'ASDFGHJKL:"zxcvbnm,./ZXCVBNM<>?'
  i = 0
  while r[i]
    ((rcl) ->
      t = {}
      ul = []
      j = 0
      while rcl[j]
        if !t[rcl[j]]
          t[rcl[j]] = 1
          ul[j] = rcl[j]
        j++
      ((cl, ul) ->
        noc = cl.length
        nouc = ul.length
        if noc > 0 and noc < res.m or noc > 0 and noc == res.m and res.u > nouc
          res.m = noc
          res.l = i
          res.u = nouc
          res.ul = ul
        return
      ) rcl, ul
      return
    ) s.match(r[i]) or []
    i++
  console.log res.ul.sort((a, b) ->
    order.indexOf(a) - order.indexOf(b)
  ).join('')
  return