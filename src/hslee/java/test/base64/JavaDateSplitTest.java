package hslee.java.test.base64;

import java.util.Date;

public class JavaDateSplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaDateSplitTest javaDateSplitTest = new JavaDateSplitTest();
		Date d = javaDateSplitTest.getDate("2016-01-08T11:22:39");
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDay());
		System.out.println(d.getHours());
		System.out.println(d.getMinutes());
		System.out.println(d.getSeconds());
	}

	private Date getDate(String strDate) {
		String[] ymdt = strDate.split("T");
		String[] ymd = ymdt[0].split("-");
		String[] time = ymdt[1].split(":");
		Date result = new Date(Integer.valueOf(ymd[0]).intValue(), Integer.valueOf(ymd[1]).intValue(),
				Integer.valueOf(ymd[2]).intValue(), Integer.valueOf(time[0]).intValue(), Integer.valueOf(
						time[1]).intValue(), Integer.valueOf(time[2]).intValue());

		return result;
	}

}
