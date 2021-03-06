package rs.uns.acs.ftn.VehicleService.config;

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
                .anyRequest().authenticated()
                .and()
                .cors();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.GET, "/test/hello");
        web.ignoring().antMatchers(HttpMethod.GET, "/licence/hello");
        web.ignoring().antMatchers(HttpMethod.GET, "/person/hello");
        web.ignoring().antMatchers(HttpMethod.GET, "/person/people");
        web.ignoring().antMatchers(HttpMethod.POST, "/person/addStudent");
        web.ignoring().antMatchers(HttpMethod.PUT, "/person/makeInstructor");
        web.ignoring().antMatchers(HttpMethod.GET, "/lessons/hello");
        web.ignoring().antMatchers(HttpMethod.GET, "/lessons/getAll");
        web.ignoring().antMatchers(HttpMethod.PUT, "/lessons/add");
        web.ignoring().antMatchers(HttpMethod.GET, "/lessons/catTakeExam");
        web.ignoring().antMatchers(HttpMethod.GET, "/exams/hello");
        web.ignoring().antMatchers(HttpMethod.GET, "/exams/getAll");
        web.ignoring().antMatchers(HttpMethod.PUT, "/exams/add");
        web.ignoring().antMatchers(HttpMethod.GET, "/licence/getAll");
        web.ignoring().antMatchers(HttpMethod.PUT, "/licence/add");
        web.ignoring().antMatchers(HttpMethod.GET, "/tickets/getAll");
        web.ignoring().antMatchers(HttpMethod.PUT, "/tickets/add");
        web.ignoring().antMatchers(HttpMethod.GET, "/person/record");
    }
//
}
