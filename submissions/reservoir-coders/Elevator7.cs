static void f(string s)
{
	var capacity = int.Parse(s.Split('\n')[0].Split(':')[1]);
	var floors = s.Split('\n').Skip(1).Reverse();
	var building = new Dictionary<int, Dictionary<int, int>>();
	int c = 0;
	foreach (var f in floors)
	{
		building[c] = new Dictionary<int, int>();
		for (int i = 0; i < floors.Count() + ((floors.Count() > 4) ? 1 : 0); i++)
		{
			if (i == 4) i++;
			var p = 0;
			var pt = f.Split('|').ToDictionary(x => int.Parse(x.Split(':')[1]), x => int.Parse(x.Split(':')[0]));
			if (pt.ContainsKey(i)) p = pt[i];
			building[c].Add(i, p);
		}
		c++;
		if (c == 4) c++;
	}
	fr(0, capacity, 0, true, building.Select(i => new KeyValuePair<int, IEnumerable<KeyValuePair<int, int>>>(i.Key, i.Value.Select(h => h))), new Dictionary<int, int>());
}

static void fr(int stops, int cap, int elevatorAt, bool goingUp,
	IEnumerable<KeyValuePair<int, IEnumerable<KeyValuePair<int, int>>>> building,
	 IEnumerable<KeyValuePair<int, int>> elevator)
{
	int maxFloor = building.Count() - 1;
	if (maxFloor >= 4) maxFloor++;
	goingUp = goingUp && elevatorAt != maxFloor || elevatorAt == 0;
	var newElevator = elevator.Where(kvp => kvp.Key != elevatorAt).ToDictionary(kvp => kvp.Key, kvp => kvp.Value);
	var newBuilding = building.ToDictionary(k => k.Key, k => k.Value.ToDictionary(j => j.Key, j => j.Value));
	var thisFloor = building.First(k => k.Key == elevatorAt).Value;
	foreach (var d in thisFloor.Where(w => (w.Key > elevatorAt && goingUp) || (w.Key < elevatorAt && !goingUp)))
	{
		if (!newElevator.ContainsKey(d.Key)) newElevator.Add(d.Key, 0);
		newElevator[d.Key] = newElevator[d.Key] + d.Value;
		newBuilding[elevatorAt][d.Key] -= d.Value;
	}
	if (cap < 1 + newElevator.Select(x => x.Value).Sum())
	{
		Console.WriteLine("polite after " + stops + " stops on " + elevatorAt + " floor"); return;
	}
	if (0 == newElevator.Select(x => x.Value).Sum())
	{
		Console.WriteLine("lonely after " + stops + " stops on " + elevatorAt + " floor"); return;
	}
	fr(stops + 1, cap, elevatorAt + (goingUp ? (elevatorAt == 3 ? 2 : 1) : (elevatorAt == 5 ? -2 : -1)), goingUp, newBuilding.Select(i => new KeyValuePair<int, IEnumerable<KeyValuePair<int, int>>>(i.Key, i.Value.Select(h => h))), newElevator);
}