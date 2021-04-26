package com.VTI.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VietnamesePhone extends Phone {

	private ArrayList<Contacts> contacts;

	public VietnamesePhone() {
		contacts = new ArrayList<Contacts>();
	}

	@Override
	public void insertContact(String name, String phone) {
		Contacts contact = new Contacts(name, phone);
		contacts.add(contact);		
	}

	@Override
	public void removeContact(String name) {
			Iterator<Contacts> iterator = contacts.iterator();
			while (iterator.hasNext()) {
				Contacts contacts = (Contacts) iterator.next();
				if (contacts.getName().equals(name)) {
					System.out.println(contacts);
		}
	}
}

	@Override
	public void updateContact(String name, String newPhone) {
		// TODO Auto-generated method stub
	}

	@Override
	public void searchContact(String name) {
		for (Contacts contacts2 : contacts) {
			if (contacts2.getName().equals(name)) {
				System.out.println(contacts2);
			}else {
				System.out.println("không có thông tin");
			}
		}
	}
}
	


