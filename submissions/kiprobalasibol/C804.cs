public class Laser
{
    public string Execute(string scene)
    {
        const string directions = @"<>^v\^v<>/v^><";
        var width = scene.IndexOf('\n') + 1;
        if (width == 0) width = scene.Length;
        var vectors = new[] { -1, 1, -width, width };

        var found = new HashSet<int>();
        var have = 0;
        var curr = 0;
        var routes = new int[scene.Length];
        var cross = false;

        for (var i = 0; i < scene.Length && !cross; i++)
        {
            var pos = i;
            int dir;
            char c = scene[pos];

            if (c == '@') have++;
            else if ((dir = directions.IndexOf(c, 0, 4)) > -1)
            {
                curr++;
                while (true)
                {
                    pos = pos + vectors[dir];
                    if (pos < 0
                        || pos >= scene.Length
                        || "<^>v#\n".IndexOf(c = scene[pos]) > -1) break;

                    if (c == '@')
                    {
                        found.Add(pos);
                        break;
                    }

                    int tmp;
                    if (c >= '0' && c <= '9')
                    {
                        pos = (tmp = scene.IndexOf(c, pos + 1)) == -1
                                       ? scene.IndexOf(c, 0, pos)
                                       : tmp;
                    }
                    else if ((tmp = directions.IndexOf(c)) > -1)
                    {
                        dir = directions.IndexOf(directions[dir + tmp + 1]);
                    }

                    if (c == ' ')
                    {
                        if (routes[pos] > 0 && routes[pos] != curr)
                        {
                            cross = true;
                            break;
                        }

                        routes[pos] = curr;
                    }
                }
            }
        }

        return cross ? ":/" : (found.Count == have ? ":D" : ":(");
    }
}

static void f(string b)
{
    Console.WriteLine(new Laser().Execute(b));
}
