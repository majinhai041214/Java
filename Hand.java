package Rummy;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
    ArrayList<Card>a1=new ArrayList<>(6);
    public Hand(){

        for(int i=0;i<6;i++){
            Random random=new Random();
            int x=random.nextInt(3);
            int y=random.nextInt(12);
            a1.add(i,new Card(x,y));
        }
    }
    public Card getCard(int i){
        return a1.get(i);
    }
    public int getSize(){
        return a1.size();
    }

    public String toString(){
        ArrayList<String> a2=new ArrayList<>();
        for(int i=0;i<a1.size();i++){
            String str=String.format("[%d]"+a1.get(i),i);
            a2.add(str);
        }
        String.format(a1.toString());

        return a2.toString();
    }
    public ArrayList add(Card card){
        a1.add(card);
        return a1;
    }
    public ArrayList divide(Card card){
        a1.remove(card);
        return a1;
    }

    //若返回值为0，则代表不能组成一套有效的出牌，若返回值为得分，则代表这三张牌可以组成有效的出牌
    public static int effective(Card car1,Card car2,Card car3){
        boolean bool=false;
        int point=0;
        if(car1.getColer().equals(car2.getColer())&&car2.getColer().equals(car3.getColer())){
            bool=true;
        }else if(car1.getscore()==(car2.getscore())&&car2.getscore()==(car3.getscore())){
            bool=true;
        }
        if(bool){
            if(car1.getscore()-'2'>=0&&car1.getscore()-'9'<=0){
                point+=5;
            }
            if(car1.getscore()=='I'||car1.getscore()=='J'||car1.getscore()=='Q'||car1.getscore()=='K'| |car1.getscore()=='A'){
                point+=10;
            }
            if(car2.getscore()-'2'>=0&&car2.getscore()-'9'<=0){
                point+=5;
            }
            if(car2.getscore()=='I'||car2.getscore()=='J'||car2.getscore()=='Q'||car2.getscore()=='K'||car2.getscore()=='A'){
                point+=10;
            }
            if(car3.getscore()-'2'>=0&&car3.getscore()-'9'<=0){
                point+=5;
            }
            if(car3.getscore()=='I'||car3.getscore()=='J'||car3.getscore()=='Q'||car3.getscore()=='K'||car3.getscore()=='A'){
                point+=10;
            }
        }
        return point;
    }

    public ArrayList disCard(Card car1,Card car2,Card car3){
        if(effective(car1,car2,car3)!=0){
            a1.remove(car1);
            a1.remove(car2);
            a1.remove(car3);
        }
        return a1;
    }

    public static void main(String[] args){
        Hand hand=new Hand();
        Card[] card=new Card[3];
        int score=0;
        for(int i=0;i<6;i++){
            for(int j=i+1;j<6;j++){
                for(int k=j+1;k<6;k++){
                    card[0]=hand.getCard(i+1);
                    card[1]=hand.getCard(j+1);
                    card[2]=hand.getCard(k+1);
                    if(effective(card[0],card[1],card[2])>score){
                        score=effective(card[0],card[1],card[2]);
                    }
                }
            }
        }
//        System.out.println(hand);
//        System.out.println(score);
        System.out.println(hand);
    }
}
