def d(s): return lambda c, x=s: x.count(c)
def f(t):
    k=d(t)
    a=''.join(sorted(t))
    print(''.join(sorted(a,key=k)))
