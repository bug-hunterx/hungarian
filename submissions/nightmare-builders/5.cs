static void f(String s){for(int i=0;i<99;i++){Console.Write(Regex.Replace(Regex.Replace(Regex.Replace(Regex.Replace(s,"(^|_|\\\\|\\|| )[|]+\\\\",delegate(Match m){return m.Value.Replace("|\\","\\\\");}),"/[|]+($|_|/|\\|| )",delegate(Match m){return m.Value.Replace("/|","//");}),"(\\s|^)\\\\","__").Replace("/||\\","//\\\\"),"/(\\s|$)","__"));}