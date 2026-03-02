/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

import java.util.ArrayList;
import java.util.List;

public class UniversalSet<T>
{
    private final List<T> elements;

    /**
     * Constructs a universal set from a list of elements.
     *
     * @param elements list of valid elements
     * @throws IllegalArgumentException if null or empty
     */
    public UniversalSet(List<T> elements)
    {
        if (elements == null || elements.isEmpty())
        {
            throw new IllegalArgumentException("Set cannot be empty or null");
        }
        this.elements = new ArrayList<>(elements);
    }

    /**
     * Returns the number of elements in the universe.
     */
    public int size()
    {
        return elements.size();
    }

    /**
     * Returns the element at a specific index.
     */
    public T elementAt(int index)
    {
        return elements.get(index);
    }

    /**
     * Returns the index of an element, or -1 if not found.
     */
    public int indexOf(T x)
    {
        return elements.indexOf(x);
    }

    /**
     * Returns a defensive copy of the universe elements.
     */
    public List<T> elements()
    {
        return new ArrayList<>(elements);
    }
}
