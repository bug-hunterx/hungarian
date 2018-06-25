
static void f(string s)
{
	//Console.Write(s);
	var map = new Cell[s.Split('\n').Max(_ => _.Length) + 1, s.Split('\n').Length];
	var actors = new List<Cell>();
	var targets = new List<Cell>();
	var x = 0;
	var y = 0;
	var actorId = 1;
	foreach (var c in s)
	{
		if (c == '\n')
		{
			x = 0;
			y += 1;
			continue;
		}

		#region init
		var actor = map[x, y] = new Cell();
		actor.x = x;
		actor.y = y;
		actors.Add(actor);
		switch (c)
		{
			case '^':
				actor.TurretId = actorId;
				actor.TurretDirection = Directions[0];
				break;
			case 'v':
				actor.TurretId = actorId;
				actor.TurretDirection = Directions[1];
				break;
			case '<':
				actor.TurretId = actorId;
				actor.TurretDirection = Directions[2];
				break;
			case '>':
				actor.TurretId = actorId;
				actor.TurretDirection = Directions[3];
				break;
			case '\\':
				actor.MirrorId = actorId;
				actor.MirrorDirection = false;
				break;
			case '/':
				actor.MirrorId = actorId;
				actor.MirrorDirection = true;
				break;
			case '#':
				actor.WallId = actorId;
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				actor.PortalId = c + 1;
				break;
			case '@':
				actor.TargetId = actorId;
				targets.Add(actor);
				break;
		}
		#endregion
		x += 1;
		actorId++;
	}

	var turrets = actors.Where(i => i.TurretId > 0);
	//var mirrors = actors.Where(i => i.MirrorId > 0);

	foreach (var turret in turrets)
	{
		var cx = turret.x;
		var cy = turret.y;

		var dir = turret.TurretDirection;

		while (true)
		{
			try
			{
				var targetActor = map[cx, cy];

				if (targetActor.WallId > 0 || (targetActor.TurretId > 0 && targetActor != turret))
					break;

				if (targetActor.PortalId > 0)
				{
					var otherPortal = actors.SingleOrDefault(i => i.PortalId == targetActor.PortalId && i != targetActor);
					cx = otherPortal.x;
					cy = otherPortal.y;
				}

				#region redirect next step
				var region = false;
				if (targetActor.MirrorId > 0)
				{
					if (!targetActor.MirrorDirection) //     \
					{
						if (dir[0] == 1) // balrol
						{
							dir = Directions[1]; // lefele
						}
						else if (dir[0] == -1) // jobbrol
						{
							dir = Directions[0]; // felfele
							region = true;
						}
						else if (dir[1] == 1) // fentrol
						{
							dir = Directions[3]; // jobbra
							region = true;
						}
						else if (dir[1] == -1) // lentrol
						{
							dir = Directions[2]; // balra
						}
					}
					else //        /
					{
						if (dir[0] == 1) // balrol
						{
							dir = Directions[0]; // felfele
						}
						else if (dir[0] == -1) // jobbrol
						{
							dir = Directions[1]; // lefele
							region = true;
						}
						else if (dir[1] == 1) // fentrol
						{
							dir = Directions[2]; // balra
						}
						else if (dir[1] == -1) // lentrol
						{
							dir = Directions[3]; // jobbra
							region = true;
						}
					}
				}
				#endregion

				if (targets.Count(target => target.BeamingIds.Any()) == targets.Count)
				{
					Console.Write(":D");
					return;
				}

				if (
					 targetActor.MirrorId > 0 && targetActor.BeamingIds.ContainsKey(region)
					 ||
					 targetActor.MirrorId == 00 && targetActor.BeamingIds.Count >= 1
				   )
				{
					Console.Write(":/");
					return;
				}
				targetActor.BeamingIds.Add(region, turret.TurretId);

				cx = cx + dir[0];
				cy = cy + dir[1];
			}
			catch { break; }
		}
		//Console.Write("---------");
		Console.Write(":(");
		return;
	}
}

private static int[][] Directions = { new[] { 0, -1 }, new[] { 0, 1 }, new[] { -1, 0 }, new[] { 1, 0 } };

private class Cell
{
	public int x;
	public int y;

	public int TurretId;
	public int[] TurretDirection;
	public int MirrorId;
	public bool MirrorDirection;
	public int WallId;
	public int TargetId;
	public int PortalId;

	public Dictionary<bool, int> BeamingIds = new Dictionary<bool, int>();
}
