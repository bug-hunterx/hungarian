static void f(int k,String s){String[] F=s.split("\n");int n=F.length;int m=F[0].length();int V=0,C=0;int[] U=new int[m];for (int j=0;j<m;j++){U[j]=-1;String Z="";for(int i=0;i<n;i++){Z+=F[n-i-1].charAt(j);}if(Z.matches("^X[|\\\\/]+[\\$\\.].*$")){int A=0;int i;for(i=0;Z.charAt(i)!='$'&&Z.charAt(i)!='.'&&Math.abs(A)<2;i++){if(Z.charAt(i)=='\\') A++;if(Z.charAt(i)=='/') A--;}if(A==0){if(Z.charAt(i)=='.') {U[j]=i;C++;}if(Z.charAt(i)=='$'){V++;}}}}if(V+C==0){System.out.print(":(");}else if(k<V){System.out.print(""+(k-V));}else if(V+C<k){System.out.print(""+(k-V-C));}else{for(int i=0;i<n;i++){for(int j=0;j<m;j++){if(U[j]==n-i-1&&k>V){k--;System.out.print("$");}else {System.out.print(F[i].charAt(j));}}System.out.println();}}}