package com.ityls.web.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ityls.utils.ResultUtils;
import com.ityls.utils.ResultVo;
import com.ityls.web.user.entity.User;
import com.ityls.web.user.entity.UserParm;
import com.ityls.web.user.service.UserService;
import com.ityls.web.user_role.entity.UserRole;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 员工管理的控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 新增员工
     *
     * @param user
     * @return
     */
    @PostMapping
    public ResultVo addUser(@RequestBody User user) {
        //判断登录名 的唯一性
        if (StringUtils.isNotEmpty(user.getUsername())) {
            QueryWrapper<User> query = new QueryWrapper<>();
            query.lambda().eq(User::getUsername, user.getUsername());
            User one = userService.getOne(query);
            if (one != null) {
                return ResultUtils.error("登录名已经被占用!", 500);
            }
        }
        //如果密码存在，MD5加密
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        boolean save = userService.save(user);
        if (save) {
            return ResultUtils.success("新增员工成功");
        }
        return ResultUtils.error("新增员工失败");
    }

    /**
     * 编辑员工
     *
     * @param user
     * @return
     */
    @PutMapping
    public ResultVo editUser(@RequestBody User user) {
        //判断登录名 的唯一性
        if (StringUtils.isNotEmpty(user.getUsername())) {
            QueryWrapper<User> query = new QueryWrapper<>();
            query.lambda().eq(User::getUsername, user.getUsername());
            User one = userService.getOne(query);
            if (one != null && one.getUserId() != user.getUserId()) {
                return ResultUtils.error("登录名已经被占用!", 500);
            }
        }
        //如果密码存在，MD5加密
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
//             user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        boolean b = userService.updateById(user);
        if (b) {
            return ResultUtils.success("编辑员工成功");
        }
        return ResultUtils.error("编辑员工失败");
    }

    /**
     * 删除员工
     *
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public ResultVo deleteUser(@PathVariable("userId") Long userId) {
        boolean b = userService.removeById(userId);
        if (b) {
            return ResultUtils.success("删除员工成功");
        }
        return ResultUtils.error("删除员工失败");
    }

    /**
     * 查询员工列表
     *
     * @param parm
     * @return
     */
    @GetMapping("/list")
    public ResultVo list(UserParm parm) {
        IPage<User> list = userService.list(parm);
        //前端不展示密码
        list.getRecords().stream().forEach(item -> item.setPassword(""));
        return ResultUtils.success("查询成功", list);
    }

    /**
     * 根据用户id查询角色
     */
    @GetMapping("/getRoleByUserId")
    public ResultVo getRoleByUserId(UserRole userRole) {
        UserRole userRole1 = userService.getRoleByUserId(userRole);
        return ResultUtils.success("查询成功", userRole1);
    }

    /**
     * 保存用户角色
     */

    @PostMapping("/saveRole")
    public ResultVo saveRole(@RequestBody UserRole userRole) {
        userService.saveRole(userRole);
        return ResultUtils.success("分配角色成功!");
    }

}


