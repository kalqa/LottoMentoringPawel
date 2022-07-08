package pl.minigames;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {
    @BeforeEach
    void setUp(){
        UserInterface UI = new UserInterface(new TestInputReciver());
    }
    @Test
    void winTextingConditions(){

    }

}