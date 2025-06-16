//package com.rw.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.security.web.util.matcher.OrRequestMatcher;
//
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    //提供UserDetailService，使默认不生效 （登录失败）
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//        inMemoryUserDetailsManager.createUser(User.withUsername("sy").password("{noop}1234").roles("admin").build());
//        return inMemoryUserDetailsManager;
//    }
//
//    /**
//     * Springboot 对SpringSecurity的默认品配置
//     * 1、默认自动配置创建全局AuthenticationManager默认找当前项目中是否存在自定义的UserDetailService实例 如果存在则自动将当前项目的UserDetailService实例设置为数据源
//     * 2、默认自动配置创建全局AuthenticationManager在工厂中使用时字节在代码中注入即可
//     */
//    //Springboot 对SpringSecurity的默认品配置
////    @Autowired
////    public void initialize(AuthenticationManagerBuilder builder) throws Exception {
////        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
////        userDetailsService.createUser(User.withUsername("hyq").password("{noop}123456").roles("admin").build());
////        builder.userDetailsService(userDetailsService);
////    }
//
//
//    /**
//     * 自定义AuthenticationManager 推荐
//     * 1、一旦通过Configure方法之定义AuthenticationManager实现 就会将工厂中自动配置的AuthenticationManager进行覆盖
//     * 2、需要在实现中指定认证数据源对象UserDetailService实例
//     * 3、这种方法创建的AuthenticationManager对象是工厂内部的一个本地AuthenticationManager对象（未注册到Bean中）
//     * 如果需要将该AuthenticationManager注册到bean中就需要将父类的authenticationManagerBean方法实现并注入到Bean中
//     */
//    //
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService());
//    }
//
//    /**
//     * 用来将工厂中自定义的AuthenticationManager实例注入到Bean容器中
//     */
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable()
//                .authorizeRequests()
//                .mvcMatchers("/index/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
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
//                ).logout(
//                        logout -> logout
//                                //默认 会话失效
//                                .invalidateHttpSession(true)
//                                //默认  清楚认证标记
//                                .clearAuthentication(true)
//                                //注销匹配器
//                                .logoutRequestMatcher(
////                                        new AntPathRequestMatcher("/toLogout", "GET")
//                                        new OrRequestMatcher(
//                                                new AntPathRequestMatcher("/toLogout", "GET"),
//                                                new AntPathRequestMatcher("/toLogout", "POST")
//                                        )
//                                )
//                                //注销成功之后 跳转哪里
////                                .logoutSuccessUrl("login")
//                                .logoutSuccessHandler(new LogoutSuccessHandlerConfig())
//                                .permitAll()
//                );
//
//    }
//}
