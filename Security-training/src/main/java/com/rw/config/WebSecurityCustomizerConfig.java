package com.rw.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

/**
 * 新型
 */
@Configuration
@EnableWebSecurity
public class WebSecurityCustomizerConfig {

    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("sy").password("{noop}123").roles("admin").build());
        return manager;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        return new ProviderManager(authenticationProvider);
    }


    /**
     * 设置密码储存格式
     *
     * @return
     */
//    @Bean
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        /**
         * 通常 mvcMatcher 比 antMatcher 更安全：
         * antMatchers("/secured")仅仅匹配/secured
         * mvcMatchers("/secured")匹配 /secured之余还匹配 /secured/,/secured.html,/secured.xyz
         * 因此 mvcMatcher 更加通用且容错性更高。
         */
        //需要注意放行资源需要放在认证之前
        httpSecurity.authorizeRequests(authorize -> authorize
                        .antMatchers("/index").permitAll()
                        .mvcMatchers("/text").permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/toLogin")).permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(
//                        form -> form
//
//                                //重定向用户登录请求到login
//                                .loginPage("/login")
//                                //用户的认证信息重定向到login接口去校验
//                                .loginProcessingUrl("/toLogin")
//                                //验证成功后默认转跳页面（不管有没有访问过安全页面）
////                                .successForwardUrl("/RestBoolController/getBool")
//                                //验证成功之后，如果没有访问过安全页面（管控页面），将会被重定向到默认的users页面,第二个参数为True时同上
//                                .defaultSuccessUrl("/out", true)
//                                //指定成功后的返回参数
////                                .successHandler(new AuthenticationSuccessHandlerConfig())
//                                //接口需使用RequestMapping、否者会报错
//                                .failureForwardUrl("/login") //认证失败后 forward转跳
////                                .failureUrl("/login") //默认 认证失败后 redirect转跳
////                                .failureHandler(new AuthenticationFailureHandlerConfig())
//                                //构建
//                                .permitAll()
//                )
                .formLogin().disable()
                .logout(
                        logout -> logout
                                //默认 会话失效
                                .invalidateHttpSession(true)
                                //默认  清楚认证标记
                                .clearAuthentication(true)
                                //注销匹配器
                                .logoutRequestMatcher(
//                                        new AntPathRequestMatcher("/toLogout", "GET")
                                        new OrRequestMatcher(
                                                new AntPathRequestMatcher("/toLogout", "GET"),
                                                new AntPathRequestMatcher("/toLogout", "POST")
                                        )
                                )
                                //注销成功之后 跳转哪里
//                                .logoutSuccessUrl("login")
                                .logoutSuccessHandler(new LogoutSuccessHandlerConfig())
                                .permitAll()
                );
        //添加一个另外的UserDetailsService来处理
//                .userDetailsService(userDetailsService());
        return httpSecurity.build();

    }

}
