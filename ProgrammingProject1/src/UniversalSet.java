import java.util.ArrayList;
import java.util.List;

public class UniversalSet<T>
{
    private List<T> elements;

    public UniversalSet(List<T> elements)
    {
        if (elements == null || elements.isEmpty())
        {
            throw new IllegalArgumentException("Set cannot be empty or null");
        }
        this.elements = new ArrayList<>(elements);
    }

    public int size()
    {
        return elements.size();
    }

    public T elementAt(int index)
    {
        return elements.get(index);
    }

    public int indexOf(T x)
    {
        return elements.indexOf(x);
    }

    public List<T> elements()
    {
        return new ArrayList<>(elements);
    }
}
