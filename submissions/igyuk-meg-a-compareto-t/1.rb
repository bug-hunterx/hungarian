def f(x)puts x.split('').group_by{|x|x}.values.sort{|x,y|x.count!=y.count ? x.count<=>y.count: x[0]<=>y[0]}.join;end;
