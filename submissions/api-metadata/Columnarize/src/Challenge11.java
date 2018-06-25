import java.awt.List;
import java.util.LinkedList;
import java.util.Optional;


public class Challenge11 {
	public static void main(String[] args) {
		
		String b=
		"      v  "+"\n"+
		"         "+"\n"+
		"> 9 # 9 @"+"\n"+
		"         "+"\n"+
		"  #      ";
        //f(b);
        b=
        "> \\  @"+"\n"+
        "> \\  @"+"\n"+
        "> \\  @";
        //f(b);
      b=
      " vvvv "+"\n"+
      " \\\\\\\\\\"+"\n"+
      " /////"+"\n"+
      " 1234 "+"\n"+
      " 4321 "+"\n"+
      "///// "+"\n"+
      "\\\\\\\\\\ "+"\n"+
      " @@@@ ";
      //f(b);
      //b=">    #";
      b=
      "       "+"\n"+
      "       "+"\n"+
      "   /  <"+"\n"+
      "   @   ";
      f(b);
    }
	
	static void f(String b) {
		String[] f= b.split("\n");
		
		LinkedList<Laser> c=new LinkedList<Laser>(),p=new LinkedList<Laser>(),m=new LinkedList<Laser>(),t=new LinkedList<Laser>();
		LinkedList<LinkedList<Laser>> l=new LinkedList<>();
		
		int i=0,j=0;
		for(;i<f.length;i++)
			for(j=0;j<f[i].length();j++) {
				char ca=f[i].charAt(j);
				switch(ca){
					case 'v':c.add(Laser.c(i, j, 0, 0));{LinkedList<Laser> x=new LinkedList<>();x.add(Laser.c(i, j, 1, 0));l.add(x);}break;
					case '>':c.add(Laser.c(i, j, 0, 0));{LinkedList<Laser> x=new LinkedList<>();x.add(Laser.c(i, j, 0, 1));l.add(x);}break;
					case '<':c.add(Laser.c(i, j, 0, 0));{LinkedList<Laser> x=new LinkedList<>();x.add(Laser.c(i, j, 0, -1));l.add(x);}break;
					case '^':c.add(Laser.c(i, j, 0, 0));{LinkedList<Laser> x=new LinkedList<>();x.add(Laser.c(i, j, -1, 0));l.add(x);}break;
					case '#':c.add(Laser.c(i, j, 0, 0));break;
					case '@':t.add(Laser.c(i, j, 0, 0));break;
					case '\\':m.add(Laser.c(i, j, 1, 0));break;
					case '/':m.add(Laser.c(i, j, -1, 0));break;
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						p.add(Laser.c(i, j, Integer.valueOf(f[i].charAt(j)), 0));
						break;
				}
			}
		
		for (LinkedList<Laser> q : l) {
			while(true) {
				Laser r=q.getLast();
				r.x+=r.h;r.y+=r.w;
				if(r.mp==1) q.removeLast(); 
				r.mp=0;
				if(r.x>=i||r.y>=j) break;
				if(c.stream().anyMatch(s->s.x==r.x&&s.y==r.y)) break;
				if(t.stream().anyMatch(s->s.x==r.x&&s.y==r.y)) {
					t.stream().filter(s->s.x==r.x&&s.y==r.y).forEach(s->s.h=1);
					break;
				}
				cm(m, r);
				
				cp(p, r);
				q.addLast(r);
				
			}
		}
		
		String r="";

		if(l.stream().anyMatch(s -> s.stream().anyMatch(z -> l.stream().anyMatch(u -> u.stream().anyMatch(a -> s!=u&&a.x==z.x&&a.y==z.y))))) r=":/";
		else if(t.stream().allMatch(s->s.h>0)) r=":D";
		else r=":(";
		
		System.out.println(r);
	}

	static void cp(LinkedList<Laser> p, Laser r) {
		Optional<Laser> w = p.stream().filter(s->s.x==r.x&&s.y==r.y).findFirst();
		if(w.isPresent()) {
			Laser v=w.get();
			p.stream().filter(s->s.h==v.h&&s!=v).forEach(s->{r.x=s.x;r.y=s.y;});
			r.mp=1;
			/*r.x+=r.h;r.y+=r.w;
			cp(p, r);*/
		}
	}

	static void cm(LinkedList<Laser> m, Laser r) {
		m.stream().filter(s->s.x==r.x&&s.y==r.y).forEach(s-> {
			s.w=r.w;r.w=r.h*s.h;r.h=s.w*s.h;
			r.mp=1;
			//r.x+=r.h;r.y+=r.w;cm(m,r);
			});
	}
	
	static class Laser{
		int x,y,h,w,mp;
		
		static Laser c(int x,int y,int h,int w) {
			Laser l = new Laser();
			l.x=x;l.y=y;l.h=h;l.w=w;
			return l;
		}
	}
}
