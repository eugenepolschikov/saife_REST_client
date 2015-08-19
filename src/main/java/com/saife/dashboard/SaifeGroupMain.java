package com.saife.dashboard;

import com.saife.dashboard.client.SaifeClientFactory;
import com.saife.dashboard.client.group.SaifeGroup;
import com.saife.dashboard.client.group.SaifeGroupClient;
import com.saife.dashboard.client.group.SaifeGroupList;

public class SaifeGroupMain {

	public static void main(String[] args) throws Exception {
		SaifeClientFactory factory = SaifeClientFactory.getInstance("6QHJH09ED82KPH0EEW9HSZ5DJ7MGRPFACBECEKE1SN9QKEA4F2A0");
		SaifeGroupClient client = factory.getGroupClient();
		SaifeGroupList list = client.list(null, null);
		System.out.println(list);
		for (SaifeGroup sg : list.getData()) {
			System.out.println(client.details(sg.getId()));
		}
	}
}
