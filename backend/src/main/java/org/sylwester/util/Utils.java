package org.sylwester.util;

import static org.joda.time.Days.daysBetween;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public final class Utils {

	private Utils() {
	}

	private static class NonNullMapper extends BeanUtilsBean {
		@Override
		public void copyProperty(Object dest, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value == null) {
				return;
			}
			super.copyProperty(dest, name, value);
		}
	}

	public static void mapNonNullProperties(Object destination, Object original) {
		try {
			BeanUtilsBean utils = new NonNullMapper();
			utils.copyProperties(destination, original);
		} catch (InvocationTargetException | IllegalAccessException e) {
			throw new RuntimeException("Cannot map objects");
		}
	}

	public static Date getDate(int year, int month, int day) {
		return new GregorianCalendar(year, month, day).getTime();
	}

	public static int calculateDaysTillDate(Date date) {
		LocalDate now = new DateTime().toLocalDate();
		LocalDate endDate = new DateTime(date).toLocalDate();
		return daysBetween(now, endDate).getDays() + 1;
	}
}
