package com.medicine.shiro;

import org.springframework.stereotype.Component;

//@Component
//public class MyRealm extends AuthorizingRealm {
////    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
////    授权
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
//        if(token.getUsername() != null){
//            AuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(),token.getPassword(),token.getUsername());
//            return info;
//        }
//        return null;
//    }
//}
