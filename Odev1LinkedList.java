public class Odev1LinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {
	/**
	 * Bir listede elemanları uygun konuma ekler. Boş bir listeye elemanlar
	 * eklendikten sonra küçükten büyüğe sıralı olur
	 * 
	 * @param value eklenecek değer
	 */
	@Override
	public void insertInOrder(T value) {
		Node<T> newNode = new Node<>(value, null);
		if (head == null || head.value.compareTo(newNode.value) >= 0) {
			addFirst(value);
		} else {
			Node<T> current = head;
			while (current.next != null && current.next.value.compareTo(newNode.value) < 0) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
	}

	/**
	 * Mevcut listeyi değiştirmeden, elemanların sırası ters çevrilmiş halde
	 * geri döndürür.
	 * 
	 * @return Ters çevrilmiş liste
	 */
	@Override
	public AbstractLinkedList<T> reverse() {
		Odev1LinkedList<T> list = new Odev1LinkedList<>();
		Node<T> current = head;
		while (current != null) {
			list.addFirst(current.value);
			current = current.next;
		}
		return list;
	}
	/**
	 * Mevcut liste ile parametre olarak gelen listeyi birleştirip geriye
	 * döndürür. Mevcut listede değişiklik yapılmaz.
	 * 
	 * @param list Mevcut listenin sonuna eklenecek liste
	 * @return Birleşmiş liste
	 */
	@Override
	public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {
		Odev1LinkedList<T> newList = new Odev1LinkedList<>();
		Node<T> current = head;
		while (current != null) {
			newList.addLast(current.value);
			current = current.next;
		}
		current = list.head;
		while (current != null) {
			newList.addLast(current.value);
			current = current.next;
		}
		return newList;
	}
	public static void main(String[] args) {
		Odev1LinkedList<Integer> firstNode = new Odev1LinkedList<>();
		firstNode.insertInOrder(21);
		firstNode.insertInOrder(21);
		firstNode.insertInOrder(36);
		firstNode.insertInOrder(42);
		firstNode.insertInOrder(43);
		firstNode.insertInOrder(48);
		firstNode.insertInOrder(98);
		firstNode.insertInOrder(66);
		firstNode.insertInOrder(65);
		firstNode.insertInOrder(79);
		firstNode.insertInOrder(78);
		firstNode.insertInOrder(74);
		firstNode.insertInOrder(81);
		firstNode.insertInOrder(56);
		firstNode.insertInOrder(96);
		firstNode.insertInOrder(48);
		firstNode.insertInOrder(27);

        Odev1LinkedList<Integer> secondNode = new Odev1LinkedList<>();
        secondNode.insertInOrder(14);
        secondNode.insertInOrder(98);
        secondNode.insertInOrder(88);
        secondNode.insertInOrder(77);
        secondNode.insertInOrder(59);

        AbstractLinkedList<Integer> xNode=firstNode.concatenate(secondNode);
		firstNode.print();
		xNode.print();
		AbstractLinkedList<Integer> thirdNode=firstNode.reverse();
		thirdNode.print();
		firstNode.print();
	}

}
