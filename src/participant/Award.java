package participant;

import constants.AwardType;

public class Award {
    private String name;
    private AwardType awardType;

    public Award(String name, AwardType awardType) {
        this.name = name;
        this.awardType = awardType;
    }

    public String getName() {
        return name;
    }

    public AwardType getAwardType() {
        return awardType;
    }
}
