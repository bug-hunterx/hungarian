        static void f(string building, int capacity)
        {
            string[] floors = building.Split('\n');
            Array.Reverse(floors);// determine the waiting ppl on the floors
            int currentFilling = 1; // we are the only one in the elevator when the game starts
            int currentFloor = 0; // we start on the BOTTOM
            int[] targetFloor = new int[floors.Length]; // how many ppl wants to go there
            int nextFloor = currentFloor; // the next floor where the elevator will stop
            int direction = -1; // at the begining we are going down
            int numberOfStops = 0; // we just start to count how many times we stoped
            for (;;)
            {
                currentFilling -= targetFloor[currentFloor];
                targetFloor[currentFloor] = 0;
                //System.Diagnostics.Debug.WriteLine(string.Format("{0} people leave on the {1} floor. {2} left in the elevator.", targetFloor[currentFloor], currentFloor, currentFilling));

                string currentFloorContent = floors[currentFloor];
                //System.Diagnostics.Debug.WriteLine(string.Format("There is loadable people on the floor: {0} ({1})", currentFloor, currentFloorContent));
                if (currentFloorContent != "")
                {
                    load(ref currentFloorContent/*ref cause not sure if everybody will hop in*/, ref targetFloor, currentFloor, ref direction, ref currentFilling);
                    floors[currentFloor] = currentFloorContent;
                }
                if (currentFilling > capacity) { System.Diagnostics.Debug.WriteLine(string.Format("polite after {0} stops at {1} floor", numberOfStops, currentFloor)); return; }
                if (currentFilling == 1) { System.Diagnostics.Debug.WriteLine(string.Format("lonely after {0} stops at {1} floor", numberOfStops, currentFloor)); return; }
                numberOfStops++;
                currentFloor = caluclateNextFloor(targetFloor, currentFloor, direction);
                
            }
        }

        static void load(ref string currentFloorContent, ref int[] targetFloor, int currenFloor, ref int direction, ref int currentFilling)
        {
            string[] pplToFloors = currentFloorContent.Split('|');
            bool firstIn = true;
            currentFloorContent = "";
            int currentNextFloor = caluclateNextFloor(targetFloor, currenFloor, direction);

            foreach (var ppl in pplToFloors)
            {
                string[] pplSplitted = ppl.Split(':');
                int howManyToGo = int.Parse(pplSplitted[0]);
                int whereToGo = int.Parse(pplSplitted[1].Replace('f','4').Replace('F','4'));
                
                if (currenFloor==currentNextFloor && firstIn)
                {
                    direction = Math.Sign(whereToGo - currenFloor);
                    firstIn = false;
                }
                if (direction * (whereToGo - currenFloor) > 0)
                {
                    targetFloor[whereToGo] += howManyToGo;
                    currentFilling += howManyToGo;
                }
                else
                {
                    currentFloorContent += ppl + "|";
                }
            }
            if (currentFloorContent != "")
            {
                currentFloorContent = currentFloorContent.Substring(0, currentFloorContent.Length - 1);
            }
        }

        static int caluclateNextFloor(int[] targetFloor, int currentFloor, int direction)
        {
            int tries = 0;
            if (currentFloor == 0) direction = 1;
            if (currentFloor == targetFloor.Length - 1) direction = -1;
            for (int nextFloor = currentFloor + direction; tries < targetFloor.Length; nextFloor += direction)
            {
                if (tries == targetFloor.Length - 1) return currentFloor;
                if (targetFloor[nextFloor] > 0) return nextFloor;
                if (nextFloor == 0 || nextFloor == targetFloor.Length - 1)
                {
                    direction *= -1;
                    nextFloor = currentFloor;
                }
                tries++;
            }

            return currentFloor;
        }