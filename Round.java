class Round {

  public final int score;

  public final int bonus;

  public final int consumed;

  public Round(Throw first, Throw second, Throw third) {
    assert null != first;

    int firstScore = getScoreOrZero(first);
    int secondScore = getScoreOrZero(second);
    int thirdScore = getScoreOrZero(third);

    if(first.isStrike) {

  score = first.score + secondScore + thirdScore;
      bonus = 2;
      consumed = 0;
    } else if(null != second && second.isSpare) {
      
  score = second.score + thirdScore;
      bonus = 1;
      consumed = 1;
  
    } else {
      score = firstScore + secondScore;
      bonus = 0;
      consumed = 1;
    }
  }

  private int getScoreOrZero(Throw theThrow) {
    return null == theThrow ? 0 : theThrow.score;
  }
}
