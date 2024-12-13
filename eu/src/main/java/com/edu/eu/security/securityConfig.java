package com.edu.eu.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class securityConfig {
	
	@Bean
	public InMemoryUserDetailsManager userManager() {
		List<UserDetails> users = List.of(
				User.withUsername("client").password("{noop}C1234").roles("USERS").build(),
				User.withUsername("vendedor").password("{noop}V1234").roles("VENTAS").build(),
				User.withUsername("bodega").password("{noop}B1234").roles("BODEGAS").build(),
				User.withUsername("admin").password("{noop}A1234").roles("ADMINS").build());
		return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(cus -> cus.disable())
				.authorizeHttpRequests(aut -> aut.requestMatchers(HttpMethod.POST, "/sede-save").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/sede-all").authenticated()
					.requestMatchers(HttpMethod.PUT, "/sede-update").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/sede-id").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS" )
					.requestMatchers(HttpMethod.POST, "/producto-save").hasAnyRole("ADMINS" ,"BODEGAS")
					.requestMatchers(HttpMethod.GET, "/producto-all").authenticated()
					.requestMatchers(HttpMethod.PUT, "/producto-update").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.GET, "/producto-id").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.POST, "/pedido-save").hasAnyRole("ADMINS" ,"VENTAS" )
					.requestMatchers(HttpMethod.GET, "/pedido-all").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.PUT, "/pedido-update").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.PUT, "/pedido-id").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.POST, "/empleado-save").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/empleado-all").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.PUT, "/empleado-update").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/empleado-id").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.POST, "/cliente-save").hasAnyRole("ADMINS" ,"VENTAS")
					.requestMatchers(HttpMethod.GET, "/cliente-all").hasAnyRole("ADMINS" ,"VENTAS")
					.requestMatchers(HttpMethod.PUT, "/cliente-update").hasAnyRole("ADMINS" ,"VENTAS")
					.requestMatchers(HttpMethod.GET, "/cliente-id").hasAnyRole("ADMINS" ,"VENTAS")
					.requestMatchers(HttpMethod.POST, "/bodega-save").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/bodega-all").hasAnyRole("ADMINS","BODEGAS")
					.requestMatchers(HttpMethod.PUT, "/bodega-update").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/bodega-id").hasAnyRole("ADMINS","BODEGAS")
					.requestMatchers(HttpMethod.GET, "/producto-id").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.POST, "/bhp-save").hasAnyRole("ADMINS" ,"VENTAS" )
					.requestMatchers(HttpMethod.GET, "/bhp-all").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.PUT, "/bhp-update").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")
					.requestMatchers(HttpMethod.PUT, "/bhp-id").hasAnyRole("ADMINS" ,"VENTAS" ,"BODEGAS")


				).httpBasic(Customizer.withDefaults());
		return http.build();
		
	}

}
