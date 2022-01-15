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
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DaoAuthenticationProvider daoAuthenticationProvider;
    private final PsyPasswordEncoder psyPasswordEncoder;
    private final PsyUserDetailsService psyUserDetailsService;
    public WebSecurityConfiguration(DaoAuthenticationProvider daoAuthenticationProvider, PsyPasswordEncoder psyPasswordEncoder, PsyUserDetailsService psyUserDetailsService) {
        this.daoAuthenticationProvider = daoAuthenticationProvider;
        this.psyPasswordEncoder = psyPasswordEncoder;
        this.psyUserDetailsService = psyUserDetailsService;
    }
    @Bean public DaoAuthenticationProvider authenticationProvider() {
        daoAuthenticationProvider.setPasswordEncoder(psyPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(psyUserDetailsService);
        return daoAuthenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(authenticationProvider());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
