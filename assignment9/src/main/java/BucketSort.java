import java.util.ArrayList;

public class BucketSort {
    private static final int BUCKET_SIZE = 26;

    public static void sort(ArrayList<String> list) {
        ArrayList<String>[] bucket = putTextsInBucket(list);
        
        for (ArrayList<String> smallList : bucket) {
            MergeSort.sort(smallList);
        }

        flattenBucket(list, bucket);
    }

    public static ArrayList<String> flattenBucket(ArrayList<String> list, ArrayList<String>[] bucket) {
        list.clear();

        for (int i = 0; i < bucket.length; i++) {
            for (String text : bucket[i]) {
                list.add(text);
            }
        }
        return list;
    }

    public static ArrayList<String>[] putTextsInBucket(ArrayList<String> list) {
        ArrayList<String>[] bucket = new ArrayList[BUCKET_SIZE];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<String>();
        }

        for (String text : list) {
            bucket[text.charAt(0) - 'a'].add(text);
        }

        return bucket;
    }
}
