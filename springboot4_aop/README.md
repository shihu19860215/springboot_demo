任意公共方法的执行：
execution(public * *(..))
任何一个以“set”开始的方法的执行：
execution(* set*(..))
AccountService 接口的任意方法的执行：
execution(* com.xyz.service.AccountService.*(..))
定义在service包里的任意方法的执行：
execution(* com.xyz.service.*.*(..))
定义在service包和所有子包里的任意类的任意方法的执行：
execution(* com.xyz.service..*.*(..))
定义在pointcutexp包和所有子包里的JoinPointObjP2类的任意方法的执行：
execution(* com.test.spring.aop.pointcutexp..JoinPointObjP2.*(..))")
***> 最靠近(..)的为方法名,靠近.*(..))的为类名或者接口名,如上例的JoinPointObjP2.*(..))

pointcutexp包里的任意类.
within(com.test.spring.aop.pointcutexp.*)
pointcutexp包和所有子包里的任意类.
within(com.test.spring.aop.pointcutexp..*)
实现了Intf接口的所有类,如果Intf不是接口,限定Intf单个类.
this(com.test.spring.aop.pointcutexp.Intf)
***> 当一个实现了接口的类被AOP的时候,用getBean方法必须cast为接口类型,不能为该类的类型.

带有@Transactional标注的所有类的任意方法.
@within(org.springframework.transaction.annotation.Transactional)
@target(org.springframework.transaction.annotation.Transactional)
带有@Transactional标注的任意方法.
@annotation(org.springframework.transaction.annotation.Transactional)
***> @within和@target针对类的注解,@annotation是针对方法的注解

参数带有@Transactional标注的方法.
@args(org.springframework.transaction.annotation.Transactional)