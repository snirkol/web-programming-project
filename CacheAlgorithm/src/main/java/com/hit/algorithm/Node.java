package com.hit.algorithm;

public class Node<K,V> {
private K key;
private V value;
private Node<K,V> next;
private Node<K,V> pre;
int age;

public Node(K key,V value)
{
	setKey(key);
	setValue(value);
	SetAge(0);
}
public void setKey(K key)
{
	this.key = key;
}
public K getKey()
{
	return this.key;
}
public void setValue(V value)
{
	this.value = value;
}
public V getValue()
{
	return this.value;
}
public Node<K,V> getNext()
{
	return this.next;
}
public void setNext(Node<K,V> n)
{
	this.next = n;
}
public Node<K,V> getpre()
{
	return this.pre;
}
public void setPre(Node<K,V> n)
{
	this.pre = n;
}

public int getAge()
{
	return this.age;
}
public void SetAge(int age)
{
	this.age = age;
}
public void increaseAge()
{
	this.age++;
}
}
