package actions;

import poll.Poll;

public class WhenActions implements Action {
	
	private Action action;
	private int condition;
	private Poll poll;

	public WhenActions(Poll poll, Action action, int toMeet) {
		this.poll = poll;
		this.condition = toMeet;
		this.action = action;
	}
	
	@Override
	public void doAction() {
		if ((this.poll.getYeses() + this.poll.getNos()) % condition == 0) {
			action.doAction();
		}
	}
}
