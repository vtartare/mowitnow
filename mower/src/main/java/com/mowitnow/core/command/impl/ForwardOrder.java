package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class ForwardOrder extends AbstractOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		if(!mower.canMove()) 
			return mower;
		logger.info("{} move forward",mower);
		mower.move();
		return mower;
	}

}
