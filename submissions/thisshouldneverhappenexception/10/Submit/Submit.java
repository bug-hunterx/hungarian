static void f(int n,String s){
        String[] m = s.split("\n");
        char[][] map = new char[m.length][m[0].length()-1];
        int actLine = 0;
        for (String a : m) {
        map[actLine] = a.toCharArray();
        actLine++;
        }
        int on = 0;
        int all = 0;
        char[] actTorch = new char[map.length];
        for (int j = 0; j < map[0].length; j++) {
        for (int i = 0; i < map.length; i++) {
        actTorch[i] = map[i][j];
        }
        if (isValid(actTorch) && isOn(actTorch)) on++;
        if (isValid(actTorch)) all++;
        }

        if (all == 0) {System.out.print(":(");return;}
        if (on > n) {System.out.print(Integer.toString(n-on));return;}
        if (all < n) {System.out.print(Integer.toString(n-all));return;}

        if (on < n) {
        for (int j = 0; j < map[0].length; j++) {
        for(int i = 0; i < map.length; i++) {
        actTorch[i] = map[i][j];
        }
        if (isValid(actTorch) && !isOn(actTorch) && on < n){
        turnOn(actTorch);
        on++;
        for(int i = 0; i < map.length; i++) {
        map[i][j] = actTorch[i];
        }
        }
        }
        }
        for(int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j]);
        }
        System.out.println();
        }
        }

static boolean isValid(char[] torch) {
        String s = "|\\/";
        if (torch[torch.length-1] != 'X') return false;
        int body = Integer.MAX_VALUE;
        int act;
        for (act = torch.length-2; s.indexOf(torch[act])>=0 && act >= 0; act--) {
        if (act == torch.length-2) body = 0;
        if (torch[act] == '\\') body--;
        if (torch[act] == '/') body++;
        if (body == -2 || body == 2) return false;
        }
        if (act < 0 || body!=0) return false;
        if (torch[act] == '$' || torch[act] == '.') return true;
        return false;
        }

static boolean isOn(char[] torch) {
        String s = "|\\/";
        int act;
        for (act = torch.length-2; s.indexOf(torch[act])>=0; act--) {
        }
        if (torch[act] == '$') return true;
        return false;
        }

static void turnOn(char[] torch) {
        String s = "|\\/";
        int act;
        for (act = torch.length-2; s.indexOf(torch[act])>=0; act--) {
        }
        torch[act] = '$';
        }