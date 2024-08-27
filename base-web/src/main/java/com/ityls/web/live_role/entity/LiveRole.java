package com.ityls.web.live_role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("live_role")
public class LiveRole {
    @TableId(type = IdType.AUTO)
    private Long liveRoleId;
    private Long roleId;
    private Long userId;
}
