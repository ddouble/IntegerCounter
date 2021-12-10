package com.sample;

class CountThread extends Thread {
    private final int[] numberArray;
    private final int startIndex;
    private final int taskSize;
    private final int lessThan;
    private final int greaterThan;
    private final CountThreadStore store;

    public CountThread(int[] numberArray, int startIndex, int taskSize, int lessThan, int greaterThan, CountThreadStore store) {
        this.numberArray = numberArray;
        this.startIndex = startIndex;
        this.taskSize = taskSize;
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.store = store;
    }

    @Override
    public void run() {
        store.incThreadAmount();
        
        int[] result = countElements(numberArray, startIndex, taskSize, lessThan, greaterThan);
        store.incLessThanAmount(result[0]);
        store.incGreaterThanAmount(result[1]);
        super.run();

        store.decThreadAmount();
    }

    public static int[] countElements(int[] arr, int lessThan, int greaterThan) {
        return countElements(arr, 0, arr.length, lessThan, greaterThan);
    }

    public static int[] countElements(int[] arr, int startIndex, int taskSize, int lessThan, int greaterThan) {
        int[] result = new int[]{0, 0};
        int c1 = 0, c2 = 0;
        for (int i = 0; i < taskSize; i++) {
            int v = arr[startIndex + i];
            if (v < lessThan) {
                c1++;
            }
            if (v > greaterThan) {
                c2++;
            }
        }
        result[0] = c1;
        result[1] = c2;
        return result;
    }
}