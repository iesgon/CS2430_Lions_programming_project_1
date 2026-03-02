# Programming Project 1 – Verification Plan
Team: Lions  
Course: CS2430 Section 501  
Semester: Spring 2026  

# 1. Univeral Set Definition

The Universal set (Zoo) used in this project is:

U = {  
0: Lion  
1: Tiger  
2: Giraffe  
3: Elephant  
4: Zebra  
5: Penguin  
6: Gorilla  
7: Hippo  
8: Rhino  
9: Kangaroo  
}

Universe size n = 10 (meets requirement n ≥ 10)

Each bit position in a BitStringSet corresponds to the index above.

# 2. PART 1 - Ordinary Sets (Bit-String Representation)

## 2.1 Test Case 1 - Exhibit Sets

Set A (Exhibit A):
{ Lion, Elephant, Penguin, Kangaroo }

Set B (Exhibit B):
{ Tiger, Elephant, Gorilla, Rhino }

## 2.2 Expected Bit Strings

Using universe order:

Index:     0 1 2 3 4 5 6 7 8 9  
Element:   L T G E Z P G H R K  

Set A:
Lion (0)       = 1  
Elephant (3)   = 1  
Penguin (5)    = 1  
Kangaroo (9)   = 1

A bits:
1001010001

A elems:
[Lion, Elephant, Penguin, Kangaroo]

Set B:
Tiger (1)      = 1  
Elephant (3)   = 1  
Gorilla (6)    = 1  
Rhino (8)      = 1  

B bits:
0101001010

B elems:
[Tiger, Elephant, Gorilla, Rhino]

# 3. Expected Results of Set Operations

## 3.1 Union (A ∪ B)

Elements in either set.

Expected elements:
{ Lion, Tiger, Elephant, Penguin, Gorilla, Rhino, Kangaroo }

Bit calculation:
1 1 0 1 0 1 1 0 1 1

A ∪ B bits:
1101011011

## 3.2 Intersection (A ∩ B)

Elements in both sets.

Common element:
Elephant

Bit calculation:
0 0 0 1 0 0 0 0 0 0

A ∩ B bits:
0001000000

Expected elements:
[Elephant]

## 3.3 Difference (A − B)

Elements in A but not in B.

{ Lion, Penguin, Kangaroo }

Bit calculation:
1 0 0 0 0 1 0 0 0 1

A − B bits:
1000010001

Expected elements:
[Lion, Penguin, Kangaroo]

## 3.4 Symmetric Difference (A Δ B)

Elements in exactly one set.

{ Lion, Tiger, Penguin, Gorilla, Rhino, Kangaroo }

Bit calculation:
1 1 0 0 0 1 1 0 1 1

A Δ B bits:
1100011011

Expected elements:
[Lion, Tiger, Penguin, Gorilla, Rhino, Kangaroo]

## 3.5 Complement (~A)

All elements in universe not in A.

Universe minus A:
{ Tiger, Giraffe, Zebra, Gorilla, Hippo, Rhino }

Bit calculation:
0 1 1 0 1 0 1 1 1 0

~A bits:
0110101110

Expected elements:
[Tiger, Giraffe, Zebra, Gorilla, Hippo, Rhino]

# 4. PART 2 – MultiSet Verification

## 4.1 Initial Multisets

Zoo1 counts:
Lion: 3  
Penguin: 10  
Elephant: 2  
Zebra: 5  
All others: 0  

Zoo2 counts:
Lion: 1  
Giraffe: 4  
Penguin: 6  
Zebra: 2  
All others: 0  

# 5. Expected MultiSet Operation Results

## 5.1 Union (max)

Lion: max(3,1) = 3  
Giraffe: 4  
Elephant: 2  
Zebra: max(5,2) = 5  
Penguin: max(10,6) = 10  

Union result:
{ Lion:3, Tiger:0, Giraffe:4, Elephant:2, Zebra:5, Penguin:10, Gorilla:0, Hippo:0, Rhino:0, Kangaroo:0 }

## 5.2 Intersection (min)

Lion: min(3,1) = 1  
Penguin: min(10,6) = 6  
Zebra: min(5,2) = 2  

Intersection result:
{ Lion:1, Tiger:0, Giraffe:0, Elephant:0, Zebra:2, Penguin:6, Gorilla:0, Hippo:0, Rhino:0, Kangaroo:0 }

## 5.3 Difference (Zoo1 − Zoo2)

Lion: 3 − 1 = 2  
Elephant: 2 − 0 = 2  
Zebra: 5 − 2 = 3  
Penguin: 10 − 6 = 4  

Difference result:
{ Lion:2, Tiger:0, Giraffe:0, Elephant:2, Zebra:3, Penguin:4, Gorilla:0, Hippo:0, Rhino:0, Kangaroo:0 }

## 5.4 Sum (Addition)

Lion: 3 + 1 = 4  
Giraffe: 4  
Elephant: 2  
Zebra: 5 + 2 = 7  
Penguin: 10 + 6 = 16  

Sum result:
{ Lion:4, Tiger:0, Giraffe:4, Elephant:2, Zebra:7, Penguin:16, Gorilla:0, Hippo:0, Rhino:0, Kangaroo:0 }

# 6. Verification Strategy

Verification was performed by:

1. Mapping each element to its fixed universe index.
2. Manually computing expected bit strings using Boolean logic.
3. Applying mathematical definitions of:
   - Union (OR / max)
   - Intersection (AND / min)
   - Difference
   - Symmetric Difference (XOR)
   - Complement
   - Multiset sum
4. Comparing expected results with program output.

All outputs match expected mathematical definitions.

# 7. Conclusion

The implementation correctly follows formal definitions of:

- Set operations using bit-string representation.
- Multiset operations using count-based representation.

The universal set size meets project requirements (n ≥ 10).
All required operations were verified for correctness.
