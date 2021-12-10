package com.sample;

class CountThread extends Thread {
    @Override
    public void run() {
        super.run();
    }

    public static int[] countElements(int[] arr, int lessThan, int greaterThan) {
        int[] result = new int[]{0, 0};
        int c1 = 0, c2 = 0;
        for (int v : arr) {
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