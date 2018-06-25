def f(s)
    w = [[6, 7, 8],[3, 4, 5],[0, 1, 2],[0, 3, 6],[1, 4, 7],[2, 5, 8],[0, 4, 8],[2, 4, 6]]
    b = {}
    for i in 0..8
        b[i] = i.to_s
    end
    for i in 0..s.length-1
        if i % 2 == 1
            b[s[i].to_i - 1] = "X"
        else
            b[s[i].to_i - 1] = "O"
        end
        w.each { |x|
        if (b[x[0]] == b[x[1]] && b[x[1]] == b[x[2]])
            puts b[x[0]]
            return
        end
    }
    end
    puts "?"
end