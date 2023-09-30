package org.example;

import java.util.Arrays;

public class QuickSortImpl {
    public static void quickSort(int a[],int p, int r){
        int q;
        if(p<r) {
            q = partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x=a[r];
        int i,j;
        i=p-1;
        for(j=p;j<=r-1;j++){
            if(a[j]<x){
                i=i+1;
                swap(a,i,j);
            }
        }
        swap(a,i+1,r);
        return i+1;
    }

    private static void swap(int[] a, int i, int r) {
        int temp;
        temp=a[i];
        a[i]=a[r];
        a[r]=temp;
    }
    public static void main(String args[]){
        int a[]={2,4,7,1,8,3,9,4,7};
        quickSort(a,0,a.length-1);
        Arrays.stream(a).forEach(i->System.out.print(i+", "));
    }
}
