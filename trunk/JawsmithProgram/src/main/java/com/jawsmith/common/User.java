package com.jawsmith.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jawsmith.interfaces.DataAccesses;
import com.jawsmith.interfaces.SystemUserMethods;
import com.jawsmith.model.SystemUser;

public class User
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
    	String[] test={"1","2","3"};
    	SystemUserMethods sysMethods = (SystemUserMethods) appContext.getBean("systemUserBean");

    	DataAccesses sysUserBo = (DataAccesses)appContext.getBean("systemUserBean");
    	
    	/**SystemUser sysUser = (SystemUser)sysMethods.findByName("apriljoy");
    	sysUser.setPasswordChangeDate("10/22/12");
    	sysUserBo.update(sysUser);
    	 insert **/
    	SystemUser user = new SystemUser();
    	user.setAccess(1);
    	user.setFirst_name("aj");
    	user.setLast_name("damo");
    	user.setPassword("121212");
    	user.setUsername("arnulfo");
  
    	
    	sysUserBo.save(user);
    
    }
}
