public class RandomizeArray {

  public static void main(String[] args) {
    String[] playlist =
        new String[] {
          "song-1", "song-2", "song-3", "song-4", "song-5", "song-6", "song-7", "song-8"
        };

    int currLast = playlist.length - 1;
    for (int i = 0; i < 20; i++) {
      int random = (int) (Math.random() * (currLast - 1));
      System.out.println("playing:::: " + playlist[random]);
      swap(random, currLast--, playlist);
      if (currLast < 0) currLast = playlist.length - 1;
    }
  }

  private static void swap(int first, int second, String[] playlist) {
    String tmp = playlist[second];
    playlist[second] = playlist[first];
    playlist[first] = tmp;
  }
}
