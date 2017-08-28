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

	public void setHead(Node<K,V> tempNode) {
		if(this.head==null){
			this.head=tempNode;
			this.tail=tempNode;
		}else{
			if(tempNode!=null){
		        tempNode.setNext(this.head);
		        tempNode.setPre(null);
			}
			
	        this.head.setPre(tempNode);
	        this.head = tempNode;
		}
	}

	public Node<K,V> getTail() {
		return tail;
	}

	public void setTail(Node<K,V> node) {
		if(this.tail!=null){
			this.tail.setNext(node);
		}
		if(node!=null){
			node.setPre(this.tail);
		}
		this.tail=node;
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
