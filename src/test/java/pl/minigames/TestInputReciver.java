package pl.minigames;

public class TestInputReciver implements InputReceivable {
    private String s;
    private Integer i;
    private String[] StringsToType;
    private int indexStringToType = 0;
    private int[] intsToType;
    private int indexIntsToType = 0;

    public Integer getInt(Integer integer) {
        return integer;
    }

    public TestInputReciver(String[] commands, int[] lottoNumbersToType) {
        this.intsToType = lottoNumbersToType;
        this.StringsToType = commands;

    }

    @Override
    public Integer receiveNumberFromUser() {
        return intsToType[indexIntsToType++];
    }


    @Override
    public String receiveSignFromUser() {
//        String toReturn = StringsToType[indexStringToType];
//        indexStringToType = indexStringToType++;
        return StringsToType[indexStringToType++];
    }

    public void setStringsToType(String[] stringsToType) {
        StringsToType = stringsToType;
    }

    public void setIntsToType(int[] intsToType) {
        this.intsToType = intsToType;
    }

    public void setStringToType(String[] s) {

    }

    public void setI(Integer i) {
        this.i = i;
    }
}
