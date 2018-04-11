package com.example.appl;

import java.util.logging.Logger;

import com.example.model.GuessGame;
import com.example.model.GuessGame.GuessResult;

/**
 * The object to coordinate the state of the Web Application and keep sitewide statistics.
 *
 * This class is an example of the Pure Fabrication principle.
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class GameCenter {
  private static final Logger LOG = Logger.getLogger(GameCenter.class.getName());

  //
  // Constants
  //

  // Output strings made public for unit test access
  public final static String NO_GAMES_MESSAGE = "No games have been played so far.";
  public final static String ONE_GAME_MESSAGE = "One game has been played so far.";
  public final static String GAMES_PLAYED_FORMAT = "There have been %d games played.";
  public final static String PERCENTAGE_WON_FORMAT = "Players have won %d%% of the games played.";

  //
  // Attributes
  //

  private int totalGames = 0;
  private int totalWins = 0;
  private GuessGame curr = null;

  //
  // Constructors
  //

  //
  // Public methods
  //

  /**
   * Create a new {@Linkplain GuessGame} game.
   *
   * @return
   *   A new {@link GuessGame}
   */
  public GuessGame getGame() {
      curr = new GuessGame();
    return curr;
  }

  /**
   * Collect sitewide statistics when a game is finished.
   */
  public void gameFinished() {
    // do some application-wide book-keeping
    synchronized (this) {  // protect the critical code
      totalGames++;
    }
      if (this.curr.isWon()){
          totalWins++;
      }
  }

  /**
   * Get a user message about the sitewide statistics.
   *
   * @return
   *   The message to the user about global game statistics.
   */
  public synchronized String getGameStatsMessage() {
    if (totalGames > 1) {
        double avgD = 100*((double)totalWins/(double)totalGames);
        int avgI;
        if (avgD%1 < .5) avgI = (int)avgD;
        else  avgI = (int)avgD+1;
        if (avgI == 0) return String.format(GAMES_PLAYED_FORMAT, totalGames)
                + "<br>" + String.format(PERCENTAGE_WON_FORMAT,avgI);

        else return String.format(GAMES_PLAYED_FORMAT, totalGames)
                + "<br>" + String.format(PERCENTAGE_WON_FORMAT,avgI);

    } else if (totalGames == 1) {
        if (totalWins==1) return ONE_GAME_MESSAGE
                + "<br>" + String.format(PERCENTAGE_WON_FORMAT,100);

        else return ONE_GAME_MESSAGE
                + "<br>" + String.format(PERCENTAGE_WON_FORMAT,0);

    } else {
      return NO_GAMES_MESSAGE;
    }
  }
}
