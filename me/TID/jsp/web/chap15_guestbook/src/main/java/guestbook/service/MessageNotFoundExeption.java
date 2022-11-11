package guestbook.service;

public class MessageNotFoundExeption extends ServiceException {
    public MessageNotFoundExeption(String message) {
        super(message);
    }
}
