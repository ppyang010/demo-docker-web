package com.code.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/5.
 * 数据库操作 demo
 */
@RestController
public class DataController {

    @Autowired
    private UserTestDao userTestDao;



    /**
     * 查询列表
     * @return
     */
    @GetMapping(value = "/peoples")
    public List<UserTestEntity> peoples (){
        return userTestDao.findAll();
    }

    /**
     * 添加
     * @return
     */
    @PostMapping("/peoples")
    public UserTestEntity addPeople(@RequestParam String name , @RequestParam Integer age){
        UserTestEntity peopleEntity=new UserTestEntity();
        return userTestDao.save(peopleEntity);
    }

    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/peoples/{id}")
    public UserTestEntity findOne( @PathVariable Integer id){
        return userTestDao.findById(id).get();
    }

    /**
     * 根据username查询
     * @param username
     * @return
     */
    @GetMapping("/peoples/username/{usernaem}")
    public List<UserTestEntity> findByAge(@PathVariable String username){
        return userTestDao.findByUsername(username);
    }

    /**
     * 更新
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping("/peoples/{id}")
    public UserTestEntity update(@PathVariable Integer id, @RequestParam String name , @RequestParam Integer age){
        UserTestEntity peopleEntity=new UserTestEntity();
        peopleEntity.setId(id);
        Integer x=0;
        return userTestDao.save(peopleEntity);
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/peoples/{id}")
    public void delete( @PathVariable Integer id){
        userTestDao.deleteById(id);
    }

    @PostMapping("/query")
    public void query(@RequestParam(required = false) Integer id, HttpServletRequest request) throws IOException {
        request.getInputStream();
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        request.getInputStream();
        System.out.println(id);
    }



}

