/**
 * 
 */
package com.mowitnow.core.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.core.context.impl.MowerContextImpl;
import com.mowitnow.core.data.Cardinal;
import com.mowitnow.core.data.Mower;
import com.mowitnow.core.loader.MowerInputFormatException;

/**
 * @author eliaj
 *
 */
public class MowerFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(MowerContextImpl.class); 
	
	private static int mowerCounter = 0;
	
	public static Mower getMower(String mowerLine) throws MowerInputFormatException{
		
		if(mowerLine == null) 
			throw new  MowerInputFormatException("Invalid Mower format");
		
		String[] mowerConfig = mowerLine.split(" ");
		
		if(mowerConfig.length != 3)  
			throw new  MowerInputFormatException("Invalid Mower format");
		
		Mower mower = new Mower();
		
		try {
			mower.setX(Integer.parseInt(mowerConfig[0]));
			mower.setY(Integer.parseInt(mowerConfig[1]));
			mower.setCardinal(Cardinal.cardinalFormChar(mowerConfig[2].charAt(0)));
			mower.setMowerId(mowerCounter);
		} catch (NumberFormatException e) {
			throw new  MowerInputFormatException("Invalid Mower format",e);
		}catch (MowerInputFormatException e) {
			throw e;
		}
		logger.info("MowerFactory : create mower {}",mower);
		mowerCounter++;
		return mower;
	}
	
}
