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