package controller.seguridad.generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import model.database.SecurityGroup;
import model.database.SecurityRole;
import model.database.SecurityUser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("assembler")
public class Assembler {

	@Transactional(readOnly = true)
	User buildUserFromUserEntity(SecurityUser userModel) {
		/* Datos basicos del usuario */
		String username = userModel.getEmail();
		String password = userModel.getPassword();
		boolean enabled = userModel.getStatus() == 'A' ? true : false;
		boolean accountNonExpired = userModel.getStatus() == 'A' ? true : false;
		boolean credentialsNonExpired = userModel.getStatus() == 'A' ? true : false;
		boolean accountNonLocked = userModel.getStatus() == 'A' ? true : false;
		/* Recolectamos los roles del usuario */
		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		SecurityGroup securityGroup = userModel.getSecurityGroup();
		Set<SecurityRole> listRoles = securityGroup.getSecurityRoles();
		for (SecurityRole securityRole : listRoles) {
			roles.add(new SimpleGrantedAuthority(securityRole.getName()));
		}
		User user = new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, roles);
		return user;
	}
}