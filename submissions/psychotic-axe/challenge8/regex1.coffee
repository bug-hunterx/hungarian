generateRegex = (width) -> "(.{" + width + "})"

generateReplace = (index, columns, row) -> 
  place = index % columns*row + index // columns + 1
  if index % columns != columns - 1
    "$" + place + "|"
  else
    "$" + place + "\n"

f = (text, columns, width) -> 

  length = text.length
  part = Math.ceil(length / width)
  row = Math.ceil(part / columns)
  
  text = text + new Array(part*width-length+1+columns*row*width-part*width).join(" ")

  regexText = (generateRegex(width) for index in[1..row*columns]).join("")
  
  replaceText = (generateReplace(index, columns, row) for index in [0..row*columns-1]).join("")
  
  
  regex = new RegExp(regexText);
  text = text.replace(regex, replaceText)

  
  console.log(text)