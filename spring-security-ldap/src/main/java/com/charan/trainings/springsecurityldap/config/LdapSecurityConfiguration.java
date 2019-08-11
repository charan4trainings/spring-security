package com.charan.trainings.springsecurityldap.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LdapSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication()
			.userSearchBase("ou=people")
			.userSearchFilter("(uid={0})")
			.groupSearchBase("ou=groups")
			.groupSearchFilter("member={0}")
			.contextSource()
				.root("dc=baeldung,dc=com")
					.ldif("classpath:ldapusers.ldif");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin().loginPage("/login").permitAll().and().logout().logoutSuccessUrl("/");
    }	

}
