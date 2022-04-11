package com.acti.utils;

import com.acti.base.DriverScript;

public class Helper extends DriverScript{
	
	public static void fn_Sleep()
	{
		try{
			
			Thread.sleep(3000);
			
		}catch(InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}

}
