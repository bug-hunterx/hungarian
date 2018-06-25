static void f(string e, int c)
{
    var l = File.ReadAllLines(e);

    var t = new Dictionary<int, int>();
    for (int i = 0; i < l.Length+1; i++)
    {
        if (i == 4)
            i++;
        t.Add(i,i==0?1:0);
    }

    var waitingList = new Dictionary<int, Dictionary<int,int>>();

    var a = l.Reverse().ToArray();
    var floor = 0;
    for (int i = 0; i < a.Count(); i++)
    {
        if (i == 4)
            floor++;

        var floorDesc = a[i].Split('|');

        var waitingOnFloor = new Dictionary<int, int>();

        foreach (var s in floorDesc)
        {
            if(String.IsNullOrEmpty(s))
                continue;

            var w = s.Split(':');

            var persons = Int32.Parse(w[0]);
            var wannaFloor = Int32.Parse(w[1]);

            waitingOnFloor.Add(wannaFloor, persons);

        }

        if (waitingOnFloor.Any())
            waitingList.Add(floor, waitingOnFloor);

        floor++;
    }

    var up = true;
    var currentFloor = 0;
    var inTheLift = new Dictionary<int, int>();
    var stopCount = 0;

    Func<int> stepInTheLift = () =>
    {
        var dl = new List<int>();
        var stepInCount = 0;
        // step in to lift
        foreach (
            var cwl in
                waitingList[currentFloor].Where(
                    i => (up && i.Key > currentFloor) || (!up && i.Key < currentFloor)))
        {
            dl.Add(cwl.Key);

            stepInCount += cwl.Value;

            if (inTheLift.ContainsKey(cwl.Key))
                inTheLift[cwl.Key] += cwl.Value;
            else
                inTheLift.Add(cwl.Key, cwl.Value);
        }

        

        foreach (var i in dl)
        {
            waitingList[currentFloor].Remove(i);
        }

        if (!waitingList[currentFloor].Any())
            waitingList.Remove(currentFloor);

        return stepInCount;
    };

    var maxFloor = (l.Count() >= 4 ? l.Count() + 1 : l.Count())-1;

    //Console.WriteLine("Step in {0} people at ground floor\n", stepInTheLift() + 1);
    stepInTheLift();
    currentFloor++;

    while (true)
    {
        if (up && currentFloor == 4)
            currentFloor++;

        if (!up && currentFloor == 4)
            currentFloor--;

        if (currentFloor == maxFloor)
            up = false;
        if (currentFloor == 0)
            up = true;

        if (inTheLift.ContainsKey(currentFloor))
        {
            var output = new StringBuilder("\n");
            output.AppendFormat("Lift stopped at {0} floor\n", currentFloor);
            stopCount++;

            var iso = inTheLift[currentFloor];

            output.AppendFormat("\tStep out {0} people\n", iso);

            // step out from lift
            inTheLift.Remove(currentFloor);

            if (waitingList.ContainsKey(currentFloor))
            {
                output.AppendFormat("\tStep in {0} people\n", stepInTheLift());
            }

            output.AppendFormat("\tThere are {0} people in the lift at floor {1}\n", inTheLift.Sum(i => i.Value) + 1, currentFloor);

            //Console.Write(output.ToString());
        }

        

        if (inTheLift.Sum(i => i.Value) + 1 > c)
        {
            Console.Write("polite after {0} stops at {1} floor", stopCount, currentFloor);
            break;
        }

        if (inTheLift.Sum(i => i.Value) == 0)
        {
            Console.Write("lonely after {0} stops at {1} floor", stopCount, currentFloor);
            break;
        }

        currentFloor += up ? 1 : -1;
    }
}