package Teori.Tugas1;
/* 
 Tugas 2 : Membuat Program Terkait Array
 Kelas Struktur Data G

 Kelompok 8
 Inzazi Nurmujaini (202210370311246)
 Krisna Bimantoro (202210370311254)
 Rofiq SamanHudi (202210370311260)
*/

public class ArrayExample {

    public static void main(String[] args) {
      int[] input = { 24, 21, 47, 40, 42, 7, 5, 80, 120, 200 };
  
      bubbleSort(input);
  
      int max = input[0];
      for (int i = 0; i < input.length; i++) {
        if (input[i] > max) {
          max = input[i];
        }
      }
  
      int indexGroup = max / 10 + 1;
  
      int[][] groups = new int[indexGroup][indexGroup];
  
      int y = 0;
  
      for (int num : input) {
        int index = num / 10;
        groups[index][y] = num;
        y++;
      }
  
      for (int i = 0; i < groups.length; i++) {
        System.out.print("Array " + i + " : ");
        for (int j = 0; j < groups.length; j++) {
          if (groups[i][j] == 0) {
            continue;
          } else {
            System.out.print(groups[i][j] + ", ");
          }
        }
        System.out.println();
      }
    }
  
    public static void bubbleSort(int[] array) {
      int n = array.length;
      for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
          if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
          }
        }
      }
    }
  }
  