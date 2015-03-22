/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johannes
 */
public class StatisticsTest {
    
    Statistics stats;
    
    Reader readerStub = new Reader() {
        public List<Player> getPlayers(){
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));//99
            players.add(new Player("Kurri",   "EDM", 37, 53));//90
            players.add(new Player("Yzerman", "DET", 42, 56));//98
            players.add(new Player("Gretzky", "EDM", 35, 89));//vitusti
            
            return players;
        }
    };
    
    public StatisticsTest() {
        this.stats = new Statistics(readerStub);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearchReturnsCorrectPlayerIfValidName() {
        System.out.println("Search with valid name");
        String name = "Kurri";
        Player result = stats.search(name);
        assertEquals("Kurri", result.getName());
    }
    
    @Test
    public void testSearchReturnsNullIfInvalidName(){
        System.out.println("Search with invalid name");
        String name = "InvalidPlayerzzz";
        Player result = stats.search(name);
        assertEquals(null, result);
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        System.out.println("team");
        String teamName = "PIT";
        List<Player> expResult = readerStub.getPlayers().subList(1, 2);
        List<Player> result = stats.team("PIT");
        assertEquals(expResult.get(0).getName(), result.get(0).getName());
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        Player expResult = new Player("Gretzky", "EDM", 35, 89);
        Player result = stats.topScorers(0).get(0);
        assertEquals(expResult.getName(), result.getName());
    }
    
}
