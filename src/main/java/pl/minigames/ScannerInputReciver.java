package pl.minigames;

import java.util.Scanner;

 class ScannerInputReciver implements IInputReciver{
    private final Scanner scanner = new Scanner(System.in);

    private ScannerInputReciver() {
    }
    public static ScannerInputReciver getInstance() {
        return new ScannerInputReciver();
    }
    @Override
    public String getString(){
        return scanner.nextLine().toUpperCase();
    }
    @Override
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
