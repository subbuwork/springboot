package springboot.jms.clt;

public interface JmsClient {
	public String getMessage();
	public void sendMessage(String message);
}
