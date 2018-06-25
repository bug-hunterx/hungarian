static void f(String a, int b){
 String[] c = a.split("\n");
 int y = c.length;
 int o[][] = new int[y][y];
 for(int i = y-1; i>= 0; i--) {
String[] split = c[i].split("\\|");
int d = y - i - 1;
for(int j = 0; j< split.length; j++) {
 String[] r = split[j].split(":");
 if(r.length==2) {
int s = Integer.parseInt(r[1]);
o[s > 4 ? s - 1 : s][d] = Integer.parseInt(r[0]);
 }
}
 }
 int stops = 0;
 int p=0;
 for(int f=0;f<y;f++){
boolean h = false;
for(int i = 0; i < f; i++) {
 if(o[f][i]!=0) {
p=f;
h=true;
 }
}
if(!h && f != 0) {
 for(int i = f; i<y;i++){
o[i][f]=0;
 }
 continue;
} else if (0 < f) {
 stops++;
}
for(int k=f-1;k>=0;k--){
 o[f][k]=0;
}
int z=1;
for(int j=f+1;j<y;j++){
 for(int k=f;k>=0;k--) {
z += o[j][k];
 }
}
boolean sure = false;
for(int i = f; i < y; i++) {
 if (o[f][i] != 0) {
sure = true;
 }
}
if(z==1 && f!=y-1 && !sure) {
 System.out.println("lonely after "+stops+" stops at "+(f>3?f+1:f)+" floor");
 return;
}
if(z>b) {
 System.out.println("polite after "+stops+" stops at "+(f>3?f+1:f)+" floor");
 return;
}
 }
 for(int f=p;f>=0;f--){
boolean h = false;
for(int i = f; i < y; i++) {
 if(o[f][i]!=0) {
h=true;
 }
}
if(f==p) {
 h = true;
}
if(!h) {
 for(int i = f; i>=0;i--){
o[f][i]=0;
 }
 continue;
} else if (f < y && p!=f){
 stops++;
}
for(int k=f;k<y;k++){
 o[f][k]=0;
}
int z=1;
for(int j=f;j>=0;j--){
 for(int k=f;k<y;k++) {
z += o[j][k];
 }
}
if(z==1) {
 System.out.println("lonely after "+stops+" stops at "+(f>3?f+1:f)+" floor");
 break;
}
if(z>b) {
 System.out.println("polite after "+stops+" stops at "+(f>3?f+1:f)+" floor");
 break;
}
 }
}
