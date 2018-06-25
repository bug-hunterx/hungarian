static void f(final int cost) {
        final int tip = (cost < 2000 ? round(cost, 100) : cost < 5000 ? round(cost, 500) : roundNearest((int) (cost * 1.1))) - cost;
        // System.out.println("cost:" + cost + " tip:" + tip);
        System.out.println(tip == 0 || tip > 1500 ? "PAID BY CARD" : tip % 100 > 0 ? "KEEP THE CHANGE YOU FILTY ANIMAL" : "HERE IS " + (tip + cost));
    }

    static int round(final int a, final int b) {
        return ((a + b - 1) / b) * b;
    }

    static int roundNearest(final int a) {
        return ((a + 250) / 500) * 500;
    }