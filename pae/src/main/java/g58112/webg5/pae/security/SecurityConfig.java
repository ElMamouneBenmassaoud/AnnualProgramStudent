package g58112.webg5.pae.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();

        users.createUser(user1);
        users.createUser(user2);

        return users;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form.loginPage("/login"));
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/private").authenticated()
                .anyRequest().permitAll()
        );
        return http.build();
    }
}