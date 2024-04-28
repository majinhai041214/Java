package Rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    static ArrayList<Card> a1=new ArrayList();
    private int i;
    public Deck(){}

    //初始化牌堆
    public ArrayList DeckInit(){

        int i,j;
        for(i=0;i<4;i++){
            for(j=0;j<13;j++){
                Card car=new Card(i,j);
                a1.add(car);
            }
        }
        Collections.shuffle(a1);
        return a1;
    }

    public Card divide(){
        Card car=new Card();
        car=a1.get(0);
        a1.remove(0);
        return a1.get(0);
    }

    public Card theFisrt(){
        return a1.get(0);
    }

    public ArrayList add(Card car){
        a1.add(car);
        return a1;
    }


    public static void main(String[] args){
        Deck de=new Deck();
        System.out.println(de.DeckInit());
//        int i=52;
//        for(i=0;i<50;i++){
//            System.out.println(a1.get(i));
//        }
    }
}
