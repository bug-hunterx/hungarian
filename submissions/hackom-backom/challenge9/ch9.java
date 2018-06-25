static void f(String scene) {
        int life = 3;
        int stars = 0;
        int coins = 0;
        int i = 0;
        String msg = null;
        String[] steps = scene.split(" ");
        for(String step : steps) {
            if (!step.trim().isEmpty()) {
                //System.out.print("#" + i++ + ":" + step);
                switch (step) {
                    case "Bowser":
                    case "Princess":
                        msg = "WIN";
                        break;
                    case "goomba":
                    case "koopa":
                    case "piranha":
                        if (stars == 0) life--;
                        break;
                    case "Star":
                        stars = 3;
                        break;
                    case "1Up":
                    case "Mushroom":
                        life++;
                        break;
                    default:
                        try {
                            if ((coins += Integer.valueOf(step)) >= 100) {
                                life += coins / 100;
                                coins = coins % 100;
                            }
                        } catch (Exception e) {
                        }
                }
                //System.out.println(" --- Life: " + life + " Stars: "+ stars + " Coins: " + coins);
                stars = Math.max(0, stars-1);
                if (life == 0) msg = "GAME OVER";
                if (msg != null) break;
            }
        }
        if (msg == null) msg = "???";
        System.out.println(msg);
    }