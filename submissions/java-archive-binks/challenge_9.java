static void f(String s) {
        int livesLeft = 2, invul = 0, coins=0;
        boolean big = false;
        for(String ev: s.split(" ")){
            if("".equals(ev)){continue;}
            if(("piranha".equals(ev) || "goomba".equals(ev) || "koopa".equals(ev)) && invul == 0){
                if(big) {big= false;} else {livesLeft--;}
            }
            if("1Up".equals(ev)){
                livesLeft++;
            }
            if("Mushroom".equals(ev)){
                big = true;
            }
            if("Star".equals(ev)){
                invul = 3;
            }
            if("Princess".equals(ev) || "Bowser".equals(ev)){
                System.out.print("WIN");
                return;
            }
            try {
                coins += Integer.parseInt(ev);
            }catch (Exception e){}
            livesLeft += coins/100;
            coins%=100;
            invul = Math.max(0,invul-1);
            if (livesLeft<0){
                System.out.print("GAME OVER");
                return;
            }
        }
        System.out.print("???");
    }