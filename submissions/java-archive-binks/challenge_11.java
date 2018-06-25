static void f(String s){
        String[] rows = s.split("\n");
        int n= rows.length, m= rows[0].length();
        char[][] matrix = new char[n][m];
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                matrix[i][j]=rows[i].charAt(j);
            }
        }
        boolean crossing = false;
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                int x=i,y=j;
                int dir = -1;
                char c = matrix[i][j];
                if (c == '>') dir = 0;
                if (c == '<') dir = 2;
                if (c == 'v') dir = 3;
                if (c == '^') dir = 1;
                if(dir > -1){
                    while(true){
                        x+=dir==3?1:(dir==1?-1:0);
                        y+=dir==0?1:(dir==2?-1:0);
                        if(x<0 || x>=n || y<0 || y>=m){
                            break;
                        }
                        c = matrix[x][y];
                        if(c=='@' || c=='!'){
                            matrix[x][y]='!';
                            break;
                        }
                        if((c=='>' && dir == 2)||(c=='<' && dir == 0)||(c=='^' && dir == 3)||(c=='v' && dir == 1)){
                            crossing=true;
                        }
                        if(c==' '){
                            matrix[x][y]='.';
                        }
                        if(c==':'){
                            crossing=true;
                        }
                        if("#><^v".contains(c+"")) {
                            break;
                        }
                        if(c=='/') dir = dir^1;
                        if(c=='\\') dir = 3-dir;
                        if(c >='0' && c<='9'){
                            boolean found = false;
                            for(int k=0;k<n;k++){
                                for(int l=0;l<m;l++){
                                    if(matrix[k][l]==c && (k!=x || l!=y) && !found){
                                        x=k;
                                        y=l;
                                        found = true;
                                    }
                                }
                            }
                        }
                    }
                }
                for(int k=0;k<n;k++){
                    for(int l=0;l<m;l++){
                        if(matrix[k][l]=='.') matrix[k][l]=':';
                    }
                }
            }
        }
        boolean allHit = true;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]=='@')
                    allHit=false;
            }
        }
        if(crossing){
            System.out.print(":/");
        }else if(allHit){
            System.out.print(":D");
        }else {
            System.out.print(":(");
        }
    }