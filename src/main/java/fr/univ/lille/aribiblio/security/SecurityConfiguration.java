package fr.univ.lille.aribiblio.security;

import fr.univ.lille.aribiblio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/auth/**","/auth","/h2/**").permitAll()
                .antMatchers("/authors","/books","/rented").hasAnyRole("USER")
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/h2/**","/auth/**","/rented")
                .and().headers().frameOptions().sameOrigin()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return s -> {
            fr.univ.lille.aribiblio.model.User user = this.userService.getUser(s);

            if(user==null) throw new BadCredentialsException("No such user");

            UserDetails userDetails= User
                    .withUsername(user.getName())
                    .password(user.getPassword())
                    .roles("USER")
                    .build();

            return userDetails;
        };
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
