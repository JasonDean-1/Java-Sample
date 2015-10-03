package Net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class testURLDecoderEncoder
{
	public static void main(String[] args) throws Exception
	{
		String keyWord = URLDecoder.decode("%B6%A1%D6%BE%B3%C9", "GBK");
		System.out.println(keyWord);
		String urlStr = URLEncoder.encode("¶¡Ö¾³É","GBK");
		System.out.println(urlStr);
	}
}
