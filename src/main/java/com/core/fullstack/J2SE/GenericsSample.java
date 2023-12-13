package com.core.fullstack.J2SE;

import java.util.ArrayList;
import java.util.List;

public class GenericsSample {

	public static void main(String[] args) {

		BaseballTeam phillies1 = new BaseballTeam("Philadelphia Phillies");
		BaseballTeam astros1 = new BaseballTeam("Houston Astros");
		scoreResult(phillies1, 3, astros1, 5);

		SportsTeam phillies2 = new SportsTeam("Philadelphia Phillies");
		SportsTeam astros2 = new SportsTeam("Houston Astros");
		scoreResult(phillies2, 3, astros2, 5);

		Team<BaseballPlayer> phillies = new Team<>("Philadelphia Phillies");
		Team<BaseballPlayer> astros = new Team<>("Houston Astros");
		scoreResult(phillies, 3, astros, 5);

		var harper = new BaseballPlayer("B Harper", "Right Fielder");
		var marsh = new BaseballPlayer("B Marsh", "Right Fielder");
		phillies.addTeamMember(harper);
		phillies.addTeamMember(marsh);
		var guthrie = new BaseballPlayer("D Guthrie", "Center Fielder");
		phillies.addTeamMember(guthrie);
		phillies.listTeamMembers();

		SportsTeam afc1 = new SportsTeam("Adelaide Crows");
		Team<FootballPlayer> afc = new Team<>("Adelaide Crows");
		var tex = new FootballPlayer("Tex Walker", "Centre half forward");
		afc.addTeamMember(tex);
		var rory = new FootballPlayer("Rory Laird", "Midfield");
		afc.addTeamMember(rory);
		afc.listTeamMembers();
	}

	public static void scoreResult(BaseballTeam team1, int t1_score, BaseballTeam team2, int t2_score) {

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}

	public static void scoreResult(SportsTeam team1, int t1_score, SportsTeam team2, int t2_score) {

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}

	public static void scoreResult(Team team1, int t1_score, Team team2, int t2_score) {

		String message = team1.setScore(t1_score, t2_score);
		team2.setScore(t2_score, t1_score);
		System.out.printf("%s %s %s %n", team1, message, team2);
	}
}

class BaseballTeam {

	private String teamName;
	private List<BaseballPlayer> teamMembers = new ArrayList<>();
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalTies = 0;

	public BaseballTeam(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(BaseballPlayer player) {

		if (!teamMembers.contains(player)) {
			teamMembers.add(player);
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

class SportsTeam {

	private String teamName;
	private List<Player> teamMembers = new ArrayList<>();
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalTies = 0;

	public SportsTeam(String teamName) {
		this.teamName = teamName;
	}

	public void addTeamMember(Player player) {

		if (!teamMembers.contains(player)) {
			teamMembers.add(player);
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
