package br.com.abcode.clientes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String[] PUBLIC_MATCHERS = {"/h2-console/**"};


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/usuarios").permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers("/cep/**").permitAll()
                .antMatchers("/api/clientes/**",
                        "/api/servicos/**").authenticated()
                .anyRequest().denyAll();

    }





}
