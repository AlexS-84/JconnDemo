package ru.sergeysjob;

import org.apache.log4j.Logger;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Успешное подключение, Друг!");
        }
        catch(Exception ex){
            //System.out.println("не прошло...");
            logger.info(ex);
            //System.out.println(ex);
        }
    }
}
