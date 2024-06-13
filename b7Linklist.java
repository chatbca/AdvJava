
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class B7LinkList {

    public static void main(String[] args) {
        LinkedList<Integer> flist = new LinkedList<Integer>();
        LinkedList<Integer> slist = new LinkedList<Integer>();
        Scanner in = new Scanner(System.in);
        char choice = 'x';
        int num, pos, fpos, spos;

        do {
            System.out.println("      MENU");
            System.out.println("------------------");
            System.out.println("a.Insert a elemnt");
            System.out.println("b.Swap elements");
            System.out.println("c.Iterate in reversee");
            System.out.println("d.Compare two list");
            System.out.println("e.Convert to Array list");
            System.out.println("x.Exit");
            System.out.println("----------------");
            System.out.print("Enter your choice:");
            choice = in.next().toLowerCase().charAt(0);

            switch (choice) {
                case 'a':
                    if (flist.size() > 0) {
                        System.out.println("Element in the list" + flist);
                    } else {
                        System.out.println("Empty List");
                    }
                    System.out.print("Enter the Postion:");
                    pos = in.nextInt();
                    if (pos <= 0) {
                        System.out.println("+ve postion /-");
                    } else if ((flist.size() > 0 && pos <= flist.size() + 1) || (pos == 1)) {
                        System.out.print("Enter a number:");
                        num = in.nextInt();
                        flist.add(pos - 1, num);
                        System.out.println("Element" + num + "is inserted at" + pos);
                    } else {
                        System.out.println("Enter proper position value..!");
                    }

                    break;
                case 'b':
                    System.out.println("Orginal List is" + flist);
                    System.out.println("Enter the postion of elements to be swapped:");
                    System.out.print("First element postion:");
                    fpos = in.nextInt();
                    System.out.print("Second element Postion:");
                    spos = in.nextInt();

                    if (fpos <= 0 && spos <= 0) {
                        System.out.println("+ve value/--");
                    } else if (fpos > flist.size() && spos > flist.size()) {
                        System.out.println("Out of bound....");
                    } else {
                        int n1 = flist.get(fpos - 1);
                        int n2 = flist.get(spos - 1);
                        flist.set(spos - 1, n1);
                        flist.set(fpos - 1, n2);
                        System.out.println("Elements Swaped...");
                        System.out.println("New List:" + flist);

                    }
                    break;
                case 'c':
                    System.out.print("Orginal List" + flist);
                    System.out.println("\nReversed List:[");
                    for (Iterator it = flist.descendingIterator(); it.hasNext();) {
                        System.out.print(it.next() + " ");
                    }
                    System.out.println("]");
                    break;
                case 'd':
                    slist = (LinkedList<Integer>) flist.clone();
                    slist.add(999);
                    if (flist.equals(slist)) {
                        System.out.println("List are Equal");
                    } else {
                        System.out.println("List not equal");
                    }
                    break;
                case 'e':
                    ArrayList<Integer> alst = new ArrayList<>(flist);
                    System.out.println("Array List" + alst);
                    break;

                case 'x':
                    System.out.println("Thank you.....");
                    return;
                default:
                    System.out.println("Wrong choice TRY AGAIN..");
            }
        } while (true);

    }

}
