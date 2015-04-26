package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
          
        Matcher m = new And( new HasAtLeast(10, "goals"),
                             new HasAtLeast(10, "assists"),
                             new PlaysIn("PHI")
        );
        
        Matcher c = new Or( new PlaysIn("COL"),
                            new PlaysIn("PHI"));
        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
        
        for (Player player : stats.matches(c)){
            System.out.println(player);
        }
    }
}
