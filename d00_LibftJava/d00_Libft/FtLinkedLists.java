package d00_Libft;

public class FtLinkedLists {
    public static nodeLists ft_lstnew(int content){
        return new nodeLists(content);
    }

    public static nodeLists ft_lstadd_back(nodeLists start, nodeLists newNode){
        if (newNode == null)
            return start;
        if (start == null)
            return newNode;
        nodeLists aux_node = start;
        while (aux_node.next != null)
            aux_node = aux_node.next;
        aux_node.next = newNode;
        return start;
    }

    public static int ft_lstsize(nodeLists start){
        if (start == null)
            return 0;
        nodeLists aux_node = start;
        int count = 0;
        while (aux_node != null)
        {
            aux_node = aux_node.next;
            count++;
        }
        return count;
    }

    public static nodeLists ft_lstclear(nodeLists start){
        if (start == null)
            return null;

        nodeLists aux_node = start;
        while (aux_node != null)
        {
            nodeLists nextNode = aux_node.next;
            aux_node.next =null;
            aux_node = nextNode;
        }
        return null;
    }
}
