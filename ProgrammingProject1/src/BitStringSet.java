/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

import java.util.ArrayList;
import java.util.List;


/**
 * Represents a mathematical set using a bit-string (boolean array)
 * relative to a fixed UniversalSet.
 * <p>
 * Each index in the boolean array corresponds to an element
 * in the UniversalSet. A value of true means the element
 * is in the set; false means it is not.
 *
 * @param <T> the type of elements stored in the set
 */
public class BitStringSet<T>
{
    private final UniversalSet<T> universe;
    private final boolean[] bits;

    /**
     * Constructs an empty set relative to the given universe.
     *
     * @param universe the universal set defining valid elements
     * @throws IllegalArgumentException if universe is null
     */
    public BitStringSet(UniversalSet<T> universe)
    {
        if (universe == null)
        {
            throw new IllegalArgumentException("Universe cannot be null");
        }

        this.universe = universe;
        this.bits = new boolean[universe.size()];
    }

    /**
     * Returns the universe associated with this set.
     *
     * @return the universal set
     */
    public UniversalSet<T> universe()
    {
        return universe;
    }

    /**
     * Checks whether an element is contained in this set.
     *
     * @param x element to check
     * @return true if element is present; false otherwise
     */
    public boolean contains(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            return false;
        }
        return bits[idx];
    }

    /**
     * Adds an element to the set.
     *
     * @param x element to add
     * @throws IllegalArgumentException if element is not in universe
     */
    public void add(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }
        bits[idx] = true;
    }

    /**
     * Removes an element from the set.
     *
     * @param x element to remove
     * @throws IllegalArgumentException if element is not in universe
     */
    public void remove(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }
        bits[idx] = false;
    }

    /**
     * Returns the membership bit at a specific index.
     *
     * @param index position in the bit array
     * @return true if present; false otherwise
     */
    public boolean getBitAt(int index)
    {
        return bits[index];
    }

    /**
     * Sets the membership bit at a specific index.
     *
     * @param index position in the bit array
     * @param value membership value
     */
    public void setBitAt(int index, boolean value)
    {
        bits[index] = value;
    }

    /**
     * Returns the size of the universe.
     *
     * @return number of elements in the universe
     */
    public int sizeOfUniverse()
    {
        return bits.length;
    }

    /**
     * Returns the bit-string representation of this set.
     *
     * @return string of 1s and 0s
     */
    public String toBitsString()
    {
        StringBuilder sb = new StringBuilder();
        for (boolean b : bits)
        {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();
    }

    /**
     * Returns a list-style string of elements contained in this set.
     *
     * @return string representation of elements
     */
    public String toElementListString()
    {
        List<T> items = new ArrayList<>();
        for (int i = 0; i < bits.length; i++)
        {
            if (bits[i])
            {
                items.add(universe.elementAt(i));
            }
        }
        return items.toString();
    }
}
