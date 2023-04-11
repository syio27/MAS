package subset;

import utility.ObjectPlus4;

public class Chat extends ObjectPlus4 {
    private String chatName;
    private long chatId;

    public static final String isOwned = "is owned by";
    public static final String isAdmined = "is admined by";

    public Chat(String chatName, long chatId) {
        this.chatName = chatName;
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatName='" + chatName + '\'' +
                ", chatId=" + chatId +
                '}';
    }
}
