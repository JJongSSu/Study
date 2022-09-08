package chap8;

public interface Messenger {
	// 인터페이스는 abstract 안써도 됨
	void sendMsg(String phoneNumber, String msg);
	void receiveMsg();

}
