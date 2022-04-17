package com.example.ReflectionAndRefactoring;

import java.util.Arrays;

public class ALibEx implements ILib{
    @Override
    public String solveFirst(int[] n) {
        return "Done by solveFirst" + Arrays.toString(n);
    }

    @Override
    public String solveOP(int[] n) {
        return "Done by solveOP" + Arrays.toString(n);
    }

    @Override
    @TheBest
    public String solveTest(int[] n) {
        return "Done by solveTest" + Arrays.toString(n);
    }

    @Override
    public String solvePR(int[] n) {
        return "Done by solvePR" + Arrays.toString(n);
    }
}
