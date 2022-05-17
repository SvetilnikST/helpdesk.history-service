package innowise.zuevsky.helpdesk.historyservice.exception;

public class HistoryNotFoundException extends RuntimeException{

    public static final String MESSAGE = "History doesn't exist! historyId:%s";

    public HistoryNotFoundException(long historyId){
        super(String.format(MESSAGE, historyId));
    }

}
