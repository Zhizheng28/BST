public class ItemType {
    
    //Initialize Varibles 
    private int value;

    /**
     * Constructor
     */
    public ItemType(int num) {
        this.value = num;
    }
    
    /**
     * Compares the value of item with the current object's 
     * value and return -1 if value of the current object is 
     * less than value in item , 0 if equal and 1 if greater
     * @param item - ItemType
     * @return 0(equal), 1(greater), -1(less)
     */
    public int compareTo(ItemType item) {
        if (this.value > item.getValue()) {
            return 1;
        } else if (this.value < item.getValue()){
            return -1;
        } else {
            return 0;
        }
    } // compareTo
    
    /**
     * get the value
     * @return a integer value
     */
    public int getValue() {
        return value;
    } // getValue

} // ItemType 
