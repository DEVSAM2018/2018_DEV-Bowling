class Throw {

  public final static char MISS = '-';
  public final static char SPARE = '/';
  public final static char STRIKE = 'X';

  public final boolean isMiss;
  public final boolean isSpare;
  public final boolean isStrike;
  public final int score;

  public Throw(char result) {
    if(MISS == result) {
 
      isMiss = true;
      isSpare = false;
      isStrike = false;
      score = 0;
    } else if(SPARE == result) {
 
      isMiss = false;
      isSpare = true;
      isStrike = false;
      score = 10;
    } else if(STRIKE == result) {
 
      isMiss = false;
      isSpare = false;
      isStrike = true;
      score = 10;
    } else {
 
      isMiss = false;
      isSpare = false;
      isStrike = false;
      score = Character.getNumericValue(result);
    }
  }
}
