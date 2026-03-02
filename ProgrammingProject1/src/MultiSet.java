/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

import java.util.HashMap;
import java.util.Map;

public class MultiSet<T>
{
    private final UniversalSet<T> universe;
    private final Map<T, Integer> counts;

    /**
     * Constructs an empty multiset relative to a universe.
     *
     * @param universe the universal set
     * @throws IllegalArgumentException if universe is null
     */
    public MultiSet(UniversalSet<T> universe)
    {
        if (universe == null)
        {
            throw new IllegalArgumentException("Universe cannot be null");
        }

        this.universe = universe;
        this.counts = new HashMap<>();
    }


    public UniversalSet<T> universe()
    {
        return universe;
    }

    /**
     * Returns the number of occurrences of an element.
     *
     * @param x element to check
     * @return number of times x appears
     */
    public int countOf(T x)
    {
        if (counts.containsKey(x))
        {
            return counts.get(x);
        } else
        {
            return 0;
        }
    }

    /**
     * Adds k occurrences of an element.
     *
     * @param x element to add
     * @param k number of occurrences
     * @throws IllegalArgumentException if k <= 0 or element not in universe
     */
    public void add(T x, int k)
    {
        if (k <= 0)
        {
            throw new IllegalArgumentException("k must be positive.");
        }

        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }

        counts.put(x, countOf(x) + k);
    }


    public void remove(T x)
    {
        remove(x, 1);
    }

    /**
     * Removes k occurrences of an element.
     * <p>
     * If resulting count is zero or negative,
     * the element is removed entirely.
     *
     * @param x element to remove
     * @param k number of occurrences
     */
    public void remove(T x, int k)
    {
        if (k <= 0)
        {
            throw new IllegalArgumentException("k must be positive.");
        }

        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }

        int current = countOf(x);
        int next = current - k;
        if (next <= 0)
        {
            counts.remove(x);
        } else
        {
            counts.put(x, next);
        }
    }

    /**
     * Returns a formatted string showing counts
     * of all universe elements.
     *
     * @return formatted count string
     */
    public String toCountsString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        for (int i = 0; i < universe.size(); i++)
        {
            T el = universe.elementAt(i);
            sb.append(el).append(":").append(countOf(el));
            if (i < universe.size() - 1)
            {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }
}
