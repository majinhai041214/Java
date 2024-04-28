package Rummy;

public class Card {
    private static String color[]={"\033[30m♠\033[0m","\033[31m♥\033[0m","\033[31m♦\033[0m","\033[30m♣\033[0m"};
    private static char score[]={'A','2','3','4','5','6','7','8','9','I','J','Q','K'};
    private String col;
    private char sco;
    public Card(){}
    public Card(int i,int j){
        this.col=color[i];
        this.sco=score[j];
    }
    public String getColer(){
        return this.col;
    }
    public char getscore(){
        return this.sco;
    }

    public String toString(){
        return String.format(this.col+this.sco);
    }

    public static void main(String[] args){
        Card car=new Card(2,0);
        System.out.println(car);
    }
}
