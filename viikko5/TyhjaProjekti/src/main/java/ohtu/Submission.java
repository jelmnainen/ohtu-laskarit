package ohtu;

import java.util.ArrayList;
import java.util.HashMap;

public class Submission {
    
    private int id;
    private String student_number;
    private int week;
    private int hours;
    private String comments;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;
    private String a11;
    private String a12;
    private String a13;
    private String a14;
    private String a15;
    private String a16;
    private String a17;
    private String a18;
    private String a19;
    private String a20;
    private String a21;
    private HashMap<Integer, Boolean> doneAssignments;
    private String createdAt;
    private String updatedAt;
    private int courseId;
    
    public Submission(){};

    @Override
    public String toString() {
        return  "Viikko " + this.week + ":\n" +
                //"Tehtyjä tehtäviä: " + getNumberOfDoneAssignments() + ",\n" +
                //"tehdyt tehtävät: " + getDoneAssignmentNumbersAsString()
                "";
                
    }
    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * @param week the week to set
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return the doneAssignments
     */
    public HashMap<Integer, Boolean> getDoneAssignments() {
        return doneAssignments;
    }

    /**
     * @param doneAssignments the doneAssignments to set
     */
    public void setDoneAssignments(HashMap<Integer, Boolean> doneAssignments) {
        this.doneAssignments = doneAssignments;
    }

    /**
     * @return the createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    private int getNumberOfDoneAssignments() {
        int done = 0;
        for(int key : this.doneAssignments.keySet()){
            if(this.doneAssignments.get(key) == true){
                done++;
            }
        }
        return done;
    }

    private ArrayList<Integer> getDoneAssignmentNumbers() {
        ArrayList<Integer> doneAssignments = new ArrayList();
        for(int key : this.doneAssignments.keySet()){
            if(this.doneAssignments.get(key) == true){
                doneAssignments.add(key);
            }
        }
        return doneAssignments;
        
    }

    private String getDoneAssignmentNumbersAsString() {
        ArrayList<Integer> doneAssignments = this.getDoneAssignmentNumbers();
        String res = "";
        
        for(int i : doneAssignments){
            res = i + ", ";
        }
        
        if(res.length() > 2){
            res = res.substring(0, res.length()-2);
        }
        
        return res;
        
    }

    /**
     * @return the a1
     */
    public String getA1() {
        return a1;
    }

    /**
     * @param a1 the a1 to set
     */
    public void setA1(String a1) {
        this.a1 = a1;
    }

    /**
     * @return the a2
     */
    public String getA2() {
        return a2;
    }

    /**
     * @param a2 the a2 to set
     */
    public void setA2(String a2) {
        this.a2 = a2;
    }

    /**
     * @return the a3
     */
    public String getA3() {
        return a3;
    }

    /**
     * @param a3 the a3 to set
     */
    public void setA3(String a3) {
        this.a3 = a3;
    }

    /**
     * @return the a4
     */
    public String getA4() {
        return a4;
    }

    /**
     * @param a4 the a4 to set
     */
    public void setA4(String a4) {
        this.a4 = a4;
    }

    /**
     * @return the a5
     */
    public String getA5() {
        return a5;
    }

    /**
     * @param a5 the a5 to set
     */
    public void setA5(String a5) {
        this.a5 = a5;
    }

    /**
     * @return the a6
     */
    public String getA6() {
        return a6;
    }

    /**
     * @param a6 the a6 to set
     */
    public void setA6(String a6) {
        this.a6 = a6;
    }

    /**
     * @return the a7
     */
    public String getA7() {
        return a7;
    }

    /**
     * @param a7 the a7 to set
     */
    public void setA7(String a7) {
        this.a7 = a7;
    }

    /**
     * @return the a8
     */
    public String getA8() {
        return a8;
    }

    /**
     * @param a8 the a8 to set
     */
    public void setA8(String a8) {
        this.a8 = a8;
    }

    /**
     * @return the a9
     */
    public String getA9() {
        return a9;
    }

    /**
     * @param a9 the a9 to set
     */
    public void setA9(String a9) {
        this.a9 = a9;
    }

    /**
     * @return the a10
     */
    public String getA10() {
        return a10;
    }

    /**
     * @param a10 the a10 to set
     */
    public void setA10(String a10) {
        this.a10 = a10;
    }

    /**
     * @return the a11
     */
    public String getA11() {
        return a11;
    }

    /**
     * @param a11 the a11 to set
     */
    public void setA11(String a11) {
        this.a11 = a11;
    }

    /**
     * @return the a12
     */
    public String getA12() {
        return a12;
    }

    /**
     * @param a12 the a12 to set
     */
    public void setA12(String a12) {
        this.a12 = a12;
    }

    /**
     * @return the a13
     */
    public String getA13() {
        return a13;
    }

    /**
     * @param a13 the a13 to set
     */
    public void setA13(String a13) {
        this.a13 = a13;
    }

    /**
     * @return the a14
     */
    public String getA14() {
        return a14;
    }

    /**
     * @param a14 the a14 to set
     */
    public void setA14(String a14) {
        this.a14 = a14;
    }

    /**
     * @return the a15
     */
    public String getA15() {
        return a15;
    }

    /**
     * @param a15 the a15 to set
     */
    public void setA15(String a15) {
        this.a15 = a15;
    }

    /**
     * @return the a16
     */
    public String getA16() {
        return a16;
    }

    /**
     * @param a16 the a16 to set
     */
    public void setA16(String a16) {
        this.a16 = a16;
    }

    /**
     * @return the a17
     */
    public String getA17() {
        return a17;
    }

    /**
     * @param a17 the a17 to set
     */
    public void setA17(String a17) {
        this.a17 = a17;
    }

    /**
     * @return the a18
     */
    public String getA18() {
        return a18;
    }

    /**
     * @param a18 the a18 to set
     */
    public void setA18(String a18) {
        this.a18 = a18;
    }

    /**
     * @return the a19
     */
    public String getA19() {
        return a19;
    }

    /**
     * @param a19 the a19 to set
     */
    public void setA19(String a19) {
        this.a19 = a19;
    }

    /**
     * @return the a20
     */
    public String getA20() {
        return a20;
    }

    /**
     * @param a20 the a20 to set
     */
    public void setA20(String a20) {
        this.a20 = a20;
    }

    /**
     * @return the a21
     */
    public String getA21() {
        return a21;
    }

    /**
     * @param a21 the a21 to set
     */
    public void setA21(String a21) {
        this.a21 = a21;
    }
    
}