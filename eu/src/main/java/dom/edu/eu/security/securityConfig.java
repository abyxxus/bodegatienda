package dom.edu.eu.security;

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
				
					//registro de usuarios
					User.withUsername("admin").password("{noop}12admin34").roles("ADMIN").build()
				
				);
		
		return new InMemoryUserDetailsManager(users);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.csrf(cus -> cus.disable())
				.authorizeHttpRequests(aut -> aut.requestMatchers(HttpMethod.POST, "/sedeSave").hasAnyRole("ADMINS")
					//.requestMatchers(HttpMethod.POST,"/dato-sav").hasAnyRole("USERS", "ADMINS")
					.requestMatchers(HttpMethod.GET, "/sedeAll").authenticated()
					.requestMatchers(HttpMethod.GET, "/sedeupdate").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.GET, "/sedeId").hasAnyRole("ADMINS")
					.requestMatchers(HttpMethod.PUT, "/sedeDispo").hasAnyRole("ADMINS")

				).httpBasic(Customizer.withDefaults());
		return http.build();
		
	}

}
