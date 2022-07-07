package pl.minigames;

import java.util.Scanner;

 class InputReciver {
    private final Scanner scanner = new Scanner(System.in);

    private InputReciver() {
    }
    public static InputReciver getInstance() {
        return new InputReciver();
    }
    public String getString(){
        return scanner.nextLine();
    }
    public Integer getInt(){
        int a = -1;
        try{
            if(scanner.hasNextInt()) a=scanner.nextInt();
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Not a number!!, number please!!");
        }
        return a;
    }
}
