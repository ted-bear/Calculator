package Calculator;

public class StateY extends State {
    boolean typing = false;
    @Override
    void clear(Context context) {
        context.state = new StateX();
        context.state.clear(context);
    }

    @Override
    void digit(Context context, char key) {
        if (!typing) {
            context.y = 0;
            typing = true;
        }
        context.y = context.y * 10 + Character.getNumericValue(key);
    }

    @Override
    void arifm(Context context, char key) { // 1+2+ ... 1+2=+
        equal(context); // =
        context.state.arifm(context, key); // +
    }

    @Override
    void equal(Context context) {
        context.state = new StateAnswer();
        context.state.equal(context);
    }
}
