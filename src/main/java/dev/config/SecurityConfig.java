package dev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Import(DataSourceMySQLConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource) // source de données
                .passwordEncoder(passwordEncoder) // choix de l'algorithme d'encodage du mot de passe
                .usersByUsernameQuery("select email, password, IS_ACTIVE from user where email=?")
                .authoritiesByUsernameQuery("select email, ROLES from user where email = ?");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /// TODO: 27/06/2018 mettre en place la protection CNRF par la suite 
        http.authorizeRequests().antMatchers("/**").permitAll().and().csrf().disable();
    }
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
    */

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
