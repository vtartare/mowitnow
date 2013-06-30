package com.mowitnow.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mowitnow.core.context.MowerContext;
import com.mowitnow.core.context.impl.MowerContextImpl;
import com.mowitnow.core.loader.MowerInputFormatException;

public class MowerApplication {
	
	protected static final Logger logger = LoggerFactory.getLogger(MowerApplication.class); 
	
	
	private MowerContext context = new MowerContextImpl();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MowerApplication app = new MowerApplication();
		try {
			app.init(args[0]);
		} catch (MowerInputFormatException e) {
			logger.error("Can not init MowerApplication : {}",e.getMessage());
			return;
		}
		app.run();
	}

	public void init(String fileName) throws MowerInputFormatException {
		
		Scanner scanner = null ;
		try {
			
			scanner = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName));
			
			if(!scanner.hasNextLine())
				throw new MowerInputFormatException(fileName + " not found");
			
			context.setField( scanner.nextLine());
			
			List<String> mowersAndOrders = new LinkedList<String>();
			while (scanner.hasNextLine()) {
				mowersAndOrders.add(scanner.nextLine());
			}
			context.setMowers(mowersAndOrders);
		}finally{
			if(scanner != null)
				scanner.close();
		}
		
	}

	public MowerContext getContext() {
		return context;
	}
	
	
	public void run() {
		context.run();
	}
	
}
