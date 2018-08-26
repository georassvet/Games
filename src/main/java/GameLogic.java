package main.java;

import java.util.Random;
import java.util.Scanner;

public class GameLogic{
    private static Random random =new Random(47);
    private Field field =new Field();

    public void start() {
        int lastPos;
        GameStatus gameStatus = GameStatus.CONTINUE;
        for (int i = 0; i < 9; i++) {
            if(i%2==0){
                lastPos = humanStep();
                if(checkWinner(lastPos)){
                    gameStatus=GameStatus.WIN_USER;
                    break;
                }
            }
            else{
                lastPos=computerStep();
                if(checkWinner(lastPos)){
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
            case WIN_PC:
                System.out.println("Победил компьютер");
            case WIN_USER:
                System.out.println("Победил человек");
        }
    }


    private boolean  checkWinner(int lastPos){
        switch (lastPos){
            case 0: {
                if((field.getField(0)==field.getField(1)&&field.getField(0)==field.getField(2)) ||
                        (field.getField(0)==field.getField(4)&&field.getField(0)==field.getField(8)) ||
                        (field.getField(0)==field.getField(1)&&field.getField(0)==field.getField(2))){
                    return true;
                }
                else return false;
            }
            case 1:{
                if((field.getField(1)==field.getField(0)&&field.getField(1)==field.getField(2)) ||
                        (field.getField(1)==field.getField(4)&&field.getField(1)==field.getField(7))){
                    return true;
                }
                else return false;
            }
            case 2:{
                if((field.getField(2)==field.getField(1)&&field.getField(2)==field.getField(0)) ||
                        (field.getField(2)==field.getField(4)&&field.getField(2)==field.getField(6)) ||
                        (field.getField(2)==field.getField(5)&&field.getField(2)==field.getField(8))){
                    return true;
                }
                else return false;
            }
            case 3:{
                if((field.getField(3)==field.getField(0)&&field.getField(3)==field.getField(6)) ||
                        (field.getField(3)==field.getField(4)&&field.getField(3)==field.getField(5))){
                    return true;
                }
                else return false;
            }
            case 4:{
                if((field.getField(4)==field.getField(0)&&field.getField(0)==field.getField(8)) ||
                        (field.getField(4)==field.getField(2)&&field.getField(4)==field.getField(6)) ||
                        (field.getField(4)==field.getField(1)&&field.getField(4)==field.getField(7)) ||
                        ((field.getField(4)==field.getField(3)&&field.getField(4)==field.getField(5)))){
                    return true;
                }
                else return false;
            }
            case 5:{
                if((field.getField(5)==field.getField(2)&&field.getField(5)==field.getField(8)) ||
                        (field.getField(5)==field.getField(4)&&field.getField(5)==field.getField(3))){
                    return true;
                }
                else {
                    return false;
                }
            }
            case 6:{
                if((field.getField(6)==field.getField(3)&&field.getField(6)==field.getField(0)) ||
                        (field.getField(6)==field.getField(4)&&field.getField(6)==field.getField(2)) ||
                        (field.getField(6)==field.getField(7)&&field.getField(6)==field.getField(8))){
                    return true;
                }
                else return false;
            }
            case 7:{
                if((field.getField(7)==field.getField(6)&&field.getField(7)==field.getField(8)) ||
                        (field.getField(7)==field.getField(4)&&field.getField(7)==field.getField(1))){
                    return true;
                }
                else return false;
            }
            case 8:{
                if((field.getField(8)==field.getField(4)&&field.getField(8)==field.getField(0)) ||
                        (field.getField(8)==field.getField(5)&&field.getField(8)==field.getField(2)) ||
                        (field.getField(8)==field.getField(7)&&field.getField(8)==field.getField(6))){
                    return true;
                }
                else return false;
            }
        }
        return  false;
    }

}