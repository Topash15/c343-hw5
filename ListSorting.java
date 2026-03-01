import java.util.ArrayList;
import java.util.Stack;

public class ListSorting
{
    public static void selectionSort(Mylist mlist)
    {
        // your code goes here:
        // follow selection sort algorithm to
        // sort mlist in increasing order of node values

        // temp storage of all values
        ArrayList<Integer> values = new ArrayList<Integer>();

        Mynode target = mlist.head;

        // if list is empty or one item, return as is
        if(target.next == null || target == null){
            return;
        }

        values.add(target.value);
        while(target.next != null){
            values.add(target.next.value);
            target = target.next;
        }

        int min, temp;
        int array_size = values.size();

        for (int i = 0; i < array_size-1; i++){
            min = i;

            for(int j = i+1; j < array_size; j++){

                if(values.get(j) < values.get(min)){
                    min = j;
                }

                temp = values.get(i);
                values.set(i, values.get(min));
                values.set(min, temp);
            }
        }

        // recreates sorted list from arrayList
        mlist.head = null;
        for(int i = values.size()-1; i >=0 ; i--){
            mlist.add(values.get(i));
        }
          
    }
    
    // recursive function to sort mlist
    public static void mergeSort(Mylist mlist)
    {
        Mynode h = mlist.head;
        
        // if 0 or 1 node: nothing to sort
        if (h == null || h.next == null) return;
 
        // get the middle node of the list
        Mynode middle = getMiddle(mlist);
        
        // divide one list into two lists
        Mylist leftList = new Mylist();
        Mylist rightList = new Mylist();
        leftList.head = mlist.head;
        rightList.head = middle.next;   
        middle.next = null;
 
        // Apply mergeSort on left and right lists
        mergeSort(leftList);
        mergeSort(rightList);
        
        //mege the two sorted lists
        Mylist sortedlist = mergeLists(leftList, rightList);
        mlist.head = sortedlist.head;
    }
    
    // return the middle node of a list
    public static Mynode getMiddle(Mylist list)
    {
        Mynode head = list.head;
        if (head == null) return head;
        else if (head.next == null) return head;
        else
        {
            Mynode slow = head;
            Mynode fast = head;

            while (fast.next != null && fast.next.next != null)
            {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
    
    // merge two sorted list and return the merged list
    public static Mylist mergeLists(Mylist m1, Mylist m2){
        Mylist result = new Mylist();
        // your code goes here
        // merge two sorted lists (increasing order) m1 and m2 into list result
        // return result, which should also be sorted and in increasing order
        Stack<Integer> tempStack = new Stack<>();

        Mynode L1 = m1.head;
        Mynode L2 = m2.head;

        while(L1 != null && L2 != null){
            if(L2.value > L1.value){
                tempStack.push(L1.value);
                L1 = L1.next;
            } else {
                tempStack.push(L2.value);
                L2 = L2.next;
            }
        }
        while(L1 != null){
            tempStack.push(L1.value);
            L1 = L1.next;
        }
        while(L2 != null){
            tempStack.push(L2.value);
            L2 = L2.next;
        }        

        while(!tempStack.isEmpty()){
            result.add(tempStack.pop());
        }

        return result;
    }
}
