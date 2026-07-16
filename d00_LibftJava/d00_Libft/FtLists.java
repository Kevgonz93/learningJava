package d00_Libft;

import java.util.Iterator;
import java.util.List;

public class FtLists {
    public static void ft_list_push_back(List<Integer> list, int value){
        if (list == null)
            return;
        list.add(value);
    }

    public static void ft_list_remove_if(List<Integer> list, int condition){
        if (list == null)
            return;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer num = it.next();
            if (num == condition)
                it.remove();
        }
    }

    public static int[] ft_list_to_array(List<Integer> list){
        if (list == null)
            return null;
        int[] result = new int[list.size()];
        int i = 0;

        while (i < list.size())
        {
            result[i] = list.get(i);
            i++;
        }
        return  result;
    }
}
