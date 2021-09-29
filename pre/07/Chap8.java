import java.util.Arrays;

public class Chap8 {
  public static void main(String[] args) {
    double[] array = {2,3,4,5};
    int[] array2 ={55,10,2,43,100};
    int[] array3 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    int[] array4 = {32,4,5,2,2,4,5,5,7,8,9,7,6,4,3,3,6,7,4,25,43,3,6,56,64};

    powArray(array, 3);
    System.out.println(indexOfMax(array2));
    sieve(array3);
    System.out.println(Arrays.toString(histogram(array4, 4)));
  }

  //exercise 1
  public static void powArray(double[] a, int b) {
    for (int i = 0; i < a.length; i++) {
      a[i] = Math.pow(a[i], b);
    }
    System.out.println(Arrays.toString(a));
  }

  public static int[] histogram(int[] array,int numberOfGroups) {
    int[] groups = new int[numberOfGroups];
    int increment = 100/numberOfGroups;
    int low = 0;
    int high = increment;
    int i = 0;
    for (int value : array) {
      for (int group : groups) {
        if (low<=value && value<high) {
          groups[i]++;
        }
        low += increment;
        high += increment;
        i++;
      }
      low = 0;
      high = increment;
      i = 0;
    }
    return groups;
  }

  //exercise 4
  public static int indexOfMax(int[] array) {
    //You can not use a enhanced for loop because it will not allow you to find the index of a value.
    int max = 0;
    int maxIndex = 0;
    for (int i=0; i<array.length; i++) {
      if (array[i] > max) {
        max = array[i];
        maxIndex = i;
      }
    }
    return maxIndex;
  }

  //exercise 5
  public static void sieve(int[] array) {
    boolean[] array2 = new boolean[array.length];
    Arrays.fill(array2, true);
    for (int i=0; i<array.length; i++) {
      if (array2[i] == false ) {
        continue;
      } else if (array[i] % 2 == 0) {
        array2[i] = true;
        int Index2 = i;
        for (int j=Index2+2; j<array.length; j+= 2) {
          array2[j] = false;
        }
      } else if (array[i] % 3 == 0) {
        array2[i] = true;
        int Index3 = i;
        for (int j=Index3+3; j<array.length; j+= 3) {
          array2[j] = false;
        }
      } else if (array[i] % 5 == 0) {
        array2[i] = true;
        int Index5 = i;
        for (int j=Index5+5; j<array.length; j+= 5) {
          array2[j] = false;
        }
      } else if (array[i] % 7 == 0) {
        array2[i] = true;
        int Index7 = i;
        for (int j=Index7+7; j<array.length; j+= 7) {
          array2[j] = false;
        }
      }
    }
    System.out.println(Arrays.toString(array2));
  }
}
