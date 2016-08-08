package com.mabao.service.impl;

import com.mabao.controller.vo.JsonResultVO;
import com.mabao.pojo.User;
import com.mabao.repository.UserRepository;
import com.mabao.service.UserService;
import com.mabao.util.BaseAction;
import com.mabao.util.UserManager;
import com.mabao.util.alibaba.message.AliSend;
import com.mabao.util.alibaba.message.ChangePasswordMes;
import com.mabao.util.alibaba.message.PhoneBindMes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;


@Service
public class UserServiceImpl extends BaseAction implements UserService {
    @Autowired
    private UserRepository userRepository;


    /**
     * 用户登录验证
     * @param name              用户名
     * @param password          密码
     * @return                  用户对象
     */
    @Override
    public User findByNameAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name,password);
    }
    /**
     * 根据ID获取用户对象
     * @param userId            用户ID
     * @return                  用户对象
     */
    @Override
    public User get(Long userId) {
        return this.userRepository.findOne(userId);
    }

    /**
     * 用户注册
     * @param userName              用户名
     * @param password              密码
     * @param email                 邮箱
     * @return                      收货地址页
     */
    @Override
    public JsonResultVO userRegister(String userName, String password, String email) {
        User isUser = this.userRepository.findByName(userName);
        if (isUser !=null){
            return new JsonResultVO(JsonResultVO.FAILURE, "该用户名已被注册");
        }else if (this.userRepository.findByEmail(email) != null) {
            return new JsonResultVO(JsonResultVO.FAILURE, "该邮箱已被使用");
        }else {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            User user = new User();
            user.setName(userName);
            user.setPassword(md5.encodePassword(password,""));
            user.setEmail(email);
            user.setCreateTime(new Date());
            user.setPicture("u6.JPG");
            this.userRepository.save(user);
            return new JsonResultVO(JsonResultVO.SUCCESS, "注册成功");
        }
    }
    /**
     * 修改用户信息
     * @param user                  用户
     * @return                      修改的用户
     */
    @Override
    public User updateUser(User user) {
        return this.userRepository.saveAndFlush(user);
    }
    /**
     * 修改密码
     * @param password              新密码
     * @return                      登录页
     */
    @Override
    public JsonResultVO changePassword(String password) {
        User user = UserManager.getUser();
        if (user != null) {
            Md5PasswordEncoder md5 = new Md5PasswordEncoder();
            user.setPassword(md5.encodePassword(password,""));
            this.updateUser(user);
            return new JsonResultVO(JsonResultVO.SUCCESS,"修改成功");
        }
        return new JsonResultVO(JsonResultVO.FAILURE,"请先登录");
    }

    /**
     * 个人中心，修改头像
     */
    @Override
    public User updateUserPicture(MultipartFile headerPic, HttpServletRequest request) {
        try {
            User user = UserManager.getUser();
            assert user != null;
            /** spring security将密码拦截导致 user中没有密码；保存时密码为NULL
             * 此处临时为赋值密码
             * */
            User tempUser = this.userRepository.findOne(user.getId());  //
            user.setPassword(tempUser.getPassword());
            //保存文件
            if (headerPic != null){
                String picURL = "/upload/header/user/"+user.getId()+"/";
                //上传文件过程
                super.upload(headerPic, picURL, request);
                String fileName = super.getFileName();
                String picName = fileName.substring(fileName.indexOf(picURL)+picURL.length(),fileName.length());

                user.setPicture(user.getId()+"/"+picName);
                return this.userRepository.saveAndFlush(user);
            }else {
                return user;
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     *
     * @param state                 短信类型 1为绑定手机 2为修改密码
     */
    @Override
    public JsonResultVO sendMessage(Integer state,String phoneNum) throws IOException {
        User user = UserManager.getUser();
        int flag = 1;
        if (user != null) {
            AliSend smsInterface = new AliSend();
            if(1 == state){
                PhoneBindMes phoneBindMes = new PhoneBindMes();
                phoneBindMes.setCode(123456);
                phoneBindMes.setPhone(phoneNum);
                phoneBindMes.setName(user.getName());
                flag = smsInterface.sendMessage(phoneBindMes);
            }else if(2 == state){
                ChangePasswordMes changePasswordMes = new ChangePasswordMes();
                changePasswordMes.setCode(123456);
                changePasswordMes.setName(user.getName());
                changePasswordMes.setPhone(user.getPhone());
                flag = smsInterface.sendMessage(changePasswordMes);
            }

            if(0 ==flag){
                return new JsonResultVO(JsonResultVO.SUCCESS,"发送成功！");
            }else if(1 ==flag){
                return new JsonResultVO(JsonResultVO.FAILURE,"发送失败");
            }else if(2 ==flag){
                return new JsonResultVO(JsonResultVO.FAILURE,"发送失败,未找到模版");
            }else{
                return new JsonResultVO(JsonResultVO.FAILURE,"发送失败,系统错误");
            }
        }
        return new JsonResultVO(JsonResultVO.FAILURE,"发送失败，请先登录！");
    }
}
