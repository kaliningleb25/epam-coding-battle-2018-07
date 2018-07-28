package com.epam.shared.model;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.playersummaries.GetPlayerSummaries;
import com.lukaspradel.steamapi.data.json.playersummaries.Player;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetPlayerSummariesRequest;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;

import java.util.Collections;

public class SteamUserInfo {
    private SteamWebApiClient client = new SteamWebApiClient.SteamWebApiClientBuilder("41920358BA623425E33B43808C32A433").build();
    private GetPlayerSummariesRequest infoUserRequest;

    private GetPlayerSummaries playerInfo = null;

    private final Player PLAYER;

    public SteamUserInfo(String steamId) {
        infoUserRequest = SteamWebApiRequestFactory.createGetPlayerSummariesRequest(Collections.singletonList(steamId));
        try {
            playerInfo = client.processRequest(infoUserRequest);
        } catch (SteamApiException e) {
            e.printStackTrace();
        }

        PLAYER = playerInfo.getResponse().getPlayers().get(0);
    }

    private String getId() {
        return PLAYER.getSteamid();
    }

    private String getPersonaName() {
        return PLAYER.getPersonaname();
    }

    private String getAvatarUrl() {
        return PLAYER.getAvatarmedium();
    }

    private String getCountryCode() { return PLAYER.getLoccountrycode(); }
}
