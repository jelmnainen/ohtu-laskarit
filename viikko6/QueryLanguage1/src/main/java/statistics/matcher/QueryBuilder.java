/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author johannes
 */
public class QueryBuilder {
    
    Matcher matcher;

    public QueryBuilder(){
        this.matcher = new And();
    }
    
    public QueryBuilder HasAtLeast(int value, String category){
        this.matcher = new And(this.matcher, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder PlaysIn(String team){
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }
    
    public Matcher build(){
        return this.matcher;
    }
    
    public QueryBuilder oneOf(Matcher... matchers){
        this.matcher = new Or(matchers);
        return this;
    }
    
}
