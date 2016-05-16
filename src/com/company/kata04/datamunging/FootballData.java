/*
* Copyright Medtronic, Inc. 2014-2015
*
* MEDTRONIC CONFIDENTIAL - This document is the property of Medtronic,
* Inc.,and must be accounted for. Information herein is confidential. Do
* not reproduce it, reveal it to unauthorized persons, or send it outside
* Medtronic without proper authorization.
*/

package com.company.kata04.datamunging;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FootballData extends ProcessingData {

    public FootballData() {
        super("resources\\football.dat");
    }

    @Override
    protected List<String> getHeadersList(String sourceString) {
        List<String> result = super.getHeadersList(sourceString);
        result.add(0, "TeamNo");
        return result;
    }

    public int getScoredForTeam(String teamName) {
        return getIntParamForFilterParam("Team", teamName, "F");
    }

    public int getScoredAgainstTeam(String teamName) {
        return getIntParamForFilterParam("Team", teamName, "A");
    }

    public int getScoreDifference(String teamName) {
        return Math.abs(getScoredForTeam(teamName) - getScoredAgainstTeam(teamName));
    }

    public String getTeamWithSmallestScoreDifference() {
        List<Integer> spreads = new ArrayList<>();
        List<String> teams = getAllValuesByName("Team");
        spreads.addAll(teams.stream().map((teamName) -> getScoreDifference(teamName)).collect(Collectors.toList()));
        int minSpreadIndex = getMinSpreadIndex(spreads);
        return teams.get(minSpreadIndex);
    }
}
