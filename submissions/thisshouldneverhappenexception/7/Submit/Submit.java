static void f(String b, int c){
        List<String> list = new ArrayList(Arrays.asList(b.split("\n")));
        Collections.reverse(list);if (list.size()>4) list.add(4, "");
        int actSize=1,stopCounter=0;
        boolean up=true;
        Map<Integer, Integer> out = new HashMap<>();
        Integer actFloor = 0;
        boolean smbOut = true;
        while (true) {
        if (actFloor == list.size()-1) up = false;
        if (actFloor == 0) up = true;
        if (actFloor.toString().contains("4")) {
        if (up) actFloor++; else actFloor--; continue;
        }
        if (out.get(actFloor) != null && out.get(actFloor) != 0) {
        actSize -= out.get(actFloor);out.put(actFloor,0);
        stopCounter++;
        smbOut = true;
        }
        String[] ppl = list.get(actFloor).split("\\|");
        if (!list.get(actFloor).isEmpty() && smbOut) {
        actSize = update(ppl, out, up, actFloor, list, actSize);
        }
        if (actSize == 1) {
        up = !up;
        actSize = update(ppl, out, up, actFloor, list, actSize);
        }
        if (actSize > c) {
        System.out.print("polite after " + stopCounter + " stops at " + actFloor + " floor");
        break;
        }
        if (actSize == 1) {
        System.out.print("lonely after " + stopCounter + " stops at " + actFloor + " floor");
        break;
        }
        smbOut = false;
        if (up) actFloor++; else actFloor--;
        }
        }

static void clean(List<String> l, int actFloor, String actppl) {
        l.set(actFloor, l.get(actFloor).replace(actppl,""));
        l.set(actFloor, l.get(actFloor).replace("||","|"));
        if (l.get(actFloor).equals("|")) l.set(actFloor, "\n");
        if (l.get(actFloor).startsWith("|")) l.set(actFloor, l.get(actFloor).substring(1));
        }

static int update(String[] ppl, Map<Integer, Integer> out, boolean up, int actFloor, List<String> list, int actSize) {
        int as = actSize;
        for (String actppl : ppl) {
        if (actppl.isEmpty()) continue;
        String[] split = actppl.split(":");
        int floor = Integer.parseInt(split[1]);
        int in = Integer.parseInt(split[0]);
        if (out.get(floor) == null) out.put(floor, 0);
        if ((up && floor >= actFloor) || (!up && floor <= actFloor)) {
        clean(list, actFloor, actppl);
        out.put(floor, out.get(floor) + in);
        as += in;
        }
        }
        return as;
        }