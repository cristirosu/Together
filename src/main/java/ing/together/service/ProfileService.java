package ing.together.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ing.together.database.Database;
import ing.together.model.Profile;

public class ProfileService {

	Map<String,Profile> profiles = Database.getProfiles();
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String name){
		Profile profile = Database.getProfile(name);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		Profile profile2 = Database.updateProfile(profile);
		return profile2;
	}
	
	public Profile addProfile(Profile profile){
		Database.addProfile(profile);
		return profile;
	}
	
}
