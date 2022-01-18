package com.sinbo.psychologicalTest.config;

import com.sinbo.psychologicalTest.component.security.PsyPasswordEncoder;
import com.sinbo.psychologicalTest.service.security.PsyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,  //Secured
        jsr250Enabled = true,   //RolesAllowed
        prePostEnabled = true   //PreAuthorize, PostAuthorize
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private PsyUserDetailsService psyUserDetailsService;
    private PsyPasswordEncoder psyPasswordEncoder;

    public WebSecurityConfig(PsyUserDetailsService psyUserDetailsService, PsyPasswordEncoder psyPasswordEncoder) {
        this.psyUserDetailsService = psyUserDetailsService;
        this.psyPasswordEncoder = psyPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(psyUserDetailsService)
                .passwordEncoder(psyPasswordEncoder);
    }

//    @Bean(BeanIds.AUTHENTICATION_MANAGER)
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }



}
