package com.medicine.config;





//@Configuration
public class ShiroConfig {
//
////    权限管理对象
//    @Bean
//    public DefaultWebSecurityManager creatSr(MyRealm realm){
//
//        return new DefaultWebSecurityManager(realm);
//    }
//
//    @Bean
//    public ShiroFilterFactoryBean creatSF(DefaultWebSecurityManager manager){
//  //创建过滤器对象
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//  //        设置过滤的权限
//        factoryBean.setSecurityManager(manager);
//  // 设置需要过滤的页面
//        factoryBean.setLoginUrl("login.html");
////        登陆的接口
//        factoryBean.setSuccessUrl("index.html");
////        未授权的页面
//        factoryBean.setUnauthorizedUrl("error.html");
////        /4、设置拦截规则 anon：匿名访问 放行 谁都可以使用 authc:认证访问 必须登录才可以使用
//
//        Map map= new HashMap();
//        map.put("/login.html","anon");
//        map.put("/user/login.do","anon");
////        静态资源
//        map.put("/static/media/*","anon");
//        map.put("/*","authc");
//        factoryBean.setFilterChainDefinitionMap(map);
//        return factoryBean;
//    }
}
