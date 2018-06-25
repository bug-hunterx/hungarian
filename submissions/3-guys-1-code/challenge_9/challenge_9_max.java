   static void f(final String storyboard) {
        System.out.println(fu(storyboard));
    }

    static String fu(final String storyboard) {
        final Mario mario = new Mario();
        for (final String stage : Arrays.asList(storyboard.replaceAll("\\s+", " ").trim().split(" "))) {
            if (stage.equals("goomba") || stage.equals("koopa") || stage.equals("piranha")) {
                if (!mario.hit()) {
                    // System.out.println("stage:" + stage + " " + mario);

                    return "GAME OVER";
                }
            } else if (stage.equals("Bowser") || stage.equals("Princess")) {
                // System.out.println("stage:" + stage + " " + mario);
                return "WIN";
            } else if (stage.equals("Mushroom"))
                mario.mushroom();
            else if (stage.equals("1Up"))
                mario.heal(100);
            else if (stage.equals("Star"))
                mario.invul();
            else
                try {
                    mario.heal(Integer.parseInt(stage.trim()));
                } catch (final Exception ex) {
                    // System.out.println(ex);
                    return "???";
                }
            // System.out.println("stage:" + stage + " " + mario);
        }
        return "???";
    }

    static class Mario {
        int coin;
        boolean isSuper;
        int invul;

        Mario() {
            coin = 300;
            isSuper = false;
            invul = 0;
        }

        boolean hit() {
            if (invul == 0) {
                if (isSuper) {
                    isSuper = false;
                } else
                    coin -= 100;
            }
            decreaseInvul();
            return coin >= 100;
        }

        void heal(final int amount) {
            coin += amount;
            decreaseInvul();
        }

        void invul() {
            invul = 2;
        }

        void mushroom() {
            isSuper = true;
            decreaseInvul();
        }

        void decreaseInvul() {
            if (invul > 0)
                invul -= 1;
        }

        @Override
        public String toString() {
            return "Mario:[coin=" + coin + " invul=" + invul + " super=" + isSuper + "]";
        }
    }