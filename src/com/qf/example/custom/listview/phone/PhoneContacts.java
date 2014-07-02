package com.qf.example.custom.listview.phone;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;

/**
 * 手机通讯录
 * 
 * @author Administrator
 * 
 */
public class PhoneContacts implements Serializable {
	private static final long serialVersionUID = 5020399480635146473L;

	/**
	 * 获取库Phone表字段
	 */
	public static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };

	/**
	 * 联系人名称索引
	 */
	public static final int PHONES_DISPLAY_NAME_INDEX = 0;
	
	/**
	 * 电话号码索引
	 */
	public static final int PHONES_NUMBER_INDEX = 1;
	
	/**
	 * 头像ID索引
	 */
	public static final int PHONES_PHOTO_ID_INDEX = 2;
	
	/**
	 * 联系人ID索引
	 */
	public static final int PHONES_CONTACT_ID_INDEX = 3;

	private String phoneNumber; // 手机号码
	private String contactName; // 联系人名称
	private Long contractId; // 联系人ID
	private Long photoId; // 联系人头像ID
	private Bitmap contractPhoto; // 联系人头像

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public Bitmap getContractPhoto() {
		return contractPhoto;
	}

	public void setContractPhoto(Bitmap contractPhoto) {
		this.contractPhoto = contractPhoto;
	}
}
