package hslee.java.test.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class TestBase64Encoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "wisol";
//		String strB64 = Base64.getDecoder().decode(str).toString();
		String str2=Base64.getEncoder().encodeToString(str.getBytes());
		System.out.println(str2+"\t");
		byte[] b=Base64.getDecoder().decode(str2);
		try {
			System.out.println(new String(b,"utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
