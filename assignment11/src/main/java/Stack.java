public class Stack<T> extends Bucket<T> {
    protected int getIdx() {
        return this.size() - 1;
    }
}
