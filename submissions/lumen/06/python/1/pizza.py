def f(c):
    x=2000
    y=5000
    z=500
    w=100
    if c<x and c%w==0:
        b=c
    elif c<x:
        b=(int(c/w)+1)*w
    elif c<y and c%z==0:
        b=c
    elif c<y:
        b=(int(c/z)+1)*z
    else:
        s=int(c*1.1)
        d = s%z
        if d<250:
            b=s-d
        else:
            b=s-d+z
    t=b-c
    if t==0 or t>1500:
        print("PAID BY CARD")
    elif t%w!=0:
        print("KEEP THE CHANGE YOU FILTY ANIMAL")
    else:
        print("HERE IS {0}".format(b))
    return
