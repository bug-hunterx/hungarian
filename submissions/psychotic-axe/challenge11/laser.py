def f(s) :
    t = []
    tu = []
    ta = 0
    pl = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
    p = []
    th = 0
    msg = ":("
    for line in s.splitlines():
        t.append(line)
    for i in range(len(t)):
        for j in range(len(t[i])):
            a = t[i][j]
            if (a == ">") or (a == "<") or (a == "^") or (a == "v"):
                tu.append((i, j))
            elif a in pl:
                p.append((a, (i, j)))
            elif a == "@":
                ta = ta+1

    for tur in tu:

        x = tur[0]
        y = tur[1]
        a = t[x][y]
        d = ""
        if a == ">":
            d = "R"
        elif a == "<":
            d = "L"
        elif a == "^":
            d = "U"
        elif a == "v":
            d = "D"

        while True:
            if d == "R":
                y = y+1
            elif d == "L":
                y = y-1
            elif d == "U":
                x = x-1
            elif d == "D":
                x = x+1

            if not 0 <= x < (len(t)) or not 0 <= y < len(t[0]):
                break
            a = t[x][y]
            if a == " ":
                t[x] = t[x][:y] + "I" + t[x][y+1:]
            elif a == "@":
                th = th+1
                break
            elif a == "#" or a == ">" or a == "<" or a == "^" or a == "v":
                break
            elif a == "I":
                msg = ":/"
                break
            elif a == "/":
                if d == "R":
                    d = "U"
                elif d == "L":
                    d = "D"
                elif d == "U":
                    d = "R"
                elif d == "D":
                    d = "L"

            elif a == "\\":
                if d == "R":
                    d = "D"
                elif d == "L":
                    d = "U"
                elif d == "U":
                    d = "L"
                elif d == "D":
                    d = "R"
            elif a in pl:
                for aa in [j for a,j in p]:
                    if not all(i > j for i,j in zip(aa, (x, y))):
                        x = aa[0]
                        y = aa[1]

    if msg == ":/":
        print(msg)
    elif th == ta:
        print(":D")
    else:
        print(":(")
    return
