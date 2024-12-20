//package com.Gladiators.Travel_Agency.config;
//
//import com.Gladiators.Travel_Agency.jwt.AuthEntryPointJwt;
//import com.Gladiators.Travel_Agency.jwt.AuthTokenFilter;
//import com.Gladiators.Travel_Agency.model.Users;
//import com.Gladiators.Travel_Agency.service.UserService;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
//@AllArgsConstructor
//public class SecurityConfig {
//
//        private UserService userService;
//        private AuthEntryPointJwt unauthorizedHandler;
//        private final BCryptPasswordEncoder passwordEncoder;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService((UserDetailsService) userService);
//        authProvider.setPasswordEncoder(passwordEncoder);
//
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//        return authConfig.getAuthenticationManager();
//    }
//
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOriginPattern("http://localhost:4200"); // Frontend URL
//        configuration.addAllowedMethod("*");
//        configuration.addAllowedHeader("*");
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        return http
//                      .cors(cors -> cors.configurationSource(corsConfigurationSource())) // CORS configuration
//                    .csrf(AbstractHttpConfigurer::disable) // Disable CSRF for stateless authentication
//                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler)) // Handle unauthenticated requests
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless authentication
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/signin","/api/user/save").permitAll() // Allow registration
//                        .requestMatchers("/api/role").hasRole("ADMIN") // Admin-only
//                        .requestMatchers("/api/tour").permitAll() // Publicly accessible
//                        .requestMatchers("/api/review").hasRole("USER") // User-only
//                        .anyRequest().authenticated() // All other requests require authentication
//                )
//                .authenticationProvider(authenticationProvider()) // JWT Authentication
//                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//}
