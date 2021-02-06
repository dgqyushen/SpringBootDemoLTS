package com.qian.springbootlibrary.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @TableId
    private Integer id;
    private String username;
    private String password;
    private Boolean root;
    @Nullable
    private Integer personal_id;


}
