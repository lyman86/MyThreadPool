import java.util.concurrent.Callable;

public class Task3 implements Callable<String> {
	private String data;
	public Task3(String data) {
		this.data = data;
	}

	public String call() throws Exception {
		
		UrlResponse urlResponse = new UrlResponse();
		System.out.println("333333");
		return urlResponse.getURLResponse(data);
	}

}