import java.util.HashMap;
import java.util.Map;
import kr.ac.kaist.mms_client.MMSClientHandler;
import kr.ac.kaist.mms_client.MMSConfiguration;

/* -------------------------------------------------------- */
/** 
File name : SC2.java
	Service Consumer which can only send messages
Author : Jaehyun Park (jae519@kaist.ac.kr)
	Haeun Kim (hukim@kaist.ac.kr)
	Jaehee Ha (jaehee.ha@kaist.ac.kr)
Creation Date : 2016-12-03

Version : 0.3.01
Rev. history : 2017-02-01 - Second Issue
Modifier : Jaehee Ha (jaehee.ha@kaist.ac.kr)

Version : 0.5.0
Rev. history : 2017-04-20
	Deprecated SC2
Modifier : Jaehee Ha (jaehee.ha@kaist.ac.kr)
*/
/* -------------------------------------------------------- */
@Deprecated
public class SC2 {
	public static void main(String args[]) throws Exception{
		String myMRN = "urn:mrn:imo:imo-no:1000002";
		//myMRN = args[0];

		MMSConfiguration.MMS_URL="127.0.0.1:8088";

		//Service Consumer which can only send message
		MMSClientHandler ch = new MMSClientHandler(myMRN);
		Map<String, String> headerfield = new HashMap<String, String>();
		headerfield.put("AccessToken", "1234567890");
		ch.setMsgHeader(headerfield);
		
		
		for (int i = 0; i < 10;i++){
			String a = ch.sendPostMsg("urn:mrn:smart-navi:device:tm-server", "/forwarding", "�ȳ� hi hello " + i);
			//Thread.sleep(100);
		}

		/*
		for (int i = 0; i < 10;i++){
			String a = ch.sendPostMsg("urn:mrn:imo:imo-no:1000005", "�ȳ� hi hello " + i);
			//Thread.sleep(100);
		}*/
	}
}
