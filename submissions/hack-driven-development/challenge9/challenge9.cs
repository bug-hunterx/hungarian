static void f(string sb){int li=3;int co=0;bool sm=false;int st=0;foreach(string o in sb.Split(' ')){if(o.Length>0){char a=o[0];char z=o[o.Length-1];int c;if(Int32.TryParse(o,out c)){co+=c;if(co>=100){li+=co/100;co-=100*(co/100);}}if(z=='a'&&st<=0){if(sm){sm=false;}else{li--;if(li==0){Console.WriteLine("GAME OVER");return;}}}if(z=='p'){li++;}if(z=='m'){sm=true;}if(z=='s'||a=='B'){Console.WriteLine("WIN");return;}st--;if(a=='S'){st=2;}}}Console.WriteLine("???");}