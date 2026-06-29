class Node{
    int val;
    Node next;

    public Node(int val){
        this(val,null);
    }
    public Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        Node curr= head.next;
        int i=0;
        while(curr!=null){
            if(i==index){
                return curr.val;
            }
            i++;
            curr= curr.next;
        }       
        return -1; 
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if(newNode.next == null){
            tail = newNode;
        }
        
    }

    public void insertTail(int val) {
        this.tail.next= new Node(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        Node curr = this.head;
        int i=0;
        while(i<index && curr!=null){
            i++;
            curr= curr.next;
        }

        if( curr!=null && curr.next!=null){
            if(curr.next == this.tail){
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = this.head.next;
        while(curr!=null){
            arr.add(curr.val);
            curr = curr.next;
        }
        return arr;
    }
}
