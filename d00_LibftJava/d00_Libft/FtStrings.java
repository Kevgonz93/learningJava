package d00_Libft;

public class FtStrings {

    public static int ft_strlen(String str){
        if (str == null)
            return 0;

        int i = 0;
        try {
            while (true) {
                str.charAt(i);
                i++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return i;
        }
    }

    public static int ft_stoi(String num){
        if (num == null || num.isEmpty())
            return 0;

        int result = 0;
        boolean positive = true;
        boolean started = false;
        int size = ft_strlen(num);
        char[] n = num.toCharArray();
        int i = 0;

        while (i < size) {
            if (n[i] == ' ') {
                i++;
                continue;
            }
            if (n[i] == '-') {
                if (started == true)
                    break;
                positive = false;
                i++;
                continue;
            }
            if (n[i] >= '0' && n[i] <= '9') {
                started = true;
                if (result == 0) {
                    result = n[i] - '0';
                    i++;
                    continue;
                }
                result *= 10;
                result += n[i] - '0';
                i++;
                continue;
            }
            if (started)
                break;
            i++;
        }
        if (positive)
            return result;
        return -result;
    }

    public static String[] ft_split(String str, char c){
        int max_size = ft_strlen(str);
        char[] aux = str.toCharArray();
        boolean isWord = false;
        int count = 0;
        int i = 0;

        while (i < max_size) {
            if (aux[i] != c)
            {
                if (!isWord)
                {
                    count++;
                    isWord = true;
                }
            }
            else if (aux[i] == c)
                isWord = false;
            i++;
        }

        String[] result = new String[count];

        isWord = false;
        i = 0;
        int j = 0;
        int start = 0;

        while (i < max_size)
        {
            if (aux[i] != c)
            {
                if (!isWord)
                {
                    start = i;
                    isWord = true;
                }
            }
            else if (aux[i] == c)
            {
                if (isWord)
                {
                    result[j] = new String(aux, start, i - start);
                    j++;
                    isWord = false;
                }
            }
            i++;
        }
        if (isWord)
            result[j] = new String(aux, start, i - start);

        return (result);
    }

    public static String ft_join(String str1, String str2){
        if (str1 == null) str1 = "";
        if (str2 == null) str2 = "";
        int max_size = 0;
        int size1 = ft_strlen(str1);
        int size2 = ft_strlen(str2);
        max_size = size1 + size2;

        char[] result = new char[max_size];
        char[] aux1 = str1.toCharArray();
        char[] aux2 = str2.toCharArray();

        int i = 0;
        int j = 0;
        while (i < size1)
        {
            result[i] = aux1[i];
            i++;
        }
        while (j < size2)
        {
            result[i] = aux2[j];
            i++;
            j++;
        }
        return (new String(result));
    }

    public static String ft_itos(int n){
        if (n == 0)
            return "0";

        if (n == -2147483648)
            return "-2147483648";

        boolean isNegative = false;

        if (n < 0)
        {
            n = -n;
            isNegative = true;
        }

        String result = "";

        while (n > 0)
        {
            int lastDigit = n % 10;
            char digit = (char) (lastDigit + '0');
            String digit_char = String.valueOf(digit);
            result = ft_join(digit_char, result);
            n /= 10;
        }
        if (isNegative)
            result = ft_join("-", result);
        return result;
    }
}

