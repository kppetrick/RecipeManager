package RecipeAppRunner;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers(HttpMethod.POST,"/storage/uploadFile").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout().logoutSuccessUrl("/");;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/storage/uploadFile/**");
    }
}
