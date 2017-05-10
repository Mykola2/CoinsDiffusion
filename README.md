# Euro Coins Diffusion
The program simulates the dissemination of euro coins throughout Europe, using a
highly simplified model. Representation of European
cities - points in a rectangular grid. Each city may have up to 4 neighbors (one to the north, east,
south and west). Each city belongs to a country, and a country is a rectangular part of the plane. 
The graph of countries is connected, but countries may border holes that represent seas, 
or non-euro countries such as Switzerland or Denmark. Initially,
each city has one million (1000000) coins in its country’s motif. Every day a
representative portion of coins, based on the city’s beginning day balance, is transported to each
neighbor of the city. A representative portion is defined as one coin for every full 1000 coins of a
motif.

A city is complete when at least one coin of each motif is
present in that city. A country is complete when all of its cities are
complete. The program determines the time required for
each country to become complete.

## Input

The input consists of several test cases. The first line of each test case is the number of countries
(1 ≤ c ≤ 20). The next c lines describe each country. The country description has the format: name xl
yl xh yh, where name is a single word with at most 25 characters; xl, yl are the lower left city
coordinates of that country (most southwestward city ) and xh, yh are the upper right city
coordinates of that country (most northeastward city). 1 ≤ xl ≤ xh ≤ 10 and 1 ≤ yl ≤ yh ≤ 10. The last
case in the input is followed by a single zero.

## Output

For each test case - a line indicating the case number, followed by a line for each country with
the country name and number of days for that country to become complete.
