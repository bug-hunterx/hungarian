	function f(cost){
		tip = 0;
		if(cost < 2000){			
			tip = (((cost + 99) / 100 ) * 100)-cost;
			cost += tip;
		}else if(cost < 5000){
			tip = (((cost + 499) / 500 ) * 500)-cost;
			cost += tip;
		}else{
			tip = (cost*0.1);			
			cost = (((cost+tip)/500)+0.5)*500;
		}
		if(tip==0||tip>1500) {
			console.log("PAID BY CARD");
		}else if(tip%100>0) {
			console.log("KEEP THE CHANGE YOU FILTY ANIMAL"); 
		}else {console.log("HERE IS "+cost);}
	}