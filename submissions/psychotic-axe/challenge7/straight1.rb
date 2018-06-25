def f(building, capacity)
    
    # build floor map
    
    puts "input: #{building} #{capacity}"
    floors = building.split("\n")
    puts "floors: #{floors}"
    floorMap = Hash.new
    floorCount = floors.size
    puts "floorCount: #{floorCount}"
    
    if floorCount > 4
        floors.insert(-5, '')
        floorCount += 1
    end
    puts "floors after insert: #{floors}"
    
    floors.each_with_index  do |floor, index|
        puts "floor: #{floor}"
        waiters = floor.split("|")
        puts "waiters: #{waiters}"
        waitersOnFloor = Hash.new
        waiters.each do |waitersForFloor|
            waiterData = waitersForFloor.split(":")
            waitingForFloor = waiterData[1].to_i
            numberOfWaiters = waiterData[0].to_i
            waitersOnFloor[waitingForFloor] = numberOfWaiters
            puts "#{numberOfWaiters} waiters on #{floorCount - 1 - index} waiting for #{waitingForFloor}"
        end
        floorMap[floorCount - 1 - index] = waitersOnFloor
    end
    puts "floorMap: #{floorMap}"

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
	puts "----------------"
        puts "stop #{stop}"
        
        currentFloor = buttonsPushed.pop
        peopleOnFloor = floorMap[currentFloor]
        puts "people on floor #{peopleOnFloor}"
        puts "peopleInLift: #{peopleInLift}"
        puts "free space #{freeSpace}"
        puts "direction #{direction}"
        
        freeSpace += peopleInLift[currentFloor].to_i
        peopleInLift.delete(currentFloor)
        puts "people left in lift: #{peopleInLift}, free space #{freeSpace}"
        
        candidates = peopleOnFloor.clone.delete_if { |key,_| (key - currentFloor) * direction < 0 }
        puts "pre dir check candidates on floor #{currentFloor}: #{candidates}"
        
        if buttonsPushed.size == 0 && peopleOnFloor.size > 0 && candidates.size == 0 && stop != 0
            direction *= -1
            puts "new direction #{direction}"
        end
        
        candidates = peopleOnFloor.clone.delete_if { |key,_| (key - currentFloor) * direction < 0 }
        puts "candidates on floor #{currentFloor}: #{candidates}"
        
        candidates.keys.each { |key| peopleOnFloor.delete(key) }
        puts "peopleOnFloor without candidates #{peopleOnFloor}"
        
        candidates.each do |waitingForFloor, candidateNum|
            if freeSpace > 0
				puts "candidate group to floor #{waitingForFloor}: #{candidateNum}"
                going = [candidateNum, freeSpace].min
				puts "going: #{going}"
                if going < candidateNum
                    candidates[waitingForFloor] = candidateNum - going
                else
                    candidates.delete(waitingForFloor)
                end
                freeSpace -= going
                (buttonsPushed << waitingForFloor).sort! { |x,y| direction * (y <=> x) }.uniq!
                peopleInLift[waitingForFloor] = peopleInLift[waitingForFloor].to_i + going
				puts "new free space: #{freeSpace}"
				puts "candidates left behind: #{candidates}"
				puts "buttonsPushed: #{buttonsPushed}"
				puts "peopleInLift: #{peopleInLift}"
            end
        end
        peopleOnFloor.merge!(candidates)
		puts "people left behind: #{peopleOnFloor}"
        
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

#polite after 3 stops at 1 floor
#f("1:0|1:1\n3:2|5:0\n1:1|2:2", 6)

#lonely after 4 stops at 0 floor
#f("2:1|3:2\n1:0|1:1\n3:2|5:0\n1:1|2:2", 10)

#polite after 7 stops at 5 floor
f("2:2|1:5\n3:8|1:0\n4:2|1:5|2:0\n1:1|2:0|4:2\n2:0|2:7\n1:0|1:8\n1:5|3:6|1:0\n1:1|1:3|2:5", 9)

#lonely after 2 stops at 2 floor
#f("1:0|1:1\n1:3|5:5|2:0\n\n3:2|5:0\n1:1|2:2", 10)
