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
		this.list.removeNode(tempNode);
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
		if(this.list.getHead() == this.list.getTail())
			this.list.setTail(n);
		
		while((n.getAge()<currNode.getAge())&&(currNode.getNext()!=null))
				currNode=(NodeWithAge<K, V>) currNode.getNext();
		n.setNext(currNode);
		if(currNode.getPre()!=null)
			n.setPre(currNode.getPre());
		currNode.setPre(n);
		if(n.getPre()!=null) 
			n.getPre().setNext(n);

	}
	
	@Override
	public V putElement(K key, V value) {
		if(map.containsKey(key))
			return getElement(key);
		
		V deletedPage = null;
		if(this.getCapacity()<=map.size())
		{
			deletedPage =this.list.getTail().getValue();
			this.removeElement(list.getTail().getKey());
		}
			
		
		NodeWithAge<K,V> n = new NodeWithAge<K,V>(key,value);
		map.put(key,n);
		findPlace(n);
		return deletedPage;
		}

	@Override
	public void removeElement(K key) {
		if(!map.containsKey(key))
			return;
		NodeWithAge<K,V> tempNode = new NodeWithAge<K,V>(key,map.get(key).getValue());
		this.list.removeNode(tempNode);
		map.remove(key);
	}
}
