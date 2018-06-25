
winCombos = {
    "123", 
    "456",
    "789",
    "147",
    "258",
    "369",
    "159",
    "357"
    }

function findElement(character, fulltext)
    for i = 1, #fulltext do
        if character == fulltext:sub(i,i) then return true end
    end
    return false
end

function containsAllElementFromWinCombo(aWinCombination, moves) 
    
    containsAll = true
    
    for i = 1, #aWinCombination do
        oneStep = aWinCombination:sub(i,i)
        if not findElement(oneStep, moves) then containsAll = false end
    end
    
    return containsAll
end

function isWinner(moves) 
    for i = 1, 8, 1 do
        aWinCombination = winCombos[i]
        if containsAllElementFromWinCombo(aWinCombination, moves) then
            return true
        end
    end
    return false
end

function f(theCase) 
    
    eO = ""
    eX = ""
    
    for i = 1, #theCase do
        c = theCase:sub(i,i)
        
            if i % 2 == 0 then
                eX = eX..c
            else
                eO = eO..c
            end
    end
    
    if isWinner(eO) then
        return "O"
    elseif isWinner(eX) then
        return "X"
    else
        return "?"    
    end
end
    

testcases = {
{"5237649", "O"},
{"52376498", "O"},
{"523764918", "O"},
{"352476", "X"},
{"4268379", "O"},
{"631854792", "?"},
{"523764918", "O"},
}

function testAll (tests)
    
    isOk = true
    
    for i = 1, 7, 1 do
        
        actualInput = tests[i][1]
        expected = tests[i][2]
        
        actualOutput = f(actualInput)
        
        ok = expected == actualOutput
        
        if not ok then 
            print (string.format("%s", ok) .. " :: " .. actualInput .. " => " .. expected) 
            isOk = false
        end
    end

    if isOk then print("EVERYHING IS OK") end
end

testAll(testcases)


