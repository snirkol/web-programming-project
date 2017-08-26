package com.hit.algorithm;

public class NodeWithAge<K,V> extends Node<K,V> {
	private int age;
	
	public NodeWithAge(K key, V value) {
		super(key, value);
		setAge(0);
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void increaseAge()
	{
		this.age++;
	}
}
