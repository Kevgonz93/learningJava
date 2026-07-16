package d00_Libft;

public class nodeLists {
    public int content;
    public nodeLists next;

    public nodeLists(int content) {
        this.content = content;
        this.next = null; // Al crearse, no apunta a nadie todavía
    }
}