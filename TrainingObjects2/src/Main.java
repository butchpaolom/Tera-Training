public class Main {

    public static void main(String[] args) {
       UIControl[] controls = { new TextBox(), new CheckBox() };
       for (UIControl control : controls)
           control.render();
    }
}
