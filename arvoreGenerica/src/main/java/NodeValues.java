public class NodeValues<T> implements Comparable<NodeValues>{
    private T key;
    private int value;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeValues(T key, int value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(NodeValues nodeValues) {
        if(this.value > nodeValues.value){
            return -1;
        }
        else if(this.value < nodeValues.value){
            return 1;
        }
        return this.getKey().toString().compareToIgnoreCase(nodeValues.getKey().toString());
    }


    @Override
    public String toString() {
        return "NodeValues{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
