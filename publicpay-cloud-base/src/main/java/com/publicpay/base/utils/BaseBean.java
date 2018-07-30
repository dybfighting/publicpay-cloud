package com.publicpay.base.utils;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author Shixy
 */
public abstract class BaseBean implements Serializable {
	@Override
	public String toString() {
		try {
			return (new ReflectionToStringBuilder(this, ToStringStyle.DEFAULT_STYLE) {
				@Override
				protected Object getValue(final Field field) throws IllegalArgumentException, IllegalAccessException {
					if (Date.class.isAssignableFrom(field.getType())) {
						return DateFormatUtils.format((Date) field.get(this.getObject()), "yyyy-MM-dd HH:mm:ss");
					} else {
						return super.getValue(field);
					}
				}
			}).setExcludeFieldNames("password", "passwd").toString();
		} catch (Exception e) {
			// NOTICE: 这样做的目的是避免由于toString()的异常导致系统异常终止
			// 大部分情况下，toString()用在日志输出等调试场景
			return super.toString();
		}
	}

}
