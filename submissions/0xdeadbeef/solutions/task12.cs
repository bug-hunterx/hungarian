static void f(string s, int w, int h)
        {
            var rows = s.Split('\n');
            var M = new char[rows[0].Length][];
            for (var i = 0; i < rows.Length; i++)
                M[i] = rows[i].ToCharArray();

            var velocity = '>';

            var path = new List<int[]> {new[] {0, 0, 0}};
            var posX = 0;
            var posY = 0;

            while (true)
            {
                int F = 0;
                int V = 0;
                int H = 0;
                int W = 0;
                var isOkay = false;
                for (var i = posX; i < posX + w; i++)
                    for (var j = posY; j < posY + h; j++)
                    {
                        try
                        {
                            var current = M[j][i];
                            if (current == '<') V--;
                            if (current == '>') V++;
                            if (current == 'v') F--;
                            if (current == '^') F++;
                            if (current == 'h') H--;
                            if (current == 'H') H++;
                            if (current == 'w') W--;
                            if (current == 'W') W++;
                            isOkay = true;
                        }
                        catch (Exception ex) { }
                    }

                if (!isOkay)
                {
                    Console.Write("9");
                    return;
                }

                if (H < 0) V = 0;
                if (W < 0) F = 0;


                if (F == 0 && V == 0)
                {
                    Console.Write("9");
                    return;
                }
                if (Math.Abs(F) > Math.Abs(V))
                {
                    velocity = Math.Sign(F) == -1 ? 'v' : '^';
                    posY -= Math.Sign(F);
                }
                else if (Math.Abs(F) < Math.Abs(V))
                {
                    velocity = Math.Sign(V) == -1 ? '<' : '>';
                    posX += Math.Sign(V);
                }
                else if (Math.Abs(F) == Math.Abs(V))
                {
                    if (velocity == '>') posX++;
                    if (velocity == '<') posX--;
                    if (velocity == 'v') posY++;
                    if (velocity == '^') posY--;
                }

                if (path.Any(p => p[0] == posX && p[1] == posY && p[2] == velocity))
                {
                    Console.Write("8");
                    return;
                }

                path.Add(new[] {posX, posY, velocity});

            }

        }