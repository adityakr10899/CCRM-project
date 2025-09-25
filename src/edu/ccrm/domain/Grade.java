package edu.ccrm.domain;
public enum Grade {
    S(10), A(9), B(8), C(7), D(6), E(5), F(0);
    private final int points;
    Grade(int p){ this.points = p; }
    public int getPoints(){ return points; }
    public static Grade fromScore(double score){
        if(score>=90) return S;
        if(score>=80) return A;
        if(score>=70) return B;
        if(score>=60) return C;
        if(score>=50) return D;
        if(score>=40) return E;
        return F;
    }
}
