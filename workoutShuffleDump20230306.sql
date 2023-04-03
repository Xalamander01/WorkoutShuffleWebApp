CREATE DATABASE  IF NOT EXISTS `workout_shuffle` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `workout_shuffle`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: workout_shuffle
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Temporary view structure for view `exercise_all_scores`
--

DROP TABLE IF EXISTS `exercise_all_scores`;
/*!50001 DROP VIEW IF EXISTS `exercise_all_scores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `exercise_all_scores` AS SELECT 
 1 AS `exercise_long_name`,
 1 AS `exercise_description`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `exercise_arm_scores`
--

DROP TABLE IF EXISTS `exercise_arm_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_arm_scores` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_forearm_score` double NOT NULL,
  `exercise_inner_bi_score` double NOT NULL,
  `exercise_outer_bi_score` double NOT NULL,
  `exercise_long_tri_score` double NOT NULL,
  `exercise_medial_tri_score` double NOT NULL,
  `exercise_lat_tri_score` double NOT NULL,
  PRIMARY KEY (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_arm_scores`
--

LOCK TABLES `exercise_arm_scores` WRITE;
/*!40000 ALTER TABLE `exercise_arm_scores` DISABLE KEYS */;
INSERT INTO `exercise_arm_scores` VALUES ('alternatingCurl',0,10,8,0,0,0),('closeGripBenchPress',0,0,0,10,10,5),('dumbbellSkullcrusher',0,0,0,7,10,7),('ezBarPreacherCurl',0,8,10,0,0,0),('hammerCurl',0,7,10,0,0,0),('inclineCurl',0,8,10,0,0,0),('preacherCurl',0,8,10,0,0,0),('ropeSkullcrusher',0,0,0,10,10,10),('ropeTricepPushdown',0,0,0,7,8,10),('skullcrusher',0,0,0,7,10,5),('standingCurl',0,9,9,0,0,0),('tricepPushdown',0,0,0,7,10,5);
/*!40000 ALTER TABLE `exercise_arm_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_back_scores`
--

DROP TABLE IF EXISTS `exercise_back_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_back_scores` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_upper_trap_scores` double NOT NULL,
  `exercise_lower_trap_scores` double NOT NULL,
  `exercise_upper_lat_scores` double NOT NULL,
  `exercise_lower_lat_scores` double NOT NULL,
  PRIMARY KEY (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_back_scores`
--

LOCK TABLES `exercise_back_scores` WRITE;
/*!40000 ALTER TABLE `exercise_back_scores` DISABLE KEYS */;
INSERT INTO `exercise_back_scores` VALUES ('barbellRow',3,8,10,9),('cableRow',10,8,4,4),('chestSupportedRow',8,6,10,7),('chinUp',3,9,9,9),('dumbbellRearRaise',8,7,3,3),('dumbbellRow',3,8,10,8),('facepull',10,8,3,3),('invertedGripPulldown',0,8,8,8),('landmineRow',3,8,10,8),('neutralGripPullUp',0,10,9,9),('oneArmLandmineRow',3,8,10,8),('pulldown',0,7,10,8),('pullUp',3,10,10,10),('shrug',10,8,4,4),('vBarPulldown',0,10,8,8),('wideGripPulldown',0,8,10,8);
/*!40000 ALTER TABLE `exercise_back_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_chest_scores`
--

DROP TABLE IF EXISTS `exercise_chest_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_chest_scores` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_upper_pec_scores` double NOT NULL,
  `exercise_middle_pec_scores` double NOT NULL,
  `exercise_lower_pec_scores` double NOT NULL,
  PRIMARY KEY (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_chest_scores`
--

LOCK TABLES `exercise_chest_scores` WRITE;
/*!40000 ALTER TABLE `exercise_chest_scores` DISABLE KEYS */;
INSERT INTO `exercise_chest_scores` VALUES ('barbellBenchPress',7,10,7),('cablePress',7,10,7),('declineBarbellBenchPress',7,7,10),('declineCablePress',7,7,10),('declineDumbbellBenchPress',7,7,10),('dips',7,7,10),('dumbbellBenchPress',7,10,7),('dumbbellFlys',7,10,7),('inclineBarbellBenchPress',10,7,7),('inclineCablePress',10,7,7),('inclineDumbbellBenchPress',10,7,7),('machineFlys',7,10,7);
/*!40000 ALTER TABLE `exercise_chest_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_dictionary`
--

DROP TABLE IF EXISTS `exercise_dictionary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_dictionary` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_long_name` varchar(45) DEFAULT NULL,
  `exercise_description` varchar(200) NOT NULL,
  PRIMARY KEY (`exercise_short_name`),
  UNIQUE KEY `exercise_short_name_UNIQUE` (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_dictionary`
--

LOCK TABLES `exercise_dictionary` WRITE;
/*!40000 ALTER TABLE `exercise_dictionary` DISABLE KEYS */;
INSERT INTO `exercise_dictionary` VALUES ('alternatingCurl','Alternating Curl','Alternate hands, curl'),('backwardLunge','Backward Lunge','Same as a lunge but backward'),('barbellBackSquat','Barbell Back Squat','Squat with a weighted barbell on your back'),('barbellBackwardLunge','Barbell Backward Lunge','Same as a backward lunge but with a barbell on your back'),('barbellBenchPress','Barbell Bench Press','Do you really not know what that is?'),('barbellFrontSquat','Barbell Front Squat','Squat with a weighted barbell on your front'),('barbellLunge','Barbell Lunge','Same as a lunge but with a barbell on your back'),('barbellOverheadPress','Overhead Press','Stand up and lift bar overhead'),('barbellRow','Barbell Row','Same as one arm row but with a barbell'),('cableFrontRaise','Cable Front Raise','Stand with your back to the cable, grab it and raise to the front'),('cablePress','Cable Press','Same as dumbbell but with a cable'),('cableRearRaise','Cable Rear Raise','Same as DB rear raise but with a cable'),('cableRow','Cable Row','Same as dumbbell row but with a cable'),('cableSideRaise','Cable Side Raise','Lean away from a cable machine and raise it to the side'),('chestSupportedRow','Chest Supported Row','Same as dumbell row but on a machine/bench to support your chest'),('chinUp','Chip Up','Pull up with an inverted grip'),('closeGripBenchPress','Close Grip Bench Press','Bench with a close grip focuses on the tris'),('deadlift','Deadlift','Pick up a heavy barbell from the ground'),('declineBarbellBenchPress','Decline Barbell Bench Press','The same but on a decline'),('declineCablePress','DeclineCablePress','Same as cable but from top to bottom'),('declineDumbbellBenchPress','Decline Dumbbell Bench press','The same but with dumbbells on a decline'),('dips','Dips','Guess'),('dumbbellBenchPress','Dumbbell Bench Press','The same but with dumbbells'),('dumbbellCalfRaise','Dumbbell Calf Raise','Stand on your toes with weights in your hands'),('dumbbellExternalRotation','Dumbbell External Rotation','Sit on the ground, put your elbow on your knee and lift against gravity'),('dumbbellFlys','Dumbbell Flys','Same as cable but with a dumbbell'),('dumbbellFrontRaise','Shoulder Front Raise','Hold dumbbell in each hand and lift it in front of you'),('dumbbellOverheadPress','Dumbbell Overhead Press','Same as overhead but with dumbbells'),('dumbbellRearRaise','Dumbbell Rear Raise','Lie face down on an incline bench, raise dumbbells to the side'),('dumbbellRow','Dumbbell Row','Horizontal Row with a dumbbell'),('dumbbellSideRaise','Dumbbell Side Raise','Raise a dumbbell to your side'),('dumbbellSkullcrusher','Dumbbell Skullcrusher','Same as skullcrusher but with dumbbells'),('dumbbellSquat','Dumbbell Squat','Squat with dumbbells in your hands'),('ezBarPreacherCurl','EZ Bar Preacher Curl','Same as dumbbell but with an EZ bar'),('facepull','Facepull','Grap a rope and pull it to your face'),('forwardLunge','Forward Lunge','Lunge forward with weights in your hands'),('gobletSquat','Goblet Squat','Squat with a single goblet in your hands'),('hackSquat','Hack Squat','There\'s a machine for that'),('hammerCurl','Hammer Curl','Curl with your palms perpendicular to the ground'),('hipAbduction','Hip Abduction','There\'s a machine for that'),('hipAdduction','Hip Adduction','There\'s a machine for that'),('hipThrust','Hip Thrust','Fuck a barbell'),('hyperExtension','Hyper Extension','Lie on your front and lift your legs'),('inclineBarbellBenchPress','Incline Barbell Bench Press','The same but on an incline'),('inclineCablePress','Incline Cable Press','Same as cable press but bottom to top'),('inclineCurl','Incline Curl','Same as alternate curl but sit on an incline bench'),('inclineDumbbellBenchPress','Incline Dumbbell Bench Press','The same but with dumbbells on an incline'),('invertedGripPulldown','Inverted Grip Pulldown','Same as pulldown but with an inverted grip (palms facing you)'),('landminePress','Landmine Press','Same as overhead press but with a landmine setup'),('landmineRow','Landmine Row','Row with a landmine setup'),('legPress','Leg Press','There\'s a machine for that'),('lRaise','L Raise','One hand does a front raise, the other does a side raise. Alternate.'),('lyingLegCurl','Lying Leg Curl','There\'s a machine for that'),('machineCalfRaise','Machine Calf Raise','There\'s a machine for that'),('machineFlys','Machine Flys','Dumbbell Flys but on a machine'),('neutralGripPullUp','Neutral Grip Pull Up','Pull up with a neutral grip'),('nordicCurl','Nordic Curl','Lie on your front and curl your upper torso'),('oneArmLandmineRow','One Arm LandmineRow','One arm row with a landmine setup'),('preacherCurl','Dumbbell Preacher Curl','Angle your arm on an incline bench, curl'),('pulldown','Pulldown','Grab the trap bar and pull it down towards yourself'),('pullUp','Pull Up','Do you not know what this is?'),('romanianDeadlift','Romanian Deadlift','Same as deadlift but focus on your hamstrings'),('ropeSkullcrusher','Rope Skullcrusher','Skullcrusher but with a rope'),('ropeTricepPushdown','Rope Tricep Pushdown','Same but with a rope lmao'),('seatedLegCurl','Seated Leg Curl','There\'s a machine for that'),('shrug','Shrug','Grab a bar and shrug your shoulders'),('sideLunge','Side Lunge','Lunge side to side, maybe hold weights'),('sideRaise','Shoulder Side Raise','Same as front raise but lift to the side'),('singleLegHipThrust','Single Leg Hip Thrust','Same as hip thrust but on a single leg'),('singleLegRomanianDeadlift','Single Leg Romanian Deadlift','Same as RDL but on a single leg'),('singleLegSquat','Single Leg Squat','Squat on a single leg'),('skullcrusher','Skullcrusher','I don\'t know how to describe this shit'),('standingCurl','Standing Barbell Curl','Stand and curl a bar'),('tricepPushdown','Tricep Pushdown','Hard to describe tf :/'),('vBarPulldown','V Bar Pulldown','Same as pulldown but with a V bar'),('wideGripPulldown','Wide Grip Pulldown','Same as pulldown but with a wider grip');
/*!40000 ALTER TABLE `exercise_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_legs_scores`
--

DROP TABLE IF EXISTS `exercise_legs_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_legs_scores` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_glute_max_scores` double NOT NULL,
  `exercise_glute_med_scores` double NOT NULL,
  `exercise_hamstring_scores` double NOT NULL,
  `exercise_upper_quad_scores` double NOT NULL,
  `exercise_lower_quad_scores` double NOT NULL,
  `exercise_calf_scores` double NOT NULL,
  PRIMARY KEY (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_legs_scores`
--

LOCK TABLES `exercise_legs_scores` WRITE;
/*!40000 ALTER TABLE `exercise_legs_scores` DISABLE KEYS */;
INSERT INTO `exercise_legs_scores` VALUES ('backwardLunge',10,8,5,7,10,2),('barbellBackSquat',10,10,8,10,10,2),('barbellBackwardLunge',10,8,5,7,10,2),('barbellFrontSquat',10,10,6,10,10,2),('barbellLunge',10,8,5,7,10,2),('deadlift',10,7,10,6,10,2),('dumbbellCalfRaise',2,2,2,2,2,10),('dumbbellSquat',10,10,5,10,10,2),('forwardLunge',10,8,5,7,10,2),('gobletSquat',10,10,5,10,10,2),('hackSquat',10,10,3,8,9,2),('hipAbduction',2,2,2,2,2,10),('hipAdduction',2,2,2,2,2,10),('hipThrust',10,10,6,7,6,2),('hyperExtension',10,10,8,4,4,2),('legPress',10,7,4,9,9,2),('lyingLegCurl',8,8,10,4,4,2),('machineCalfRaise',2,2,2,2,2,10),('nordicCurl',8,8,10,4,4,2),('romanianDeadlift',10,10,10,6,6,2),('seatedLegCurl',8,8,10,4,4,2),('sideLunge',7,10,2,6,6,2),('singleLegHipThrust',10,10,6,7,6,2),('singleLegRomanianDeadlift',10,10,10,6,6,2),('singleLegSquat',10,10,5,10,10,2);
/*!40000 ALTER TABLE `exercise_legs_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exercise_shoulder_scores`
--

DROP TABLE IF EXISTS `exercise_shoulder_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_shoulder_scores` (
  `exercise_short_name` varchar(45) NOT NULL,
  `exercise_front_shoulder_score` double NOT NULL,
  `exercise_side_shoulder_score` double NOT NULL,
  `exercise_rear_shoulder_score` double NOT NULL,
  PRIMARY KEY (`exercise_short_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_shoulder_scores`
--

LOCK TABLES `exercise_shoulder_scores` WRITE;
/*!40000 ALTER TABLE `exercise_shoulder_scores` DISABLE KEYS */;
INSERT INTO `exercise_shoulder_scores` VALUES ('barbellOverheadPress',10,2,0),('cableFrontRaise',10,2,0),('cableRearRaise',0,2,10),('cableSideRaise',2,10,0),('closeGripBenchPress',4,0,0),('dumbbellExternalRotation',0,0,10),('dumbbellFrontRaise',10,0,0),('dumbbellOverheadPress',10,2,0),('dumbbellRearRaise',0,2,10),('facepull',0,2,10),('inclineBarbellBenchPress',4,0,0),('inclineDumbbellBenchPress',4,0,0),('landminePress',10,0,0),('lRaise',8,0,0),('sideRaise',2,10,0);
/*!40000 ALTER TABLE `exercise_shoulder_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_information`
--

DROP TABLE IF EXISTS `users_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_information` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(512) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_information`
--

LOCK TABLES `users_information` WRITE;
/*!40000 ALTER TABLE `users_information` DISABLE KEYS */;
INSERT INTO `users_information` VALUES (7,'aza','[B@433722e2');
/*!40000 ALTER TABLE `users_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_preferences`
--

DROP TABLE IF EXISTS `users_preferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_preferences` (
  `user_id` int NOT NULL,
  `preferred_split` varchar(45) DEFAULT NULL,
  `preferred_workouts_weekly` int DEFAULT NULL,
  `favorite_workouts` varchar(45) DEFAULT NULL,
  `date_of_last_split_switch` date DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_preferences`
--

LOCK TABLES `users_preferences` WRITE;
/*!40000 ALTER TABLE `users_preferences` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_preferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workout_splits`
--

DROP TABLE IF EXISTS `workout_splits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workout_splits` (
  `workout_split` varchar(45) NOT NULL,
  `workouts_per_week` int NOT NULL,
  `types_of_workouts` varchar(200) NOT NULL,
  PRIMARY KEY (`workout_split`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workout_splits`
--

LOCK TABLES `workout_splits` WRITE;
/*!40000 ALTER TABLE `workout_splits` DISABLE KEYS */;
INSERT INTO `workout_splits` VALUES ('bodypartSplit',5,'upper,lower,push,pull,legs'),('fullBody2',2,'fullBody,fullBody'),('fullBody3',3,'fullBody,fullBody,fullBody'),('pushPullLegs3',3,'push,pull,legs'),('pushPullLegs6',6,'push,pull,legs,push,pull,legs'),('upperLower',4,'upper,lower,upper,lower');
/*!40000 ALTER TABLE `workout_splits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workouts_and_scores`
--

DROP TABLE IF EXISTS `workouts_and_scores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workouts_and_scores` (
  `workout_type` varchar(45) NOT NULL,
  `legs_push_exercise_count` int NOT NULL,
  `workout_legs_push_score_goal` double NOT NULL,
  `legs_pull_exercise_count` int NOT NULL,
  `workout_legs_pull_score_goal` double NOT NULL,
  `back_exercise_count` int NOT NULL,
  `workout_back_score_goal` double NOT NULL,
  `chest_exercise_count` int NOT NULL,
  `workout_chest_score_goal` double NOT NULL,
  `shoulder_push_exercise_count` int NOT NULL,
  `workout_shoulder_push_score_goal` double NOT NULL,
  `shoulder_pull_exercise_count` int NOT NULL,
  `workout_shoulder_pull_score_goal` double NOT NULL,
  `arm_push_exercise_count` int NOT NULL,
  `workout_arm_push_score_goal` double NOT NULL,
  `arm_pull_exercise_count` int NOT NULL,
  `workout_arm_pull_score_goal` double NOT NULL,
  PRIMARY KEY (`workout_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workouts_and_scores`
--

LOCK TABLES `workouts_and_scores` WRITE;
/*!40000 ALTER TABLE `workouts_and_scores` DISABLE KEYS */;
INSERT INTO `workouts_and_scores` VALUES ('fullBody',1,7,1,7,1,9,1,7,0,0,0,0,1,1,1,1),('legs',3,10,2,10,0,0,0,0,0,0,0,0,0,0,0,0),('lower',3,23,3,23,0,0,0,0,0,0,0,0,0,0,0,0),('pull',0,0,0,0,2,15,0,0,0,0,2,13,0,0,2,15),('push',0,0,0,0,0,0,2,10,2,15,0,0,2,15,0,0),('upper',0,0,0,0,1,7,1,7,1,7,1,7,1,7,1,7);
/*!40000 ALTER TABLE `workouts_and_scores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `exercise_all_scores`
--

/*!50001 DROP VIEW IF EXISTS `exercise_all_scores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `exercise_all_scores` AS select `dict`.`exercise_long_name` AS `exercise_long_name`,`dict`.`exercise_description` AS `exercise_description` from (`exercise_legs_scores` `leg_score` left join (`exercise_arm_scores` `arm_score` left join (`exercise_shoulder_scores` `sh_score` left join (`exercise_back_scores` `back_score` left join (`exercise_chest_scores` `ch_score` left join `exercise_dictionary` `dict` on((`dict`.`exercise_short_name` = `ch_score`.`exercise_short_name`))) on((`dict`.`exercise_short_name` = `back_score`.`exercise_short_name`))) on((`dict`.`exercise_short_name` = `sh_score`.`exercise_short_name`))) on((`dict`.`exercise_short_name` = `arm_score`.`exercise_short_name`))) on((`dict`.`exercise_short_name` = `leg_score`.`exercise_short_name`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-06  7:41:42
