package cn.sqyl.dataobject;

public class daka_msgKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_msg.date
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    protected String date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column daka_msg.belong_dakaID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    protected Integer belongDakaid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_msg.date
     *
     * @return the value of daka_msg.date
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public String getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_msg.date
     *
     * @param date the value for daka_msg.date
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column daka_msg.belong_dakaID
     *
     * @return the value of daka_msg.belong_dakaID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public Integer getBelongDakaid() {
        return belongDakaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column daka_msg.belong_dakaID
     *
     * @param belongDakaid the value for daka_msg.belong_dakaID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setBelongDakaid(Integer belongDakaid) {
        this.belongDakaid = belongDakaid;
    }
}