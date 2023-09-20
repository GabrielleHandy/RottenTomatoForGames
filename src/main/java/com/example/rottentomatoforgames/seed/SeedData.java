package com.example.rottentomatoforgames.seed;

import com.example.rottentomatoforgames.model.Game;
import com.example.rottentomatoforgames.model.Rating;
import com.example.rottentomatoforgames.model.User;
import com.example.rottentomatoforgames.model.UserProfile;
import com.example.rottentomatoforgames.repository.GameRepository;
import com.example.rottentomatoforgames.repository.RatingRepository;
import com.example.rottentomatoforgames.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@Component
public class SeedData implements CommandLineRunner {
        private final PasswordEncoder passwordEncoder;
        private final UserRepository userRepository;
        private final GameRepository gameRepository;
        private final RatingRepository ratingRepository;
    @Autowired
    public SeedData(PasswordEncoder passwordEncoder, UserRepository userRepository, GameRepository gameRepository, RatingRepository ratingRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.ratingRepository = ratingRepository;
    }




        @Override
        public void run(String... args) throws Exception {
        int count = 10;
            UserProfile userProfile;
            User user = new User();
            user.setUserName("GabbyDev");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setEmailAddress("GabbyDev@Ga.com");
            userProfile = new UserProfile();
            user.setUserProfile(userProfile);
            user = userRepository.save(user);

            User user1 = new User();
            user1.setUserName("WOOp");
            user1.setPassword(passwordEncoder.encode("12345"));
            user1.setEmailAddress("HDHDH@gmail");
            userProfile = new UserProfile();
            user1.setUserProfile(userProfile);
            user1 = userRepository.save(user1);


            User user2 = new User();
            user2.setUserName("Gav");
            user2.setPassword(passwordEncoder.encode("12345"));
            user2.setEmailAddress("Gav@Ga.com");
            userProfile = new UserProfile();
            user2.setUserProfile(userProfile);
            user2= userRepository.save(user2);



            Game game;
            File file = new File("src/main/java/com/example/rottentomatoforgames/seed/imdb_video_games.csv");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            while (count != 0){
                game = new Game();
                line = scanner.nextLine();
                String[] info = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                System.out.println(Arrays.toString(info) + " "  +info[9]);
                game.setTitle(info[1]);
                game.setReleaseYear(Integer.parseInt(info[6]));
                gameRepository.save(game);
                count--;

            }
            scanner.close();

            Rating rating = new Rating();

            rating.setGame(gameRepository.findById(4L).get());
            rating.setRatedBy(user2.getUserProfile());
            rating.setRating(4);
            rating.setReview("Could have been better");

            ratingRepository.save(rating);
            Game updateRatedGame = gameRepository.findById(4L).get();
            updateRatedGame.setAverageRating();
            gameRepository.save(updateRatedGame);

            Rating rating1 = new Rating();
            Game ratedGame1 = gameRepository.findById(6L).get();
            rating1.setGame(ratedGame1);
            rating1.setRatedBy(user1.getUserProfile());
            rating1.setRating(5);
            rating1.setReview("Changed my life!");
            ratingRepository.save(rating1);
            Game updateRatedGame1 = gameRepository.findById(6L).get();
            updateRatedGame1.setAverageRating();
            gameRepository.save(updateRatedGame1);

        }
    }

