package com.qf.example.custom.listview.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.qf.example.custom.listview.adapter.CustomListViewAdapter;
import com.qf.example.custom.listview.common.CommonKey;
import com.qf.example.custom.listview.phone.PhoneContacts;
import com.qf.example.custom.listview.phone.PhoneContactsData;
import com.qf.example.custom.listview.util.SystemUtil;

public class MainActivity extends Activity {
	private ListView lvCustom;
	
	private TextView txContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initUI();
	}

	private void initUI() {
		lvCustom = (ListView) findViewById(R.id.lvCustom);
		initLvCustomData();
	}
	
	private void initLvCustomData() {
		PhoneContactsData data = new PhoneContactsData(this);
		List<PhoneContacts> list = data.getPhoneContacts();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		if (list.size() > 0) {
			for (int i = 0 ; i < list.size() ; i++) {
				PhoneContacts contacts = list.get(i);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put(CommonKey.KEY_TITLE, contacts.getContactName());
				map.put(CommonKey.KEY_CONTENT, contacts.getPhoneNumber());
				mapList.add(map);
			}
			
			CustomListViewAdapter adapter = new CustomListViewAdapter(this, mapList);
			lvCustom.setAdapter(adapter);
			lvCustom.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					txContent = (TextView) lvCustom.findViewWithTag(CommonKey.KEY_CONTENT + position);
					if (txContent.getVisibility() == View.GONE) {
						txContent.setVisibility(View.VISIBLE);
					} else {
						txContent.setVisibility(View.GONE);
					}
					txContent.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View v) {
							SystemUtil.callPhone(MainActivity.this, txContent.getText().toString());
						}
					});
				}
			});
		}
	}

}
