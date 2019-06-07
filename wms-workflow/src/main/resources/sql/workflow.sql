/*
  用户组视图
 */
-- ----------------------------
-- -- Table structure for act_id_group
-- -- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `act_id_group` AS (select `role`.`role_id` AS `ID_`,1 AS `REV_`,`role`.`role_name` AS `NAME_`,'' AS `TYPE_` from `role`)
-- ----------------------------
-- -- Table structure for act_id_membership
-- -- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `act_id_membership` AS (select `userrole`.`user_id` AS `USER_ID_`,1 AS `REV_`,`userrole`.`role_id` AS `GROUP_ID_` from `user_role` `userrole`)
-- ----------------------------
-- -- Table structure for act_id_membership
-- -- ----------------------------
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `act_id_user` AS (select `userinfo`.`user_id` AS `ID_`,1 AS `REV_`,'' AS `FIRST_`,'' AS `LAST_`,`userinfo`.`user_name` AS `DISPLAY_NAME_`,`userinfo`.`email` AS `EMAIL_`,`userinfo`.`password` AS `PWD_`,'' AS `PICTURE_ID_`,'' AS `TENANT_ID_` from `user_info` `userinfo`)