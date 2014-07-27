package net.xqx.security;

import java.util.ArrayList;
import java.util.List;

import net.xqx.dao.admin.LoginDao;
import net.xqx.models.TAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		List<TAdmin> admins=loginDao.getAdmins(userName);
		TAdmin admin=null;
		if(admins!=null&&admins.size()>0){
			admin=admins.get(0);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		User u = new User(admin.getfAdminName(), admin.getfAdminPassword(), authorities);
		return u;
	}

}
