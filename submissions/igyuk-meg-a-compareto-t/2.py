def f(s):
 k = '`1234567890-=~!@#$%^&*()_+``qwertyuiop[]\QWERTYUIOP{}|`asdfghjkl;\'ASDFGHJKL:"`````zxcvbnm,./ZXCVBNM<>?'
 m = [[],[],[],[]]
 c = [set(), set(),set(),set()]
 for x in s:
  i = k.index(x)//27
  if x not in c[i]:
   c[i].add(x)
   m[i].append(x)
 [y.sort(key=lambda x: k.index(x)) for y in m]
 m.sort(key=lambda x: len(x) if len(x) > 0 else 99)
 print(''.join(m[0]))
