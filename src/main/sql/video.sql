DROP TABLE IF EXISTS video;

CREATE TABLE video (
    video_id INT PRIMARY KEY AUTO_INCREMENT,
    video_name VARCHAR(255) NOT NULL,
    video_url VARCHAR(255) NOT NULL
);

insert into video (video_name,video_url) values ('视频1','url1');
insert into video (video_name,video_url) values ('视频2','url2');
insert into video (video_name,video_url) values ('视频3','url3');


-- 首先删除已存在的表（注意删除顺序：先删除有外键依赖的表）
DROP TABLE IF EXISTS Video;
DROP TABLE IF EXISTS Course;
DROP TABLE IF EXISTS Category;

-- 1. 课程分类表 (Category)
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY, -- 分类ID
    name VARCHAR(255) NOT NULL,                -- 分类名称
    description TEXT,                          -- 分类描述
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 2. 课程表 (Course)
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

-- 3. 视频表 (Video)
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

-- 插入测试数据

-- 插入课程分类
INSERT INTO Category (name, description) VALUES
('编程开发', '包含各种编程语言和开发技术的课程'),
('数据科学', '数据分析、机器学习和人工智能相关课程'),
('设计创作', '平面设计、UI设计和视频制作课程');

-- 插入课程
INSERT INTO Course (title, description, category_id, price, duration) VALUES
('Java编程基础', 'Java语言基础知识与核心概念', 1, 199.00, 1200),
('Python数据分析', 'Python数据分析与可视化', 2, 299.00, 900),
('UI设计入门', '学习UI设计基本原则和工具使用', 3, 159.00, 600);

-- 插入视频
INSERT INTO Video (course_id, title, url, duration, sort_order) VALUES
(1, 'Java介绍', 'https://example.com/videos/java-intro.mp4', 600, 1),
(1, 'Java基本语法', 'https://example.com/videos/java-syntax.mp4', 900, 2),
(2, 'Python基础', 'https://example.com/videos/python-basics.mp4', 750, 1),
(2, '数据处理实战', 'https://example.com/videos/data-processing.mp4', 1200, 2),
(3, 'UI设计原则', 'https://example.com/videos/ui-principles.mp4', 800, 1),
(3, 'Figma工具使用', 'https://example.com/videos/figma-tutorial.mp4', 1000, 2);
