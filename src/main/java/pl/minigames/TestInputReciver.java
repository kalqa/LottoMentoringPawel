package pl.minigames;

class TestInputReciver implements IInputReciver{
    private String s;
    private Integer i;
    public Integer getInt(Integer integer) {
        return integer;
    }

    @Override
    public Integer getInt() {
        return i;
    }

    public TestInputReciver() {
    }

    @Override
    public String getString() {
        return s;
    }
    public String setString(String s) {
        return this.s=s;
    }

    public void setI(Integer i) {
        this.i = i;
    }
}
