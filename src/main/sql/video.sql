DROP TABLE IF EXISTS video;

CREATE TABLE video (
    video_id INT PRIMARY KEY AUTO_INCREMENT,
    video_name VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL
);

insert into video (video_name,video_url) values ('视频1','url1');
insert into video (video_name,video_url) values ('视频2','url2');
insert into video (video_name,video_url) values ('视频3','url3');



-- 1. 课程分类表 (Category)
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY, -- 分类ID
    name VARCHAR(255) NOT NULL,                -- 分类名称
    description TEXT,                          -- 分类描述
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. 课程标签表 (Tag)
CREATE TABLE Tag (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,    -- 标签ID
    name VARCHAR(255) NOT NULL UNIQUE,        -- 标签名
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 3. 课程表 (Course)
CREATE TABLE Course (
    course_id INT AUTO_INCREMENT PRIMARY KEY, -- 课程ID
    title VARCHAR(255) NOT NULL,              -- 课程标题
    description TEXT,                         -- 课程描述
    category_id INT NOT NULL,                 -- 所属分类ID（外键）
    price DECIMAL(10, 2),                    -- 课程价格
    duration INT,                            -- 课程总时长（单位：分钟）
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

-- 4. 课程-标签关联表 (Course_Tag)
CREATE TABLE Course_Tag (
    course_id INT NOT NULL,                  -- 课程ID（外键）
    tag_id INT NOT NULL,                     -- 标签ID（外键）
    PRIMARY KEY (course_id, tag_id),
    FOREIGN KEY (course_id) REFERENCES Course(course_id),
    FOREIGN KEY (tag_id) REFERENCES Tag(tag_id)
);

-- 5. 视频表 (Video)
CREATE TABLE Video (
    video_id INT AUTO_INCREMENT PRIMARY KEY, -- 视频ID
    course_id INT NOT NULL,                 -- 所属课程ID（外键）
    title VARCHAR(255) NOT NULL,            -- 视频标题
    url VARCHAR(255) NOT NULL,              -- 视频URL
    duration INT,                           -- 视频时长（单位：秒）
    sort_order INT,                         -- 视频排序序号
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES Course(course_id)
);
