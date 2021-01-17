package javasource;

import java.util.*;

/**
 * 멀티캠퍼스에서 주관한 코딩테스트를 응시할 때
 * 리스트로 준비된 값의 모든 요소의 합의 조합을 구하는 알고리즘이 필요했었다.
 * 그 부분을 정리한다.
 */
public class CollectionItemSum {
    public static void main(String[] args) {
        int[] array= {1, 3, 5, 7, 9};

        powerset(array, 0, new boolean[array.length]);
        // print(new boolean[3]);
    }

    public static void powerset(int[]arr, int idx, boolean[] sel) {
        System.out.println("idx = "+idx + " 재귀");
        print(sel);
        if(idx == arr.length) {
            for(int i=0; i<sel.length; i++) {
                if(sel[i]) {
                    System.out.print(arr[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        sel[idx] = true;
        powerset(arr, idx+1, sel);
        sel[idx] = false;
        powerset(arr, idx+1, sel);
    }

    public static void print(boolean[] sel) {
        for(int i=0; i<sel.length; i++) {
            System.out.print(sel[i]+" ");
        }
        System.out.println();
    }
/*
    public static void getAllSums(int[] numbersArray, int start, int sum) {
        if(numbersArray.length == start) {
            tree.add(sum);
            return;
        }
        int value = sum + numbersArray[start];
        getAllSums(numbersArray, start + 1, value);
        getAllSums(numbersArray, start + 1, sum);
    }
*/
}
