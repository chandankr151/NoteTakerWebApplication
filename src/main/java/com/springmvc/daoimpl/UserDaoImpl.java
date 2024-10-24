package com.springmvc.daoimpl;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.Notes;
import com.springmvc.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public int saveUser(User user) {

		int i = (Integer) hibernateTemplate.save(user);
		return i;
	}

	@Override
	public User login(String email, String password) {

		String query = "from User where email=:em and password=:pwd";
		User user = (User) hibernateTemplate.execute(s -> {
			Query q = s.createQuery(query);
			q.setString("em", email);
			q.setString("pwd", password);

			return q.uniqueResult();
		});

		return user;
	}

	@Override
	public int saveNotes(Notes notes) {

		int i = (Integer) hibernateTemplate.save(notes);
		return i;
	}

	@Override
	public List<Notes> getNotesByUser(User user) {

		String sql = "from Notes where user=:us";
		List<Notes> list = hibernateTemplate.execute(s -> {
			Query q = s.createQuery(sql);
			q.setEntity("us", user);
			return q.getResultList();
		});
		return list;
	}

	@Override
	public Notes getNotesById(int id) {

		Notes notes = hibernateTemplate.get(Notes.class, id);
		return notes;
	}

	@Override
	public void deleteNotes(int id) {

		Notes notes = hibernateTemplate.get(Notes.class, id);
		hibernateTemplate.delete(notes);
		System.out.println("Notes deleted Successfully.");
	}

	@Override
	public void updateNotes(Notes n) {
		hibernateTemplate.update(n);
		System.out.println("Updated Successfully.");
	}
}
