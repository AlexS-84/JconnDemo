package ru.sergeysjob;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Успешное подключение, Друг!");
        }
        catch(Exception e){
            System.out.println("не прошло...");

            System.out.println(e);
        }
    }
}
