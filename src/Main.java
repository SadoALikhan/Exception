import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {

    public static String simbols = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";

    public static void validation(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        char[] a = login.toCharArray();
        char[] b = password.toCharArray();
        for (char d : a) {
            if (!simbols.contains(String.valueOf(d)) || login.length() > 20) {
                throw new WrongLoginException();
            }
        }
        for (char d : b) {
            if (!simbols.contains(String.valueOf(d)) || password.length() > 20) {
                throw new WrongPasswordException();
            } else if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException();
            }
        }
    }

    public static void dataChecking(String login, String password, String confirmPassword) {
        try {
            validation(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Неверно введен логин.");
        } catch (WrongPasswordException e) {
            System.out.println("Неверно введен пароль.");
        }
    }
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        dataChecking("Ali_khan", "ali111_Khan_999", "ali111_Khan_999");
    }
}