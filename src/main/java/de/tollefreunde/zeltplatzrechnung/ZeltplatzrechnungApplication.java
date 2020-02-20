package de.tollefreunde.zeltplatzrechnung;

import de.tollefreunde.zeltplatzrechnung.security.MyUserDetailsService;
import de.tollefreunde.zeltplatzrechnung.security.ZPAAuthenticationSuccessHandler;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebSecurity
public class ZeltplatzrechnungApplication extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(ZeltplatzrechnungApplication.class, args);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/css/**", "/webjars/**").permitAll()
            .anyRequest().authenticated().and()
            .formLogin().loginPage("/login").permitAll().successHandler(zpaAuthenticationSuccessHandler()).and()
            .logout().permitAll();
  }

  @Autowired
  @Bean
  public DaoAuthenticationProvider authenticationProvider(final MyUserDetailsService userDetailsService) {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(encoder());
    return authProvider;
  }

  @Bean
  public PasswordEncoder encoder() {
    final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(6);
    bCryptPasswordEncoder.encode("secret");
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationSuccessHandler zpaAuthenticationSuccessHandler() {
    return new ZPAAuthenticationSuccessHandler();
  }

  @Bean
  public LayoutDialect layoutDialect() {
    return new LayoutDialect();
  }
}

