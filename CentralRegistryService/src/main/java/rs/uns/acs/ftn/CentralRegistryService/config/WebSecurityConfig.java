package rs.uns.acs.ftn.CentralRegistryService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.ws.rs.HttpMethod;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET).permitAll()
                .antMatchers(HttpMethod.POST).permitAll()
                .antMatchers(HttpMethod.PUT).permitAll()
                .antMatchers(HttpMethod.DELETE).permitAll()
                .antMatchers(HttpMethod.HEAD).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().permitAll()
                .and()
                .cors();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.GET, "/*");
        web.ignoring().antMatchers(HttpMethod.POST, "/*");
        web.ignoring().antMatchers(HttpMethod.PUT, "/*");
        web.ignoring().antMatchers(HttpMethod.PUT, "/citizen/exists");
        web.ignoring().antMatchers(HttpMethod.DELETE, "/*");
        web.ignoring().antMatchers(HttpMethod.HEAD, "/*");
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/*");
    }
}
