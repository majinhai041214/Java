package Rummy;

import java.util.Scanner;

public class Game {
    public Deck deck;
    public Player player1;
    public Player player2;
    public Game() {
        Deck deck = new Deck();
        deck.DeckInit();
        Scanner sc = new Scanner(System.in);
        System.out.println("玩家1，怎么称呼你？");
        String name1 = sc.next();
        System.out.println("玩家2，怎么称呼你？");
        String name2 = sc.next();
        this.player1 = new Player(name1);
        int score1 = 0;
        this.player2 = new Player(name2);
        int score2 = 0;
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        while (true) {
            System.out.println(name1 + "这是给你发的起手6张手牌外加一张从牌堆上抽的新牌：");
            hand1.add(deck.theFisrt());
            deck.divide();
            System.out.println(hand1);
            Card[] card = new Card[3];
            int score = 0;
            for (int i = 0; i < hand1.getSize() ; i++) {
                for (int j = i + 1; j < hand1.getSize() ; j++) {
                    for (int k = j + 1; k < hand1.getSize() ; k++) {
                        card[0] = hand1.getCard(i );
                        card[1] = hand1.getCard(j );
                        card[2] = hand1.getCard(k );
                        if (Hand.effective(card[0], card[1], card[2]) > score) {
                            score = Hand.effective(card[0], card[1], card[2]);
                        }
                    }
                }
            }
            if (score != 0) {
            System.out.println(score);
                System.out.println("你决定出一套同花色或同值的三张牌吗？(y/n)");

                if (sc.next().equals("y")) {
                    System.out.println("请给出你决定要出的三张牌的序号");
                    Card car1 = new Card();
                    Card car2 = new Card();
                    Card car3 = new Card();
                    car1 = hand1.getCard(sc.nextInt());
                    car2 = hand1.getCard(sc.nextInt());
                    car3 = hand1.getCard(sc.nextInt());
                    score1 += Hand.effective(car1, car2, car3);
                    System.out.printf("厉害啊！你现在得到了%d分", score1);
                    hand1.disCard(car1, car2, car3);
                }

                System.out.printf("\n");
                System.out.println("你现在手里的牌有：" + hand1);
            }
            System.out.printf("\n");
            System.out.printf("你想把那张牌放回到牌堆中（0-%d）？请给出牌的序号：", hand1.getSize() - 1);
            Card car4 = new Card();
            car4 = hand1.getCard(sc.nextInt());
            hand1.divide(car4);
            System.out.println(name1+"你剩余的牌是："+hand1);


            System.out.printf("\n");
            System.out.println(name2 + "这是给你发的起手6张手牌外加一张从牌堆上抽的新牌：");
            hand2.add(deck.theFisrt());
            deck.divide();
            System.out.println(hand2);
            Card[] card2 = new Card[3];
            int scor = 0;
            for (int i = 0; i < hand2.getSize() ; i++) {
                for (int j = i + 1; j < hand2.getSize() ; j++) {
                    for (int k = j + 1; k < hand2.getSize();k++){
                        card2[0] = hand2.getCard(i );
                        card2[1] = hand2.getCard(j);
                        card2[2] = hand2.getCard(k);
                        if (Hand.effective(card2[0], card2[1], card2[2]) > scor) {
                            scor = Hand.effective(card2[0], card2[1], card2[2]);
                        }
                    }
                }
            }

            System.out.println(scor);
            if (scor != 0) {
            System.out.println(scor);
                System.out.println("你决定出一套同花色或同值的三张牌吗？(y/n)");

                if (sc.next().equals("y")) {
                    System.out.println("请给出你决定要出的三张牌的序号");
                    Card car1 = new Card();
                    Card car2 = new Card();
                    Card car3 = new Card();
                    car1 = hand2.getCard(sc.nextInt());
                    car2 = hand2.getCard(sc.nextInt());
                    car3 = hand2.getCard(sc.nextInt());
                    score2 += Hand.effective(car1, car2, car3);
                    System.out.printf("厉害啊！你现在得到了%d分", score2);
                    hand2.disCard(car1, car2, car3);
                }

                    System.out.printf("\n");
                    System.out.println("你现在手里的牌有：" + hand2);
            }
                System.out.printf("\n");
                System.out.printf("你想把那张牌放回到牌堆中（0-%d）？请给出牌的序号：", hand2.getSize() - 1);
                Card car5 = new Card();
                car5 = hand2.getCard(sc.nextInt());
                hand2.divide(car5);
                System.out.println(name2+"你剩余的牌是："+hand2);


                if (hand1.getSize() == 0) {
                    System.out.print(name1 + "已经没有牌可用了,游戏结束");
                    break;
                } else if (hand2.getSize() == 0) {
                    System.out.println(name2 + "已经没有牌可用了，游戏结束");
                    break;
                }
//            }
        }
        System.out.printf("\n");
        System.out.printf(name1 + "目前得分是" + score1);
        System.out.printf("\n");
        System.out.printf(name2 + "目前得分是" + score2);
            if (score1 > score2) {
                System.out.printf("\n");
                System.out.printf("祝贺" + name1 + "，你赢了");
            } else if (score2 > score1) {
                System.out.printf("\n");
                System.out.printf("祝贺" + name2 + "，你赢了");
            }

    }

    public static  void main(String[] args){
        Game game=new Game();
    }
}
