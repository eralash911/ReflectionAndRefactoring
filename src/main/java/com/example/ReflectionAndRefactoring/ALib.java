package com.example.ReflectionAndRefactoring;

import java.util.Arrays;

public final class ALib {
    private ALib(){}

    public static String solveFirst(int []n){
        return "Done by solveFirst" + Arrays.toString(n);
    }
    public static String solveOp(int []n){
        return "Done by solveOp" + Arrays.toString(n);
    }
    @TheBest
    public static String solveTest(int []n){
        return "Done by solveTest" + Arrays.toString(n);
    }

    public static String solvePr(int []n){
        return "Done by solveFirst" + Arrays.toString(n);
    }
}
