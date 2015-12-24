package ing.together.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ing.together.model.Profile;
import ing.together.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	public ProfileService profileService = new ProfileService();
	
	// Get all profiles
	@GET
	public List<Profile> getProfiles(){
		return profileService.getProfiles();
	}
	
	// Get single profile
	@GET
	@Path("/{name}")
	public Profile getProfile(@PathParam("name") String name){
		return profileService.getProfile(name);
	}
	
	// Update profile
	@PUT
	@Path("/{name}")
	public Profile updateProfile(@PathParam("name") String name, Profile profile){
		
		System.out.println("Updated profile : " + name);
		profileService.updateProfile(profile);
		
		return profile;
	}
	
	// Create profile
	@POST
	public Profile createProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
}
