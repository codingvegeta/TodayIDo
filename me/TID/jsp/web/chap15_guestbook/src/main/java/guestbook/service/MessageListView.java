package guestbook.service;

import guestbook.model.Message;

import java.util.List;

public class MessageListView {

    private int messageTotalCount;
    private int currentPageNumber;
    private List<Message> messageList;
    private int pageTotalCount;
    private int messageCountPerPage;
    private int firstRow;
    private int endRow;

    public MessageListView(int messageTotalCount, int currentPageNumber, List<Message> messageList,
                           int messageCountPerPage, int startRow, int endRow) {
        this.messageList = messageList;
        this.messageTotalCount = messageTotalCount;
        this.currentPageNumber = currentPageNumber;
        this.messageCountPerPage = messageCountPerPage;
        this.firstRow = startRow;
        this.endRow = endRow;

        calculatePageTotalCount();
    }

    private void calculatePageTotalCount() { //전체 페이지의 갯수를 구하는 메서드
        if (messageTotalCount == 0) {
            pageTotalCount = 0;
        } else {
            pageTotalCount = messageTotalCount / messageCountPerPage;
            if (messageTotalCount % messageCountPerPage > 0) {
                pageTotalCount++;
            }
        }
    }

    public int getMessageTotalCount() {
        return messageTotalCount;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public int getPageTotalCount() {
        return pageTotalCount;
    }

    public int getMessageCountPerPage() {
        return messageCountPerPage;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public boolean isEmpty() {
        return messageTotalCount == 0;
    }
}
