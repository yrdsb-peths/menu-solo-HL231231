import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.util.Map;

public class HighScoreScreen extends World
{
    public HighScoreScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Button back = new Button(false);
        addObject(back, 100, 50);
        Label backOverlay = new Label("Back", 50);
        backOverlay.setFillColor(Color.WHITE);
        addObject(backOverlay, 100, 50);
        Label HighScores = new Label("High Scores", 50);
        HighScores.setFillColor(Color.BLACK);
        addObject(HighScores, 400, 50);
        Map<String,Integer> scoresHolder = new HashMap<>();
        scoresHolder.put("Daniel", 5520);
        scoresHolder.put("Samantha", 2510);
        scoresHolder.put("John", 10240);
        int scoreOffset =  40;
        while(!scoresHolder.isEmpty())
        {
            String highestKey = "";
            int highestValue = Integer.MIN_VALUE;
            for(String key: scoresHolder.keySet())
            {
                if(scoresHolder.get(key) > highestValue)
                {
                    highestKey = key;
                    highestValue = scoresHolder.get(key);
                }
            }
            Label Score = new Label(highestKey + ":..." + highestValue, 30);
            Score.setFillColor(Color.BLACK);
            addObject(Score, 400, 50 + scoreOffset);
            scoresHolder.remove(highestKey);
            scoreOffset += 40;
        }
        for(int i = 0; i < 5; i++)
        {
            Label emptyScore = new Label("..........", 30);
            emptyScore.setFillColor(Color.BLACK);
            addObject(emptyScore, 400, 50 + scoreOffset);
            scoreOffset += 40;
        }
    }
}
