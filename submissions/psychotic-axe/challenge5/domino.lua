function f(s)
local aa=""
local a=" "..s:gsub("__","_").." "
local l=a:len()
local r=""
for i=1,l do
local c=a:sub(i,i)
if c=="/" or c=="|" or c=="_" or(c==" " and a:sub(i+1,i+1)~=" ") then r = r..c else
aa=aa..rs(r..c)
r="" end end
aa=aa..rs(r)
aa=aa:gsub("_","__")
if aa:sub(1,1)==" " then aa=aa:sub(2,-1) end
if aa:sub(-1,-1)==" " then aa=aa:sub(1,-2) end
print(aa)end
function rs(s)
local a=s
local l=a:len()
local aa=""
for i=1,l do
local j=l-i+1
if i+2<j then a=r(a:sub(1,i))..a:sub(i+1,j-1)..r(a:sub(j,l)) else a=r(a) end end aa=aa..a return aa end
function r(s)
local r=s
local a=r
while r==a do a=a:gsub("/ ","_",1):gsub(" \\","_",1):gsub("/||\\","//\\\\",1):gsub("/|([^\\])","//%1",1):gsub("([^/])|\\","%1\\\\",1)
if r~=a then r=a else break end end return a end
