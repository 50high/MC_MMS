import java.util.List;
import java.util.Map;

import kr.ac.kaist.mms_client.MMSClientHandler;
import kr.ac.kaist.mms_client.MMSConfiguration;

/* -------------------------------------------------------- */
/** 
File name : SC_GEO2.java
	Service Consumer which uses the georeporter function. 
Author : Jaehyun Park (jae519@kaist.ac.kr)
Creation Date : 2017-06-27
*/
/* -------------------------------------------------------- */

public class SC_GEO2 {
	public static void main(String args[]) throws Exception{
		String myMRN = "urn:mrn:imo:imo-no:1000112";
		//myMRN = args[0];
		

		MMSConfiguration.MMS_URL="127.0.0.1:8088";
		
		//Service Consumer cannot be HTTP server and should poll from MMS. 
		MMSClientHandler polling = new MMSClientHandler(myMRN);
		
		int pollInterval = 1000;
		String dstMRN = "urn:mrn:smart-navi:device:mms1";
		String svcMRN = "urn:mrn:smart-navi:device:geo-server";
		polling.startPolling(dstMRN, svcMRN, pollInterval, new MMSClientHandler.PollingResponseCallback() {
			//Response Callback from the polling message
			//it is called when client receives a message
			@Override
			public void callbackMethod(Map<String, List<String>> headerField, String message) {
				// TODO Auto-generated method stub
				System.out.print(message);
			}
		});
		MMSConfiguration.lat = (float)2.0;
		MMSConfiguration.lon = (float)2.0;
		int geoInterval = 1000;
		polling.startGeoReporting(svcMRN, geoInterval);
	}
}