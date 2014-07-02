package com.qf.example.custom.listview.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class SystemUtil {
	public static void callPhone(Context context, String phone) {
		Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + phone));
		context.startActivity(intent);
	}
}
