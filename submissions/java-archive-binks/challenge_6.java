static void f(int c){
        int total = 0;
        if(c < 2000){
            total = (((c-1)/100)+1)*100;
        }else if (c < 5000) {
            total = (((c-1)/500)+1)*500;
        }else {
            total = ((((int)(c*1.1)-250)/500)+1)*500;
        }
        int tip = total - c;
        if (tip == 0 || tip > 1500) {
            System.out.print("PAID BY CARD");
        }else if (tip % 100 != 0) {
            System.out.print("KEEP THE CHANGE YOU FILTY ANIMAL");
        }else {
            System.out.print("HERE IS "+total);
        }
    }