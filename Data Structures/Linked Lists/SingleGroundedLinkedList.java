
public final class SingleGroundedLinkedList<T> {

  private final LinkedListNode linkedListRoot;

  public SingleGroundedLinkedList() {
    this.linkedListRoot = new LinkedListNode(null);
  }

  public SingleGroundedLinkedList(final T rootNodeValue) {
    linkedListRoot = new LinkedListNode(rootNodeValue);
  }

  public final void addNext(final T nextNodeValue) throws Exception {
    LinkedListNode node = linkedListRoot;
    while(node.getNext() != null) {
      node = node.getNext();
    }
    node.createAndAttachNext(nextNodeValue);
  }

  @Override
  public final String toString() {
    LinkedListNode node = linkedListRoot;
    final StringBuilder sb = new StringBuilder("");
    while(node != null) {
      sb.append(node.getNodeValue() + " ");
      node = node.getNext();
    }
    return sb.toString();
  }

  private final class LinkedListNode<T> {
    private LinkedListNode nextNode;
    private final T nodeValue;

    public LinkedListNode(final T nodeValue) {
      this.nodeValue = nodeValue;
      this.nextNode = null;
    }

    public final LinkedListNode getNext() {
      return nextNode;
    }

    public final void createAndAttachNext(final T nodeValue) throws Exception {
      if(nextNode != null) {
        throw new Exception("Could not attach next, next node already has value of " + nextNode.getNodeValue());
      }

      nextNode = new LinkedListNode(nodeValue);
    }

    public final T getNodeValue() {
      return nodeValue;
    }
  }
}

final class Driver {

  public static final void main(final String[] args) throws Exception {
    final SingleGroundedLinkedList<Integer> linkedList = new SingleGroundedLinkedList(1);
    for(int i = 2 ; i < 11 ; ++i) linkedList.addNext(i);
    System.out.println(linkedList.toString());

    final SingleGroundedLinkedList<String> stringLinkedList = new SingleGroundedLinkedList("Hassan a\n");
    for(int i = 1 ; i < 26 ; ++i) stringLinkedList.addNext(String.format("Hassan %c\n", (int)'a' + i));
    System.out.println(stringLinkedList.toString());
  }
}
