import java.util.concurrent.Callable;

public class Task2 implements Callable<String> {
	private String data;
	public Task2(String data) {
		this.data = data;
	}

	public String call() throws Exception {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("22222");
		UrlResponse urlResponse = new UrlResponse();
		return urlResponse.getURLResponse(data);
	}

}