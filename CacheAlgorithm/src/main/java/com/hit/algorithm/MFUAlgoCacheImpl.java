package com.hit.algorithm;

import java.util.HashMap;

public class MFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K, V>{
	private Node<K,V> head;
	private Node<K,V> tail;
	private HashMap<K,Node<K,V>> map  = new HashMap<K,Node<K,V>>();
	
	public MFUAlgoCacheImpl(int capacity) {
		super(capacity);
		this.head = null;
		this.tail = null;
	}

	@Override
	public V getElement(K key) 
	{
		if(!map.containsKey(key))
			return null;
		
			Node<K,V> tempNode = map.get(key);
			this.remove(tempNode);
			tempNode.increaseAge();
			this.findPlace(tempNode);
			return tempNode.getValue();
	}

	private void findPlace(Node<K,V> n) {
		Node<K,V> currNode = head;
		if(head== null){
			head=n;
			return;
		}
		while((n.getAge()<currNode.getAge())&&(currNode.getpre()!=null))
		{
				currNode = currNode.getpre();
		}
		n.setNext(currNode);
		n.setPre(currNode.getpre());
		
		currNode.setPre(n);
		if(n.getpre()!=null)
			n.getpre().setNext(n);
	}

	private void remove(Node<K,V> n) {
		if(n.getpre()!=null){
			n.getpre().setNext(n.getNext());
		}else{
			head = n.getNext();
		}
	}

	@Override
	public V putElement(K key, V value) {
		Node<K,V> n = new Node<K,V>(key,value);
		map.put(key,n);
		findPlace(map.get(key));
		return null;
	}

	@Override
	public void removeElement(K key) {
		if(!map.containsKey(key))
			return;
		Node<K,V> tempNode = new Node<K,V>(key,map.get(key).getValue());
		remove(tempNode);
		map.remove(key);
	}
}
