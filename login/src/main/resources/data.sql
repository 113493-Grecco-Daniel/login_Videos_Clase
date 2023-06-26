--
--players
INSERT INTO players (id, user_name ,password, email, avatar, last_login ,crated_at , updated_at )
VALUES (1111,'APP',null,null,null,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO players (id, user_name ,password, email, avatar, last_login ,crated_at , updated_at )
VALUES (2222,'Daniel','Cordoba+01' ,'daniel@daniel.com','un pug',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO players (id, user_name ,password, email, avatar, last_login ,crated_at , updated_at )
VALUES (3333,'Otro_Daniel','algo secreto...','danielalbertogrecco@gmail.com','un condor',CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
--
--
-- games
INSERT INTO games (id, code, user_name, description, rules)
Values(1000000, 'RPS', 'Rock Paper Scissors',
       'Rock, Paper, Scissor is a simple hand game tipicaly played bettween two individuals.' ||
       'Rock, Paper, Scissor is a simple hand game tipicaly played bettween two individuals.' ||
       'Rock, Paper, Scissor is a simple hand game tipicaly played bettween two individuals.' ||
       'Rock, Paper, Scissor is a simple hand game tipicaly played bettween two individuals.' ||
       'Rock, Paper, Scissor is a simple hand game tipicaly played bettween two individuals.' ||
       'The game involve each players...' ,
       'resto de las reglas... ' ||
       'resto de las reglas... ' ||
       'resto de las reglas... ' ||
       'resto de las reglas... ' ||
       'resto de las reglas... ' ||
       'resto de las reglas... ' ||
       'resto de las reglas... '  );

--
--matches
INSERT INTO  matches(id, game_id, player_id, created_at, updated_at, status)
VALUES (1000000, 1000000, 2222, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'STARTED');

INSERT INTO  matches (id, game_id, player_id, created_at, updated_at, status)
VALUES (1000001, 1000000, 2222, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'FINISHED');

INSERT INTO  matches (id, game_id, player_id, created_at, updated_at, status)
VALUES (1000002, 1000000, 2222, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'CANCELED');
--
--matches_rps
INSERT INTO  matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
VALUES (1000000, 10, 5, 3, 2);

INSERT INTO matches_rps (id, number_of_plays, remainder_plays, player1score, player2score, winner_id)
    VALUES (1000001, 10, 0, 6, 4, 2222);

INSERT INTO matches_rps(id, number_of_plays, remainder_plays, player1score, player2score)
    VALUES (1000002, 10, 5, 3, 2);
--
-- plays_rps
--partida 1 id1000000 va ganando 2222 3 a 2 -- aca deja de insertar datos, no hacepta ver si es por el match_rps_id
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id  )
VALUES (1000000, 1000000 ,'ROCK', 'PAPER',  1111);  -- porque la compu es 1111, el usa 10000000
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000001, 1000000 ,'PAPER', 'ROCK', 2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000002, 1000000 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000003, 1000000 ,'ROCK', 'SCISSORS',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000004, 1000000 ,'PAPER', 'SCISSORS',  1111); -- porque la compu es 1111, el usa 10000000

--partida 2 id10000001  gano 2222 6 a 4
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000005, 1000001 ,'ROCK', 'PAPER',  1111); -- porque la compu es 1111, el usa 10000000
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000006, 1000001 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000007, 1000001 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000008, 1000001 ,'ROCK', 'SCISSORS', 2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000009, 1000001 ,'PAPER', 'SCISSORS',  1111); -- porque la compu es 1111, el usa 10000000
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000010, 1000001 ,'ROCK', 'PAPER',  1111); -- porque la compu es 1111, el usa 10000000
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000011, 1000001 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000012, 1000001 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000013, 1000001 ,'ROCK', 'SCISSORS',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000014, 1000001 ,'PAPER', 'SCISSORS',  1111); -- porque la compu es 1111, el usa 10000000

--partida 3 id1000002 va ganando pero esta cancelada 2222 3 a 2
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id)
VALUES (1000015, 1000002 ,'ROCK', 'PAPER',  1111); -- porque la compu es 1111, el usa 10000000
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000016, 1000002 ,'PAPER', 'ROCK',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000017, 1000002 ,'PAPER', 'ROCK', 2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000018, 1000002 ,'ROCK', 'SCISSORS',  2222);
INSERT INTO plays_rps (id, match_rps_id, shape_hand_player1,shape_hand_player2 ,  winner_id )
VALUES (1000019, 1000002 ,'PAPER', 'SCISSORS',  1111); -- porque la compu es 1111, el usa 10000000
