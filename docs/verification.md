# Verification Plan - Programming Project 1
Team name: The lions
Role Owner: Chris Salcedo (Verification Lead)

##1 Univeral Set

Zoo = [Lion, Tiger, Bear, Koala, Zebra, Giraffe, Gorilla, Otter, Sloth, Panda, Penguin, Elephant, Monkey]

Index Mapping: 
0 - Lion
1 - Tiger
2 - Bear
3 - Koala
4 - Zebra
5 - Giraffe
6 - Gorilla
7 - Otter
8 - Sloth
9 - Panda
10 - Penguin
11 - Elephant


_**##2 Ordinary Set Test Case 1 (Normal Overlap)**_

**Set A (Big Animals Exhibit):** 
{Lion, Tiger, Bear, Zebra, Giraffe, Elephant}
**Bit String Representation:** 
Set A: [1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1]

**Set B (Forest Habitat exhibit):** 
{Bear, Koala, Gorilla, Sloth, Panda}
**Bit String Representation:** 
Set B: [0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0]

**Expected Results:** 
A ∪ B: [1, 1, 1, 1, 1, 1, 1, 0 ,1 ,1 ,0 ,1]
Element Listing: {Lion, Tiger, Bear, koala, Zebra, Giraffe, Gorilla, Sloth, panda, Elephant}

A ∩ B: [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Element Listing: {Bear}

A − B: [1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1]
Element Listing: 
{Lion TIger, Zebra, Giraffe, Elephant}

A ⊕ B: [1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1]
Element Listing: {Lion, Tiger, Koala, Zebra, Giraffe, Gorilla, Sloth, Panda, Elephant}

NOT(A): [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0]
Element Listing: {Koala, Gorilla, Otter, Sloth, Panda, Penguin}


_**#3 Ordinary Set Test Case 2 (Disjointed Sets)**_

**Set C (Aquatic Animals):** 
{Otter, Penguin}
**Bit String Representation:** 
[0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0]

**Set D (Primaes Exhitit):** 
{Gorilla}
**Bit String Representation:**
[0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0]

**Expected Results:**
C ∪ D: [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0]
C ∩ D: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
C − D: [0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0]
C ⊕ D: [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0]

**#4 Ordinary Set Edge Case - Empty Set**

Set E = ∅
Bit String: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

**Expected Results (with Set A):**
E ∪ A = A  
E ∩ A = ∅  
E − A = ∅ 

NOT(E) = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

**##5 Multiset Test Case - Animal Counts**

**Multiset A (Safari Exhibit)**
Lion: 3
Tiger: 2
Zebra: 5
Giraffe: 2
Elephant: 2

**Mutiset B (Rainforest Exhibit)**
Bear: 2
Gorilla: 3
Sloth: 2
Panda: 2
Tiger: 2

**Expected Mutiset Results:**
**Union (Max Count)**

Lion: 3
Tiger: 2
Bear: 2
Zebra: 5
Giraffe: 2
Elephant: 2
Gorilla: 3
Sloth: 2
Panda: 2

**Intersection (Min Count)**
Tiger: 2

**Difference (A-B)**
Lion: 3
Tiger: 0
Zebra: 5
Giraffe: 2
Elephant: 2
(No negative values allowed)

**Sum (A+B)**
Lion: 3
Tiger: 4
Bear: 2
Zebra: 5
Giraffe: 2
Elephant: 2
Gorilla: 3
Sloth: 2
Panda: 2

**6. Multiset Edge Case - Substraction to Zero**
Multiset X: 
Lion: 1

Multiset Y: 
Lion: 5

**Expected Result:**
X-Y: 
Lion: 0

Counts must never become negative.

##7 Verification Method
For each test case: 
1. Run the Java Program
2. Capture the printed Output
3. Compare bit strings exactly to expected arrays
4. Compare element listings to expected listings
5. Compare multiset counts to expected values
6. Confirm no substraction produces negative values 

If any output differs from the expected values, the test case fails.

**##8 Rationale for Test Selection**
-Test Case 1 verifies overlapping sets.
--Test Case 2 verifies disjoint behavior.
-The empty set verifies identity and complement laws. 
-The multiset test verifies max, min, subtraction, and addition.
-The substraction edge case verifies non-negative contraints.

These cases ensure both correctness and robustness of the implementation.
