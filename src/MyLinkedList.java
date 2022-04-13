public class MyLinkedList<E> implements MyList<E> {

    private Node<E> head, tail;
    private int size = 0;

    public MyLinkedList() {

    }

    public MyLinkedList(String[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public String getFirst() {
        if (size == 0) {
            return null;
        } else {
            return head.element;
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(E);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(E);

        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            (current.next).next = temp;
            size++;
        }
    }

    public String toString() {

        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;

        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
                result.append(", "); // Separate two elements with a comma
            } else {
                result.append("]"); // Insert the closing ] in the string
            }

        }
        return result.toString();
    }



}
