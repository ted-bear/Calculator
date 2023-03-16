package Calculator;

public class StateAction extends State{
    @Override
    void clear(Context context) {
        context.state = new StateX();
        context.state.clear(context);
    }

    @Override
    void digit(Context context, char key) {
        context.state = new StateY();
        context.state.digit(context, key);
    }

    @Override
    void arifm(Context context, char key) {
        context.o = key;
    }

    @Override
    void equal(Context context) {
        context.y = context.x;
        context.state = new StateAnswer();
        context.state.equal(context);
    }
}
