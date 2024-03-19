public class Main {
    public static void main(String[] args) {

        boolean play;

        PersonManager personManager = new PersonManager();
        Init.init(personManager);

        UI ui = new UI(personManager);

        do {
            play = ui.evaluateMainMenuInput();
        } while (play);
    }
}
