package com.springmvc.dao;

import java.util.List;

import com.springmvc.entity.Notes;
import com.springmvc.entity.User;

public interface UserDao {

	public int saveUser(User user);

	public User login(String email, String password);

	public int saveNotes(Notes notes);

	public List<Notes> getNotesByUser(User user);

	public Notes getNotesById(int id);
	
	public void deleteNotes(int id);

	public void updateNotes(Notes s);
}
