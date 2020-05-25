public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message) {
        super("Данные некорректны " + message);
    }
}
