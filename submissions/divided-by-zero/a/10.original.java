    static void f(int n, String scene) {

        String[] parts = scene.split("\\r?\\n");
        String bottom = parts[parts.length - 1];

        List<T> torches = new ArrayList<>();
        int alreadiLitTorches = 0;

        for (int i = 0; i < bottom.length(); ++i) {

            if ('X' == bottom.charAt(i)) {

                Status stat = Status.OK;

                for (int k = parts.length - 2; k >= 0; --k) {

                    if (stat == Status.OK && parts[k].charAt(i) == '.') {
                        T t = new T();
                        t.wick = new int[]{i, k};
                        torches.add(t);
                    } else if (stat == Status.OK && parts[k].charAt(i) == '$') {
                        ++alreadiLitTorches;
                    } else if (stat == Status.OK && parts[k].charAt(i) == '/') {
                        stat = Status.RIGHT;
                    } else if (stat == Status.OK && parts[k].charAt(i) == '\\') {
                        stat = Status.LEFT;
                    } else if (stat == Status.RIGHT && parts[k].charAt(i) == '\\') {
                        stat = Status.OK;
                    } else if (stat == Status.LEFT && parts[k].charAt(i) == '/') {
                        stat = Status.OK;
                    } else if (stat == Status.OK && parts[k].charAt(i) == '|') {
                        stat = Status.OK;
                    } else if( (stat == Status.LEFT || stat == Status.RIGHT) && parts[k].charAt(i) == '|' ) {
                    } else {
                        break;
                    }
                }
            }

        }

        if (torches.size() == 0 && alreadiLitTorches == 0) {
            System.out.println(":(");
        } else if( (torches.size() + alreadiLitTorches) < n ) {
            System.out.println( n - (torches.size() + alreadiLitTorches) );
        } else if( alreadiLitTorches > n ) {
            System.out.println( n - alreadiLitTorches );
        } else if( (torches.size() + alreadiLitTorches) >= n ) {

            int r = n - alreadiLitTorches;

            for (int i = 0; i < r; ++i) {

                StringBuilder sb = new StringBuilder(parts[torches.get(i).wick[1]]);
                sb.setCharAt(torches.get(i).wick[0],'$');
                parts[torches.get(i).wick[1]] = sb.toString();
            }

            for( int i = 0; i < parts.length; ++i ) {
                System.out.println(parts[i]);
            }

        } else {
            throw new IllegalArgumentException(scene);
        }
    }

    enum Status {
        OK, LEFT, RIGHT;
    }

    static class T {
        int[] wick;
    }