import sys,collections
def f(i):
    for p in sorted(sorted(i),key=collections.Counter(i).get):sys.stdout.write(p)