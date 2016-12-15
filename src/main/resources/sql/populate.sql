INSERT INTO `role` (`id`, `type`) VALUES ('1', 'ADMIN');
INSERT INTO `role` (`id`, `type`) VALUES ('2', 'USER');
INSERT INTO `user` (`id`, `active`, `created_at`, `email`, `password`, `removed`, `username`, `region`) VALUES ('24670397', '1', '2016-12-15 12:22:05', 'ff@20.gg', '$2a$10$GOqit2ZkhaV/NW.8KpK7xOBwapeHK1YkIqUpzG4YJiisVdxfo69G6', '0', 'oliwer94', 'EUW');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('24670397', '2');
INSERT INTO `user` (`id`, `active`, `created_at`, `email`, `password`, `removed`, `username`, `region`) VALUES ('19652129', '1', '2016-12-15 12:22:05', 'ff@20.gg', '$2a$10$GOqit2ZkhaV/NW.8KpK7xOBwapeHK1YkIqUpzG4YJiisVdxfo69G6', '0', 'FigaPl', 'EUW');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES ('19652129', '1');
