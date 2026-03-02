/**
 * Team: Lions
 * Team members: Iesus Gonzalez, Chris Salcedo, Edgar Pena
 * CS2430 Section 501
 * Programming Project 1 - Spring 2026
 */

public class SetOperations<T>
{
    private void sameSizeAssurance(BitStringSet<T> a, BitStringSet<T> b)
    {
        if (a == null || b == null)
        {
            throw new IllegalArgumentException("Sets cannot be null");
        }

        if (a.sizeOfUniverse() != b.sizeOfUniverse())
        {
            throw new IllegalArgumentException("Sets cannot differ in size");
        }
    }

    /**
     * Computes the complement of a set.
     */
    public BitStringSet<T> complement(BitStringSet<T> a)
    {
        if (a == null)
        {
            throw new IllegalArgumentException("Set cannot be null");

        }

        BitStringSet<T> result = new BitStringSet<>(a.universe());
        for (int i = 0; i < a.sizeOfUniverse(); i++)
        {
            result.setBitAt(i, !a.getBitAt(i));
        }
        return result;
    }

    /**
     * Computes the union of two sets.
     */
    public BitStringSet<T> union(BitStringSet<T> a, BitStringSet<T> b)
    {
        sameSizeAssurance(a, b);

        BitStringSet<T> result = new BitStringSet<>(a.universe());
        for (int i = 0; i < a.sizeOfUniverse(); i++)
        {
            result.setBitAt(i, a.getBitAt(i) || b.getBitAt(i));
        }
        return result;
    }

    public BitStringSet<T> intersection(BitStringSet<T> a, BitStringSet<T> b)
    {
        sameSizeAssurance(a, b);

        BitStringSet<T> result = new BitStringSet<>(a.universe());
        for (int i = 0; i < a.sizeOfUniverse(); i++)
        {
            result.setBitAt(i, a.getBitAt(i) && b.getBitAt(i));
        }
        return result;
    }

    /**
     * Computes the difference A - B.
     */
    public BitStringSet<T> difference(BitStringSet<T> a, BitStringSet<T> b)
    {
        sameSizeAssurance(a, b);

        BitStringSet<T> result = new BitStringSet<>(a.universe());
        for (int i = 0; i < a.sizeOfUniverse(); i++)
        {
            result.setBitAt(i, a.getBitAt(i) && !b.getBitAt(i));
        }
        return result;
    }

    /**
     * Computes the symmetric difference of two sets.
     */
    public BitStringSet<T> symmetricDifference(BitStringSet<T> a, BitStringSet<T> b)
    {
        sameSizeAssurance(a, b);

        BitStringSet<T> result = new BitStringSet<>(a.universe());
        for (int i = 0; i < a.sizeOfUniverse(); i++)
        {
            boolean av = a.getBitAt(i);
            boolean bv = b.getBitAt(i);
            result.setBitAt(i, (av && !bv) || (!av && bv));
        }
        return result;
    }
}
