def f(i, s) :
  r = []
  for l in s.splitlines():
    for i, c in enumerate(l):
      r[i] = (r[i] or '') +c
    r = r + '\n'
  print(r)
  return

f(1, """         &
      *   ##
    ~    .   *  *
       . \     *
    .  | |  $
    |  X /  |
    X    X  X     """)