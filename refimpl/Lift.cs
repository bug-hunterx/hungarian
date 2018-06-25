using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

namespace Challenges
{
    public class Lift
    {
        public string Execute(string building, int capacity)
        {
            var l = building.Split('\n');

            var t = new Dictionary<int, int>();
            for (int i = 0; i < l.Length + 1; i++)
            {
                if (i == 4)
                    i++;
                t.Add(i, i == 0 ? 1 : 0);
            }

            var waitingList = new Dictionary<int, Dictionary<int, int>>();

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
                    if (String.IsNullOrEmpty(s))
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

            Func<bool> canMoveForward = () =>
            {
                return (inTheLift.Any(i => up && i.Key > currentFloor && i.Value > 0)
                || inTheLift.Any(i => !up && i.Key < currentFloor && i.Value > 0))
                ||
                (waitingList.Keys.Any(i => i == currentFloor) && (waitingList[currentFloor].Any(i => up && i.Key > currentFloor) || waitingList[currentFloor].Any(i => !up && i.Key < currentFloor)));
            };


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

                //if (!waitingList[currentFloor].Any())
                //    waitingList.Remove(currentFloor);

                return stepInCount;
            };

            var maxFloor = (l.Count() >= 4 ? l.Count() + 1 : l.Count()) - 1;

            //Console.WriteLine("Step in {0} people at ground floor\n", stepInTheLift() + 1);
            stepInTheLift();

            if (inTheLift.Sum(i => i.Value) + 1 > capacity)
            {
                return String.Format("polite after {0} stops at {1} floor", stopCount, currentFloor);
            }
            else if (inTheLift.Sum(i => i.Value) == 0)
            {
                return String.Format("lonely after {0} stops at {1} floor", stopCount, currentFloor);
            }

            currentFloor++;

            while (true)
            {
                if (up && currentFloor == 4)
                    currentFloor++;

                if (!up && currentFloor == 4)
                    currentFloor--;

                if (currentFloor == maxFloor)
                    up = false;

                else if (currentFloor == 0)
                    up = true;

                else if (!canMoveForward() && currentFloor > 0)
                    up = !up;

                if (inTheLift.ContainsKey(currentFloor))
                {
                    stopCount++;

                    var iso = inTheLift[currentFloor];
                    inTheLift.Remove(currentFloor);

                    if (waitingList.ContainsKey(currentFloor))
                    {
                        stepInTheLift();
                    }
                }

                if (inTheLift.Sum(i => i.Value) + 1 > capacity)
                {
                    return $"polite after {stopCount} stops at {currentFloor} floor";
                }

                if (inTheLift.Sum(i => i.Value) == 0)
                {
                    return $"lonely after {stopCount} stops at {currentFloor} floor";
                    break;
                }

                currentFloor += up ? 1 : -1;
            }
        }
    }
}
