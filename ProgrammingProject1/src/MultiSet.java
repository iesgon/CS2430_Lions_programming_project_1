import java.util.HashMap;
import java.util.Map;

public class MultiSet<T>
{
    private UniversalSet<T> universe;
    private Map<T, Integer> counts;

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

    public int countOf(T x)
    {
        if (counts.containsKey(x))
        {
            return counts.get(x);
        }
        else
        {
            return 0;
        }
    }

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
        }
        else
        {
            counts.put(x, next);
        }
    }

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
