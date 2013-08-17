Roman Numerals by James Richardson
----------------------------------

Approach:
---------
1. Firstly, handled the upper and lower bounds to make rest of problem easier to solve.
1. Secondly solved problem for numbers from 1 to 10
1. Next noticed pattern that repeats itself for numbers 10 to 100 and 100 to 1000, so produced code to handle this pattern
1. Then all that was left was to handle adding sets of numbers together
1. Finally I had constants left through the code, so I pulled these into an enum.  It seemed best to take associated methods too.

Assumptions:
------------
* The only irregular representation is as documented 9, 90 and 900, otherwise number parts can just be joined together.

Work Remaining:
---------------
* With the extraction of the enum, various tests could be added here now.  This would simplify tests around the generator.
* The THOUSANDS part of the enum does not handle 'out of bounds' if numbers of 4000 or larger are given.