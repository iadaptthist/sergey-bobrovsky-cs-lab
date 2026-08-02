import java.util.List;

public class Level1 
{
    public static int listLengthRecursive(List<Integer> list) 
  {
        if (list.size() == 0) {
            return 0;
        }

        list.remove(0);

        return 1 + listLengthRecursive(list);
    }
}
