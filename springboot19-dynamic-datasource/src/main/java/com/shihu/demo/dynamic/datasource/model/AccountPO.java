package com.shihu.demo.dynamic.datasource.model;


import com.msh.frame.client.base.BasePO;
import com.msh.frame.client.validation.IInsert;
import com.msh.frame.client.validation.IInsertVO;
import com.msh.frame.client.validation.IUpdate;
import com.msh.frame.client.validation.IUpdateVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@ApiModel("PO")
public class AccountPO extends BasePO{
	@NotNull(groups = {IInsertVO.class,IInsert.class},message = "账号不能为空")
	@Size(groups = {IInsertVO.class,IUpdateVO.class,IInsert.class,IUpdate.class},max = 20, message = "account长度范围最大20")
	@ApiModelProperty("账号")
	private String account;

	@NotNull(groups = {IInsertVO.class,IInsert.class},message = "用户名不能为空")
	@Size(groups = {IInsertVO.class,IUpdateVO.class,IInsert.class,IUpdate.class},max = 20, message = "username长度范围最大20")
	@ApiModelProperty("用户名")
	private String username;

	@NotNull(groups = {IInsertVO.class,IInsert.class},message = "密码不能为空")
	@Size(groups = {IInsertVO.class,IUpdateVO.class,IInsert.class,IUpdate.class},max = 64, message = "password长度范围最大64")
	@ApiModelProperty("密码")
	private String password;

	@NotNull(groups = {IInsertVO.class,IInsert.class},message = "状态不能为空")
	@ApiModelProperty("状态")
	private Integer status;

	@NotNull(groups = {IUpdateVO.class,IUpdate.class}, message = "更新版本不能为空")
	@ApiModelProperty("更新版本")
	private Integer updateVersion;


}



