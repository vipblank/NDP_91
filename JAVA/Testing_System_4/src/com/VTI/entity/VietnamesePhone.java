package com.VTI.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VietnamesePhone extends Phone {
	public ArrayList<Contacts> ListContacts;
	public VietnamesePhone() {
		ListContacts = new ArrayList<Contacts>();
	}

	@Override
	public void insertContact(String name, String phone) {
		Contacts contacts = new Contacts(name, phone);
		ListContacts.add(contacts);	
	}

	@Override
	public void removeContact(String name) {
		Iterator<Contacts> iterator = ListContacts.iterator();
		while (iterator.hasNext()) {
			Contacts contacts = (Contacts) iterator.next();
			if (contacts.getName().equals(name)) {
				iterator.remove();
			}
		}	
	}

	@Override
	public void updateContact(String name, String newPhone) {
		for (Contacts contacts : ListContacts) {
			if (contacts.getName().equals(name)) {
				contacts.setNumber(newPhone);
				System.out.println("Thông tin tài khoản sau update: " + contacts);
			}
		}
	}

	@Override
	public void searchContact(String name) {
		for (Contacts contacts : ListContacts) {
			if (contacts.getName().equals(name)) {
				System.out.println(contacts);
			}
		}	
	}
}
	


