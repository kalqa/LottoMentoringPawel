package pl.minigames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    UserInterface userInterface;
    @BeforeEach
    void setUp(){
        String[] array = new String[]{"1","LOTTO","1","1"};
        int[] ints = new int[]{1,2,3,4,5,6};
        this.userInterface = new UserInterface(new TestInputReciver(array,ints));
    }
    @Test
    void winTextingConditions(){
        String result = userInterface.start();
        Assertions.assertEquals("500",result);
    }

}