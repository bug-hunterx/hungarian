function f(building, capacity) {
    
    var floors = building.split('\n').reverse();
    if (floors.length > 3) {
        floors.splice(4, 0, '');
    }
    var currentFloor = 0;
    var travelers = [];
    var lonely = true;
    var up = true;
    var directionChanged = false;
    var stops = 0;

    var dirSign = () => up ? 1 : -1;

    var getTargetLevel = e => e.substring(2,3);
    var isElevatorEmptyButPeopleOnFloors = () => travelers.length == 0 && floors[currentFloor].length > 0;

    var getIn = () => {
        var goodArray = [];
        var badArray = [];
        floors[currentFloor].split('|').map(f=> getTargetLevel(f) * dirSign() > currentFloor * dirSign() ? goodArray.push(f):badArray.push(f));
        if(goodArray.length == 0 && travelers.length == 0) {
            up = !up;
            goodArray = badArray;
            badArray = [];
        }
        goodArray.map(x=>travelers.push(x));
        floors[currentFloor] = badArray.join('|');

    };

    var goToNextFloor = () => {
        var target;
        if (travelers.length > 0){
            target = travelers.reduce((a, b) => (up ? Math.min : Math.max)(a,getTargetLevel(b)), dirSign()/0)
        }
        stops++;
        currentFloor = target;

        if ((floors.length-1 == currentFloor || 0 == currentFloor) && isElevatorEmptyButPeopleOnFloors()){
            up = !up;
            directionChanged = true;
        }
    };

    var getOut = () => {
        if (travelers.length > 0){
            travelers = travelers.filter(x=>getTargetLevel(x)!=currentFloor);
        }
        if (isElevatorEmptyButPeopleOnFloors()){
            directionChanged = true;
        }

    };

    var limitReached = () => travelers.length > 0 ?
        capacity <= travelers.reduce((a, b) => a + parseInt(b.substring(0,1)),0)
        : false;

    do {
        directionChanged = false;
        getIn();
        if (limitReached()){
            lonely=false;
            break;
        }
        goToNextFloor();

        getOut();
    } while (travelers.length != 0 || directionChanged)
    console.log((lonely?'lonely':'polite') + ' after ' + stops + ' stops at ' + currentFloor + ' floor')
}