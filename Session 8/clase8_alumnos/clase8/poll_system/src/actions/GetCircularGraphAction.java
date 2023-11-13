package actions;

import poll.Poll;

public class GetCircularGraphAction implements Action {

	private Poll poll;

	public GetCircularGraphAction(Poll poll) {
		this.poll = poll;
	}
	
	@Override
	public void doAction() {
		System.out.println("Dibujando un gráfico circular...");
	}

}
