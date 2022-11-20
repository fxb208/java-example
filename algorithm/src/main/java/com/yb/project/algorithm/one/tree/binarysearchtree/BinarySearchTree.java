package com.yb.project.algorithm.one.tree.binarysearchtree;

import java.util.List;



/**
 * 二叉搜索树
 * @author fxb20
 *
 */
public class BinarySearchTree {
	
    private transient Entry root;

    /**
     * The number of entries in the tree
     */
    private transient int size = 0;

    public int getSize() {
    	return size;
    }
    
    public Entry getRoot() {
    	return root;
    }
    
    public void treeSearch() {
    	
    }
    
    public void treeDelete(Integer value) {
    	
    	Entry delEntry=inorderTreeWalk(root,value);
    	if(delEntry !=null) {
    		if(delEntry.left==null) {
    			transplant(delEntry,delEntry.right);
    		}else if(delEntry.right==null) {
    			transplant(delEntry,delEntry.left);
    		}else {
    			Entry y=treeMinimum(delEntry.right);
    			if(y.parent !=delEntry) {
    				transplant(y,y.right);
    				y.right=delEntry.right;
    				y.right.parent=y;
    			}
    			transplant(delEntry,y);
    			y.left=delEntry.left;
    			y.left.parent=y;
    		}
    	}
    }
    
    public Entry inorderTreeWalk(Entry entry,Integer v) {
    	if(entry !=null) {
    		if(v.equals(entry.value)) {
    			return entry;
    		}else if(v<entry.value) {
    			return inorderTreeWalk(entry.left,v);
    		}else {
    			return inorderTreeWalk(entry.right,v);
    		}
    	}
    	return null;
    }
    
    private void transplant(Entry u,Entry v) {
    	if(u.parent==null) {
    		root=v;
    	}else if(u.parent.left==u) {
    		u.parent.left=v;
    	}else if(u.parent.right==u) {
    		u.parent.right=v;
    	}
    	if(v !=null) {
    		v.parent=u.parent;
    	}
    }
    
//    /** From CLR */
//    private void rotateLeft(Entry p) {
//    	
//    	/**
//    	 * 1，改变p 的父节点        p.parent.left=r     p.parent.right=r 
//    	 * 2，改变P              p.parent=r      p.right=r.left           
//    	 * 3，改变P的右节点R        r.left=p;     r.parent=p.parent;
//    	 * 4，改变P的右节点R 的左节点   r.left.parent=p
//    	 * 
//    	 */
//
//        if (p != null) {
//            Entry r = p.right;  //
//            p.right = r.left;   //  2，改变P    p.parent=r      p.right=r.left    
//            if (r.left != null)
//                r.left.parent = p;  //4，改变P的右节点R 的左节点
//            r.parent = p.parent;    //3，改变P的右节点R        r.left=p;     r.parent=p.parent;
//            if (p.parent == null)
//                root = r;
//            else if (p.parent.left == p)
//                p.parent.left = r;    //1，改变p 的父节点        p.parent.left=r     p.parent.right=r 
//            else
//                p.parent.right = r;   //1，改变p 的父节点        p.parent.left=r     p.parent.right=r 
//            r.left = p;               //3，改变P的右节点R        r.left=p;     r.parent=p.parent;
//            p.parent = r;             //2，改变P              p.parent=r      p.right=r.left 
//        }
//    }
    
    public void inorderTreeWalk(List<Integer> list,Entry entry) {
    	if(entry !=null) {
    		inorderTreeWalk(list,entry.left);
    		list.add(entry.value);
    		inorderTreeWalk(list,entry.right);
    	}
    }
    
    public Entry treeMaximum(Entry y) {
    	while(y!=null && y.right !=null) {
    		y=y.right;
    	}
    	if(y !=null) {
    		return y;
    	}
    	return y;
    }
    
    public Entry treeMinimum(Entry y) {
    	while(y!=null && y.left !=null) {
    		y=y.left;
    	}
    	if(y !=null) {
    		return y;
    	}
    	return y;
    }
    
	public void treeInsert(Integer value) {
		Entry z = new Entry(value, null);
    	Entry y=null;
    	Entry x = root;
		while(x !=null) {	
			y=x;
			if(z.value<x.value) {
				x=x.left;
			}else {
				x=x.right;
			}
		}
		z.parent=y;
		if(y==null) {
			root=z;
		}else if(z.value<y.value) {
			y.left=z;
		}else {
			y.right=z;
		}
		size++;
	}
	
    static final class Entry{
    	Integer value;
        Entry left;
        Entry right;
        Entry parent;

        /**
         * Make a new cell with given key, value, and parent, and with
         * {@code null} child links, and BLACK color.
         */
        Entry(Integer value, Entry parent) {
            this.value = value;
            this.parent = parent;
        }

        /**
         * Returns the value associated with the key.
         *
         * @return the value associated with the key
         */
        public Integer getValue() {
            return value;
        }

        /**
         * Replaces the value currently associated with the key with the given
         * value.
         *
         * @return the value associated with the key before this method was
         *         called
         */
        public Integer setValue(Integer value) {
        	Integer oldValue = this.value;
            this.value =  value;
            return oldValue;
        }        

        public String toString() {
            return "value=" + value;
        }
    }
}
