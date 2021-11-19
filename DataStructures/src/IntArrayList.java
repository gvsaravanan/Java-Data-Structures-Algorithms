import java.util.Arrays;

public class IntArrayList {

    static int[] arr;
    static int length;

    public IntArrayList(int length) {
        arr = new int[length];
        this.length = length;
    }

    public int find(int element) {
        int i = 0;
        while (i < length) {
            if (arr[i] == element) {
                return i;
            } else {
                i += 1;
            }
        }
        return -1;
    }

    public boolean add(int element) {
        int empty = find(0);
        if (empty == -1) {
            arr = Arrays.copyOf(arr, length * 2);
            length *= 2;
            arr[find(0)] = element;
        } else {
            arr[empty] = element;
        }
        return true;
    }

    public boolean insert(int element, int index) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index > length - 1) {
            arr = Arrays.copyOf(arr, length * 2);
            length *= 2;
            arr[index] = element;
        }

        if (index == length) {
            arr[index] = element;
        } else {
            for (int i = length - 1; i > index; i--) {
                arr[i+1] = arr[i];
                arr[index] = element;
            }
        }

        length++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > length) {
            return false;
        } else {
            for (int i = length - 2; i > index; i--) {
                arr[i] = arr[i+1];
                arr[index] = 0;
            }
        }

        length -= 1;
        return true;
    }

    public int size() {
        return length;
    }

    public String toString() {
        return Arrays.toString(arr);
    }
}