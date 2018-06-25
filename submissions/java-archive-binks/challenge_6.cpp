void f(int c){int t=0;if(c<2000){t=(((c-1)/100)+1)*100;}else if(c<5000){t=(((c-1)/500)+1)*500;}else{t=((((int)(c*1.1)-250)/500)+1)*500;}int T=t-c;if(T==0||T>1500){printf("PAID BY CARD");}else if(T%100!=0){printf("KEEP THE CHANGE YOU FILTY ANIMAL");}else{printf("HERE IS %d",t);}}

