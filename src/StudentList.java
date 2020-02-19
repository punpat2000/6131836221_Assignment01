
public class StudentList extends CDLinkedList {
    // you can write additional methods.



	// implement this method
	public void removeStudent(String id) throws Exception {
		if(this.isEmpty()) return;
		DListIterator l = new DListIterator(this.header);
		while(l.currentNode.nextNode != this.header) {
			l.next();
			Student s = (Student)l.currentNode.data;
			if(s.getId().equals(id)) {
				this.removeAt(l);
				return;
			}
		}
	}

	// implement this method
	public void appendQuick(CDLinkedList list2) throws Exception {
		if(list2.isEmpty()) {
			return;
		}
		this.size += list2.size();
		DListNode l1 = this.header.previousNode;
		DListNode f2 = list2.header.nextNode;
		DListNode l2 = list2.header.previousNode;
		l1.nextNode = f2;
		f2.previousNode = l1;
		l2.nextNode = this.header;
		this.header.previousNode = l2;
	}

	// implement this method
	public void append(CDLinkedList list2) throws Exception {
		if(list2.isEmpty()) return;
		DListIterator l2 = new DListIterator(list2.header);
		while(l2.currentNode.nextNode != list2.header) {
			DListIterator l = new DListIterator(this.header.previousNode);
			l2.next();
			Object temp = ((Student)l2.currentNode.data).createCopy();
			this.insert(temp, l);
		}
	}

	// implement this method
	public CDLinkedList gender(int i) throws Exception {
		if(i!=0 && i!=1 )
			return null;
		String gender = i==0?"male":"female";
		CDLinkedList l2 = new CDLinkedList();
		DListIterator p2 = new DListIterator(l2.header);
		DListIterator p = new DListIterator(this.header);
		while(p.currentNode.nextNode != this.header) {
			p.next();
			Student s = ((Student)p.currentNode.data).createCopy();
			if(s.getSex().equals(gender)) {
				l2.insert(s, p2);
				p2.next();
			}
		}
		return l2;

	}

}
