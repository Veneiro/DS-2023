package actions;

import poll.Poll;

public class GetBarGraphAction implements Action {

	private Poll poll;

	public GetBarGraphAction(Poll poll) {
		this.poll = poll;
	}
	
	@Override
	public void doAction() {
		System.out.println("Dibujando un gráfico de barras...");
	}

}
