package com.hit.algorithm;

import java.util.HashMap;

public class LRUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K, V>{
	private HashMap<K,Node<K,V>> map;
	private LinkedList<K, V> list;
	
	public LRUAlgoCacheImpl(int capacity) {
		super(capacity);
		this.map=new HashMap<K,Node<K,V>>();
		this.list=new LinkedList<>();
	}
	
	@Override
	public V getElement(K key) {
		if(this.map.containsKey(key)){
            Node<K,V> n = map.get(key);
            removeNode(key);
            list.setHead(n);
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
            list.setHead(old);
        }else{
            Node<K,V> created = new Node<K,V>(key, value);
            if(map.size()>=getCapacity()){
            	V removeValue=list.getTail().getValue();
                removeElement(list.getTail().getKey());
                list.setHead(created);
                map.put(key, created);
                return removeValue;
 
            }else{
                list.setHead(created);
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
        }else{
            list.setHead(toRemove.getNext());
        }
 
        if(toRemove.getNext()!=null){
        	toRemove.getNext().setPre(toRemove.getPre());
        }else{
        	list.setTail(toRemove.getPre());
        }
	}



}
