import java.util.Iterator;
import java.util.List;
import java.util.Map;

import kr.ac.kaist.mms_client.*;

public class ServiceProvider {
	public static void main(String args[]) throws Exception{
		String myMRN;
		int port;
		myMRN = "urn:mrn:smart-navi:device:tm-server";
		port = 8902;
		
		MMSConfiguration.MMSURL="127.0.0.1:8088";
		MMSConfiguration.CMURL="127.0.0.1";
		
		MMSClientHandler ch = new MMSClientHandler(myMRN);
		ch.setMSP(port);
		ch.setReqCallBack(new MMSClientHandler.ReqCallBack() {
			
			//it is called when client receives a message
			@Override
			public String callbackMethod(Map<String,List<String>> header, String message) {
				try {
					Iterator<String> iter = header.keySet().iterator();
					while (iter.hasNext()){
						String key = iter.next();
						System.out.println(key+":"+header.get(key).toString());
					}
					System.out.println(message);
					//it only forwards messages to sc having urn:mrn:imo:imo-no:0100006
					String res = ch.sendPostMsg("urn:mrn:imo:imo-no:0100006", message);
					System.out.println(res);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return "OK";
			}
		});
	}
}
