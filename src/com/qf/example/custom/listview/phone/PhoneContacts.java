package com.qf.example.custom.listview.phone;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Photo;

/**
 * �ֻ�ͨѶ¼
 * 
 * @author Administrator
 * 
 */
public class PhoneContacts implements Serializable {
	private static final long serialVersionUID = 5020399480635146473L;

	/**
	 * ��ȡ��Phone���ֶ�
	 */
	public static final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };

	/**
	 * ��ϵ����������
	 */
	public static final int PHONES_DISPLAY_NAME_INDEX = 0;
	
	/**
	 * �绰��������
	 */
	public static final int PHONES_NUMBER_INDEX = 1;
	
	/**
	 * ͷ��ID����
	 */
	public static final int PHONES_PHOTO_ID_INDEX = 2;
	
	/**
	 * ��ϵ��ID����
	 */
	public static final int PHONES_CONTACT_ID_INDEX = 3;

	private String phoneNumber; // �ֻ�����
	private String contactName; // ��ϵ������
	private Long contractId; // ��ϵ��ID
	private Long photoId; // ��ϵ��ͷ��ID
	private Bitmap contractPhoto; // ��ϵ��ͷ��

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
