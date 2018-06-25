static void f(String building, int capacity) {
String[] storeyQueues = building.split("\n");
int storeyNumber = storeyQueues.length;

int currentFloor = 0;
boolean direction = true; //UP
int personsNumberInLift = 0;
int steps = 0;

String lift = "";

while (true) {

    if (steps != 0) {
        String[] groups = lift.split("\\|");

        boolean stop = false;
        for (String group : groups) {
            int toFloor = Integer.parseInt(String.valueOf(group.charAt(2)));
            if (toFloor == currentFloor) {
                stop = true;
            }
        }
        if (!stop) {
            //Skip this floor
            if (direction) { //UP
                currentFloor++;
            } else {
                currentFloor--;
            }
            continue;
        }

        StringBuffer newLift = new StringBuffer();
        for (String group : groups) {
            int numberOfGuysInGroup = Integer.parseInt(String.valueOf(group.charAt(0)));
            int toFloor = Integer.parseInt(String.valueOf(group.charAt(2)));

            if (toFloor != currentFloor) {
                newLift = newLift.append(group).append("|");
            } else {
                personsNumberInLift=personsNumberInLift-numberOfGuysInGroup;
            }
        }
        lift = newLift.toString();
    }
    steps++;

    String queue = storeyQueues[storeyNumber - currentFloor -1];
    StringBuffer newQueue = new StringBuffer();

    String[] groups = queue.split("\\|");

    if (!"".equals(queue)) {
        if (personsNumberInLift == 0 && groups.length != 0) {
            for (String group : groups) {
                int numberOfGuysInGroup = Integer.parseInt(String.valueOf(group.charAt(0)));
                int toFloor = Integer.parseInt(String.valueOf(group.charAt(2)));

                personsNumberInLift += numberOfGuysInGroup;
                lift = lift.concat(group).concat("|");

                if (toFloor >= currentFloor) {
                    direction = true; //UP
                } else {
                    direction = false; //DOWN
                }
            }

        } else {
            for (String group : groups) {
                int numberOfGuysInGroup = Integer.parseInt(String.valueOf(group.charAt(0)));
                int toFloor = Integer.parseInt(String.valueOf(group.charAt(2)));
                if (direction) { //UP
                    if (currentFloor <= toFloor) {
                        personsNumberInLift += numberOfGuysInGroup;
                        lift = lift.concat(group).concat("|");
                    } else {
                        newQueue = newQueue.append(group);
                    }
                } else {
                    if (currentFloor >= toFloor) {
                        personsNumberInLift += numberOfGuysInGroup;
                        lift = lift.concat(group).concat("|");
                    } else {
                        newQueue = newQueue.append(group);
                    }
                }
            }
        }
    }

    if (personsNumberInLift <= 0) {
        System.out.println("lonely after " + (steps-1) + " stops at " + currentFloor + " floor");
        return;
    } else if (capacity<=personsNumberInLift) {
        System.out.println("polite after " + (steps-1) + " stops at " + currentFloor + " floor");
        return;
    } else {
        queue = newQueue.toString();
        storeyQueues[storeyNumber - currentFloor -1] = queue;
    }

    if (direction) { //UP
        currentFloor++;
    } else {
        currentFloor--;
    }

    //Set the direction of the elavator
    if (storeyNumber<=currentFloor+1) {
        direction=false; //Move down
    }
    if (currentFloor<=0) {
        direction=true;  //Move up
    }
}
}


