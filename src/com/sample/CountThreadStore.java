package com.sample;

public class CountThreadStore {
    public int lessThan;
    public int greaterThan;
    private int lessThanAmount = 0;
    private int greaterThanAmount = 0;
    private int threadAmount = 0;
    private long startTime = 0;
    private long endTime = 0;
    private boolean _isRunning = false;

    synchronized void incLessThanAmount(int amount) {
        lessThanAmount += amount;
    }

    synchronized void incGreaterThanAmount(int amount) {
        greaterThanAmount += amount;
    }

    synchronized void incThreadAmount() {
        if (!_isRunning) _isRunning = true;
        if (startTime == 0) startTime = System.nanoTime();
        threadAmount++;
    }

    synchronized void decThreadAmount() {
        threadAmount--;
        if (_isRunning && threadAmount == 0) {
            endTime = System.nanoTime();
            _isRunning = false;

            System.out.println("\nCount with multi-thread");
            System.out.printf("%d numbers of less than %d\n", getLessThanAmount(), lessThan);
            System.out.printf("%d numbers of less than %d\n", getGreaterThanAmount(), greaterThan);
            System.out.printf("%fms %n", getExecutionTime() / 1000000.0);
        }
    }

    synchronized public int getThreadAmount() {
        return threadAmount;
    }

    synchronized public int getLessThanAmount() {
        return lessThanAmount;
    }

    synchronized public int getGreaterThanAmount() {
        return greaterThanAmount;
    }

    synchronized public boolean isRunning() {
        return _isRunning;
    }

    synchronized public long getExecutionTime() {
        return endTime - startTime;
    }
}
