package backend;

public class Reward {
    final String REWARDID;
    private String rewardName;
    private String rewardValue;

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
