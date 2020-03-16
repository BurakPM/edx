//This might be the shortest way

public int kthLargest(int k, int[] arr) {
    Arrays.sort(arr);
    int index = (k - k + (-k - 1));
    return arr[arr.length+index];
}
