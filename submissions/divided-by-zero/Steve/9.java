static void f(String f){boolean b=false;String r="GAME OVER",a[]=f.split(" ");int y=3,c=0,w=a.length-1,i=0,p=0;for(String m:a){if("".equals(m))continue;char n=m.charAt(0);if(z("gkp",n)&&p<=0) if(b)b=!b;else y--;if(y<=0){break;}if(z("BP",n)){r="WIN";break;}if(z("S",n))p=3;if(z("M",n))b=true;if("1Up".equals(m))y++;if(m.matches("\\d+")){c+=Integer.parseInt(m);int newLife=c/100;y+=newLife;c-=newLife*100;}if(i==w){r="???";break;}p--;i++;};System.out.println(r);}static boolean z(String b,char i){return b.indexOf(i)>=0?true:false;}