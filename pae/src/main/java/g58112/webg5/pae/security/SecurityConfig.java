package g58112.webg5.pae.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager users() {
        UserDetails user1 = User.withUsername("prof")
                .password("{noop}prof")
                .authorities("PROF").build();

        UserDetails user2 = User.withUsername("etudiant")
                .password("{noop}etudiant")
                .authorities("USER")
                .build();

        UserDetails user3 = User.withUsername("secretariat")
                .password("{noop}secretariat")
                .authorities("SECRETARIAT")
                .build();

        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

        users.createUser(user1);
        users.createUser(user2);
        users.createUser(user3);

        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http.formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home"));
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers(mvc.pattern("/courses/**")).authenticated()
                .requestMatchers(mvc.pattern("/students/**")).authenticated()
                .anyRequest().permitAll());
        http.exceptionHandling(error -> error.accessDeniedPage("/"));
        http.logout(logout -> logout.logoutSuccessUrl("/"));
        return http.build();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/db/**"));
    }
}