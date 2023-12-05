package com.core.fullstack.J2SE;

import java.util.ArrayList;
import java.util.List;

interface Player {
}

record BaseballPlayer(String name, String position) implements Player {
}

record FootballPlayer(String name, String position) implements Player {
}

public class GenericsLearn {

	public static void main(String[] args) {

		Team<BaseballPlayer> phillies = new Team<>("A");
		Team<BaseballPlayer> astros = new Team<>("B");
		scoreResult(phillies, 3, astros, 5);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Left Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
		phillies.addTeamMember(guthrie);
		phillies.listTeamMembers();

		Team<FootballPlayer> afc = new Team<>("A");
		var tex = new FootballPlayer("Tex Walker", "Centre half forward");
		afc.addTeamMember(tex);
		var rory = new FootballPlayer("Rory Laird", "Midfield");
		afc.addTeamMember(rory);
		scoreResult(afc, 8, afc, 6);
		afc.listTeamMembers();
	}

	public static void scoreResult(Team<?> team1, int t1_score, Team<?> team2, int t2_score) {

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}
}

class Team<T> {

	private String teamName;
	private List<T> teamMembers = new ArrayList<>();
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalTies = 0;

	public Team(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(T t) {

		if (!teamMembers.contains(t)) {
			teamMembers.add(t);
		}
	}

	public void listTeamMembers() {

		System.out.println(teamName + " Roster:");
		System.out.println(teamMembers);
	}

	public int ranking() {
		return (totalLosses * 2) + totalTies + 1;
	}

	public String setScore(int ourScore, int theirScore) {

		String message = "lost to";
		if (ourScore > theirScore) {
			totalWins++;
			message = "beat";
		} else if (ourScore == theirScore) {
			totalTies++;
			message = "tied";
		} else {
			totalLosses++;
		}

		return message;

	}

	@Override
	public String toString() {
		return teamName + " (Ranked " + ranking() + ")";
	}
}
