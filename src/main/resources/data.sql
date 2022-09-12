INSERT INTO article(id, title, content) VALUES (1, '가가가가', '1111');
INSERT INTO article(id, title, content) VALUES (3, '다다다다', '3333');
INSERT INTO article(id, title, content) VALUES (2, '나나나나', '2222');



-- article 더미 데이터
INSERT INTO article(id, title, content) VALUES (4, '당신의 인생 영화는?', '댓글 ㄱ');
INSERT INTO article(id, title, content) VALUES (5, '당신의 소울 푸드는?', '댓글 ㄱㄱ');
INSERT INTO article(id, title, content) VALUES (6, '당신의 취미는?', '댓글 ㄱㄱㄱ');

-- comment 더미 데이터
---- 4번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (1, 4, 'Park', '굳 윌 헌팅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (2, 4, 'Kim', '아이 엠 샘');
INSERT INTO comment(id, article_id, nickname, body) VALUES (3, 4, 'Choi', '쇼생크 탈출');

---- 5번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (4, 5, 'Park', '치킨');
INSERT INTO comment(id, article_id, nickname, body) VALUES (5, 5, 'Kim', '샤브샤브');
INSERT INTO comment(id, article_id, nickname, body) VALUES (6, 5, 'Choi', '초밥');

---- 6번 게시글의 댓글들
INSERT INTO comment(id, article_id, nickname, body) VALUES (7, 6, 'Park', '조깅');
INSERT INTO comment(id, article_id, nickname, body) VALUES (8, 6, 'Kim', '유튜브');
INSERT INTO comment(id, article_id, nickname, body) VALUES (9, 6, 'Choi', '독서');

-- member 더미 데이터
INSERT INTO member(id, name, email, password, nickname) VALUES (1, '이건목', '1@1.1', '1111', '민트삼겹');
INSERT INTO member(id, name, email, password, nickname) VALUES (2, '최유진', '2@2.2', '2222', '쵸코삼겹');

-- note 더미 데이터
---- 민트삼겹의 노트
INSERT INTO note(id, member_id, title) VALUES (1, 1, '영어');
INSERT INTO note(id, member_id, title) VALUES (2, 1, '스페인어');


---- 쵸코삼겹의 노트
INSERT INTO note(id, member_id, title) VALUES (3, 2, '영어');
INSERT INTO note(id, member_id, title) VALUES (4, 2, '중국어');
INSERT INTO note(id, member_id, title) VALUES (5, 2, '불어');

-- word 더미 데이터
---- 민트삼겹의 영어 단어
INSERT INTO word(id, note_id, name, mean) VALUES (1, 1, 'hi', '안녕');
INSERT INTO word(id, note_id, name, mean) VALUES (2, 1, 'bye', '잘가');

---- 민트삼겹의 스페인어 단어
INSERT INTO word(id, note_id, name, mean) VALUES (3, 2, 'hola', '안녕');
INSERT INTO word(id, note_id, name, mean) VALUES (4, 2, 'chao', '잘가');

---- 쵸코삼겹의 영어 단어
INSERT INTO word(id, note_id, name, mean) VALUES (5, 3, 'hi', '안녕');
INSERT INTO word(id, note_id, name, mean) VALUES (6, 3, 'bye', '잘가');

---- 쵸코삼겹의 중국어 단어
INSERT INTO word(id, note_id, name, mean) VALUES (7, 4, '你好', '안녕');
INSERT INTO word(id, note_id, name, mean) VALUES (8, 4, '再见', '잘가');

---- 쵸코삼겹의 불어 단어
INSERT INTO word(id, note_id, name, mean) VALUES (9, 5, 'salut', '안녕');
INSERT INTO word(id, note_id, name, mean) VALUES (10, 5, 'Au revoir', '잘가');