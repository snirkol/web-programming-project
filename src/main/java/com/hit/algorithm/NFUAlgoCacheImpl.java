package com.hit.algorithm; 

import java.util.HashMap;

public class NFUAlgoCacheImpl<K,V> extends AbstractAlgoCache<K, V>{
	private LinkedList<K, V> list;
	private HashMap<K,NodeWithAge<K,V>> map  = new HashMap<K,NodeWithAge<K,V>>();
	
	public NFUAlgoCacheImpl(int capacity) {
		super(capacity);
		this.list=new LinkedList<>();
		this.map  = new HashMap<K,NodeWithAge<K,V>>();
	}

	@Override
	public V getElement(K key) 
	{
		if(!map.containsKey(key))
			return null;
		
		NodeWithAge<K,V> tempNode = map.get(key);
		this.remove(tempNode);
		tempNode.increaseAge();
		this.findPlace(tempNode);
		return tempNode.getValue();
	}

	private void findPlace(NodeWithAge<K,V> n) {
		NodeWithAge<K,V> currNode = (NodeWithAge<K, V>) list.getHead();
		if(list.getHead()== null){
			list.setHead(n);
			return;
		}
		while((n.getAge()<currNode.getAge())&&(currNode.getPre()!=null))
		{
				currNode=(NodeWithAge<K, V>) currNode.getPre();
		}
		n.setNext(currNode);
		n.setPre(currNode.getPre());
		
		currNode.setPre(n);
		if(n.getPre()!=null)
			n.getPre().setNext(n);
	}

	private void remove(NodeWithAge<K,V> n) {
		if(n.getPre()!=null){
			n.getPre().setNext(n.getNext());
		}else{
			list.setHead((NodeWithAge<K, V>) n.getNext());
		}
	}

	@Override
	public V putElement(K key, V value) {
		NodeWithAge<K,V> n = new NodeWithAge<K,V>(key,value);
		map.put(key,n);
		findPlace(map.get(key));
		return null;
	}

	@Override
	public void removeElement(K key) {
		if(!map.containsKey(key))
			return;
		NodeWithAge<K,V> tempNode = new NodeWithAge<K,V>(key,map.get(key).getValue());
		remove(tempNode);
		map.remove(key);
	}
}
