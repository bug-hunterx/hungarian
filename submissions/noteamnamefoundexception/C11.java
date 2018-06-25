
	static void f(String p){
		String[] mapInput = p.split("\n");		
		int height = mapInput.length;
		int width = mapInput[0].length();
		String[][] map = new String[height][width];		
		
		int[][] score = new int[height][width];
		
		for(int i = 0;i<height;i++){
			for(int k = 0;k<width;k++){
				map[i][k] = ""+mapInput[i].charAt(k);
			}
		}		
		for(int i = 0;i<height;i++){
			for(int k = 0;k<width;k++){
				String object = map[i][k];
				switch(object){
					case "^":
						simuleShoot(0,-1,map,score,i,k);
					break;
					case "<":
						simuleShoot(-1,0,map,score,i,k);
					break;
					case "v":
						simuleShoot(0,1,map,score,i,k);
					break;
					case ">":
						simuleShoot(1,0,map,score,i,k);
					break;					
				}				
			}			
		}
		for(int i = 0;i<height;i++){
			for(int k = 0;k<width;k++){
				if(score[i][k]>1) {
					System.out.print(":/");return;
				}
			}
		}
		for(int i = 0;i<height;i++){
			for(int k = 0;k<width;k++){
				if(map[i][k].equals("@")) {
					System.out.print(":(");return;
				}
			}
		}		
		System.out.print(":D");

	}

	
	private static void simuleShoot(int dirX, int dirY, String[][] map,int[][] score, int y, int x ){
		int newX = x+dirX;
		int newY = y+dirY;
		if(newX >= map[0].length || newX < 0 || newY >= map.length || newY <0) return;
		
		String object = map[newY][newX];
		switch(object){
			case "/": 
				if(dirX==0 && dirY==-1){
					dirX=1;
					dirY=0;
				}else
				if(dirX==-1 && dirY==0){
					dirX=0;
					dirY=1;
				}else
				if(dirX==0 && dirY==1){
					dirX=-1;
					dirY=0;
				}else
				if(dirX==1 && dirY==0){
					dirX=0;
					dirY=-1;
				}
				simuleShoot(dirX,dirY,map,score, newY, newX );
			break;
			case "\\":
				if(dirX==0 && dirY==-1){
					dirX=-1;
					dirY=0;
				}else
				if(dirX==-1 && dirY==0){
					dirX=0;
					dirY=1;
				}else
				if(dirX==0 && dirY==1){
					dirX=1;
					dirY=0;
				}else
				if(dirX==1 && dirY==0){
					dirX=0;
					dirY=1;
				}
				simuleShoot(dirX,dirY,map,score, newY, newX );
			break;
			case "@":
				 map[newY][newX]="";
			break;
			default:{
				if(map[newY][newX].equals(" ")){
					score[newY][newX]++;
					simuleShoot(dirX,dirY,map,score, newY, newX );	
				}else{				
					if(!map[newY][newX].equals("")){
					int[] c = getPortalEndpoint(object,map,newX,newY);
					simuleShoot(dirX,dirY,map,score, c[0],  c[1] );
					}
				}	
			}
		}
		
	}
	
	static int[] getPortalEndpoint(String object, String[][] map,int x,int y){
		int[] c = {0,0};
		for(int i = 0;i<map.length;i++){
			for(int k = 0;k<map[0].length;k++){
				if(map[i][k].equals(object) && i!=y && k!=x){
					c[1] = k;
					c[0] = y;
					break;
				}
			}
		}
		return c;
	}

