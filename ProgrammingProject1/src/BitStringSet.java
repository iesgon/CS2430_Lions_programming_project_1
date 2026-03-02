import java.util.ArrayList;
import java.util.List;

public class BitStringSet<T>
{
    private UniversalSet<T> universe;
    private boolean[] bits;

    public BitStringSet(UniversalSet<T> universe)
    {
        if(universe == null)
        {
            throw new IllegalArgumentException("Universe cannot be null");
        }

        this.universe = universe;
        this.bits = new boolean[universe.size()];
    }

    public UniversalSet<T> universe()
    {
        return universe;
    }

    public boolean contains(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            return false;
        }
        return bits[idx];
    }

    public void add(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }
        bits[idx] = true;
    }

    public void remove(T x)
    {
        int idx = universe.indexOf(x);
        if (idx < 0)
        {
            throw new IllegalArgumentException("Element not in universe: " + x);
        }
        bits[idx] = false;
    }

    public boolean getBitAt(int index)
    {
        return bits[index];
    }

    public void setBitAt(int index, boolean value)
    {
        bits[index] = value;
    }

    public int sizeOfUniverse()
    {
        return bits.length;
    }

    public String toBitsString()
    {
        StringBuilder sb = new StringBuilder();
        for (boolean b : bits)
        {
            sb.append(b ? '1' : '0');
        }
        return sb.toString();
    }

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
