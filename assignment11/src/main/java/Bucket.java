import java.util.ArrayList;

public abstract class Bucket<T> extends ArrayList<T> {
    protected abstract int getIdx();

    public T Pick() {
        int idx = this.getIdx();
        T value = this.get(idx);
        this.remove(idx);
        return value;
    }
}
