public class Tree {
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py

    /*
    FUNCTIONS TO IMPLEMENT:
    - __init__
    - is_empty
    - __len__
    - count
    - __str__
    - _str_indented
    - average
    - _average_helper
    - __eq__
    - __contains__
    - leaves
    - delete_item
    - _delete_root
    - _extract_leaf
    - insert
    - insert_child
    * */

    public int[] leaves() {
        if (this.isEmpty()) {
            return new int[] {};
        } else if (this.subtress.size() == 0) {
            return new int[] {self.root} 
        } else {
            throw new Exception("write this dumdum")
        }
    }
}
