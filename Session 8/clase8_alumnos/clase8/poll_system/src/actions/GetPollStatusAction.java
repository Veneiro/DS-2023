package actions;

import poll.Poll;

public class GetPollStatusAction implements Action {

	Poll poll;
	
	public GetPollStatusAction(Poll poll) {
		this.poll = poll;
	}
	
	@Override
	public void doAction() {
		System.out.println("Nº votos SÍ: " + poll.getYeses() + " - Nº votos NO: "
				+ poll.getNos() + "\n");
	}

}
