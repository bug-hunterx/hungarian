static void f(int k,String s){
        String[] rows = s.split("\n");
        int n=rows.length;
        int m = rows[0].length();
        int litTorch = 0,lightableTorch=0;
        int[] flameHeight = new int[m];
        for (int j=0;j<m;j++){
            flameHeight[j]=-1;
            String torch = "";
            for(int i=0;i<n;i++){
                torch+=rows[n-i-1].charAt(j);
            }
            if(torch.matches("^X[|\\\\/]+[\\$\\.].*$")){
                int count=0;
                int i;
                for(i=0;torch.charAt(i)!='$' && torch.charAt(i)!='.' && Math.abs(count)<2;i++){
                    if(torch.charAt(i)=='\\') count++;
                    if(torch.charAt(i)=='/') count--;
                }
                if(count == 0){
                    if(torch.charAt(i)=='.') {flameHeight[j] = i;lightableTorch++;}
                    if(torch.charAt(i)=='$'){litTorch++;}
                }
            }
        }
        if(litTorch+lightableTorch==0){
            System.out.print(":(");
        }else if(k<litTorch){
            System.out.print(""+(k-litTorch));
        }else if (litTorch+lightableTorch < k){
            System.out.print(""+(k-litTorch-lightableTorch));
        }else {
            for(int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if(flameHeight[j]==n-i-1 && k>litTorch){
                        k--;
                        System.out.print("$");
                    }else {
                        System.out.print(rows[i].charAt(j));
                    }
                }
                System.out.println();
            }

        }
    }