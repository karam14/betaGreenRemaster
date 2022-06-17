package backend;

public class Reward {
    public String REWARDID;
    public String rewardName;
    public String rewardValue;

    public Reward(String REWARDID, String rewardName, String rewardValue) {
        this.REWARDID = REWARDID;
        this.rewardName = rewardName;
        this.rewardValue = rewardValue;
    }

    public String getREWARDID() {
        return REWARDID;
    }

    public String getRewardName() {
        return rewardName;
    }

    public String getRewardValue() {
        return rewardValue;
    }
}
