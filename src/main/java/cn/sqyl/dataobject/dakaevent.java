package cn.sqyl.dataobject;

public class dakaevent {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.id
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.name
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.belong_UserID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private Integer belongUserid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.last_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private Integer lastDays;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.type
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dakaevent.daka_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    private String dakaDays;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.id
     *
     * @return the value of dakaevent.id
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.id
     *
     * @param id the value for dakaevent.id
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.name
     *
     * @return the value of dakaevent.name
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.name
     *
     * @param name the value for dakaevent.name
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.belong_UserID
     *
     * @return the value of dakaevent.belong_UserID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public Integer getBelongUserid() {
        return belongUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.belong_UserID
     *
     * @param belongUserid the value for dakaevent.belong_UserID
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setBelongUserid(Integer belongUserid) {
        this.belongUserid = belongUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.last_days
     *
     * @return the value of dakaevent.last_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public Integer getLastDays() {
        return lastDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.last_days
     *
     * @param lastDays the value for dakaevent.last_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setLastDays(Integer lastDays) {
        this.lastDays = lastDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.type
     *
     * @return the value of dakaevent.type
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.type
     *
     * @param type the value for dakaevent.type
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dakaevent.daka_days
     *
     * @return the value of dakaevent.daka_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public String getDakaDays() {
        return dakaDays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dakaevent.daka_days
     *
     * @param dakaDays the value for dakaevent.daka_days
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    public void setDakaDays(String dakaDays) {
        this.dakaDays = dakaDays == null ? null : dakaDays.trim();
    }
}