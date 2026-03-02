import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
 /*     ===============================
        Universe (Zoo Animals)
        ===============================
 */
        UniversalSet<String> u =
                new UniversalSet<>(List.of(
                        "Lion", "Tiger", "Giraffe", "Elephant",
                        "Zebra", "Penguin", "Gorilla"
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

        BitStringSet<String> exhibitB = new BitStringSet<>(u);
        exhibitB.add("Tiger");
        exhibitB.add("Elephant");
        exhibitB.add("Gorilla");

        SetOperations<String> ops = new SetOperations<>();

        System.out.println("\n=== SET TEST CASE 1 ===");
        System.out.println("A bits: " + exhibitA.toBitsString());
        System.out.println("A elems: " + exhibitA.toElementListString());
        System.out.println("B bits: " + exhibitB.toBitsString());
        System.out.println("B elems: " + exhibitB.toElementListString());

        System.out.println("\nA ∪ B: " +
                ops.union(exhibitA, exhibitB).toElementListString());

        System.out.println("A ∩ B: " +
                ops.intersection(exhibitA, exhibitB).toElementListString());

        System.out.println("A \\ B: " +
                ops.difference(exhibitA, exhibitB).toElementListString());

        System.out.println("A Δ B: " +
                ops.symmetricDifference(exhibitA, exhibitB).toElementListString());

        System.out.println("~A: " +
                ops.complement(exhibitA).toElementListString());


/*      ===============================
        PART 2 – MultiSets (Counts)
        ===============================
 */
        MultiSet<String> zoo1 = new MultiSet<>(u);
        zoo1.add("Lion", 3);
        zoo1.add("Penguin", 10);
        zoo1.add("Elephant", 2);

        MultiSet<String> zoo2 = new MultiSet<>(u);
        zoo2.add("Lion", 1);
        zoo2.add("Giraffe", 4);
        zoo2.add("Penguin", 6);

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
}