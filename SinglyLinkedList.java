public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        size--;

        if (isEmpty()){
            tail = null;
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        StringBuilder listStringBuilder = new StringBuilder();
        Node current = head;
        while (current != null){
            listStringBuilder.append (current.getElement());
            current = current.getNext();
        }
        String listString = listStringBuilder.toString();
        return listString;
     
    }

    public E removeLast(){
        if (head == null) {
            return null;
        }

        if (head.getNext() == null) {
            E answer = head.getElement();
            head = null;
            size--;
            return answer;
        }

        Node<E> current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        E answer = current.getNext().getElement();
        current.setNext(null);
        size --;

        return answer;
      
    }

    public void reverse(){       
        Node <E> current = head;
        Node <E> previous = null;

        while (current != null) {
            Node <E> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }
}
