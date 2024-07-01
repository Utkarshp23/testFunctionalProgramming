package com.func;

public class Patterns {

    static int minJumps(int[] arr, int n) {
        // your code here
        int curIndex = 0;
        int jumps =0;
        while(curIndex<n-1){
            if (arr[curIndex]==0) return -1;

            curIndex = findIndexOfMaxInRange(arr,curIndex+1,curIndex+arr[curIndex]);
            jumps++;
            if (curIndex +arr[curIndex]>= n) break;

        }
        return jumps;
    }

    static int findIndexOfMaxInRange(int[] arr, int start, int end){
        int maxIndex = start;
        int maxElement = arr[maxIndex];
        for(int i =start+1;i<=end;i++){
            if(i<arr.length && arr[i]>maxElement){
                maxIndex =i;
                maxElement = arr[i];
            }
        }
        return maxIndex;
    }

    public static boolean isPrime(int n){
        int range =(int) Math.sqrt(n);
        for(int i=2;i<=range;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static long sumOfDivisors(int N){
        // code here
        long sum =0l;
        for(int i=1;i<=N;i++){
            sum += indNumber(i);
        }
        return sum;
    }

    public static long indNumber(int n){
        int range =(int) Math.sqrt(n);
        long sum =0l;
        for(int i=1;i<=range;i++){
            if(n%i==0){
                sum+=i;
                if(i!=(n/i)){
                    sum+=(n/i);
                }
            }
        }
        return sum;
    }

    public static boolean armstrongNumber(int n){

        int digitCount=(int) (Math.log10(n) + 1);
        int temp1 = n;
        int sum =0;
        while(temp1!=0){
            int rem = temp1 % 10;
            sum += Math.pow(rem,digitCount);
            temp1/=10;
        }
        return sum==n;
    }

    static  int  select(int arr[], int startIndex)
    {
        // code here such that selectionSort() sorts arr[]
        int n = arr.length;
        int minEle = arr[startIndex];
        int minInd = startIndex;

        for(int i=startIndex;i<n;i++){
            if(arr[i]<minEle){
                minEle = arr[i];
                minInd = i;
            }
        }
        return  minInd;
    }

    static void  selectionSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n;i++){
            int minInd = select(arr,i);
            int temp = arr[i];
            arr[i]= arr[minInd];
            arr[minInd] = temp;
        }
    }

    static void bubleSort(int arr[], int n){

        for(int i=0;i<n;i++){
            for(int j=0;j<n-(i+1);j++){
                if(arr[j]>arr[j+1]){
                    int temp =  arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void recursivBubble_sort(int[] arr, int n) {
        //Base case: range == 1.
        if (n == 1) return;
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        //Range reduced after recursion:
        recursivBubble_sort(arr, n - 1);

    }

    static void insert(int arr[],int j)
    {
        // Your code here
        while(j>=1 && arr[j]<arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }
    }

    static void insertionSort(int arr[], int n){

        for(int i=1;i<n;i++){
            insert(arr,i);
//           int j = i;
//           while(j>=1 && arr[j]<arr[j-1]){
//               int temp = arr[j];
//               arr[j] = arr[j-1];
//               arr[j-1] = temp;
//               j--;
//           }
        }
    }

    static void recurssiveInsertionSort(int [] arr,int n){

        if(n==0) return;
        recurssiveInsertionSort(arr, n-1);
        for(int i=n-1;i>0;i--){
            if(arr[i]<arr[i-1]){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int n = 7;
        int[] arr = new int[] {4, 1, 3, 9, 7};
//        System.out.println(minJumps(arr,5 ));
        recurssiveInsertionSort(arr,5);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);



//        for(int i=0;i<n;i++){
//            for (int j=0;j<=i;j++){
//                if((i+j)%2==0){
//                    System.out.print(1);
//                }
//                else{
//                    System.out.print(0);
//                }
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                System.out.print(j+1);
//            }
//            for(int j=0;j<(2*n-2*(i+1));j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<=i;j++){
//                System.out.print(i-j+1);
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for (int j=0;j<=i;j++){
//                    System.out.print((char)(j+65));
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                System.out.print((char)(i+65));
//            }
//
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-(i+1);j++){
//                System.out.print(" ");
//            }
//            int range = (2*i+1);
//            int mid = (2*i+1)/2;
//            for(int j=0;j<range;j++){
//                int k=j;
//                if(j>mid) k=mid-(j-mid);
//
//                System.out.print((char)(k+65));
//            }
//            for(int j=0;j<n-(i+1);j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

//        for(int i=n-1;i>=0;i--){
//            for(int j=0;j<n-i;j++){
//                System.out.print((char)(i+j+65)+" ");
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=n-1;((n-1)-j)<=i;j--){
//                System.out.print((char)(j+65)+" ");
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n-i;j++){
//                System.out.print("*");
//            }
//            for(int j=0;j<2*i;j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<n-i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<=i;j++){
//                System.out.print("*");
//            }
//            for(int j=0;j<(2*n-2*(i+1));j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<=i;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        for(int i=0;i<2*n;i++){
//            int star=i+1;
//            int space=2*(n-(i+1));
//            if (i>=n){
//                star=2*n-(i+1);
//                space=2*(i-(n-1));
//            }
//            for(int j=0;j<star;j++){
//                System.out.print("*");
//            }
//            for(int j=0;j<space;j++){
//                System.out.print(" ");
//            }
//            for(int j=0;j<star;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(i==0 ||i==n-1 || j==0 || j==n-1)
//                    System.out.print("*");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }

//        int start = n;
//        for(int i=0;i<(2*n-1);i++){
//            for(int j=0;j<(2*n-1);j++){
//                int top = i;
//                int left = j;
//                int right = (2*n-2)-j;
//                int bottom = (2*n-2)-i;
//
//                System.out.print(n-Math.min(Math.min(top,bottom),Math.min(left,right))+" ");
//
//            }
//            System.out.println();
//        }

//        int num = 1234567;
//        int count =0;
//        while (num!=0){
//            count++;
//            num/=10;
//        }
//        System.out.println(count);

//        int num = 7;
//        int tempNum =num;
//        int count =0;
//        while (tempNum!=0){
//            int rem = tempNum%10;
//            if(rem!=0 && num%rem==0) count++;
//            tempNum/=10;
//        }
//        System.out.println(count);

//        int num = 1534236461;
//        int tempNum =num;
//        int reverseNumber =0;
//        while (tempNum!=0){
//            int rem = tempNum%10;
//            reverseNumber = reverseNumber*10 +rem;
//            tempNum/=10;
//        }
//        System.out.println(reverseNumber);


    }


}
