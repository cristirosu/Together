package ing.together.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ing.together.model.Profile;

public class Database {
	
	private static Map<String,Profile> profiles = new HashMap<String,Profile>();
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static Map<String,Profile> getProfiles(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Profile");
		profiles.clear();
		for(Profile p : (List<Profile>)query.list()){
			profiles.put(p.getName(), p);
		}
		
		session.getTransaction().commit();
		session.close();
		
		return profiles;
	}
	
	public static Profile getProfile(String name){
		getProfiles();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Profile profile = session.get(Profile.class, profiles.get(name).getId());
		
		session.getTransaction().commit();
		session.close();
		
		return profile;
	}
	
	public static Profile updateProfile(Profile profile){
		getProfiles();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(profile);
		
		session.getTransaction().commit();
		session.close();
		
		return profile;
	}
	
	public static Profile addProfile(Profile profile){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(profile);
		
		session.getTransaction().commit();
		session.close();
		
		return profile;
	}
	
}
