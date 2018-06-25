function f(s)
    a = {}
    r = ''
    for i = 1, #s do
        char = s:sub(i, i)
        if a[char] == nil then
            a[char] = 1
        else
            a[char] = a[char] + 1
        end
    end
    
    m = 0
    for k,v in pairs(a) do 
        if v > m then m = v end
    end
    r = ""
    for i = 1, m do
        s = {}
       for k,v in pairs(a) do
          if v == i then table.insert(s,k) end
        end
        if #s > 0 then
            table.sort(s, function(a,b) return string.byte(a) < string.byte(b) end)
            for k, v in ipairs(s) do
                for j = 1, i do
                   r = r .. v
                end
            end
        end
    end
    print(r)
end