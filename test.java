public class test
{
    public static void main(String[] args)
    {
        Mylist m1 = new Mylist();
        addData(m1);
        System.out.println("Contents of m1 before sorting: ");
        m1.display();
        ListSorting.selectionSort(m1);
        System.out.println("\nContents of m1 after selection sort: ");
        m1.display();
        
        Mylist m2 = new Mylist();
        addData(m2);
        System.out.println("\n\nContents of m2 before sorting: ");
        m2.display();
        ListSorting.mergeSort(m2);
        System.out.println("\nContents of m2 after merge sort: ");
        m2.display();        
    }
    
    public static void addData(Mylist m)
    {
        for(int i=0; i<20; i++)
        {
            int n = (int)(Math.random()*100);
            m.add(n);
        }
    }
}

/*
sample output:

Contents of m1 before sorting:
88 52 3 5 87 99 31 47 84 50 42 11 78 19 0 16 88 10 15 60

Contents of m1 after selection sort:
0 3 5 10 11 15 16 19 31 42 47 50 52 60 78 84 87 88 88 99


Contents of m2 before sorting:
92 78 91 87 81 79 52 91 78 32 27 88 50 28 1 17 30 76 28 63

Contents of m2 after merge sort:
1 17 27 28 28 30 32 50 52 63 76 78 78 79 81 87 88 91 91 92

*/
