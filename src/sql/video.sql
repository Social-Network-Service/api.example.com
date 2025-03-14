DROP TABLE IF EXISTS video;

CREATE TABLE video (
    id INT PRIMARY KEY AUTO_INCREMENT,
    video_name VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL
);

insert into video (video_name,video_url) values ('视频1','url1');
insert into video (video_name,video_url) values ('视频2','url2');
insert into video (video_name,video_url) values ('视频3','url3');