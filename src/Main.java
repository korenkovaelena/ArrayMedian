import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] arr = inputArray(arrLength());
        double sum = sum(arr);
        averege(arr, sum);
        double[] sortedArr = sortArr(arr,  sum);
        median(sortedArr, sum);
    }

    public static double[] inputArray(int n){
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double[] arr = new double[n];
        System.out.println("Введите числа-элементы массива");
        for (int i=0; i<n; i++) {
            arr[i] = sc.nextDouble();
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int arrLength(){
        System.out.println("Введите число - размер массива");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }
    public static double sum(double[] arr){
        double sum = 0;
        for (int i=0; i<arr.length; i++)
            sum += arr[i];
        System.out.println("Сумма элементов = "+ sum);
        return sum;
    }
    public static double averege(double[] arr, double sum){
        double averege = sum/arr.length;
        System.out.println("Среднее арифметическое = "+ averege);
        return averege;
    }
    public static double[] median(double[] sortedArr, double sum){
        double middle = (double) sortedArr.length /2;
        double[] medianOne = new double[1];
        double[] medianTwo = new double[2];
        if (middle % 1  != 0) {
            medianOne[0] = sortedArr[(int) middle];
            System.out.println("Медиана = " + Arrays.toString(medianOne));
            return medianOne;
        }
        else {
            medianTwo[0] = sortedArr[(int) middle-1];
            medianTwo[1] = sortedArr[(int) middle];
            System.out.println("Медиана = " + Arrays.toString(medianTwo));
            return medianTwo;
        }

    }
    public static double[] sortArr(double[] arr, double sum){
        double[] sortedArr = new double[arr.length];
        boolean isSorted=false;
        for (int i=0; i< arr.length-1 && !isSorted; i++ )  {
            isSorted = true;
            for (int k=0; k+1< arr.length-i; k++) {
                if( arr[k] > arr[k+1])
                {
                    double tmp = arr[k];
                    arr[k] = arr[k+1];
                    arr[k+1] = tmp;
                    isSorted=false;
                }
            }
        }
        System.out.println("Отсортированный массив = "+ Arrays.toString(arr));
        return arr;
    }
}