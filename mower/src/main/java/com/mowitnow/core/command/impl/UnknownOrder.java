package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class UnknownOrder extends AbstractOrder implements Order {
	
	@Override
	public Mower execute(Mower mower) {
		logger.info("{} jump!",mower);
		return mower;
	}

}
