package pe.edu.upc.pwspringahorraland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.pwspringahorraland.business.crud.impl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**", "/images/**", "/login/**",
						"/iniciar","/users/new", "/users/list", "/home" ,"/user/save", "/login/saveseller","/login/saveconsumer","/elegir", "/login/newseller","/login/newconsumer", "/{id}/Add",
						"/products/confirm","/iniciar", "/cart", "{cart,sale}", "/cart/{id}/del", "/cart/removeAll", "/cart/{id}/sale", "/cart/savesale", "complaintEdit", 
						"/seller/{sellerId}/complaint-replies", "/seller/complaint-replies/{complaintRepliesId}", "/deliveryman", "/deliveryman/detail/{deliveryManId}", "/deliveryman/deliveryman/new", "/deliveryman/saveNew",
						"/deliveryman/map")
				.permitAll().anyRequest().authenticated().and().formLogin().permitAll().loginPage("/login").loginProcessingUrl("/login")
				.defaultSuccessUrl("/home").permitAll()
				.and().logout().permitAll().and().exceptionHandling();
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {

		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}
