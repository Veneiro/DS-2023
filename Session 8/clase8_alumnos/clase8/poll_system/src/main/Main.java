package main;

import java.io.IOException;

import actions.GetBarGraphAction;
import actions.GetCircularGraphAction;
import actions.GetPollStatusAction;
import actions.StartActions;
import actions.WhenActions;
import poll.Poll;
import ui.Interviewer;

public class Main {
	public static void main(String[] args) throws IOException {
		program5();
	}

	public static void program1() throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		poll.registerActions(new GetPollStatusAction(poll));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

	public static void program2() throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		poll.registerActions(new GetCircularGraphAction(poll),
				new GetPollStatusAction(poll));
		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

	public static void program3() throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		poll.registerActions(new GetPollStatusAction(poll),
				new StartActions(poll, new GetCircularGraphAction(poll), 3));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

	public static void program4() throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		poll.registerActions(new GetPollStatusAction(poll),
				new StartActions(poll, new GetCircularGraphAction(poll), 3),
				new WhenActions(poll, new GetBarGraphAction(poll), 3));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}

	public static void program5() throws IOException {
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");
		poll.registerActions(new StartActions(poll,
				new WhenActions(poll, new GetPollStatusAction(poll), 2), 4));

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}
