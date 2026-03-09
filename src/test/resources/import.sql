INSERT INTO booking (id) VALUES ('3b210a9a-9b93-4603-a4d9-68ec3645ab18');
INSERT INTO booking (id) VALUES ('e81c6732-6315-46e7-9dc5-6baaa8d1a3bc');

INSERT INTO username (id) values ('721302b1-7189-4701-b055-bd66da07860b');
INSERT INTO username (id) values ('95f62c3f-58ce-4195-aadd-d0888c690362');

INSERT INTO account (id, username_id) values ('eea8c177-fb46-446c-aafd-90bc4977dd8c', '721302b1-7189-4701-b055-bd66da07860b');

INSERT INTO store (id, booking_id) values ('82f30dc9-ecd0-4d32-b23c-fa1ebbf25075', 'e81c6732-6315-46e7-9dc5-6baaa8d1a3bc');

INSERT INTO address (id, store_id) values ('4f627fe1-25fd-4cb8-bc82-fb50b0c4ce19', '82f30dc9-ecd0-4d32-b23c-fa1ebbf25075');
INSERT INTO address (id, store_id) values ('ad611c31-a66c-4587-80e0-785dc57a3f75', '82f30dc9-ecd0-4d32-b23c-fa1ebbf25075');

INSERT INTO addressassignment (id, account_id, booking_id, address_id, username_id) values ('d37d445a-53e1-4c78-bc8e-f71afd90dc55', 'eea8c177-fb46-446c-aafd-90bc4977dd8c', 'e81c6732-6315-46e7-9dc5-6baaa8d1a3bc', '4f627fe1-25fd-4cb8-bc82-fb50b0c4ce19', '95f62c3f-58ce-4195-aadd-d0888c690362');
INSERT INTO addressassignment (id, account_id, booking_id, address_id, username_id) values ('4b14fc2b-9c25-4e03-9a56-33ffb914beb9', 'eea8c177-fb46-446c-aafd-90bc4977dd8c',  'e81c6732-6315-46e7-9dc5-6baaa8d1a3bc', 'ad611c31-a66c-4587-80e0-785dc57a3f75', '721302b1-7189-4701-b055-bd66da07860b');

INSERT INTO bookingassignment (id, account_id, booking_id) values ('1d75d4b0-c530-444b-b9be-2265454cb7b7', 'eea8c177-fb46-446c-aafd-90bc4977dd8c', '3b210a9a-9b93-4603-a4d9-68ec3645ab18');
INSERT INTO bookingassignment (id, account_id, booking_id) values ('4c403108-698e-4b98-bd2c-b9d74069150d', 'eea8c177-fb46-446c-aafd-90bc4977dd8c', 'e81c6732-6315-46e7-9dc5-6baaa8d1a3bc');
