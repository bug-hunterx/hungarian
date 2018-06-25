def r(a,b)
return ((a+b-1)/b)*b
end
def f(c)
@t=(c<2000?r(c,100):c<5000?r(c,500):(((c*1.1).floor+250)/500)*500)-c
puts @t==0||@t>1500?"PAID BY CARD":@t%100>0? "KEEP THE CHANGE YOU FILTY ANIMAL":"HERE IS #{@t+c}"
end