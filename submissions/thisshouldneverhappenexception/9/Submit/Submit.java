static void f(String s){
String[] map=s.trim().split("\\s+");
Set e=new HashSet<>(Arrays.asList("piranha","goomba","koopa"));
int c=0,l=3,r=0;boolean superM=false;
for (String act : map){if(r>0)r--;if("Bowser".equals(act)||"Princess".equals(act))System.out.print("WIN");
else if(e.contains(act)&&r==0){if(superM)superM=false;else l--;if(l==0)System.out.print("GAME OVER");
}else if("Mushroom".equals(act)){superM=true;}else if("Star".equals(act)){r=3;}else if("1Up".equals(act)){l++;}
else try{c+=Integer.parseInt(act);if(c>=100){l+=c/100;c=c%100;}}catch(NumberFormatException n){}}System.out.print("???");}