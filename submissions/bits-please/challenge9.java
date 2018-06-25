static void f(String s)
{
	int life=3;
	int big = 0;
	int star = 0;
	int coins=0;
	int end=1;
	String[] stories=s.replaceAll(" +", " ").split(" ");
	for(String story:stories)
	{
		if("goombakoopapiranha".contains(story)){
			if(star==0){
				if(big>0)
					big=0;
				else
					life--;
			}
		}
		if(star>0){
			star--;
		}
		if("Mushroom".equals(story)){
			big=1;
		}
		if("Star".equals(story)){
			star+=2;
		}
		if(story.matches("^-?\\d+$")){
			coins+=Integer.valueOf(story);
			life+=(int)(coins/100);
			coins%=100;
		}
		if("1Up".equals(story)){
			life++;
		}
		if(life>0){
			if("PrincessBowser".contains(story)){
				System.out.print("WIN");
				end--;
				break;
			}
		}else{
			System.out.print("GAME OVER");
			end--;
			break;
		}
	}
	if(end>0)System.out.print("???");
}
