/*
public class MyLinkedList implements NodeList {

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    ListItem root = null;

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            root = item;
        }
        ListItem currItem = root;
        while (root != null) {
            int compare = currItem.compareTo(item);
            if (compare < 0) {
                if (currItem.next() != null) {
                    currItem = currItem.next();
                } else {
                    currItem.setNext(item);
                    item.setPrevious(currItem);
                    return true;
                }
            } else if (compare > 0) {
                if (currItem.previous() != null) {
                    currItem.previous().setNext(item);
                    item.setPrevious(currItem.previous());
                    item.setNext(currItem);
                    currItem.setPrevious(item);
                } else {
                    item.setNext(root);
                    root.setPrevious(item);
                    root = item;
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            ListItem curr = root;
            while (curr != null) {
                if (curr.compareTo(item) == 0) {
                    if (curr == root) {
                        root = root.next();
                    } else {
                        curr.previous().setNext(curr.next());
                        if (curr.next() != null) {
                            curr.next().setPrevious(curr.previous());
                        }
                    }
                    return true;
                } else if (curr.compareTo(item) < 0) {
                    curr = curr.next();
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            System.out.println(root);
            root = root.next();
        }
    }
}
*/
