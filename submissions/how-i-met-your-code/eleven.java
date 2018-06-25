static void f(String m){
    String lines[] = m.split("\n");
    int borderX = lines.length, borderY = 0, counter = 0, destroyed = 0, colors[][] = new int[borderX][];
    boolean happy = false, sad = false, neutral = false;
    char [][] map = new char[borderX][];

    for(int i = 0 ; i < borderX; ++i) {
        map[i] = lines[i].toCharArray();
        if(borderY==0) borderY = map[i].length;
        colors[i] = new int[borderY];
        for(int j = 0 ; j < borderY ; ++j)
        {
            colors[i][j] = 0;
            if(map[i][j] == '@') ++counter;
        }
    }
    int coordX, coordY;
    for(coordX = 0 ; coordX < borderX ; ++coordX){
        for(coordY = 0 ; coordY < borderY; ++coordY){
            char c = map[coordX][coordY];
            int directionX = 0, directionY = 0;
            switch (c) {
                case '>':
                    directionX = 0;
                    directionY = 1;
                    break;
                case '<':
                    directionX = 0;
                    directionY = -1;
                    break;
                case '^':
                    directionX = -1;
                    directionY = 0;
                    break;
                case 'v':
                    directionX = 1;
                    directionY = 0;
                    break;
            }
            boolean end = directionX == 0 & directionY == 0, foundMyWay = false;
            int coordInnerX = coordX, coordInnerY = coordY;
            while(!end) {
                coordInnerX += directionX;
                coordInnerY += directionY;
                if(!(end=coordInnerX==borderX|coordInnerY==borderY|coordInnerX<0|coordInnerY<0)){
                    c = map[coordInnerX][coordInnerY];
                    if(c == '@'||c == '#'){
                        if(c == '@'&colors[coordInnerX][coordInnerY] == 0) {
                            colors[coordInnerX][coordInnerY] = 1;
                            ++destroyed;
                        }
                        end = true;
                        foundMyWay = true;
                    } else if(c>'/' && c<':'){
                        boolean b = false;
                        for(int i = 0 ; i < borderX & !b ; ++i){
                            for (int j = 0; j < borderY & !b; ++j) {
                                if ((i != coordInnerX | j != coordInnerY) & map[i][j] == c) {
                                    coordInnerX = i;
                                    coordInnerY = j;
                                    b = true;
                                }
                            }
                        }
                    } else if(c=='\\' || c=='/'){
                        if(c=='\\') {
                            int tmp = directionX;
                            directionX = directionY;
                            directionY = tmp;
                        } else {
                            int tmp = directionX;
                            directionX = -1 *directionY;
                            directionY = -1 *tmp;
                        }
                    } else if(c == ' ' & colors[coordInnerX][coordInnerY]!=0) {
                        neutral = true;
                        end = true;
                        foundMyWay = true;
                    } else {
                        colors[coordInnerX][coordInnerY] = 1;
                    }
                }
            }
        }
    }
    happy = destroyed == counter;
    if(neutral){
        System.out.print(":/");
    } else if(happy) {
        System.out.print(":D");
    } else{
        System.out.print(":D");
    }
}