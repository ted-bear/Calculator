package Calculator;

public class Context {
    int x;
    int y;
    char o;
    State state;

    public Context() {
        state = new StateX();
        state.clear(this);
    }

    public void press(char key) {
        switch (key) {
            case 'c', 'C' -> state.clear(this);
            case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> state.digit(this, key);
            case '+', '-', '/', '*' -> state.arifm(this, key);
            case '=' -> state.equal(this);
        }
    }

    public int run(String keys) { // "C2+3="
        for(char key : keys.toCharArray()) {
            press(key);
        }
        return x;
    }

    @Override
    public String toString() {
        return "x = " + x +
                "; y = " + y +
                "; operation = "+ o +
                "; state = " + state.getClass().getName();
    }
}
