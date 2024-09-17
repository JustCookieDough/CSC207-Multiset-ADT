import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py

    private Integer root; // its gotta be Integer and not int cause it has to be nullable  -scott
    private ArrayList<Tree> subtrees;

    /*
    FUNCTIONS TO IMPLEMENT:
    - __init__
    - ~~is_empty~~
    - __len__
    - count
    - __str__
    - _str_indented
    - average
    - _average_helper
    - __eq__
    - __contains__
    - ~~leaves~~
    - ~~delete_item~~
    - ~~_delete_root~~
    - ~~_extract_leaf~~
    - ~~insert~~
    - ~~insert_child~~
    * */

    // sorry did these for yall got tired of seeing the red references
    public Tree(Integer root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = subtrees;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public List<Integer> leaves() {
        if (isEmpty()) {
            return new ArrayList<>();
        } else if (subtrees.isEmpty()) {
            return new ArrayList<>(Collections.singletonList(root)); // ugly but it works. might fix later -scott
        } else {
            ArrayList<Integer> leaves = new ArrayList<>();
            for (Tree subtree : subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }

    public boolean deleteItem(int item) {
        if (isEmpty()) {
            return false;
        } else if (root == item) {
            deleteRoot();
            return true;
        } else {
            for (int i = 0; i < subtrees.size(); i++) {
                boolean deleted = subtrees.get(i).deleteItem(item);
                if (deleted && subtrees.get(i).isEmpty()) {
                    subtrees.remove(i);
                    return true;
                } else if (deleted) {
                    return true;
                }
            }

            return false;
        }
    }

    private void deleteRoot() {
        if (subtrees.isEmpty()) {
            root = null;
        } else {
            Tree chosenSubtree = subtrees.removeFirst();
            root = chosenSubtree.root;
            subtrees.addAll(chosenSubtree.subtrees);
        }
    }

    private int extractLeaf() {
        if (subtrees.isEmpty()) {
            int oldRoot = root;
            root = null;
            return oldRoot;
        } else {
            int leaf = subtrees.getFirst().extractLeaf();

            if (subtrees.getFirst().isEmpty()) {
                subtrees.removeFirst();
            }

            return leaf;
        }
    }

    public void insert(int item) {
        if (isEmpty()) {
            root = item;
        } else if (subtrees.isEmpty()) {
            subtrees.add(new Tree(item, new ArrayList<>()));
        } else {
            Random rand = new Random();
            if (rand.nextInt(3) == 0) { // one in three chance!
                subtrees.add(new Tree(item, new ArrayList<>()));
            } else {
                int subtreeIndex = rand.nextInt(subtrees.size());
                subtrees.get(subtreeIndex).insert(item);
            }
        }
    }

    public boolean insertChild(int item, int parent) {
        if (isEmpty()) {
            return false;
        } else if (root == parent) {
            subtrees.add(new Tree(item, new ArrayList<>()));
            return true;
        } else {
            for (Tree subtree : subtrees) {
                if (subtree.insertChild(item, parent)) {
                    return true;
                }
            }
            return false;
        }
    }
}
