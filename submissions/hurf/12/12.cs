        static bool isHorizontal = true;
        static bool isVertical = true;

        

        static void f(String sceneInput, int width, int height)
        {
            isVertical = true;
            isHorizontal = true;

            char[,] scene = new char[1000,1000];
            int pozX = 500, pozY = 500;
            //int pozX = 0, pozY = 0;
            string[] seps = new string[] {"\n"};
            string[] rows;

            for (int i = 0; i < 1000; ++i)
                for (int j = 0; j < 1000; ++j)
                    scene[i, j] = ' ';
            
            rows = sceneInput.Split(seps, StringSplitOptions.None);

            int row = 0;
            foreach(string s in rows) {
                //Console.WriteLine(s);
                for (int i=0;i<s.Length;++i)
                {
                    scene[pozX+i,pozY+row] = s.ElementAt(i);
                }
                ++row;
            }

            //Console.WriteLine("---------------------");


            /*for (int i = 0; i < 50; ++i)
            {
                for (int j = 0; j < 50; ++j)
                {
                    Console.Write(scene[i, j]);
                }
                Console.WriteLine();
            }*/

            Coor<int, int, char> act = new Coor<int, int, char>(pozX, pozY, '>');
            Coor<int, int, char> newCoor = act;

            int[,] detect = new int[1000,1000];
            for (int i = 0; i < 1000; ++i)
                for (int j = 0; j < 1000; ++j)
                    detect[i, j] = 0;

            while (true)
            {
                //isVertical = true;
                //isHorizontal = true;
                //Console.WriteLine(newCoor);
                newCoor = calculate(scene, newCoor, width, height);
                if (newCoor == null)
                {
                    break;
                }
                else
                {
                    if (detect[newCoor.x, newCoor.y] > 30)
                    {
                        Console.WriteLine("8");
                        break;
                    }
                    else
                    {
                        detect[newCoor.x, newCoor.y] = detect[newCoor.x, newCoor.y] + 1;
                    }
                }
                //Console.WriteLine(newCoor);
                //Console.WriteLine("-------");
            }
        }
        
        private static Coor<int, int, char> calculate(char[,] scene, Coor<int, int, char> act, int width, int height)
        {
            Coor<int, int, char> ret = new Coor<int, int, char>();
            //counters
            Dictionary<char, int> counters = new Dictionary<char, int>();
            counters['h'] = 0;
            counters['H'] = 0;
            counters['w'] = 0;
            counters['W'] = 0;
            counters['^'] = 0;
            counters['v'] = 0;
            counters['<'] = 0;
            counters['>'] = 0;
            counters[' '] = 0;

            for (int i = 0; i < width; ++i)
            {
                for (int j = 0; j < height; ++j)
                {
                    char ch = scene[act.x + i, act.y + j];
                    int orig = counters[ch];
                    counters[ch] = orig + 1;
                }
            }

            //buttons
            if (counters['H'] > counters['h'])
            {
                isHorizontal = true;
            }
            else if (counters['H'] < counters['h'])
            {
                isHorizontal = false;
            }

            if (counters['W'] > counters['w'])
            {
                isVertical = true;
            }
            else if (counters['W'] < counters['w'])
            {
                isVertical = false;
            }

            /*
            if (!(counters['^'] == 0 && counters['v'] == 0 && counters['<'] == 0 && counters['>'] == 0) && (!isHorizontal || !isVertical))
            {
                ret = previousStep(act);
            }*/

            if (counters[' '] == width * height)
            {
                Console.WriteLine("9");
                return null;
            }
            else if (!isHorizontal && !isVertical)
            {
                //stop?
                Console.WriteLine("9");
                return null;
            }
            else if (isHorizontal && !isVertical)
            {
                ret = horizontalStep(counters, act);
                if (ret == act)
                {
                    Console.WriteLine("9");
                    return null;
                }
                /*if (counters['<'] > counters['>'])
                {
                    ret.x = act.x - 1;
                    ret.y = act.y;
                }
                else if (counters['>'] > counters['<'])
                {
                    ret.x = act.x + 1;
                    ret.y = act.y;
                }
                else
                {
                    //previous
                }*/
            }
            else if (!isHorizontal && isVertical)
            {
                ret = verticalStep(counters, act);
                if(ret == act) {
                    Console.WriteLine("9");
                    return null;
                }
                /*if (counters['^'] > counters['v'])
                {
                    ret.x = act.x;
                    ret.y = act.y-1;
                }
                else if (counters['^'] < counters['v'])
                {
                    ret.x = act.x;
                    ret.y = act.y + 1;
                }
                else
                {
                    //previous
                }*/
            }
            else if (isHorizontal && isVertical)
            {/*
                int max = Math.Max(Math.Max(counters['<'], counters['>']), Math.Max(counters['v'], counters['^']));
                int counter = 0;
                if (counters['<'] == max) ++counter;
                if (counters['>'] == max) ++counter;
                if (counters['v'] == max) ++counter;
                if (counters['^'] == max) ++counter;

                if (counter > 3)
                {
                    ret = previousStep(act);
                }
                else*/
                {
                    int maxHor = counters['<'] > counters['>'] ? counters['<'] : counters['>'];
                    int maxVer = counters['v'] > counters['^'] ? counters['v'] : counters['^'];
                    maxVer = counters['v'] == counters['^'] ? 0 : maxVer;
                    maxHor = counters['<'] == counters['>'] ? 0 : maxHor;
                    if (maxHor > maxVer)
                    {
                        ret = horizontalStep(counters, act);
                        if (ret == act)
                        {
                            Console.WriteLine("9");
                            return null;
                        }
                    }
                    else if (maxHor < maxVer)
                    {
                        ret = verticalStep(counters, act);
                        if (ret == act)
                        {
                            Console.WriteLine("9");
                            return null;
                        }

                    }
                    else if (maxHor == 0) //maxVer=0
                    {
                        /*if (act.x == 500 && act.y == 500)
                        {
                            ret = previousStep(act);
                        }
                        else*/
                        {
                            Console.WriteLine("9");
                            ret = null;
                        }
                        //ret = previousStep(act);
                    }
                    else
                    {
                        /// 
                        /*
                        if (act.prev == '<' || act.prev == '>')
                        {
                            ret = horizontalStep(counters, act);
                            if (ret == act)
                            {
                                Console.WriteLine("9");
                                return null;
                            }
                        }
                        else
                        {
                            ret = verticalStep(counters, act);
                            if (ret == act)
                            {
                                Console.WriteLine("9");
                                return null;
                            }
                        }*/
                        ret = previousStep(act);
                    }
                }
            }

            return ret;
        }

        private static Coor<int, int, char> previousStep(Coor<int, int, char> act)
        {
            if (act.prev == '<')
            {
                return new Coor<int, int, char>(act.x-1, act.y, act.prev);
            }
            else if (act.prev == '>')
            {
                return new Coor<int, int, char>(act.x+1, act.y, act.prev);
            }
            else if (act.prev == '^')
            {
                return new Coor<int, int, char>(act.x, act.y-1, act.prev);
            }
            else //v
            {
                return new Coor<int, int, char>(act.x, act.y+1, act.prev);
            }
        }

        private static Coor<int, int, char> verticalStep(Dictionary<char, int> counters, Coor<int, int, char> act)
        {
            if (counters['^'] > counters['v'])
            {
                return new Coor<int, int, char>(act.x, act.y - 1, '^');
            }
            else if (counters['^'] < counters['v'])
            {
                return new Coor<int, int, char>(act.x, act.y + 1, 'v');
            }
            else
            {
                return previousStep(act);
                //act.prev = ' ';
                //return act;
            }
        }

        private static Coor<int, int, char> horizontalStep(Dictionary<char, int> counters, Coor<int, int, char> act)
        {
            if (counters['<'] > counters['>'])
            {
                return new Coor<int, int, char>(act.x - 1, act.y, '<');
            }
            else if (counters['>'] > counters['<'])
            {
                return new Coor<int, int, char>(act.x + 1, act.y, '>');
            }
            else
            {
                return previousStep(act);
                //act.prev = ' ';
                //return act;
            }
        }

        public class Coor<T, U, Z>
        {
            public Coor(){}
            public Coor(T x, U y, Z prev)
            {
                this.x = x;
                this.y = y;
                this.prev = prev;
            }

            public T x { get; set; }
            public U y { get; set; }
            public Z prev { get; set; }

            public override string ToString()
            {
                return "(" + x + "," + y + ") - prev: " + prev;
            }
        };