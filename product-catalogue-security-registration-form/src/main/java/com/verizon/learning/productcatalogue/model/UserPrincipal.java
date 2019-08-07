package com.verizon.learning.productcatalogue.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.verizon.learning.productcatalogue.entity.ApplicationUser;
import com.verizon.learning.productcatalogue.entity.Authority;

public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 2118245692648869495L;

	private ApplicationUser user;

	public UserPrincipal(ApplicationUser user) {
		if (user == null) {
			throw new RuntimeException("User can't be null");
		}
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<>();
		for (final Authority role : user.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}
