package com.qf.example.custom.listview.adapter;

import java.util.List;
import java.util.Map;

import com.qf.example.custom.listview.common.CommonKey;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomListViewAdapter extends BaseAdapter {
	private Context context;
	private List<Map<String, Object>> data;
	
	public CustomListViewAdapter(Context context, List<Map<String, Object>> data) {
		this.context = context;
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout view = new LinearLayout(context);
		view.setOrientation(LinearLayout.VERTICAL);
		
		TextView txTitle = new TextView(context);
		txTitle.setText(String.valueOf(data.get(position).get(CommonKey.KEY_TITLE)));
		
		TextView txContent = new TextView(context);
		txContent.setTag(CommonKey.KEY_CONTENT + position);
		txContent.setVisibility(View.GONE);
		txContent.setText(String.valueOf(data.get(position).get(CommonKey.KEY_CONTENT)));
		
		view.addView(txTitle);
		view.addView(txContent);
		
		return view;
	}

}
