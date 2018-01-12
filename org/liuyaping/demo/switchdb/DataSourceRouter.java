/**
 * 
 */
package org.applesline.demo.switchdb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义数据源注解。
 * 
 * @author liuyaping
 * @date 2017年8月15
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceRouter {

	String name();
}
