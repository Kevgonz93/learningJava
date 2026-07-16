package d00_Libft;

public class FtArrays {
    public static int checkSort(int[] array)
    {
        if (array == null || array.length <= 1)
            return 1;
        int i = 0;
        while (i < array.length - 1)
        {
            if (array[i] > array[i + 1])
                return (0);
            i++;
        }
        return (1);
    }

    public static void ft_sort_int(int[] array){
        if (array == null || array.length <= 1)
            return;

        int size = array.length;
        int i = 0;
        int aux = 0;

        while (checkSort(array) == 0)
        {
            while (i < size - 1){
                if (array[i] > array[i + 1])
                {
                    aux = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = aux;
                 }
                i++;
            }
            i = 0;
        }
        return;
    }

    public static int ft_search_int(int[] array, int n)
    {
        if (array == null)
            return -1;

        int low = 0;
        int high = array.length - 1;
        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            if (n < array[mid])
                high = mid - 1;
            else if (n > array[mid])
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
