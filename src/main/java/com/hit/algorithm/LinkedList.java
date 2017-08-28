package com.hit.algorithm;

public class LinkedList<K,V> {
	private Node<K,V> head;
	private Node<K,V> tail;
	
	public LinkedList() {
		this.setHead(null);
		this.setTail(null);
	}

	public Node<K,V> getHead() {
		return head;
	}

	public void setHead(Node<K,V> head) {
		if(this.head==null){
			this.head=head;
			this.tail=head;
		}else{
			if(head!=null){
		        head.setNext(this.head);
		        head.setPre(null);
			}
			
	        this.head.setPre(head);
	        this.head = head;
		}
	}

	public Node<K,V> getTail() {
		return tail;
	}

	public void setTail(Node<K,V> tail) {
		if(this.tail!=null){
			this.tail.setNext(tail);
			tail.setPre(this.tail);
		}
		this.tail=tail;
	}
	
	public void removeNode(Node<K,V> toRemove){
        if(toRemove.getPre()!=null){
        	toRemove.getPre().setNext(toRemove.getNext());
        }else{        	
            setHead(toRemove.getNext());
        }
        
        if(toRemove.getNext()!=null){
        	toRemove.getNext().setPre(toRemove.getPre());
        }else{
        	setTail(toRemove.getPre());
        }
		
	}

}
