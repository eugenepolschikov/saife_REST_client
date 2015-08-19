package com.saife.dashboard;

import com.saife.dashboard.client.SaifeClientFactory;
import com.saife.dashboard.client.endpoint.SaifeEndpoint;
import com.saife.dashboard.client.endpoint.SaifeEndpointClient;
import com.saife.dashboard.client.endpoint.SaifeEndpointList;

public class SaifeEndpointMain {

	public static void main(String[] args) throws Exception {
		SaifeClientFactory factory = SaifeClientFactory.getInstance("6QHJH09ED82KPH0EEW9HSZ5DJ7MGRPFACBECEKE1SN9QKEA4F2A0");
		SaifeEndpointClient client = factory.getEndpointClient();
		SaifeEndpointList list = client.list(null, null);
		System.out.println(list);
		for (SaifeEndpoint se : list.getData()) {
			System.out.println(client.retrieve(se.getId()));
		}
	}
}
