/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

public class MultiSetOperations<T>
{
    private void ensureSameUniverse(MultiSet<T> a, MultiSet<T> b)
    {
        if (a == null || b == null)
        {
            throw new IllegalArgumentException("Multisets cannot be null.");
        }
        if (a.universe().size() != b.universe().size())
        {
            throw new IllegalArgumentException("Universe sizes differ.");
        }
    }

    /**
     * Computes the multiset union (max counts).
     */
    public MultiSet<T> union(MultiSet<T> a, MultiSet<T> b)
    {
        ensureSameUniverse(a, b);

        MultiSet<T> result = new MultiSet<>(a.universe());
        for (int i = 0; i < a.universe().size(); i++)
        {
            T x = a.universe().elementAt(i);
            int c = Math.max(a.countOf(x), b.countOf(x));
            if (c > 0)
            {
                result.add(x, c);
            }
        }
        return result;
    }

    /**
     * Computes the multiset intersection (min counts).
     */
    public MultiSet<T> intersection(MultiSet<T> a, MultiSet<T> b)
    {
        ensureSameUniverse(a, b);

        MultiSet<T> result = new MultiSet<>(a.universe());
        for (int i = 0; i < a.universe().size(); i++)
        {
            T x = a.universe().elementAt(i);
            int c = Math.min(a.countOf(x), b.countOf(x));
            if (c > 0)
            {
                result.add(x, c);
            }
        }
        return result;
    }

    /**
     * Computes multiset difference (A - B).
     */
    public MultiSet<T> difference(MultiSet<T> a, MultiSet<T> b)
    {
        ensureSameUniverse(a, b);

        MultiSet<T> result = new MultiSet<>(a.universe());
        for (int i = 0; i < a.universe().size(); i++)
        {
            T x = a.universe().elementAt(i);
            int c = a.countOf(x) - b.countOf(x);
            if (c > 0)
            {
                result.add(x, c);
            }
        }
        return result;
    }

    /**
     * Computes multiset sum (adds counts).
     */
    public MultiSet<T> sum(MultiSet<T> a, MultiSet<T> b)
    {
        ensureSameUniverse(a, b);

        MultiSet<T> result = new MultiSet<>(a.universe());
        for (int i = 0; i < a.universe().size(); i++)
        {
            T x = a.universe().elementAt(i);
            int c = a.countOf(x) + b.countOf(x);
            if (c > 0)
            {
                result.add(x, c);
            }
        }
        return result;
    }
}