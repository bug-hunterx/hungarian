local instances = {}
function f(input)
	input:gsub( "%a", function (c) instances[c] = instances[c] + 1 end) 
	for letter, count in pairs(instances) do
	  print(letter, count)
	end
end

f("alma")
