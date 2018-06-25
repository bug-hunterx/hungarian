public class Mario {

    private static int invulnerability = 0;
    private static int coins = 0;

    enum State {
        SUPER, SMALL
    }
    public static void f(String input) {

        String[] commands = input.split("\\s+");

        State state = State.SMALL;
        int life = 3;

        for (String command : commands) {
            if (!command.equals("") && invulnerability > 0) {
                invulnerability--;
            }

            switch (command) {
                case "goomba" :
                case "koopa" :
                case "piranha" :

                if (invulnerability <= 0) {
                    switch (state) {
                        case SMALL :
                            life--;
                            if (life == 0) {
                                System.out.print("GAME OVER");
                                return;
                            }
                            break;
                        case SUPER :
                            state = State.SMALL;
                            break;

                    }
                }
                    break;

                case "Mushroom" :
                    if (state == State.SMALL){
                        state = State.SUPER;
                    }
                    break;
                case "Star" :
                    invulnerability = 3;
                    break;
                case "1Up":
                    life++;
                    break;
                case "Bowser" :
                case "Princess" :
                    System.out.print("WIN");
                    return;

                default:
                    try {
                        coins += Integer.parseInt(command);
                        if (coins >= 100 ) {
                            coins -= 100;
                            life++;
                        }
                    } catch (Exception e) {}

            }

        }

        if (life  > 0)
        System.out.print("???");

    }


}
