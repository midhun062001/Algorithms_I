package com.coursera.algorithms.chapter.one.four.analysis.exercises;

public class BitonicArray {

    /*
    * @param int[] bitonic array (an array contain increasing sequence of elements immediately followed by decreasing sequence of elements)
    * @param int target to be searched
    * @return int index if element found otherwise return-1
    * */

    public static int bitonicSearch(int a[], int target) {
        int N = a.length;

        int l = 0;
        int r = N-1;

        // find peek element
        while(l<r) {
            int mid =  l+(r-l)/2;

            if(a[mid] < a[mid+1]) {
                l = mid+1;
            }
            else {
                r = mid;
            }
        }

        if(a[l] == target) {
            return l;
        }

        int peek = l;

        // search in left sub array (ascending order)
        int index = binarySearch(a,target,0,peek-1,false);
        if(index >= 0) {
            return index;
        }
        else {
            // if not found search in right subarray (descending order)
            return binarySearch(a,target,peek+1,N-1,true);
        }
    }

    public static int binarySearch(int[] a, int target, int l, int r, boolean isDescending) {
        while(l<=r) {
            int mid = l + (r-l)/2;

            if(a[mid] == target) {
                return mid;
            }
            else if(a[mid] < target) {
                if(isDescending) {
                    r =  mid-1;
                }
                else {
                    l = mid+1;
                }
            }
            else {
                if(isDescending) {
                    l = mid+1;
                }
                else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {6,10,9,8,4,2,1};
        int idx = bitonicSearch(a,9);
        System.out.println(idx);

        int[] b = {9,8,4,2,1};
        System.out.println(bitonicSearch(b,9));

        int[] c = {1,2,3,4,5};
        System.out.println(bitonicSearch(c,4));
    }
}
