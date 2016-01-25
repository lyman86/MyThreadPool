import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public  class UrlResponse {
	/**
	 * 鑾峰彇鎸囧畾URL鐨勫搷搴斿瓧绗︿覆
	 * 
	 * @param urlString
	 * @return
	 */
	public String getURLResponse(String urlString) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		StringBuffer stringBuffer = new StringBuffer();
		try {
			
			URL url = new URL(urlString);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST"); 
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.connect();
		    	   is = conn.getInputStream();
		    	   InputStreamReader isr = new InputStreamReader(is,"utf-8");
					BufferedReader bufferReader = new BufferedReader(isr);
					String inputLine = "";
					while ((inputLine = bufferReader.readLine()) != null) {
						stringBuffer.append(inputLine);
					}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				conn.disconnect();
			}
		}

		return stringBuffer.toString();
	}

}
