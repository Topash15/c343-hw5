public class Mylist
{
    Mynode head;
    
    public Mylist()
    {
        head = null;
    }
    
    public void add(int n)
    {
        Mynode m = new Mynode(n);
        m.next = head;
        head = m;
    }
    
    public void display()
    {
        Mynode temp = head;
        while(temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
