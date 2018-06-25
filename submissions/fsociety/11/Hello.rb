def f(s)
    r=0
    c=0
    os=[]
    ts=[]
    ms=[]
    ps=[]
    cs=[]
    sc=[[]]
    h=0
    w=0
    ds={'>'=>[0,1,'-','v','^','<'],'<'=>[0,-1,'-','^','v','>'],'^'=>[-1,0,'|','<','>','v'],'v'=>[1,0,'|','>','<','^']}
    t=":("
    for i in 0..s.length-1
        case s[i]
            when "@"
                os.push([r,c,false])
            when "#"
                cs.push([r,c])
             when "\\","/"
                ms.push([r,c,s[i]])
            when ">","<","^","v"
                ts.push([r,c,s[i]])
            when "1".."9"
                ps.push([r,c,s[i]])
            else
                ""
        end
        if s[i]=="\n"
            r+=1
            sc[r]=[]
            w=c
            c=0
        else
            sc[r][c]=s[i]
            c+=1
        end
    end
    h=r+1
    ts.each_with_index  {|v,i|
        x,y,d=v
        dx,dy,dc,rd,ld,ac=ds[d]
        ti=(65+i).chr
        #print x, ",", y, " ", sc[x][y], "| ",ds[d]," | ", (0..h) === x+dx, "\n"
        while (0..h-1) === x+dx && (0..w-1) === y+dy
            #print x, ",", y, "\n"
            x+=dx
            y+=dy
            #print "x+dx=", x, ",", y, " | ", (0..h), "\n"
            #print x, ",", y, " ", sc[x][y], "\n"
            case sc[x][y]
                when "@"
                    uo=os.select {|o| o[0] == x && o[1] == y}
                    uo[0][2]=true
                    break
                when "A".."Z"
                    if (ti != sc[x][y])
                        print ":/"
                        return
                    end
                when "\\"
                    dx,dy,dc,rd,ld,ac=ds[rd]
                when "/"
                    dx,dy,dc,rd,ld,ac=ds[ld]
                when "#"
                    break
                when "1".."9"
                    mp=ps.select {|m| (m[0] != x || m[1] != y) && m[2] == sc[x][y]}
                    x,y=mp[0][0],mp[0][1]
                when ">","<","^","v"
                    if sc[x][y]==ac
                        print ":/"
                        return
                    end
                    break
                else
                    sc[x][y]=ti
            end
        end
    }
    #print os
    if os.all? {|o| o[2]}
        t=":D"
    end
    print t
end

#f("  @      v  \n> / <  @ \\ @\n  @      ^  ")
f("      v  \n> 9 # 9 @\n  #      ")
f("     v \n> 9#9 @")
f(" vvvv \n \\\\\\\\\\\n /////\n 1234 \n 4321 \n///// \n\\\\\\\\\\ \n @@@@ ")
f("> \\  @\n> \\  @\n> \\  @")
f(">v@@<\n")
f(">   \\\n  \\ /\n")