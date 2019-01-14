package lab09;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to implement the Binary Search Tree data structure.
 * The structure is generic in the type of Objects it contains.
 * @param <T> the type of the contained elements this structure is to hold
 */
public class BinarySearchTree<T> {
    private Comparator<T> comparator;
    private T data;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    /**
     * Constructs an empty BST with a Comparator
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(Comparator<T> comp) {
        this.comparator = comp;
    }

    /**
     * Constructs a BST with data and a Comparator
     * @param data the data this BST should hold
     * @param comp the Comparator to use to impose an ordering on instances of T
     */
    public BinarySearchTree(T data, Comparator<T> comp) {
        this.data = data;
        this.comparator = comp;
    }

    /**
     * Inserts an element into this BST
     * @param element the element to insert into this BST
     */
    public void insert(T element) {
    	if(data == null){
    		data = element;
    	}
    	else if(comparator.compare(element, data) < 0){
	    		if(left == null)
	    			left = new BinarySearchTree<>(element, comparator);
	    		else
	    			left.insert(element);
    	}else if(comparator.compare(element, data) > 0){
	    		if(right == null)
	    			right = new BinarySearchTree<>(element, comparator);
	    		else
	    			right.insert(element);
	    }
    }

    /**
     * Searchs for a given element in this BST
     * @param element the element to search this BST for
     * @return the element in this BST matching the given element, if found,
     *         otherwise null if the given element is not in this BST
     */
    public T find(T element) {
    	if(comparator.compare(element, data) < 0){
    		if(left == null)
    			return null;
    		return left.find(element);
    	}
    	if(comparator.compare(element, data) > 0){
    		if(right == null)
    			return null;
    		return right.find(element);
    	}
    	return data;
    }

    /**
     * Gathers all the elements of this BST in order
     * @return a List holding the elements in this BST in order
     */
    public List<T> getElements() {
        List<T> list = new ArrayList<>();
        if(right != null) {
        	list.addAll(right.getElements());
        }
        if(left != null) {
        	list.addAll(left.getElements());
        }
        list.add(data);
        list.sort(comparator);
        /*
        if(left == null && right == null && !list.contains(data)){
        	list.add(data);
        }else if(left == null){
        	list.addAll(right.getElements());
        }else if(right == null){
        	list.addAll(left.getElements());
        }
        */
        return list;
    }

    /**
     * Pretty prints the contents of this BST in a horizontal tree-like fashion
     */
    public void prettyPrint() {
        prettyPrint(0);
    }

    private void prettyPrint(int indentLevel) {
        // TODO
        // print `indentLevel` amount of spaces before printing data on its own line
	//HINT: you will want to do an in order traversal here. (see the Traversal section in the explanation of Binary Trees above)
        // you may use a for loop to print `indentLevel` amount of spaces
        // each time you recurse, you add to indentLevel
    	for(int i = 0; i < indentLevel; i++) {
    		System.out.print(" ");
    	}
    	if(left != null) {
    		left.prettyPrint(indentLevel + 1);
        	for(int i = 0; i < indentLevel; i++) {
        		System.out.print(" ");
        	}
    		System.out.println(data);
    	}
    	if(right != null) {
    		right.prettyPrint(indentLevel + 1);
    	}
    	if(left == null) {
    		System.out.println(data);
    	}
    }

    /**
     * A main method supplied for any debugging needs
     */
    public static void main(String[] args) {
        // Up to you how you use this main method, feel free to change it
        Comparator<Integer> intComp = (i, j) -> i - j; // lambda expression
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(intComp);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(0);
        tree.insert(3);
        tree.insert(9);
        tree.insert(4);
        System.out.println(tree.getElements());
        tree.prettyPrint();
    }
}