package cn.sqyl.dao;

import cn.sqyl.dataobject.user_password;

public interface user_passwordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    int insert(user_password record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    int insertSelective(user_password record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    user_password selectByPrimaryKey(Integer id);

    user_password selectByUserId(Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    int updateByPrimaryKeySelective(user_password record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_password
     *
     * @mbg.generated Mon May 10 21:11:49 CST 2021
     */
    int updateByPrimaryKey(user_password record);
}