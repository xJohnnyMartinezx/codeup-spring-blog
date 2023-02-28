-- INSERT INTO users (username, password, email, role, created_at)
-- VALUES
--     ('test_user', 'test123', 'test@test.com', 'USER', NOW()),
--     ('test_user2', 'test12345', 'test2@test.com', 'USER', NOW()),
--     ('test_user3', 'test1234567', 'test3@test.com', 'USER', NOW());

INSERT INTO posts (user_id, title, body)
VALUES
    (1, 'My First Post', 'Do not be alarmed. This is only a test. From user no. 1'),
    (2, 'Title for test post 2', 'Do not be alarmed. This is only a test. From user no. 2'),
    (3, 'Title for test post 3', 'Do not be alarmed. This is only a test. From user no. 3');