DROP DATABASE IF EXISTS miru;

CREATE DATABASE miru;

USE miru;

-- 유저 아이디, 비밀번호, 이메일, 사진추천 여부, 비밀번호 암호화 salt
CREATE TABLE `user` (
  `id` varchar(30) NOT NULL,
  `password` char(64) NOT NULL,
  `email` varchar(50) NOT NULL,
  `recommendFlag` tinyint(1) NOT NULL,
  `salt` char(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 사진 인덱스 번호, 사진파일 경로, 사진 태그, 사진공개 여부, 사진 등록시간
CREATE TABLE `picture` (
  `pictureIdx` int NOT NULL AUTO_INCREMENT,
  `filepath` varchar(100) NOT NULL,
  `tag` varchar(50) NOT NULL,
  `publicFlag` tinyint(1) DEFAULT '1',
  `isPicture` tinyint(1) DEFAULT '1',
  `id` varchar(30) DEFAULT NULL,
  `updateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pictureIdx`),
  KEY `id` (`id`),
  CONSTRAINT `picture_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 유저 아이디, 좋아요 등록한 유저 아이디
CREATE TABLE `favoriteuser` (
  `id` varchar(30) NOT NULL,
  `followId` varchar(30) NOT NULL,
  PRIMARY KEY (`id`,`followId`),
  KEY `followId` (`followId`),
  CONSTRAINT `favoriteuser_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `favoriteuser_ibfk_2` FOREIGN KEY (`followId`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 유저 아이디, 좋아요 등록한 사진 인덱스, 사진 출력순서
CREATE TABLE `favoritepicture` (
  `id` varchar(30) NOT NULL,
  `pictureIdx` int NOT NULL,
  `pictureOrder` int NOT NULL,
  PRIMARY KEY (`id`,`pictureIdx`),
  KEY `pictureIdx` (`pictureIdx`),
  CONSTRAINT `favoritepicture_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `favoritepicture_ibfk_2` FOREIGN KEY (`pictureIdx`) REFERENCES `picture` (`pictureIdx`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;