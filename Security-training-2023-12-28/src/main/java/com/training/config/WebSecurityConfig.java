package com.training.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    //在bean中添加UserDetailService来使默认配置文件不生效
//    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        inMemoryUserDetailsManager.createUser(User.withUsername("hyq").password("{noop}123").roles("admin").build());
        return inMemoryUserDetailsManager;
    }

    //SpringBoot对SpringSecurity默认配置中 在工厂中默认创建AuthenticationManager
//    @Autowired
//    public void userDetailsRewrite(AuthenticationManagerBuilder builder) throws Exception {
//        System.out.println(builder);
//        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//        userDetailsService.createUser(User.withUsername("sy").password("{noop}123").roles("admin").build());
//        builder.userDetailsService(userDetailsService);
//    }

    //设置密码加密规则
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    //自定义AuthenticationManager
//    @Bean
//    public AuthenticationManager authenticationManagerBuilder(AuthenticationConfiguration configuration) throws Exception {
////        return new AuthenticationManagerBuilder().authenticationProvider(userDetailsService);
//        return configuration.getAuthenticationManager();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .mvcMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin(form -> form
                        //指定未登录时转跳那个端口
                        .loginPage("/log/in")
                        //验证端口
                        .loginProcessingUrl("/toLogin")
                        //验证后转跳端口
                        .defaultSuccessUrl("/home")
                        //失败后转跳端口
                        .failureForwardUrl("/log/in")
                        .permitAll()
                )
                .logout(
                        logout -> logout
                                .logoutRequestMatcher(
                                        new OrRequestMatcher(
                                                new AntPathRequestMatcher("/off", "POST")
                                        )
                                )
                                .logoutSuccessUrl("/log/in")
                                .permitAll()
                )
                //自定义SecurityFilterChain的数据源（userDetailService）
                .userDetailsService(userDetailsService());

        return httpSecurity.build();
    }

}
