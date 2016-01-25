import java.util.concurrent.Callable;

public class Task4 implements Callable<String> {
	private String data;
	public Task4(String data) {
		this.data = data;
	}

	public String call() throws Exception {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		UrlResponse urlResponse = new UrlResponse();
		System.out.println("4444444");
		return urlResponse.getURLResponse(data);
	}

}