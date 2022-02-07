package com.griddynamics.skarapuhina.model.board.getBoardsInfo;

import com.griddynamics.skarapuhina.model.board.Prefs;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
 class BackgroundImageScaled{
    public int width;
    public int height;
    public String url;
}


@Getter
 class LabelNames{
    public String green;
    public String yellow;
    public String orange;
    public String red;
    public String purple;
    public String blue;
    public String sky;
    public String lime;
    public String pink;
    public String black;
}
@Getter
@Setter
 class Membership{
    public String id;
    public String idMember;
    public String memberType;
    public boolean unconfirmed;
    public boolean deactivated;
}

@Getter
public class Board{
    public String name;
    public String desc;
    public Object descData;
    public boolean closed;
    public Object dateClosed;
    public String idOrganization;
    public Object idEnterprise;
    public Object limits;
    public Object pinned;
    public String shortLink;
    public ArrayList<Object> powerUps;
    public Date dateLastActivity;
    public ArrayList<Object> idTags;
    public Object datePluginDisable;
    public Object creationMethod;
    public Object ixUpdate;
    public boolean enterpriseOwned;
    public String idBoardSource;
    public String idMemberCreator;
    public String id;
    public boolean starred;
    public String url;
    public Prefs prefs;
    public boolean subscribed;
    public LabelNames labelNames;
    public Date dateLastView;
    public String shortUrl;
    public Object templateGallery;
    public ArrayList<String> premiumFeatures;
    public ArrayList<Membership> memberships;
}


