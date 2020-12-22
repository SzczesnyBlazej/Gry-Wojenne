package classes;


public enum Ranks {
    Serial(1),
    Capral(2),
    Capitan(3),
    Major(4);


    private final int value;

    Ranks(int value) {
        this.value=value;
    }
    public int getValue(){
        return value;
    }

}
