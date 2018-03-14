/**
 * STARPOST CONFIDENTIAL
 * _____________________
 * 
 * [2014] - [2018] StarPost Supply Chain Management Co. (Shenzhen) Ltd. 
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of
 * StarPost Supply Chain Management Co. (Shenzhen) Ltd. and its suppliers, if
 * any. The intellectual and technical concepts contained herein are proprietary
 * to StarPost Supply Chain Management Co. (Shenzhen) Ltd. and its suppliers and
 * may be covered by China and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from StarPost Supply Chain Management Co. (Shenzhen)
 * Ltd.
 *
 */
package cn.murphypen.Java_GUI.Day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author dongjianpeng
 *
 */
public class Script {

	public static void main(String[] args) {

		String command = "java -version";
		exec(command);
	}

	public static void exec(String command) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(command);
			printInputStream(process.getInputStream(), false, "GBK");
			printInputStream(process.getErrorStream(), true, "GBK");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printInputStream(InputStream is, boolean isError, String encoding) {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(is, encoding);
			br = new BufferedReader(isr);
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
			if (isError) {
				System.err.println("===========");
				System.err.println(sb);
				System.err.println("===========");
			} else {
				System.out.println("===========");
				System.out.println(sb);
				System.out.println("===========");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
