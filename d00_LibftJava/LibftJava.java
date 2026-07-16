package d00_LibftJava;
import d00_Libft.*;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class LibftJava {
    public static void loading_tests(){
        int i = 0;
        System.out.print("Loading");
        while (i < 5)
        {
            try
            {
                Thread.sleep(1000);
                if (i == 4)
                    System.out.println(".");
                else
                    System.out.print(".");
                i++;
                System.out.flush();
            }
            catch (InterruptedException e)
            {
                System.out.println("Load interrupted");
            }
        }
    }

    public static void testingStrlen(){
        System.out.println("\n>>>\t\t\tFT_STRLEN\n");

        String  str1 = "Hello";
        String  str2 = "World!";
        int     len1 = FtStrings.ft_strlen(str1);
        int     len2 = FtStrings.ft_strlen(str2);

        System.out.println("Testing FT_STRLEN with: " + str1 + " we got a size of "+ len1);
        System.out.println("Testing FT_STRLEN with: " + str2 + " we got a size of "+ len2);
        System.out.println("--------------------------------------------");
    }

    public static void testingStoi(){
        System.out.println("\n>>>\t\t\tFT_STOI\n");

        String  nb1 = "123";
        String  nb2 = "-091a23";
        int     num1 = FtStrings.ft_stoi(nb1);
        int     num2 = FtStrings.ft_stoi(nb2);

        System.out.println("Testing FT_STOI with: " + nb1 + ". The result is " + num1);
        System.out.println("Testing FT_STOI with: " + nb2 + ". The result is " + num2);
    }

    public static void testingSplit(){
        System.out.println("\n>>>\t\t\tFT_SPLIT\n");

        String str1 = "Hello-World-!";
        String[] splited = FtStrings.ft_split(str1, '-');

        System.out.println("Testing FT_SPLIT with: "+ str1 + " and '-'.\n");
        int i = 0;
        System.out.println("\t\t\t----- Case 01 -----\n");
        while (i < splited.length)
        {
            System.out.println("splited[" + i +"] : " + splited[i]);
            i++;
        }
        System.out.println("\nwith the original SPLIT:\n");
        String[] splited_natural = str1.split("-");
        i = 0;
        while (i < splited_natural.length)
        {
            System.out.println("splited_natural[" + i +"] : " + splited_natural[i]);
            i++;
        }
        System.out.println("\n\t\t\t----- Case 02 -----\n");

        String str2 = "-----Testing----with-another-str-case";
        splited = FtStrings.ft_split(str2, '-');
        splited_natural = str2.split("-");
        i = 0;
        while (i < splited.length)
        {
            System.out.println("splited[" + i +"] : " + splited[i]);
            i++;
        }
        System.out.println("\nwith the original SPLIT:\n");

        i = 0;
        while (i < splited_natural.length)
        {
            System.out.println("splited_natural[" + i +"] : " + splited_natural[i]);
            i++;
        }
    }

    public static void testingJoin(){
        System.out.println("\n>>>\t\t\tFT_JOIN\n");

        String str1 = "hola";
        String str2 = " mundo!";

        System.out.println("Testing FT_JOIN with \"" + str1 + "\" and \"" + str2 + ". Should return: \"" + FtStrings.ft_join(str1, str2) + "\"");

        str1 = "testing ";
        str2 = "whit JAVA!";

        System.out.println("Testing FT_JOIN with \"" + str1 + "\" and \"" + str2 + ". Should return: \"" + FtStrings.ft_join(str1, str2) + "\"");
    }

    public static void testingItos(){
        System.out.println("\n>>>\t\t\tFT_ITOS\n");

        int num1 = -12341;
        int num2 = 123153543;
        String str1 = FtStrings.ft_itos(num1);
        String str2 = FtStrings.ft_itos(num2);

        System.out.println("Testing FT_ITOS with: " + num1 + ". The result is " + str1);
        System.out.println("Testing FT_ITOS with: " + num2 + ". The result is " + str2);
    }

    public static void testing_FtStrings(){
        System.out.println("TESTING FTSTRINGS CLASS\n");

        testingStrlen();
        testingStoi();
        testingSplit();
        testingJoin();
        testingItos();

        System.out.println("\n\t--------------------o--------------------");
    }

    public static void testingSortInt(){
        System.out.println(">>>\t\t\tFT_SORT_INT\n");

        int i = 0;
        Random random = new Random();
        int[] arr1 = new int[10];
        while (i < arr1.length)
        {
            arr1[i] = random.nextInt(100)+1;
            i++;
        }
        i = 0;
        System.out.println("Testing with: ");

        System.out.print("{");
        while(i < arr1.length) {
            System.out.print(arr1[i]);
            if (i != arr1.length - 1)
                System.out.print(", ");
            i++;
        }
        System.out.println("}");
        FtArrays.ft_sort_int(arr1);
        i = 0;
        System.out.print("{");
        while(i < arr1.length) {
            System.out.print(arr1[i]);
            if (i != arr1.length - 1)
                System.out.print(", ");
            i++;
        }
        System.out.println("}");
    }

    public static void testingSearchInt(){
        System.out.println(">>>\t\t\tFT_SEARCH_INT\n");

        int i = 0;
        int toFind = 0;
        boolean done = false;
        Random random = new Random();
        int[] arr1 = new int[10];
        while (i < arr1.length)
        {
            arr1[i] = random.nextInt(100)+1;
            if (i == random.nextInt(10) && !done)
            {
                toFind = arr1[i];
                done = true;
            }
            i++;
        }
        i = 0;

        System.out.println("Testing with: ");
        System.out.print("{");

        while(i < arr1.length) {
            System.out.print(arr1[i]);
            if (i != arr1.length - 1)
                System.out.print(", ");
            i++;
        }

        System.out.print("}\t");
        System.out.println("toFind is \"" + toFind + "\"");
        try{
            System.out.println("But first...!");
            Thread.sleep(1000);
            FtArrays.ft_sort_int(arr1);
            Thread.sleep(1000);
            System.out.println("Sorting complete!");
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            System.out.println("Initial sorting failed");
        }

        //loading_tests();

        int founded = FtArrays.ft_search_int(arr1, toFind);
        int founder_original = Arrays.binarySearch(arr1, toFind);

        System.out.println("We found " + toFind + " in the index " + founded);
        System.out.println("And should be: " + founder_original);
    }

    public static void testing_FtArrays(){
        System.out.println("TESTING FTARRAYS CLASS\n");

        testingSortInt();
        testingSearchInt();

        System.out.println("\n\t--------------------o--------------------");
    }

    public static void testing_FtLists(){
        System.out.println("TESTING FTLISTS CLASS");

        List<Integer> list = new ArrayList<>();

        FtLists.ft_list_push_back(list, 123);
        FtLists.ft_list_push_back(list, 41343);
        FtLists.ft_list_push_back(list, 453);
        FtLists.ft_list_push_back(list, 76455445);
        FtLists.ft_list_push_back(list, 76455);

        System.out.println("\n>>>\t\t\tFT_LIST_PUSH_BACK\n");

        System.out.println("The initial list is: " + list + " and have " + list.size() + " numbers.");

        Random random = new Random();
        int index = random.nextInt(list.size());
        int toRemove = list.get(index);

        System.out.println("\n>>>\t\t\tFT_LIST_REMOVE_IF\n");
        System.out.println("Now, we gonna remove " + toRemove);

        FtLists.ft_list_remove_if(list, toRemove);

        System.out.println("And now we have " + list);
        System.out.println("\n>>>\t\t\tFT_LIST_TO_ARRAY\n");

        int[] newArray = FtLists.ft_list_to_array(list);

        System.out.println("We've converted the list to array and you should see like this:");

        int i = 0;

        System.out.print("newArray = [");
        while(i < newArray.length) {
            System.out.print(newArray[i]);
            if (i != newArray.length - 1)
                System.out.print(", ");
            i++;
        }
        System.out.println("]");
        System.out.println("list = " + list);
        System.out.println("\n\t--------------------o--------------------\n");
    }

    public static void testing_FtLinkedLists(){
        System.out.println("TESTING FTLINKEDLISTS CLASS");

        Random random = new Random();
        int[] numbers = new int[10];
        int i = 0;
        while (i < 10)
            numbers[i++] = random.nextInt(10);

        i = 0;
        System.out.print("\nWe are testing with: {");
        while(i < 10)
        {
            System.out.print(numbers[i]);
            if (i != 9)
                System.out.print(" ,");
            i++;
        }
        System.out.println("}");

        System.out.println("\n>>>\t\t\tFT_LSTNEW\n");

        i = 0;
        nodeLists node1 = new nodeLists(numbers[i++]);

        System.out.println("testing ft_lstnew with: " + numbers[0]);
        System.out.println("\nnode1.content = " + node1.content);

        System.out.println("\n>>>\t\t\tFT_LSTADD_BACK\n");

        while (i < 10)
        {
            nodeLists aux_node = new nodeLists(numbers[i]);
            node1 = FtLinkedLists.ft_lstadd_back(node1, aux_node);
            i++;
        }

        System.out.print("the new list are: {");

        nodeLists aux_node = node1;
        while (aux_node != null)
        {
            System.out.print(aux_node.content);
            if (aux_node.next != null)
                System.out.print(" ,");
            aux_node = aux_node.next;
        }

        System.out.println("}");

        System.out.println("\n>>>\t\t\tFT_LSTSIZE\n");

        System.out.println("The size of the LIST is: " + FtLinkedLists.ft_lstsize(node1));

        System.out.println("\n>>>\t\t\tFT_LSTCLEAR\n");

        node1 = FtLinkedLists.ft_lstclear(node1);

        if (node1 == null)
            System.out.println("The list have been deleted");
        else
            System.out.println("The list haven't been deleted");

        System.out.println("\n\t--------------------o--------------------\n");
    }

    public static void main(String [] argc)
    {
        /*
        testing_FtStrings();
        testing_FtArrays();
         */

        testing_FtLists();
        //testing_FtLinkedLists();
        return;
    }
}