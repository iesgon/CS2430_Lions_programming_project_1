/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

import java.util.List;

public class Main
{
    /**
     * Program entry point.
     * <p>
     * Creates a universe of zoo animals and runs
     * both set and multiset test cases.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args)
    {
 /*     ===============================
        Universe (Zoo Animals)
        ===============================
 */
        UniversalSet<String> u =
                new UniversalSet<>(List.of(
                        "Lion", "Tiger", "Giraffe", "Elephant",
                        "Zebra", "Penguin", "Gorilla", "Hippo",
                        "Rhino", "Kangaroo"
                ));

        System.out.println("=================================");
        System.out.println("UNIVERSAL SET (Zoo Animals)");
        System.out.println("U = " + u.elements());
        System.out.println("=================================");

/*
        ===============================
        PART 1 – Ordinary Sets
        ===============================
 */
        BitStringSet<String> exhibitA = new BitStringSet<>(u);
        exhibitA.add("Lion");
        exhibitA.add("Elephant");
        exhibitA.add("Penguin");
        exhibitA.add("Kangaroo");

        BitStringSet<String> exhibitB = new BitStringSet<>(u);
        exhibitB.add("Tiger");
        exhibitB.add("Elephant");
        exhibitB.add("Gorilla");
        exhibitB.add("Rhino");

        SetOperations<String> ops = new SetOperations<>();

        System.out.println("\n=== SET TEST CASE 1 ===");
        printSet("A", exhibitA);
        printSet("B", exhibitB);

        BitStringSet<String> union = ops.union(exhibitA, exhibitB);
        BitStringSet<String> inter = ops.intersection(exhibitA, exhibitB);
        BitStringSet<String> diff = ops.difference(exhibitA, exhibitB);
        BitStringSet<String> symDiff = ops.symmetricDifference(exhibitA, exhibitB);
        BitStringSet<String> comp = ops.complement(exhibitA);

        System.out.println();
        printSet("A ∪ B", union);
        printSet("A ∩ B", inter);
        printSet("A \\ B", diff);
        printSet("A Δ B", symDiff);
        printSet("~A", comp);


/*      ===============================
        PART 2 – MultiSets (Counts)
        ===============================
 */
        MultiSet<String> zoo1 = new MultiSet<>(u);
        zoo1.add("Lion", 3);
        zoo1.add("Penguin", 10);
        zoo1.add("Elephant", 2);
        zoo1.add("Zebra", 5);

        MultiSet<String> zoo2 = new MultiSet<>(u);
        zoo2.add("Lion", 1);
        zoo2.add("Giraffe", 4);
        zoo2.add("Penguin", 6);
        zoo2.add("Zebra", 2);

        MultiSetOperations<String> mops = new MultiSetOperations<>();

        System.out.println("\n=================================");
        System.out.println("MULTISET TEST CASE");
        System.out.println("=================================");

        System.out.println("Zoo1 counts: " + zoo1.toCountsString());
        System.out.println("Zoo2 counts: " + zoo2.toCountsString());

        System.out.println("\nUnion (max): " +
                mops.union(zoo1, zoo2).toCountsString());

        System.out.println("Intersection (min): " +
                mops.intersection(zoo1, zoo2).toCountsString());

        System.out.println("Difference (zoo1 - zoo2): " +
                mops.difference(zoo1, zoo2).toCountsString());

        System.out.println("Sum (add counts): " +
                mops.sum(zoo1, zoo2).toCountsString());
    }

    /**
     * Helper method to print bits and elements
     * @param label
     * @param set
     */
    private static void printSet(String label, BitStringSet<String> set)
    {
        System.out.println(label + " bits:  " + set.toBitsString());
        System.out.println(label + " elems: " + set.toElementListString());
    }
}