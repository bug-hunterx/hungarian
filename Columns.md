
*The task*

```f(input: string, n: int, width: int)```

Reflow `input` so that it is laid out in `n` columns, each column `width` characters wide. Columns must be separated by `|`. Print the result to `STDOUT`.


*Rules*

>Note: the multi-line examples below will use `.` to represent spaces.

Input will contain ASCII characters and will be only one line.

Output formatting:

- you must use `\n` for new lines
- result must be rectangular and space padded
- all columns must be exactly `width` character wide

_Valid_
```
ab|gh|mn
cd|ij|o.
ef|kl|..
```

_Invalid_
```
ab|gh|mn
cd|ij|o
ef|kl|
```

_Invalid_
```
ab|gh|mn..
cd|ij|o...
ef|kl|....
```


*Example Test-Cases*

> Note: you submission will be tested using a lot more inputs

*1.*

Input: `"Results, Relentlessly", 3, 4`

Output:
```
Resu|.Rel|essl
lts,|entl|y...
```

*2.*

Input: `"This is a longer text with, a, lot, of, unneeded, comma. And...    spaces.", 4, 5`

Output:
```
This.|t.wit|unnee|.....
is.a.|h,.a,|ded,.|..spa
longe|.lot,|comma|ces..
r.tex|.of,.|..And|.....
```
