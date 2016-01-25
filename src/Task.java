public class Task implements Runnable {
	private String data;
	private String StringData;


	public Task(String data) {
		this.data = data;
	}

	public void run() {
		UrlResponse urlResponse = new UrlResponse();
		StringData = urlResponse.getURLResponse(data);
		if (StringData!=null) {
			System.out.println("加载成功");
		}
		
	}

}