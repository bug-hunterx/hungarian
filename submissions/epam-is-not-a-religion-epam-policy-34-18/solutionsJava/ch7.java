public static void f(String building, int capacity) {
        boolean directionIsUp = true;
        int actualFloor = 0;
final int[] availableCap = {capacity};
        int stops = 0;
        String[] floors = building.split("\n");
        //store the peoples in the elevator and store their target floor
        Map<Integer, Integer> travelers = new HashMap<>();
        // contains the pending requests
        List<Map<Integer, Integer>> requests = new ArrayList<>();
        for (String floor : floors) {
        Map<Integer, Integer> requestOfTheFloor = new HashMap<>();
        requests.add(requestOfTheFloor);
        for (String request : floor.split("\\|")) {
        String[] numbers = request.split(":");
        if (numbers.length == 2) {
        requestOfTheFloor.put(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[0]));
        }
        }
        }
        Collections.reverse(requests);
final String[] out = {"" };
        for(;;) {

        if (actualFloor == floors.length - 1) {
        directionIsUp = false;

        }
        if (actualFloor == 0) {
        directionIsUp = true;
        }
final int finalActualFloor = actualFloor;
final int finalStops = stops;
        fillLiftWithPassangers(capacity, directionIsUp, actualFloor, availableCap, travelers, requests, out, finalActualFloor, finalStops);

        if (capacity == availableCap[0]) {
        directionIsUp = !directionIsUp;
        fillLiftWithPassangers(capacity, directionIsUp, actualFloor, availableCap, travelers, requests, out, finalActualFloor, finalStops);
        }

        if (capacity == availableCap[0]) {
        out[0] = "lonely after "+finalStops+" stops at "+ finalActualFloor +" floor";
        }

        if (out[0].length() != 0) {
        System.out.println(out[0]);
        return;
        }

        if (directionIsUp) {
        actualFloor++;
        } else {
        actualFloor--;
        }
        stops++;

        for (Map.Entry<Integer, Integer> arrivedTravelers : travelers.entrySet()) {
        if (arrivedTravelers.getKey() == actualFloor) {
        availableCap[0] = availableCap[0] + arrivedTravelers.getValue();
        arrivedTravelers.setValue(0);
        }
        }

        }
        }

private static void fillLiftWithPassangers(final int capacity, boolean directionIsUp, int actualFloor, final int[] availableCap, final Map<Integer, Integer> travelers, List<Map<Integer, Integer>> requests, final String[] out, final int finalActualFloor, final int finalStops) {
        if (directionIsUp) {
        requests.get(actualFloor).entrySet().stream().filter(new Predicate<Map.Entry<Integer, Integer>>() {
@Override
public boolean test(Map.Entry<Integer, Integer> req) {
        return req.getKey() > finalActualFloor;
        }
        }).forEach(new Consumer<Map.Entry<Integer, Integer>>() {
@Override
public void accept(Map.Entry<Integer, Integer> req) {
        if (capacity != 0) {
        if (req.getValue() >= availableCap[0]) {
        out[0] = "polite after "+ finalStops +" stops at "+finalActualFloor+" floor";
        } else {
        availableCap[0] = availableCap[0] - req.getValue();
        if (travelers.containsKey(req.getKey())) {
        travelers.put(req.getKey(),travelers.get(req.getKey()) + req.getValue());
        } else {
        travelers.put(req.getKey(),req.getValue());
        }
        req.setValue(0);
        }
        }
        }
        });
        } else {
        requests.get(actualFloor).entrySet().stream().filter(new Predicate<Map.Entry<Integer, Integer>>() {
@Override
public boolean test(Map.Entry<Integer, Integer> req) {
        return req.getKey() < finalActualFloor;
}
        }).forEach(new Consumer<Map.Entry<Integer, Integer>>() {
@Override
public void accept(Map.Entry<Integer, Integer> req) {
        if (capacity != 0) {
        if (req.getValue() >= availableCap[0]) {
        out[0] = "polite after "+finalStops+" stops at "+finalActualFloor+" floor";
        } else {
        availableCap[0] = availableCap[0] - req.getValue();
        if (travelers.containsKey(req.getKey())) {
        travelers.put(req.getKey(),travelers.get(req.getKey()) + req.getValue());
        } else {
        travelers.put(req.getKey(),req.getValue());
        }
        req.setValue(0);
        }
        }
        }
        });
        }
        }