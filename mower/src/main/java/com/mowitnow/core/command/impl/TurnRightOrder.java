package com.mowitnow.core.command.impl;

import com.mowitnow.core.command.Order;
import com.mowitnow.core.data.Mower;

public class TurnRightOrder extends AbstractOrder implements Order {

	@Override
	public Mower execute(Mower mower) {
		logger.info("{} turn right",mower);
		mower.setCardinal(mower.getCardinal().right());
		return mower;
	}

}
