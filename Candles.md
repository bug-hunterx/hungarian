
It's dark in the night, so light it up... with torches!

```
    *   *
 *     *     *
   *      *  .
     .  $    /
 . . /  | $  \
 | | \  | |  |
 X X X  X X  X
```

*The task*

```f(n: int, scene: string)```

Implement a function `f` that prints the modified `scene` to `STDOUT` with exactly `n` torches lit. (So, if `n=6`, but 2 are already lit, you only have to lit 4 more.)

If there are no torches in the scene, print `:(`.

If there are less torches than expected, the print the number of torches missing. E.g. if `n=6`, but you have only 4, print `2`. It's possible that more torches are lit, than `n`, so the output can be negative.


*Rules*

These are torches:
```
    .
  . \
. \ | $
| / / |
X X X X
```

They have a wick (`.`) or flame (`$`), a body (`|\/`), and a base (`X`). If any of them is missing, it is not a torch. If the body is unbalanced (`/` does not have its corresponding `\`, or vice-versa), it is not a torch either. Levitating torches are a flame hazard, so they are also ignored.

You light a torch by replacing its wick with a flame.

Here are some non-torches:
```
          .
    #     \
  . /   . \
  | \ $ | /
. / / ! X /
| X X X   X
```

> Left to right: missing base, unbalanced, unbalanced + invalid flame, invalid body, base is not on the ground

It is a clear night, so the sky may has stars (`*`), moon (`C`), maybe birds (`~`), falling meteors (`#`), or just random letters (glitch in the matrix?). Anyway, any non-torch characters are parts of the scenery, so your output must also contain them.

The input will be a multiline string. Lines are separated by `\n` and are space padded at least on one side, so the input is always rectangular:
```
field =
  "       &        \n" +
  "    *   ##      \n" +
  "  ~    .   *  * \n" +
  "     . \     *  \n" +
  "  .  | |  $     \n" +
  "  |  X /  |     \n" +
  "  X    X  X     ";
```


*Example Test-Cases*
> Note: you submission will be tested using a lot more inputs

*1.*

Input:
```
n=2
field=
*    *  .
   ~ .  \
  .  |  |  $
  |  X  /  |
  X     X  X
```

Output:
```
*    *  .
   ~ .  \
  $  |  |  $
  |  X  /  |
  X     X  X
```
> Notice the stars and the bird.

*2.*

Input:
```
n=5
field=
    .
  . \
$ | | $
| X / |
X   X X
```

Output:
```
2
```
> We have 3 valid torches (2 lit), but 5 were expected. If `n` were 1, the output would be `-1` (`1 - 2 = -1`).

*3.*

Input:
```
n=1
field=
    #
  . \
$ | | $
| X / !
    X X
```

Output:
```
:(
```
> None of the constructs are torches.
