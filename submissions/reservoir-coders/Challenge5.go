func r(s,p,r string) string{return strings.Replace(s,p,r,-1)}
func f(s string){t:=" "+s+" ";s=t;for{t=s;s=r(s,"/|\\","s");s=r(s,"/ ","__");s=r(s,"/|","//");s=r(s," \\","__");s=r(s,"|\\","\\\\");if t==s{break}}
s=r(s,"s","/|\\");fmt.Print(strings.Trim(s," "));}