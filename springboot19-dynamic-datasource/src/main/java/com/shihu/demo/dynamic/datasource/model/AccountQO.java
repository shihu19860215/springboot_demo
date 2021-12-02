package com.shihu.demo.dynamic.datasource.model;

import com.msh.frame.client.base.BaseQO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author shihu
 * @mail m-sh@qq.com
 */
@Data
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel("QO")
public class AccountQO extends BaseQO {
	@ApiModelProperty("账号")
	private String account ;

	@ApiModelProperty("用户名")
	private String username ;

	@ApiModelProperty("密码")
	private String password ;

	@ApiModelProperty("状态")
	private Integer status ;

}