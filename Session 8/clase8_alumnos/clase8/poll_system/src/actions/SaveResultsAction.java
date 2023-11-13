package actions;

import poll.Poll;

public class SaveResultsAction implements Action {

	private Poll poll;

	public SaveResultsAction(Poll poll) {
		this.poll = poll;
	}
	
	@Override
	public void doAction() {
		System.out.println("Guardando los resultados...");
	}

}
