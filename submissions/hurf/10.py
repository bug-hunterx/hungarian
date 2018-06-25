import re
def f(s, c):
    a=[''.join(i[::-1]) for i in list(zip(*[line[::-1] for line in c.split('\n')]))[::-1]]
    r="^X((\|)|(/\|\\\\)|(\\\\\|/)|(/\\\\)|(\\\\/))+"
    l=[m.group(0) for l in a for m in [re.search(r+"(\$)",l)] if m]
    p=[m.group(0) for l in a for m in [re.search(r+"(\.)",l)] if m]
    if len(l) > s:
        print(s - len(l))
    elif len(l) + len(p) == 0:
        print(":(")
    elif len(l) + len(p) < s:
        print(s - (len(l) + len(p)))
    else:
        d=0
        for x,i in enumerate(a, 0):
            if (d < s - len(l) and re.search(r+"(\.)",i)):
                a[x] = i.replace('.','$',1)
                d+=1;
        for row in list(zip(*a))[::-1]:
            print(''.join(row))