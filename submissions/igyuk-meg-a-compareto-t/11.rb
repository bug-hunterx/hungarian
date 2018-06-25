T='^v<>'
D={'^'=>[0,-1],'v'=>[0,1],'>'=>[1,0],'<'=>[-1,0]}
M={
    '/' => {'>'=>'^', 'v'=>'<', '<'=>'v', '^'=>'>'},
    '\\'=> {'>'=>'v', 'v'=>'>', '<'=>'^', '^'=>'<'}
}
def f(s)
    m=s.split("\n").map{|x|x.split('')}
    l=[]
    xs=m[0].size-1
    ys=m.size-1
    r=[]
    t=[]
    p=Hash.new{[]}
    (0..ys).map{|y|
        l[y] = [0] * (xs+1);
        (0..xs).map{|x|
            c=m[y][x]
            l[y][x]=0
            r<<[x,y,c] if T.index c
            p[c]=p[c]<<[x,y] if ('0'..'9').include? c
            t<<[x,y] if c=='@'
        }
    }
    p=Hash[p.values.map{|x|[x[0],x[1],x[1],x[0]]}.flatten(1).each_slice(2).to_a]
    r.each_with_index{|s,k|
        x,y,d=s
        moved = false
        loop do
            break if x<0||x>xs||y<0||y>ys
            if l[y][x]>0 and l[y][x]!=k+1
                #puts l.map{|x|x.join ''}.join("\n")
                puts ':/'
                return
            end
            c=m[y][x]
            break if c=='#'
			break if T.index c and moved
            if c=='@'
                t.delete([x,y])
                break
            elsif M.include? c
                d = M[c][d]
            elsif p.include? [x,y]
                x,y = p[[x, y]]
            else
                l[y][x] = k+1 if moved
            end
            x += D[d][0]
            y += D[d][1]
            moved = true
        end
    }
    
    #puts l.map{|x|x.join ''}.join("\n")
    puts t.size>0?':(':':D'
end