package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        QueryBuilder query = new QueryBuilder();
        
        
        Matcher a = query.oneOf(query.PlaysIn("PHI").build(), query.PlaysIn("CAL").build()).build();

        for (Player player : stats.matches(a)){
            System.out.println(player   );
        }
    }
}
