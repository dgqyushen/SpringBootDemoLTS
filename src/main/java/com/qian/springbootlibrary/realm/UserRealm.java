//package com.qian.springbootlibrary.realm;
//
//import com.qian.springbootlibrary.pojo.User;
//import com.qian.springbootlibrary.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class UserRealm extends AuthorizingRealm {
//
//
//    @Autowired
//    private UserService userServiceImpl;
//
//    /**
//     * 授权
//     * @param principalCollection
//     * @return
//     */
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        return null;
//    }
//
//    /**
//     * 认证
//     * @param authenticationToken
//     * @return
//     * @throws AuthenticationException
//     */
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
////        userMapper.getUserByUserName()
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        User user = userServiceImpl.getUserByUserName(token.getUsername());
//        if (user==null){
//            throw new UnknownAccountException();
//        }
//
////        String name = "root";
////        String password = "123456";
//
////        if (!token.getUsername().equals(name)){
////            throw new UnknownAccountException();
////        }
//
////        new UsernamePasswordToken()
//
////        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
////        User user = userServiceImpl.getUserByUserName(token.getUsername());
////        if (user != null){
////            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
////        }
//
//        return new SimpleAuthenticationInfo("",user.getPassword(),"");
//    }
//}
