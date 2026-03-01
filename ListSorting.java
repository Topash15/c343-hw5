import java.util.Stack;

public class ListSorting {
    public static void selectionSort(Mylist mlist) {

        // sorted values
        Mylist result = new Mylist();

        // find max in input list, add to result
        Mynode max, prevMax, curr, prevCurr;

        // if list is empty or one item, return as is
        if (mlist.head == null || mlist.head.next == null) {
            return;
        }

        while (mlist.head != null) {
            max = mlist.head;
            prevMax = null;
            prevCurr = max;
            curr = mlist.head.next;

            while (curr != null) {
                if (curr.value > max.value) {
                    prevMax = prevCurr;
                    max = curr;
                }
                prevCurr = curr;
                curr = curr.next;
            }
            if (mlist.head.value == max.value) {
                result.add(max.value);
                mlist.head = mlist.head.next;
            } else {
                result.add(max.value);
                prevMax.next = max.next;
            }
        }

        mlist.head = result.head;
    }

    // recursive function to sort mlist
    public static void mergeSort(Mylist mlist) {
        Mynode h = mlist.head;

        // if 0 or 1 node: nothing to sort
        if (h == null || h.next == null)
            return;

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

        // mege the two sorted lists
        Mylist sortedlist = mergeLists(leftList, rightList);
        mlist.head = sortedlist.head;
    }

    // return the middle node of a list
    public static Mynode getMiddle(Mylist list) {
        Mynode head = list.head;
        if (head == null)
            return head;
        else if (head.next == null)
            return head;
        else {
            Mynode slow = head;
            Mynode fast = head;

            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }

    // merge two sorted list and return the merged list
    public static Mylist mergeLists(Mylist m1, Mylist m2) {
        Mylist result = new Mylist();

        Stack<Integer> tempStack = new Stack<>();

        Mynode L1 = m1.head;
        Mynode L2 = m2.head;

        while (L1 != null && L2 != null) {
            if (L2.value > L1.value) {
                tempStack.push(L1.value);
                L1 = L1.next;
            } else {
                tempStack.push(L2.value);
                L2 = L2.next;
            }
        }
        while (L1 != null) {
            tempStack.push(L1.value);
            L1 = L1.next;
        }
        while (L2 != null) {
            tempStack.push(L2.value);
            L2 = L2.next;
        }

        while (!tempStack.isEmpty()) {
            result.add(tempStack.pop());
        }

        return result;
    }
}
