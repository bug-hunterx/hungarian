function f(s)
	local kRows = {
	"/[^`1234567890\\-=~!@#\\$%\\^&*()_+]/g",
	"/[^qwertyuiop[]QWERTYUIOP{}|\\]/g",
	"/[^asdfghjkl;'ASDFGHJKL:\"]/g",
	"/[^zxcvbnm,./ZXCVBNM<>?]/g"
	}
	local sRows = {
		"`1234567890-=~!@#$%^&*()_+",
        "qwertyuiop[]QWERTYUIOP{}|\\",
		'asdfghjkl;\'ASDFGHJKL:"',
        "zxcvbnm,./ZXCVBNM<>?"
	}
	local lines = {s, s, s, s}
	
	function toArray(iter)
		local i = 1;
		local array = {};

		for item in iter do
		  array[i] = item;
		  i = i +1
		end

		return array
	end

	function uniq(test)
local hash = {}
local res = {}

for _,v in ipairs(test) do
   if (not hash[v]) then
       res[#res+1] = v -- you could print here instead of saving to result table if you wanted
       hash[v] = true
   end

end
return res
	end
for i,line in ipairs(uniq({"a","a","bela"})) do print(line) end

	local m = 0
	local minL = ''
	local ind = 0

	for i, line in ipairs(lines) do
		local l = string.match(line, kRows[i])
		if l == nil then l = line end
		if string.len(l) > 0 and (string.len(l) <= m or m == 0) then
			if string.len(l) == m then
				local lU = table.getn(uniq(toArray(string.gmatch(l, ""))))
				local mU = 0--table.getn(uniq(toArray(string.gmatch(minL, ""))))
				if lU <= mU then
					if lU == mU then
						if ind > i then
							m = string.len(l)
							minL = l
							ind = i
						end
					else
						m = string.len(l)
						minL = l
						ind = i
					end
				end
			else
				m = string.len(l)
				minL = i
				ind = i
			end
		end 
	end

	local splitted = toArray(string.gmatch(minL, ":"))
	if splitted == nil then splitted = {} end

	local sorted = table.sort(splitted, function(a,b)
		return string.find(sRows[ind], a) - string.find(sRows[ind],b)
	end)
	if sorted == nil then sorted = {} end


	local uniqed = {}
	for i, sort in ipairs(sorted) do
		uniqed[i] = uniq(sort)
	end
	print(table.concat(uniqed, ''))
end
f('sadfm,nn23')