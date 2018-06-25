function f(buildingRaw, capacity) {
    var building = buildingRaw.split('\n'),
        numberOfFloors = building.length,
        currentDir = 1,
        currentMaxWish = 0,
        currentLoad = 1,
        currentFloor = 0,
        actualPassengers = [],
        numberOfStops = -1;

    building.reverse().forEach(function (floor, floorIndex) {
        var passengers = floor.split('|'),
            floorObj = {
                goUp: [],
                goDown: []
            };

        passengers.forEach(function (passenger) {
            var passDetails = passenger.split(':'),
                number = parseInt(passDetails[0],10),
                desiredFloor = parseInt(passDetails[1],10),
                category;

            desiredFloor = desiredFloor > 3 ? desiredFloor-1 : desiredFloor;

            if (desiredFloor > floorIndex) {
                category = floorObj.goUp;
            } else {
                category = floorObj.goDown;
            }

            category.push({
                num: number,
                floor: desiredFloor
            });
        });

        building[floorIndex] = floorObj;
    });

    for (var i = 0; i < building.length; i++) {
        actualPassengers[i] = [];
    }

    return stopOnFloor(currentFloor, currentDir, currentLoad, currentMaxWish, actualPassengers);

    function getNumberOfWaitingPassengers(passengerToDealWith) {
        var sum = 0;
        for (var i = 0; i < passengerToDealWith.length; i++) {
            sum += passengerToDealWith[i].num;
        }

        return sum;
    }

    function stopOnFloor(floor, direction, currentLoad, currentMaxWish, actualPassengers) {
        var passengerToDealWith = direction ? building[floor].goUp : building[floor].goDown,
            passengersToOtherDir = !direction ? building[floor].goUp : building[floor].goDown,
            numOfInPass = 0,
            nextFloorInThisDireciton,
            sum = getNumberOfWaitingPassengers(passengerToDealWith),
            actPass;

        numberOfStops++;

        if (currentLoad + sum > capacity) {
            console.log('polite after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor');
            return 'polite after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor';
        }

        // console.log(`Lift stopped at ${floor > 3 ? floor+1 : floor} floor`);

        // TAKING OFF
        actualPassengers[floor].forEach(function (offPass) {
            currentLoad -= offPass.num;
            // console.log(`Step out ${offPass.num} people`);
            // find new max-min
        });

        actualPassengers[floor] = [];

        // TAKING ON
        for (var i = 0; i < passengerToDealWith.length; i++) {
            actPass = passengerToDealWith[i];
            if (currentLoad + actPass.num <= capacity) {
                actualPassengers[actPass.floor].push(actPass);

                currentLoad += actPass.num;
                numOfInPass++;
                // console.log(`Step in ${actPass.num} people (${actPass.num}:${actPass.floor})`);
            } else if (currentLoad + actPass.num >= capacity) {
                console.log('polite after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor');

                return 'polite after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor'
            }
        }

        for (var j = 0; j < numOfInPass; j++) {
            passengerToDealWith.shift();
        }

        if (currentLoad === 1 && !passengerToDealWith.length && !passengersToOtherDir.length) {
            console.log('lonely after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor');
            return 'lonely after ' + numberOfStops + ' stops at ' + (floor > 3 ? floor+1 : floor) + ' floor';
        }

        nextFloorInThisDireciton = isThereMOrePassengerTowardsCurrentDirection(floor, direction, actualPassengers);

        if (nextFloorInThisDireciton !== false) {
            return stopOnFloor(nextFloorInThisDireciton, direction, currentLoad, currentMaxWish, actualPassengers);
        } else {
            // console.log('CHANGE DIR');
            direction = !direction;
            numberOfStops--;
            return stopOnFloor(floor, direction, currentLoad, currentMaxWish, actualPassengers);
        }
    }

    function isThereMOrePassengerTowardsCurrentDirection(actFloor, direction, actPassengers) {
        var i = actFloor;

        if (direction) {
            while (i < building.length) {
                if (actPassengers[i].length) {
                    return i;
                }
                i++;
            }

            return false;
        } else {
            while (i >= 0) {
                if (actPassengers[i].length) {
                    return i;
                }
                i--;
            }

            return false;
        }
    }


}
