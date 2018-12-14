public class PicTranspose {

  public static void main(String[] args) {
    int [][] photoMat =
        {
            {3,4,7},
            {7,3,0},
            {9,2,4}
        };

    int a = 3;

    int [][] tped = new int[a][a];
    for(int i=0; i<a; i++) {
      for(int j=0; j<a; j++) {
        tped[j][a-i-1] = photoMat[i][j];
        printPhotoMat(tped, a);
      }
    }
  }

  public static void printPhotoMat(int[][] arr, int a) {
    System.out.println("---------------");
    for(int i=0; i<a; i++) {
      for(int j=0; j<a; j++) {
        System.out.print(arr[i][j] + " ");
      }

      System.out.println(" ");
    }
  }
}
