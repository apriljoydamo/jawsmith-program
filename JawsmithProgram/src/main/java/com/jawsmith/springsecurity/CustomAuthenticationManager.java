package com.jawsmith.springsecurity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.SystemUserMethods;
import com.jawsmith.model.SystemUser;



public class CustomAuthenticationManager implements AuthenticationManager {  

	
	protected static Logger logger = Logger.getLogger("service");
	ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	SystemUserMethods sysMethods = (SystemUserMethods)appContext.getBean("systemUserBean");
	// Our custom DAO layer
	SystemUser systemUser = new SystemUser();

	/**
	 * The authentication process.
	 * @param auth The user who logged in.
	 **/
	public Authentication authenticate(Authentication auth)
	   	throws AuthenticationException {
			logger.debug("Performing custom authentication");
		
		/*String encryptedPassword="";
		try{
			encryptedPassword=EncryptDecryption.encrypt((String)auth.getCredentials());
		}catch(Exception e){
			System.out.println("Wrong pass");	  
		}*/
			
			
	   //Init a database user object
			//systemUser= (SystemUser)sysMethods.findByName((String)auth.getName());
			try {
				//Retrieve user details from database				
				systemUser = (SystemUser)sysMethods.findByName((String)auth.getName());
				System.out.println("user exists: auth "+auth.getName());
				System.out.println("auth password: "+auth.getCredentials());
				System.out.println("user exists: sysUser "+systemUser.getUsername());
				System.out.println("systemUser password: "+systemUser.getPassword());
				logger.debug("Username EXISTS");				
			} catch (Exception e) {
				logger.error("Username does not exist!");
				throw new BadCredentialsException("Username does not exist!");
			}
			
		try{
			//if entered username and password == the user's username and password in the database
			if(systemUser.getPassword().equals(auth.getCredentials()) && systemUser.getUsername().equals(auth.getName())){
				System.out.println("correct password");
				System.out.println("auth password: "+auth.getCredentials());
				System.out.println("systemUser password: "+systemUser.getPassword());
			}
		}catch (Exception e){
			System.out.println("wrong pass");
			System.out.println("auth password: "+auth.getCredentials());
			System.out.println("systemUser password: "+systemUser.getPassword());
			  throw new BadCredentialsException("Wrong username or password");
		}
	
		//Here's the main logic of this custom authentication manager
		//Username and password must be the same to authenticate
		if (auth.getName().equals(systemUser.getPassword()) == true) {
			//this part might just be from the example code
			logger.debug("Entered username and password are the same!");
			throw new BadCredentialsException("Entered username and password are the same!");
	    }else{
		    logger.debug("User details are good and ready to go");
		    return new UsernamePasswordAuthenticationToken(
		    		auth.getName(),systemUser.getPassword(), 
		    		getAuthorities(systemUser.getAccess()));
	    }
		
		  
			/*return new UsernamePasswordAuthenticationToken(
		    		auth.getName(),"1212", 
		    		getAuthorities(systemUser.getAccess()));
		    		*/
	 }
	  
	 /**
	  * Retrieves the correct ROLE type depending on the access level, where access level is an Integer.
	  * Basically, this interprets the access value whether it's for a regular user or admin.
	  * 
	  * @param access an integer value representing the access of the user
	  * @return collection of granted authorities
	  */
	  public Collection<GrantedAuthority> getAuthorities(Integer access) {
	   // Create a list of grants for this user
	   List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
	    
	   //All users are granted with ROLE_USER access
	   //Therefore this user gets a ROLE_USER by default
	   //logger.debug("Grant ROLE_USER to this user");
	   authList.add(new GrantedAuthorityImpl("ROLE_USER"));
	    
	   //Check if this user has admin access 
	   //We interpret Integer(1) as an admin user
	   //If access=1, compareTo will return 0 which mean it is equals. 
	   //-1 means access is less than 1 and 1 means access is larger than 1
	   if (access.compareTo(1) == 0) { 
	   //User has admin access
		   logger.debug("Grant ROLE_ADMIN to this user");
		   System.out.println("Access: "+access+" compareTo: "+(access.compareTo(1))+" equals: "+(access.compareTo(1) == 0));
		   authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
	   }
	   if (access.compareTo(2) == 0) {
		   System.out.println("Access: "+access+" compareTo: "+(access.compareTo(2))+" equals: "+(access.compareTo(2) == 0));
		   authList.add(new GrantedAuthorityImpl("ROLE_APPROVER"));
		   }
	   if (access.compareTo(3) == 0) {
		   System.out.println("Access: "+access+" compareTo: "+(access.compareTo(3))+" equals: "+(access.compareTo(3) == 0));
		   authList.add(new GrantedAuthorityImpl("ROLE_ENCODER"));
		   }
	   // Return list of granted authorities
	   return authList;
	   }

}
