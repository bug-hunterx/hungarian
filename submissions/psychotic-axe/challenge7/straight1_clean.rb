def f(building, capacity)
    # build floor map
    
    floors = building.split("\n")
    floorMap = Hash.new
    floorCount = floors.size
    
    if floorCount > 4
        floors.insert(-5, '')
        floorCount += 1
    end
    
    floors.each_with_index  do |floor, index|
        waiters = floor.split("|")
        waitersOnFloor = Hash.new
        waiters.each do |waitersForFloor|
            waiterData = waitersForFloor.split(":")
            waitingForFloor = waiterData[1].to_i
            numberOfWaiters = waiterData[0].to_i
            waitersOnFloor[waitingForFloor] = numberOfWaiters
        end
        floorMap[floorCount - 1 - index] = waitersOnFloor
    end

    # initialize lift
    
    currentFloor = 0
    direction = 1
    freeSpace = capacity
    buttonsPushed = [0]
    peopleInLift = Hash.new
    
    # move lift
    result = ""
    stop = 0
    while true
        currentFloor = buttonsPushed.pop
        peopleOnFloor = floorMap[currentFloor]
        
        freeSpace += peopleInLift[currentFloor].to_i
        peopleInLift.delete(currentFloor)
        
        candidates = peopleOnFloor.clone.delete_if { |key,_| (key - currentFloor) * direction < 0 }
        
        if buttonsPushed.size == 0 && peopleOnFloor.size > 0 && candidates.size == 0 && stop != 0
            direction *= -1
        end
        
        candidates = peopleOnFloor.clone.delete_if { |key,_| (key - currentFloor) * direction < 0 }
        
        candidates.keys.each { |key| peopleOnFloor.delete(key) }
        
        candidates.each do |waitingForFloor, candidateNum|
            if freeSpace > 0
                going = [candidateNum, freeSpace].min
                if going < candidateNum
                    candidates[waitingForFloor] = candidateNum - going
                else
                    candidates.delete(waitingForFloor)
                end
                freeSpace -= going
                (buttonsPushed << waitingForFloor).sort! { |x,y| direction * (y <=> x) }.uniq!
                peopleInLift[waitingForFloor] = peopleInLift[waitingForFloor].to_i + going
            end
        end
        peopleOnFloor.merge!(candidates)
        
        if candidates.size == 0 && freeSpace == capacity
            result = "lonely after #{stop} stops at #{currentFloor} floor"
            break
        end
        if freeSpace == 0
            result = "polite after #{stop} stops at #{currentFloor} floor"
            break
        end
        
        stop += 1
    end
    
    # end
    puts result
end
