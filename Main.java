public class Main {

  public static void main(String[] args) {

   if(null == args || 1 > args.length || "".equals(args[0])) {
     
      System.out.println("throws is a sequence of characters in this format:");
      System.out.println("'X' To indicates a strike");
      System.out.println("'/' To indicates a spare");
      System.out.println("'-' To indicates a miss");
      System.out.println("Or '1'-'9' to indicate number of knocked down pins.");
      System.exit(1);
    }

    char[] theThrows = args[0].toCharArray();

    int throwsCount = theThrows.length;

    Throw[] throwsList = new Throw[2 + theThrows.length];

    int throwPos = -1;
    while(throwsCount > ++throwPos) {
      throwsList[throwPos] = new Throw(theThrows[throwPos]);
    }

    throwsList[throwPos++] = null;
    throwsList[throwPos++] = null;

    notify("\nAnalyzing %d throw(s):\n", throwsCount);

    int totalScore = 0, roundCount = 0;

    Round theRound;

    throwPos = 0;

    do {
      roundCount++;
      Throw first = throwsList[throwPos];
      Throw second = throwsList[1 + throwPos];
      Throw third = throwsList[2 + throwPos];

      theRound = new Round(first, second, third);

      totalScore += theRound.score;

      throwPos += theRound.consumed;

      notify(
        "[Round #%d]\tScore: %d\tBonus: %d",
        roundCount, theRound.score, theRound.bonus
      );
    } while(throwsCount - theRound.bonus > ++throwPos);

    notify("\n%d round(s) score: %d\n", roundCount, totalScore);
  }


  private static void notify(String format, Object... args) {
    System.out.format(format + "\n", args);
  }
}
