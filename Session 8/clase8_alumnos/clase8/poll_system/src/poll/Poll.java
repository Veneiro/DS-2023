package poll;

import java.util.ArrayList;
import java.util.List;

import actions.Action;

public class Poll {
	private int yeses, nos;
	private String question;
	private List<Action> actions = new ArrayList<Action>();
	

	public Poll(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void registerActions(Action... action) {
		for (Action a : action) {
			this.actions.add(a);
		}
	}

	public int getYeses() {
		return yeses;
	}

	public int getNos() {
		return nos;
	}

	public void incrementYeses() {
		yeses++;
		for (Action action : actions) {
			action.doAction();
		}
	}

	public void incrementNos() {
		nos++;
		for (Action action : actions) {
			action.doAction();
		}
	}
}
