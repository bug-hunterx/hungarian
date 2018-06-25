static void f(String building, int capacity){
        goingUp=true;
        int numberOfPpl = 0;
        int currentLevel = 0;
        int stops = 0, prevLevel= 0;
        buildingLevels = new LinkedList<>(Arrays.asList(building.split("\n")));
        
        levelMap = new HashMap<>();
        Collections.reverse(buildingLevels);
        if(buildingLevels.size() > 4) buildingLevels.add(4,"");
        numberOfPpl -= getOut(currentLevel);
        numberOfPpl += getIn(currentLevel);
        if(numberOfPpl >= capacity && currentLevel == 0){
            System.out.println("polite" + " after " + stops + " stops at " + 0 + " floor");
            return;
        }
        do{
            prevLevel = currentLevel;
            currentLevel = nextLevel(currentLevel);
            goingUp = currentLevel == 0?true:currentLevel == buildingLevels.size()-1?false:(prevLevel < currentLevel);
            numberOfPpl -= getOut(currentLevel);
            numberOfPpl += getIn(currentLevel);
            stops++;
        }while(!(numberOfPpl <= 0 || numberOfPpl >= capacity || currentLevel == -1));
        System.out.println((numberOfPpl==0?"lonely":"polite") + " after " + stops + " stops at " + Math.max(currentLevel,0) + " floor");
    }

    private static boolean up(int level){
        return levelMap.keySet().stream().filter(level1 -> level1 > level  && !levelMap.get(level).isEmpty()).sorted().findFirst().isPresent();
    }

    private static int nextLevel(int currentLevel) {
        return levelMap.keySet().stream().filter(level -> level > currentLevel  && !levelMap.get(level).isEmpty()).sorted().findFirst().orElseGet(
                ()->levelMap.keySet().stream().filter(level -> level < currentLevel && !levelMap.get(level).isEmpty()).sorted((a,b)->b-a).findFirst().orElse(-1));
    }

    private static int getIn(int level) {
        int inSum = 0;
        String levelString = buildingLevels.get(level);
        long count = levelMap.entrySet().stream().filter(entry -> !entry.getValue().isEmpty()).count();
        if(!levelString.isEmpty()) {
            String[] movingData = levelString.split("\\|");
            List<String> newData = new ArrayList<>();
            for (String s : movingData) {
                String[] data = s.split(":");
                Integer pplToLevel = Integer.parseInt(data[0]);
                Integer toLevel = Integer.parseInt(data[1]);

                if((toLevel > level && goingUp) ||(toLevel < level &&!goingUp)){
                    addToMap(toLevel, pplToLevel);
                    inSum += pplToLevel;
                    if(count == 0 && levelMap.entrySet().stream().filter(entry -> !entry.getValue().isEmpty()).count() >0 ){
                        goingUp = goingUp || toLevel > level;
                    };
                }else{
                    newData.add(pplToLevel + ":" + toLevel);
                }

            }
            buildingLevels.set(level, newData.stream().collect(Collectors.joining("|")));
        }
        return inSum;

    }

    private static int getOut(Integer level) {
        int result = getList(level).stream().reduce((a,b)->a+b).orElse(0);
        levelMap.put(level, new ArrayList<>());
        return result;
    }

    private static void addToMap(Integer key, Integer value) {
        List<Integer> levelList = getList(key);
        levelList.add(value);
        levelMap.put(key, levelList);
    }

    static List<Integer> getList(Integer level){
        List<Integer> levelList = levelMap.get(level);
        if(levelList == null){
            levelList = new ArrayList<>();
        }
        return levelList;
    }