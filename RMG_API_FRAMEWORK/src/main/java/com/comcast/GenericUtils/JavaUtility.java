package com.comcast.GenericUtils;

import java.util.Random;
/**
 * generic method related to java
 * @author ADMIN
 *
 */

public class JavaUtility 
{
	/**
	 * generate random number
	 * @return
	 */
public int randomnum()
{
	Random random = new Random();
	int ran = random.nextInt(1000);
	return ran;
}
}
