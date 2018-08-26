package main.java;

import java.util.Random;
import java.util.Scanner;

public class GameLogic{
    private static Random random =new Random(47);
    private Field field =new Field();

    public void start() {
        GameStatus gameStatus = GameStatus.CONTINUE;
        for (int i = 0; i < 9; i++) {
            if(i%2==0){
                humanStep();
                if(checkWinner()){
                    gameStatus=GameStatus.WIN_USER;
                    break;
                }
            }
            else{
                computerStep();
                if(checkWinner()){
                    gameStatus=GameStatus.WIN_PC;
                    break;
                }
            }
            field.print();
            if(i==8 && gameStatus==GameStatus.CONTINUE){
                gameStatus=GameStatus.DRAW;
            }

        }
        showResult(gameStatus);
    }
    private int humanStep(){
        boolean checkStep;
        int pos;
        do{
            Scanner sc =new Scanner(System.in);
            System.out.println("Введите номер ячейки");
            pos = sc.nextInt();
            checkStep = field.setField('X', pos);
        }
        while (!checkStep);
        return pos;
    }

    private int computerStep(){
        boolean checkStep;
        int pos;
        do{
            pos =random.nextInt(9);
            checkStep = field.setField('O', pos);
        }
        while (!checkStep);
        return pos;
    }

    private void showResult(GameStatus gameStatus){
        switch (gameStatus){
            case DRAW:
                System.out.println("Ничья");
                break;
            case WIN_PC:
                System.out.println("Победил компьютер");
                break;
            case WIN_USER:
                System.out.println("Победил человек");
                break;
        }
    }
    private boolean  checkWinner(){
                        char f0 =field.getField(0);
                        char f1 =field.getField(1);
                        char f2 =field.getField(2);
                        char f3 =field.getField(3);
                        char f4 =field.getField(4);
                        char f5 =field.getField(5);
                        char f6 =field.getField(6);
                        char f7 =field.getField(7);
                        char f8 =field.getField(8);

                        if(((f0== 'X' || f0 == 'O') &&  f0 == f1 && f0 == f2 )
                        || ((f0== 'X' || f0 == 'O') &&  f0 == f4 && f0 == f8 )
                        || ((f0== 'X' || f0 == 'O') &&  f0 == f3 && f0 == f6 )
                        || ((f1== 'X' || f1 == 'O') &&  f1 == f4 && f0 == f7 )
                        || ((f2== 'X' || f2 == 'O') &&  f2 == f5 && f2 == f8 )
                        || ((f3== 'X' || f3 == 'O') &&  f3 == f4 && f3 == f5 )
                        || ((f6== 'X' || f6 == 'O') &&  f6 == f7 && f6 == f8 )
                        || ((f6== 'X' || f6 == 'O') &&  f6 == f4 && f6 == f2 )
                        ) {
            return true;
            } else {
            return false;
            }
    }
}

