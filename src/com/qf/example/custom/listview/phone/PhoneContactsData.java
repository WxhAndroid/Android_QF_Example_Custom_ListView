package com.qf.example.custom.listview.phone;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import com.qf.example.custom.listview.activity.R;

/**
 * 手机通讯录数据
 * @author Administrator
 *
 */
public class PhoneContactsData {
	private Context context;
	
	public PhoneContactsData(Context context) {
		this.context = context;
	}
	
	/**
	 * 获取全部手机联系人信息
	 * @return
	 */
	public List<PhoneContacts> getPhoneContacts() {
		List<PhoneContacts> list = new ArrayList<PhoneContacts>();
		
		Cursor cursor = context.getContentResolver().query(Phone.CONTENT_URI, PhoneContacts.PHONES_PROJECTION, null, null, null);
		if (cursor != null) {
			while (cursor.moveToNext()) {
				PhoneContacts contacts = new PhoneContacts();
				contacts.setContactName(cursor.getString(PhoneContacts.PHONES_DISPLAY_NAME_INDEX));
				contacts.setContractId(cursor.getLong(PhoneContacts.PHONES_CONTACT_ID_INDEX));
				contacts.setPhoneNumber(cursor.getString(PhoneContacts.PHONES_NUMBER_INDEX));
				contacts.setPhotoId(cursor.getLong(PhoneContacts.PHONES_PHOTO_ID_INDEX));
				
				// PhotoId > 0 说明有头像
				if (contacts.getPhotoId() > 0) {
					Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contacts.getContractId());
					InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(context.getContentResolver(), uri);
					contacts.setContractPhoto(BitmapFactory.decodeStream(input));
				} else {
					contacts.setContractPhoto(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher));
				}
				
				list.add(contacts);
			}
			
			cursor.close();
		}
		
		return list;
	}
}
