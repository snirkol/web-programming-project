package com.hit.algorithm;

import java.util.HashMap;

public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K, V>{
	private HashMap<K,Node<K,V>> map;
    private Node<K,V> head;
    private Node<K,V> end;
	
	public LRUAlgoCacheImpl(int capacity) {
		super(capacity);
		this.map=new HashMap<K,Node<K,V>>();
		this.setHead(null);
		this.setEnd(null);
	}
	
	@Override
	public V getElement(K key) {
		if(this.map.containsKey(key)){
            Node<K,V> n = map.get(key);
            removeNode(key);
            setHead(n);
            return n.getValue();
		}
		
		return null;
	}

	@Override
	public V putElement(K key, V value) {
        if(map.containsKey(key)){
            Node<K,V> old = map.get(key);
            old.setValue(value);
            removeElement(key);
            setHead(old);
        }else{
            Node<K,V> created = new Node<K,V>(key, value);
            if(map.size()>=getCapacity()){
            	V removeValue=end.getValue();
                removeElement(end.getKey());
                setHead(created);
                map.put(key, created);
                return removeValue;
 
            }else{
                setHead(created);
                map.put(key, created);
            }    
        }
        
        return null;
	}

	@Override
	public void removeElement(K key) {
		removeNode(key);
		map.remove(key);
	}
	
	public void removeNode(K key){
		Node<K, V> toRemove=map.get(key);
        if(toRemove.getPre()!=null){
        	toRemove.getPre().setNext(toRemove.getNext());
        	toRemove.getNext().setPre(toRemove.getPre());
        }else{
            setHead(toRemove.getNext());
        }
 
        if(toRemove.getNext()!=null){
        	toRemove.getNext().setPre(toRemove.getPre());
        	toRemove.getPre().setNext(toRemove.getNext());
        }else{
        	setEnd(toRemove.getPre());
        }
	}

	public Node<K, V> getHead() {
		return head;
	}

	public void setHead(Node<K, V> head) {
        head.setNext(this.head);
        head.setPre(null);
 
        if(this.head!=null)
            this.head.setPre(head);
 
        this.head = head;
 
        if(this.end ==null)
            this.end = head;
	}

	public Node<K, V> getEnd() {
		return end;
	}

	public void setEnd(Node<K, V> end) {
		if((this.head==null)||(end==null)){
			this.end=null;
		}else{
			this.end.setNext(end);
			end.setPre(this.end);
			this.end=end;
		}
	}

}
