package com.griddynamics.skarapuhina.model.board.createBoard;

import com.griddynamics.skarapuhina.model.board.Prefs;
import lombok.Getter;

@Getter
public class CreateBoard {
    public String id;
    public String name;
    public String desc;
    public Object descData;
    public boolean closed;
    public String idOrganization;
    public Object idEnterprise;
    public boolean pinned;
    public String url;
    public String shortUrl;
    public Prefs prefs;
    public LabelNames labelNames;
    public Limits limits;
}

class LabelNames {
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

class Limits {
}
