package main.java;

public class Field{
    private char[] field;

    public Field(){
        field = new char[9];
    }

    public boolean setField(char marker, int pos) {
        if(pos<0 || pos>8){
            System.out.println("Неверное значение ячейки");
            return false;
        }
        if(field[pos]=='\u0000'){
            field[pos]=marker;
            return true;
        }
        System.out.println("В эту ячейку значение уже установленно");
        return false;
    }

    public char getField(int pos){
        return field[pos];
    }

    public void print(){
        for (int i = 0,k=1; i < 9 ; i++, k++) {
            if(field[i]!='\u0000'){
                System.out.print(field[i]);
            }
            else
                System.out.print('\u00B7');
            if(k%3==0){
                System.out.println();
            }
        }
        System.out.println();
    }
}